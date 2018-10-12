package com.niit.dao;

import java.util.List;

import com.niit.model.UserProcess;

public interface UserProcessDao {
	boolean saveUserProcess(UserProcess userProcess);
	boolean deleteUserProcess(UserProcess userProcess);
	boolean updateUserProcess(UserProcess userProcess);
	List<UserProcess> getId(int id);
	boolean loginUserProcess(UserProcess user);
}
