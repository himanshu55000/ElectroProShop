package com.electroproshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ElectroProShopBacked.dao.SupplierDAO;
import com.ElectroProShopBacked.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping("/manageSupplier")
	public String manageSupplier(Model m) {
		List<Supplier> list=supplierDAO.getAllSupplier();
		m.addAttribute("supList",list);
		return "manageSupplier";
	}
	@RequestMapping("/addSupplier")
	public String addSupplier(@RequestParam String name) {
		supplier.setSid(0);
		supplier.setSupplierName(name);
		supplierDAO.addSupplier(supplier);
		return "redirect:manageSupplier";
	}
	@RequestMapping("/updateSupplier")
	public String updateSupplier(@RequestParam int id,@RequestParam String name) {
		supplier.setSid(id);
		supplier.setSupplierName(name);
		supplierDAO.updateSupplier(supplier);
		return "redirect:manageSupplier";
	}
	@RequestMapping("/deleteSupplier")
	public String deleteSupplier(@RequestParam int id) {
		Supplier supplier2=supplierDAO.getSupplierById(id);
		supplierDAO.deleteSupplier(supplier2);
		return "redirect:manageSupplier";
	}
}
