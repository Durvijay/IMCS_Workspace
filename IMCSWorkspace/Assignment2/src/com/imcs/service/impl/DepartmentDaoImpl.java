package com.imcs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.imcs.beans.Department;
import com.imcs.service.dao.DepartmentDao;
import com.imcs.util.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	DBUtil dbconn = null;
	Connection connection = null;
	PreparedStatement statement = null;

	@Override
	public void insertDepatmentRecords(Set<Department> departmentList) throws SQLException {

		try {
			connection = DBUtil.setDBConnection();
			statement = connection
					.prepareStatement("INSERT IGNORE INTO department (DepartmentId,DepartmentName) VALUES (?,?)");
			for (Department department : departmentList) {
				statement.setInt(1, department.getDepartmentId());
				statement.setString(2, department.getDepartmentName());
				statement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}

	}

	@Override
	public boolean validatedDepartment(String deptName) {
		try {
			connection = DBUtil.setDBConnection();
			statement = connection.prepareStatement("select * from department where DepartmentName=?");
			statement.setString(1, deptName);
			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
