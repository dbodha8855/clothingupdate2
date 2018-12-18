package com.cg.clothing.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.clothing.dao.TrouserDaoImpl;
import com.cg.clothing.exception.ClothingException;
import com.cg.clothing.util.DBConnection;

public class DBConnectionTest2 {
	static TrouserDaoImpl daotest;
	static Connection dbCon;

	@BeforeClass
	public static void initialise() {
		daotest = new TrouserDaoImpl();
		dbCon = null;
	}

	@Before
	public void beforeEachTest() {
		System.out.println("----Starting DBConnection Test Case----\n");
	}

	/**
	 * Test case for Establishing Connection
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * @throws DonorException
	 **/
	@Test
	public void test() throws ClothingException, ClassNotFoundException, SQLException, IOException {
		Connection dbCon = DBConnection.getConnection();
		Assert.assertNotNull(dbCon);
	}

	@After
	public void afterEachTest() {
		System.out.println("----End of DBConnection Test Case----\n");
	}

	@AfterClass
	public static void destroy() {
		System.out.println("\t----End of Tests----");
		daotest = null;
		dbCon = null;
	}

}

