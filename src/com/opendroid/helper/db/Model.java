package com.opendroid.helper.db;

public interface Model {
	public int getId();

	public void setId(int id);
	
	public String getTableName();

	public String getCreateStatement();
}