package net.raise.util;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PoiUtilsTest
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Test
	public void testGetArray() throws IOException
	{
		String filename = "D:\\work\\MyWork\\对接配置\\Last Mile 配置项.xlsx";
		String[][]  datas = PoiUtils.getArray(filename, "美国");
		int r=0;
		for(r=95;r<131;r++){
			doIt(datas[r][0], datas[r][1]);
		}
		
		
//		for(r=205;r<214;r++){
//			doIt(datas[r][0], datas[r][1]);
//		}
//		for(r=220;r<224;r++){
//			doIt(datas[r][0], datas[r][1]);
//		}
		
	}
	
	public void doIt(String... args){
		String s = "insert into wt_sysconfig(name,value) values('%s','%s');";
		String ss = String.format(s, args);
		System.out.println(ss);
	}
	
	
//	@Test
	public void testGetArray1() throws IOException
	{
		String filename = "D:\\work\\MyWork\\USA\\DHL\\New XML-PI Toolkit (US)\\Reference_Data.xls";
		String[][]  datas = PoiUtils.getArray(filename, "Error Eessages");
		int r=0;
		for(r=1;r<313;r++){
			doIt1(datas[r][0],"3");
		}
		
	}
	
	public void doIt1(String... args){
		String s = "insert into WT_POSTCODE_GROUP(POSTCODE,LOGISTICS_DIST_ID) values('%s',%s);";
		String ss = String.format(s, args);
		System.out.println(ss);
	}
}
