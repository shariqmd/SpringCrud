package com.myspringcrud.service;

import java.util.List;

import com.myspringcrud.entity.MyInfo;

public interface MyCrudService {

	void addCustomer(MyInfo info);

	List<MyInfo> getcustomers();

	MyInfo getcustomer(int theid);

	void deletecustomer(int theid);

}
