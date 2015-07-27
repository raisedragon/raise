package net.raise.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.math.NumberUtils;
import org.junit.Test;

public class T {
	@SuppressWarnings("deprecation")
//	@Test
	public void test() throws ParseException{
		String t= "18th Nov 2014 06:11".replace("th", "");
		@SuppressWarnings("deprecation")
//		Date d = new Date(t);
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm",Locale.US);  
		Date dt = dateFormat.parse(t);
		System.out.println(System.currentTimeMillis());
	}
	@Test
	public void test2(){
		double a = 0.215;
		double b= 0.248;
		double c =BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).doubleValue();
		System.out.println(a+b);
		System.out.println(c);

	}
}
