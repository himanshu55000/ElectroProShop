package com.ElectroProShopBacked.dao;

import java.util.List;

import com.ElectroProShopBacked.model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplierById(int id);
	public List<Supplier> getAllSupplier();
}
