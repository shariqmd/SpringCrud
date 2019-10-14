package com.myspringcrud.dao;

import java.util.List;

import com.myspringcrud.entity.MyInfo;

public interface MyCrudDao {

	void addCustomer(MyInfo info);

	List<MyInfo> getcustomers();

	MyInfo getcustomer(int theid);

	void deletecustomer(int theid);

}
