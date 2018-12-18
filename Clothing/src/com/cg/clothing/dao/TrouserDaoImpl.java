package com.cg.clothing.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.clothing.bean.Shirt;
import com.cg.clothing.bean.Trouser;
import com.cg.clothing.util.DBConnection;

public class TrouserDaoImpl implements ITrouserDao 
{

	@Override
	public String addTrouser(Trouser trouser) throws SQLException, IOException 
	{
		String trouserId=null;
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			ResultSet resultSet=null;
			Statement stmt=conn.createStatement();
			
			pstmt=conn.prepareStatement("insert into trouser_details values(trouserId_sequence.nextval,?,?,?)");
			pstmt.setDouble(1, trouser.getTrouserPrice());
			pstmt.setString(2, trouser.getTrouserSize());
			pstmt.setString(3, trouser.getTrouserColour());
			
			pstmt.executeUpdate();
			resultSet=pstmt.executeQuery("select max(trouser_id) from trouser_details");
			while(resultSet.next())
			{
				System.out.println(resultSet.getString(1));
				//System.out.println(resultSet.getString(2));
				//System.out.println(resultSet.getString(3));
				//System.out.println(resultSet.getDouble(4));
			}
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e);
		}
		
		
		return trouserId;	
	}
	@Override
	public Trouser selectTrouser(String tid) throws SQLException, IOException 
	{
		Trouser s = new Trouser();
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			ResultSet resultSet=null;
			Statement stmt=conn.createStatement();
			
			
			pstmt=conn.prepareStatement("select * from trouser_details where trouser_id=?");
			pstmt.setString(1, tid);
			resultSet=pstmt.executeQuery();
			
			
			while(resultSet.next())
			{
	
				s.setTrouserId(resultSet.getString(1));
				s.setTrouserPrice(resultSet.getDouble(2));
				s.setTrouserSize(resultSet.getString(3));
				s.setTrouserColour(resultSet.getString(4));
			}
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e);
		}
		
		return s;
		
	}
	@Override
	public Trouser deleteTrouser(String tid) throws SQLException, IOException 
	{
		Trouser t = new Trouser();
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			ResultSet resultSet=null;
			Statement stmt=conn.createStatement();
			
			pstmt=conn.prepareStatement("delete from trouser_details where trouser_id=?");
			
			pstmt.setString(1, tid);
			resultSet=pstmt.executeQuery();
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e);
		}
		
		return t;
	}


	

	

	

}
