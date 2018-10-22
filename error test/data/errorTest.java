package com.pxy.test;
/*
 * 循环error测试捕捉方法
 */
import java.text.ParseException;
import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class errorTest {
	
	public static void main(String[] args) {
		/*
		 * 方法1：在循环内捕捉
		 */
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Date> list = new ArrayList<>(10);
		for(int cnt1=0;cnt1<10;cnt1++){
		    try {
		        Date date = dateformat.parse("09-02");
		        list.add(date);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		}
		
		/*
		 * 方法2：在循环外捕捉
		 */
		
		SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Date> list2 = new ArrayList<>(10);
		try {
		    for(int cnt1=0;cnt1<10;cnt1++){
		        Date date = dateformat2.parse("09-02");
		        list2.add(date);
		    }
		} catch (ParseException e) {
		    e.printStackTrace();
		}


	}

}
