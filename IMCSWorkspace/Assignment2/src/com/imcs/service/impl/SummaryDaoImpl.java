package com.imcs.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imcs.beans.Summary;
import com.imcs.service.dao.SummaryDao;
import com.imcs.util.DBUtil;

public class SummaryDaoImpl implements SummaryDao {

	Connection connection = null;
	PreparedStatement statement = null;

	@Override
	public void insertSummaryRecord(Summary createSummary) throws SQLException {
		connection = DBUtil.setDBConnection();
		statement = connection.prepareStatement(
				"INSERT INTO summary (ValidRecords, InValidRecords, TotalRecords, TotalDeparments, FileName, UploadedDate) VALUES (?,?,?,?,?,?)");
		statement.setInt(1, createSummary.getNoOfValidRecords());
		statement.setInt(2, createSummary.getNoOfInvalidRecords());
		statement.setInt(3, createSummary.getTotalRecords());
		statement.setInt(4, createSummary.getTotalDepartments());
		statement.setString(5, createSummary.getFileName());
		statement.setDate(6, new Date(createSummary.getUploadedDate().getTime()));
		statement.executeUpdate();
	}

	@Override
	public List<Summary> getEmployeeInsertSummary() throws SQLException {
		List<Summary> summaryList = new ArrayList<>();
		connection = DBUtil.setDBConnection();
		statement = connection.prepareStatement("select * from summary");
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			summaryList
					.add(new Summary(rs.getInt("ValidRecords"), rs.getInt("InValidRecords"), rs.getString("FileName"),
							rs.getDate("UploadedDate"), rs.getInt("TotalRecords"), rs.getInt("TotalDeparments")));
		}
		return summaryList;
	}
}
