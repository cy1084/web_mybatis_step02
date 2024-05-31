package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.JobsDto;

public interface IBindingDao {
	public List<JobsDto> binding01(Map<String, Object> map);
	public List<JobsDto> binding02(Map<String, Object> map);
}
