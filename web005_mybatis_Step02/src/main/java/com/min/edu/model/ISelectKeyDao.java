package com.min.edu.model;

import com.min.edu.dto.InfoDto;

public interface ISelectKeyDao {
	public int insertInfo(InfoDto dto);

	public InfoDto selectInfo(InfoDto dto);

}
