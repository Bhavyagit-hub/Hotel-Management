package com.example.demo.service;

import com.example.demo.model.Admin;

public interface AdminService {
	Admin saveAdmin(Admin admin);
	Admin loginAdmin(Admin admin);
}
