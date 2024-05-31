package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.JobsDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class BindingDaoImpl implements IBindingDao {
	private Logger log = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.BindingDaoImpl.";

	@Override
	public List<JobsDto> binding01(Map<String, Object> map) {
		log.info("mybatis의 바인딩 문법은 $와 #");
		SqlSession session = manager.openSession();
		return session.selectList(NS + "binding01", map);
	}
	
	@Override
	public List<JobsDto> binding02(Map<String, Object> map) {
		log.info("mybatis에서 LIKE 연산자 사용하기");
		SqlSession session = manager.openSession();
		return session.selectList(NS + "binding02", map);
	}

}
