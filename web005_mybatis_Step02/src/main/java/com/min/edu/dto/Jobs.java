package com.min.edu.dto;

public class Jobs {
	private int idx;
	private String name;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Jobs [idx=" + idx + ", name=" + name + "]";
	}

}
