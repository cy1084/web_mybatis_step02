package com.edu.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.InfoDto;
import com.min.edu.dto.JobsDto;
import com.min.edu.model.BindingDaoImpl;
import com.min.edu.model.IBindingDao;
import com.min.edu.service.InfoService;

public class MyBatis_Binding_JUnitTest {

//	@Test
	public void selectKey_JUnitTest() {
		InfoService service = new InfoService();
		
		InfoDto inDto=new InfoDto();
		inDto.setName("오월");
		inDto.setPhone("05");
		
		InfoDto resultDto = service.insertAndSelect(inDto);
		System.out.println(resultDto);
		assertNotNull(resultDto);
	}

//	@SuppressWarnings({ "unchecked", "serial" })
	@SuppressWarnings("serial")
	@Test
	public void binding_test() {
		IBindingDao dao = new BindingDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>() {
			{
//			put("column","JOB_ID");
//			SQL injection 공격..					
				put("column", "'1'='1' or JOB_ID");
				/*
				 * 위의 쿼리는 항상 참이 되어, 데이터베이스의 모든 행 반환 이는 데이터베이스의 비정상적인 접근을 허용하고, 민감한 정보를 탈취하는 등의
				 * 보안 문제를 야기
				 */
				put("value", "AV_PREG");
			}
		};
//		List<JobsDto> lists01 = dao.binding01(map);
//		assertNotEquals(0, lists01.size());

		map = new HashMap<String, Object>() {
			{
				put("value", "IT_DEV");
			}
		};

		List<JobsDto> lists02 = dao.binding02(map);
		assertNotEquals(0, lists02.size());

	}

}
