package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl {

    @Value("EMPLOYEE_DATA.json")
    private Resource resource;



}
