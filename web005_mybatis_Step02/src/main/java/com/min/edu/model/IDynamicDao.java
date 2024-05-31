package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Jobs;
import com.min.edu.dto.JobsDto;

public interface IDynamicDao {
	public List<JobsDto> getJobsIf(Map<String, Object> map);

	public List<JobsDto> getJobsMap(Map<String, String[]> map);

	public List<JobsDto> getJobsList(List<String> list);

	public List<Jobs> example01(List<String> list);

	public List<JobsDto> getJobsChoose(Map<String, Object> map);
	
	public List<JobsDto> getJobsTrim(JobsDto dto);
	
	public int updateJobsSet(JobsDto dto);
	
	public int updateJobsTrim(JobsDto dto);
}
