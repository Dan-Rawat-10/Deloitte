package com.deloitte.cms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.deloitte.cms.dao.Customer;
import com.deloitte.cms.dao.CustomerDAO;
import com.deloitte.cms.dao.DBUtility;

public class CustomerDOAImpl implements CustomerDAO {
	private static final String SELECT_CUSTOMER_QUERY = "select * from hr.customer where customerId = ?";
	private static final String SELECT_ALL_CUSTOMER = "select * from hr.customer";
	private static final String INSERT_CUSTOMER = "INSERT INTO hr.customer values(?,?,?,?)";
	private static final String UPDATE_CUSTOMER_ = "update hr.customer set customername = ?, customeraddress = ?, billamount = ? where customerId = ?";
	private static final String DELETE_CUSTOMER = "delete from hr.customer where customerId = ?";
	private static final String SEARCH_CUSTOMER = "select customername, customeraddress, billamount from hr.customer where customerId = ?";
	
	@Override
	public List<Customer> getAllCusomers() {
		Connection con = DBUtility.getMyConnection();
		PreparedStatement st;
		List<Customer> allcust = new ArrayList<Customer>();
		try {
			st = con.prepareStatement(SELECT_ALL_CUSTOMER);
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerId(rs.get Int(1));
				cust.setCustomerName(rs.getString(2));
				cust.setCustomerAddress(rs.getString(3));
				cust.setBillAmount(rs.getInt(4));
				allcust.add(cust);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allcust;
	}

	@Override
	public boolean insertCustomer(Customer customer) {
		Connection con = DBUtility.getMyConnection();
		PreparedStatement st;
		int num = 0;
		try {
			st = con.prepareStatement(INSERT_CUSTOMER);
			st.setInt(1, customer.getCustomerId());
			st.setString(2, customer.getCustomerName());
			st.setString(3, customer.getCustomerAddress());
			st.setInt(4, customer.getBillAmount());
			num = st.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(num ==0)
			return false;
		return true;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		Connection con = DBUtility.getMyConnection();
		PreparedStatement st;
		int num = 0;
		try {
			st = con.prepareStatement(UPDATE_CUSTOMER_);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the name : ");
			String name = sc.next();
			System.out.println("Enter the address : ");
			String add = sc.next();
			System.out.println("Enter the billamount : ");
			int bill = sc.nextInt();
			st.setInt(4, customer.getCustomerId());
			st.setString(1, name);
			st.setString(2, add);
			st.setInt(3, bill);
			num = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(num == 0)
			return false;
		return true;
	}

	@Override
	public boolean deleteCustomer(int id) {
		Connection con = DBUtility.getMyConnection();
		PreparedStatement st;
		int num = 0;
		try {
			st = con.prepareStatement(DELETE_CUSTOMER);
			st.setInt(1,id);
			num = st.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(num == 0)
			return false;
		return true;
	}

	@Override
	public Customer searchCustomerById(int customerId) {
		Connection con = DBUtility.getMyConnection();
		PreparedStatement st;
		Customer cust = new Customer();
		try {
			st = con.prepareStatement(SEARCH_CUSTOMER);
			st.setInt(1,customerId);
			ResultSet rs = st.executeQuery();
			rs.next();
			cust.setCustomerId(customerId);
			cust.setCustomerName(rs.getString(1));
			cust.setCustomerAddress(rs.getString(2));
			cust.setBillAmount(rs.getInt(3));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public boolean isCustomerExists(int customerId) {
		boolean isUserExist = false;
		Connection con = DBUtility.getMyConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement(SELECT_CUSTOMER_QUERY);
			st.setInt(1, customerId);
			
			ResultSet rs = st.executeQuery();
			if(rs.next())
				isUserExist = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUserExist;
	}

}
