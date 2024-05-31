package com.edu.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.Jobs;
import com.min.edu.dto.JobsDto;
import com.min.edu.model.DynamicDaoImpl;
import com.min.edu.model.IDynamicDao;

public class MyBatis_Dynamic_JUnitTest {

	private IDynamicDao dao;

	public MyBatis_Dynamic_JUnitTest() {
		dao = new DynamicDaoImpl();
	}

	@Test
	public void setToTrim_JUnitTest() {
		JobsDto dto = new JobsDto();
		dto.setJob_id("AD_PRES");
		//dto.setJob_title("President");
		int n = dao.updateJobsSet(dto);
		assertEquals(1, n);
	} 
	
	
	//@Test
	public void set_JUnitTest() {
		JobsDto dto = new JobsDto();
		//dto.setJob_id("AD_PRES");
		dto.setJob_title("President");

		int n = dao.updateJobsSet(dto);
		assertEquals(1, n);
	}

	// @Test
	public void trim_prefix_JUnitTest() {
		JobsDto dto = new JobsDto();
		// dto.setJob_id("AD_PRES");
		dto.setJob_title("President");

		List<JobsDto> list = dao.getJobsTrim(dto);
		assertNotNull(list);
		// SELECT JOB_ID, JOB_TITLE, MIN_SALARY MAX_SALARY FROM JOBS WHERE JOB_ID=? AND
		// JOB_TITLE=?
		// 위 쿼리 실행

		// dto.setJob_id("AD_PRES"); 주석 처리하면
		// ~FROM JOBS WHERE JOB_TITLE=?
		// AND 절이 WHERE 절로!

	}

	// @Test
	public void choose_JUnitTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("job_title", "President");
		// put 안하면 전체 조회 됨
		List<JobsDto> list = dao.getJobsChoose(map);
		assertNotNull(list);
	}

	// @Test
	public void foreach_index_JUnitTest() {
		String[] strs = { "날씨", "맑음", "여행", "영화" };
		List<String> list = Arrays.asList(strs);
		List<Jobs> list2 = dao.example01(list);
		assertNotNull(list2);
	}

	// @Test
	public void foreach_list_JUnitTest() {
		String[] job_ids = { "PR_REP", "SA_MAN" };
		List<String> list = Arrays.asList(job_ids);
		// array를 String[] 타입에 맞춰서 list로

		List<JobsDto> list2 = dao.getJobsList(list);
		assertNotNull(list2);

	}

	// @Test
	public void foreach_map_JUnitTest() {
		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] job_ids = { "PR_REP", "SA_MAN" };
		map.put("ids", job_ids);
		// SELECT JOB_ID, JOB_TITLE, MIN_SALARY MAX_SALARY FROM JOBS WHERE JOB_ID IN (
		// ?, ? )
		// 요렇게 쿼리문 생성

		List<JobsDto> list = dao.getJobsMap(map);
		assertNotNull(list);
	}

	// @Test
	public void if_JUnitTest() {
//		List<JobsDto> lists=dao.getJobsIf(null);
		// 객체 자체가 null => 상관없음

		List<JobsDto> lists = dao.getJobsIf(new HashMap<String, Object>() {
			{
				// put("id",null);
				put("id", "AD_PREG");
				// if 문을 통해 쿼리가
				// SELECT JOB_ID, JOB_TITLE, MIN_SALARY MAX_SALARY FROM JOBS WHERE JOB_ID=?
				// 로 준비됨
				// WHERE JOB_ID=? 절 추가

			}
		});
		// id 값이 null

		assertNotNull(lists);

	}

}
