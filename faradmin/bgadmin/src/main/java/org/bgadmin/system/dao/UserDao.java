package org.bgadmin.system.dao;

import java.util.List;

import org.bgadmin.system.entity.TestModel;

public interface UserDao  { 
	
	public TestModel get(String id);
	
	public String add(TestModel t);
	
	public boolean del(String id);
	
	public boolean update(TestModel t);
	
	public List<TestModel> list(TestModel t);
} 
	  
