package com.kyle.erp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateManager {
	
	public static void getToday(HttpServletRequest req, HttpServletResponse res){
		Date today = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		req.setAttribute("y", sdf.format(today));
		
		sdf = new SimpleDateFormat("MM");
		req.setAttribute("m", sdf.format(today));
		
		sdf = new SimpleDateFormat("dd");
		req.setAttribute("d", sdf.format(today));
	}
	
	public static void getDueDay(HttpServletRequest req, HttpServletResponse res){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 30);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		req.setAttribute("y2", sdf.format(cal.getTime()));
		
		sdf = new SimpleDateFormat("MM");
		req.setAttribute("m2", sdf.format(cal.getTime()));
		
		sdf = new SimpleDateFormat("dd");
		req.setAttribute("d2", sdf.format(cal.getTime()));
	}
	
}






