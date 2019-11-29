package com.pma.model;

import java.io.Serializable;

public class ParentTask implements Serializable {

	private static final long serialVersionUID = 1L;
	private int parentId;
	private String parentTask;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

}
