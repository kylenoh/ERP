package com.kyle.erp;

import java.text.SimpleDateFormat;
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
	
}






