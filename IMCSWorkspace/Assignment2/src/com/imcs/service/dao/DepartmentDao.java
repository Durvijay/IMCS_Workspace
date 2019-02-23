package com.imcs.service.dao;

import java.sql.SQLException;
import java.util.Set;

import com.imcs.beans.Department;

public interface DepartmentDao {

	public void insertDepatmentRecords(Set<Department> departmentList) throws SQLException;

	public boolean validatedDepartment(String deptName);

}
