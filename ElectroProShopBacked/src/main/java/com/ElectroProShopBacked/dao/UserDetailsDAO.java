package com.ElectroProShopBacked.dao;

import com.ElectroProShopBacked.model.UserDetails;

public interface UserDetailsDAO {
public boolean addUserDetails(UserDetails userDetails);
public boolean validateUser(String username,String password);
}
