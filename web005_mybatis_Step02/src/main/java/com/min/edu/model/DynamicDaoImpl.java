package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.Jobs;
import com.min.edu.dto.JobsDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class DynamicDaoImpl implements IDynamicDao {
	private Logger log = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.DynamicDaoImpl.";

	@Override
	public List<JobsDto> getJobsIf(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		return session.selectList(NS + "getJobsIf", map);
	}

	@Override
	public List<JobsDto> getJobsMap(Map<String, String[]> map) {
		log.info("foreach문을 통한 다중 값 사용 Map:" + map);
		SqlSession session = manager.openSession();
		List<JobsDto> list = session.selectList(NS + "getJobsMap", map);
		return list;
	}

	@Override
	public List<JobsDto> getJobsList(List<String> list) {
		log.info("foreach문을 통한 다중 값 사용 list:" + list);
		SqlSession session = manager.openSession();
		List<JobsDto> list2 = session.selectList(NS + "getJobsList", list);
		return list2;
	}

	@Override
	public List<Jobs> example01(List<String> list) {
		log.info("foreach문을 통한 다중 값 사용 list+index:" + list);
		SqlSession session = manager.openSession();
		List<Jobs> list2 = session.selectList(NS + "example01", list);

		return list2;
	}

	@Override
	public List<JobsDto> getJobsChoose(Map<String, Object> map) {
		log.info("choose 입력된 것 중 하나가 조건이 됨: " + map);
		SqlSession session = manager.openSession();
		List<JobsDto> list = session.selectList(NS + "getJobsChoose", map);

		return list;
	}

	@Override
	public List<JobsDto> getJobsTrim(JobsDto dto) {
		log.info("trim과 prifix 문법" + dto);
		SqlSession session = manager.openSession();
		List<JobsDto> list = session.selectList(NS + "getJobsTrim", dto);
		// JobsDto는 xml의 resultType에서 결정!
		return list;
	}

	@Override
	public int updateJobsSet(JobsDto dto) {
		log.info("<set>은 자동으로 set 절의 구분자인 ,를 제거");
		SqlSession session = manager.openSession();
		int n = session.delete(NS + "updateJobsSet", dto);
		return n;
	}

	@Override
	public int updateJobsTrim(JobsDto dto) {
		log.info("<set>의 동작을 trim과 suffixoverrides를 통해 구현");
		SqlSession session = manager.openSession();
		int n = session.update(NS + "updateJobsTrim", dto);
		//.update든 .delete든 상관없고 (NS + "updateJobsTrim", dto)만 바르게 작성되면 됨
		return n;
	}

}
