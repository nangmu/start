package com.siuk;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataBaseTests {

	@Autowired
	private DataSource dataSource;

	@Test
	public void isHikariDataSource() {
		String keyword = "hikari";
		assertTrue(dataSource.getClass().getName().contains(keyword));
	}

	@Test
	public void connectionTest() throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT 100");
		ResultSet rs = pstmt.executeQuery();
		int result = 0;
		if(rs.next()) {
			result = rs.getInt(1);
		}
		assertTrue(result == 100);
	}
}
