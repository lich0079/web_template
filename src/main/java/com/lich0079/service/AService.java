package com.lich0079.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * the cache approach relay on spring proxy the class
 * so it must be a spring inited object so spring can proxy it
 * also the method must not be static
 */
@Service("aService")
public class AService {

    @Cacheable("pattern")
    public List getEmployeeData(String date){
    	System.out.println("Cache is not being used");
    	return new ArrayList();
    }

}
