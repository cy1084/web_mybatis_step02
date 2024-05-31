package com.min.edu.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.InfoDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class SelectKeyDaoImpl implements ISelectKeyDao {

	private Logger log = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.SelectKeyDaoImpl.";

	@Override
	public int insertInfo(InfoDto dto) {
		SqlSession session = manager.openSession(true);
		return session.insert(NS + "insertInfo", dto);
	}

	@Override
	public InfoDto selectInfo(InfoDto dto) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "selectInfo", dto);
	}

}
