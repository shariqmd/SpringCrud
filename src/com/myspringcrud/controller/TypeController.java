package com.myspringcrud.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myspringcrud.entity.MyInfo;
import com.myspringcrud.service.MyCrudService;




@Controller
public class TypeController {
	
	@Autowired
	private MyCrudService mycrudservice;
	
	
	@RequestMapping("/customer")
	public String showForm(Model model) {
		
		MyInfo myinfo=new MyInfo();
		model.addAttribute("customer",myinfo);
		
		return "customerform";
		
	}
	
	
	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("customer") MyInfo info, HttpSession session) {
		
		mycrudservice.addCustomer(info);
		session.setAttribute("msgclc", "");
		
		
		return "redirect:/list";
		
		
	}
	
	@GetMapping("/list")
	
	public String listCustomer(Model model) {
		
		List<MyInfo> getcustomerlist=mycrudservice.getcustomers();
		
		model.addAttribute("myinfo",getcustomerlist);
		
		
		
		return "listcustomer";
		
		
		
	}
	
	@GetMapping("/updateForm")
	public String  updateCustomer(@RequestParam("customerId") int theid, Model model, HttpSession session) {
		
		System.out.println("THis is Id000000000000000000" +theid);
		
		MyInfo mypinfo = mycrudservice.getcustomer(theid);
		model.addAttribute("customer",mypinfo);
	    
		
		return "customerform";
		
		
		
	}
	
	@GetMapping("/delete")
	
	public String deleteCustomer(@RequestParam("customerId") int theid, Model model, HttpSession session) {
		
		mycrudservice.deletecustomer(theid);
		
		session.setAttribute("msgclc", "");
		
		return "redirect:/list";
		
		
	}
	
	

}
