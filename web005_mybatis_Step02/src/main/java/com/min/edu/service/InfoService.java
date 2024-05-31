package com.min.edu.service;

import com.min.edu.dto.InfoDto;
import com.min.edu.model.ISelectKeyDao;
import com.min.edu.model.SelectKeyDaoImpl;

public class InfoService {

	private ISelectKeyDao dao;

	public InfoService() {
		dao = new SelectKeyDaoImpl();
	}

	public InfoDto insertAndSelect(InfoDto dto) {
		InfoDto reDto = null;
		
		System.out.println("-------------처음 입력되는 dto 값------------"+dto);
		int n=dao.insertInfo(dto);
		System.out.println("-------------insert 후 확인 dto 값---------------"+dto);
		reDto=dao.selectInfo(dto);
		
		return reDto;
	}

}
