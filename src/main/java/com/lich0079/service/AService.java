package com.lich0079.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("aService")
public class AService {

    @Cacheable("pattern")
    public List getEmployeeData(String date){
    	System.out.println("Cache is not being used");
    	return new ArrayList();
    }

}
