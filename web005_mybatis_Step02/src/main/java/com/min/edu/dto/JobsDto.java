package com.min.edu.dto;

public class JobsDto {
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
	
	@Override
	public String toString() {
		return "JobsDto [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary + ", max_salary="
				+ max_salary + "]";
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public int getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}

	public int getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}
	
	

}
