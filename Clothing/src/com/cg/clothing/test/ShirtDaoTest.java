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

import com.cg.clothing.bean.Shirt;
import com.cg.clothing.dao.ShirtDaoImpl;
import com.cg.clothing.exception.ClothingException;
import com.cg.clothing.service.ClothingServiceImpl;
import com.cg.clothing.service.IClothingService;

public class ShirtDaoTest {

	static ShirtDaoImpl dao;
	static Shirt shirt;

	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new ShirtDaoImpl();
		shirt = new Shirt();
	}

	@Test
	public void testAddDonar() throws ClothingException, SQLException, IOException {

		assertNotNull(dao.addShirt(shirt));

	}

	/************************************
	 * Test case for addShirt()
	 * @throws IOException 
	 * @throws SQLException 
	 * 
	 ************************************/

	@Ignore
	@Test
	public void testAddShirt() throws ClothingException, SQLException, IOException {
		// increment the number next time you test for positive test case
		assertEquals(1001, dao.addShirt(shirt));
	}

	/************************************
	 * Test case for addShirt()
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 * 
	 ************************************/

	@Test
	public void testAddShirt2() throws ClothingException, NumberFormatException, SQLException, IOException {

		shirt.setShirtId("1");
		shirt.setShirtPrice(1245);
		shirt.setShirtSize("M");
		shirt.setShirtColour("Red");
		assertTrue("Data Inserted successfully",
				Integer.parseInt(dao.addShirt(shirt)) > 1);

	}
}
