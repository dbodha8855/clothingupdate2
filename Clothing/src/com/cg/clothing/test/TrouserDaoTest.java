package com.cg.clothing.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.cg.clothing.bean.Trouser;
import com.cg.clothing.dao.TrouserDaoImpl;
import com.cg.clothing.exception.ClothingException;
import com.cg.clothing.service.ClothingServiceImpl;
import com.cg.clothing.service.IClothingService;

public class TrouserDaoTest {

	static TrouserDaoImpl dao;
	static Trouser trouser;

	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new TrouserDaoImpl();
		trouser = new Trouser();
	}

	@Test
	public void testAddShirt() throws ClothingException, SQLException, IOException {

		assertNotNull(dao.addTrouser(trouser));

	}

	/************************************
	 * Test case for addTrouser()
	 * @throws IOException 
	 * @throws SQLException 
	 * 
	 ************************************/

	@Ignore
	@Test
	public void testAddTrouser() throws ClothingException, SQLException, IOException {
		// increment the number next time you test for positive test case
		assertEquals(1001, dao.addTrouser(trouser));
	}

	/************************************
	 * Test case for addTrouser()
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 * 
	 ************************************/

	@Test
	public void testAddTrouser2() throws ClothingException, NumberFormatException, SQLException, IOException {

		trouser.setTrouserId("1");
		trouser.setTrouserPrice(15689);
		trouser.setTrouserSize("S");
		trouser.setTrouserColour("Green");
		assertTrue("Data Inserted successfully",
				Integer.parseInt(dao.addTrouser(trouser)) > 1);

	}
}
