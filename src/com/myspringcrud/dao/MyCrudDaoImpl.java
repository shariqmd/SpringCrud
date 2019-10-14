package com.myspringcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.myspringcrud.entity.MyInfo;

@Repository
public class MyCrudDaoImpl implements MyCrudDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void addCustomer(MyInfo info) {
		System.out.println(info.getId());
		System.out.println(info.getFirstname());
		System.out.println(info.getLastname());
		System.out.println(info.getEmail());
	Session session =sessionfactory.getCurrentSession();
	session.saveOrUpdate(info);
		
		
		
		
	}

	@Override
	public List<MyInfo> getcustomers() {
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		Session session=sessionfactory.getCurrentSession();
		Query<MyInfo> myquery=session.createQuery("from MyInfo",MyInfo.class);
		List<MyInfo>mylist=myquery.getResultList();
		
		return mylist;
	}

	@Override
	public MyInfo getcustomer(int theid) {
		Session session=sessionfactory.getCurrentSession();
		MyInfo myinfo=	session.get(MyInfo.class,theid);
		return myinfo;
	}

	@Override
	public void deletecustomer(int theid) {
		
		Session session=sessionfactory.getCurrentSession();
		Query qry=session.createQuery("delete from MyInfo where id=:infoid");
		qry.setParameter("infoid", theid);
		qry.executeUpdate();
		
	}

}
