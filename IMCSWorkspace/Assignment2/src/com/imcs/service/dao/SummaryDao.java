package com.imcs.service.dao;

import java.sql.SQLException;
import java.util.List;

import com.imcs.beans.Summary;

public interface SummaryDao {

	public void insertSummaryRecord(Summary createSummary) throws SQLException;

	public List<Summary> getEmployeeInsertSummary() throws SQLException;

}
