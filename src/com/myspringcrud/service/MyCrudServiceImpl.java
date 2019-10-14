package com.myspringcrud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringcrud.dao.MyCrudDao;
import com.myspringcrud.entity.MyInfo;

@Service
public class MyCrudServiceImpl implements MyCrudService {
	
	@Autowired
	
    private MyCrudDao mycruddao;
	
	@Transactional
	@Override
	public void addCustomer(MyInfo info) {
	 
		mycruddao.addCustomer(info);
		
	}
	
    @Transactional
	@Override
	public List<MyInfo> getcustomers() {

		return mycruddao.getcustomers();
	}

    @Transactional
	@Override
	public MyInfo getcustomer(int theid) {
		
		return mycruddao.getcustomer(theid);
	}
    
    @Transactional
	@Override
	public void deletecustomer(int theid) {
	
		mycruddao.deletecustomer(theid);
		
	}

}
