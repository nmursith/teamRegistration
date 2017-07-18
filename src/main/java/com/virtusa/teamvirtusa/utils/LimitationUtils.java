package com.virtusa.teamvirtusa.utils;

import org.springframework.stereotype.Service;

@Service
public class LimitationUtils {

	public int getMaxSize(int size){
		if (size > 10){
			return 10;
		}
		return size;
	}
	
}
