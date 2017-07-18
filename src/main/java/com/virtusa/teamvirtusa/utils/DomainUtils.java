package com.virtusa.teamvirtusa.utils;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomainUtils {
	
	private int DIGITS = 14;
	
	public String getRandomAccountNumber(){
		StringBuilder sb = new StringBuilder(DIGITS);
		for(int i = 0;i < DIGITS;i++) {		
		    sb.append((char) (Math.random() * 9 + '1'));
		}
		return sb.toString();
	}

/*	public List<_EntitySummary> getOrderedList(List<Object[]> list){
		List<_EntitySummary> entities = new ArrayList<>();
		for (Object[] a : list) {
			entities.add(new _EntitySummary(a[0].toString(), Float.parseFloat(a[1].toString())));
		}
		return entities;
	}*/
	
}
