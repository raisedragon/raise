package net.raise.util;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class VoyagePoiUtilsTest
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
		String filename = "C:/Users/longsheng.wang/Desktop/物流计划 华南 201507 OLD.xls";
		String[][]  datas = PoiUtils.getArray(filename, "SEA");
		int r=0;
		
		for(r=1;r<197;r++){
			doItSea(datas[r][0],
					datas[r][1],
					datas[r][2],
					datas[r][3],
					datas[r][4],
//					datas[r][5],
					datas[r][6],
//					datas[r][7],
//					datas[r][8],
					datas[r][9],
					datas[r][10],
//					datas[r][11],
					datas[r][12],
//					datas[r][13],
//					datas[r][14],
					datas[r][15],
					datas[r][16],
					datas[r][17],
					datas[r][18],
					datas[r][19],
					datas[r][20],
					datas[r][21],
					datas[r][22],
					datas[r][23]
					);
		}
		
		datas = PoiUtils.getArray(filename, "AIR");
		r=0;
		
		for(r=1;r<244;r++){
			doItAir(datas[r][0],
					datas[r][1],
					datas[r][2],
					datas[r][3],
//					datas[r][4],
					datas[r][5],
//					datas[r][6],
//					datas[r][7],
					datas[r][8],
					datas[r][9],
//					datas[r][10],
					datas[r][11],
//					datas[r][12],
//					datas[r][13],
					datas[r][14],
					datas[r][15],
					datas[r][16],
					datas[r][17],
					datas[r][18],
					datas[r][19],
					datas[r][20],
					datas[r][21],
					datas[r][22]
					);
		}
		
	}
	
	public void doItAir(String... args){
		String s = "select * from adempiere.wt_airflights t where"
		+"    PLANNAME               ='%s'"	//空运计划名
		+"and SERVICETIME            ='%s'"	//服务时间
		+"and BOATNAME               ='%s'"//航班
//		+"and SHIPNO                 ='%s'"//航班
		+"and START_COUNTRY_ID       = %s "//始发港国家
		+"and M_WAREHOUSESOURCE_ID   = %s "//始发仓库
//		+"and ORIGINALNAME           ='%s'"
		+"and ORIGINALCODE           ='%s'"//始发港代码
		+"and END_COUNTRY_ID         = %s "//目的港国家
		+"and M_WAREHOUSE_ID         = %s "//目的仓库
//		+"and DESTINATIONNAME        ='%s'"
		+"and DESTINATIONCODE        ='%s'"//目的港代码
		+"and ETD                    =to_date('%s','yyyy-mm-dd hh24:mi:ss')"//始发港ETD
		+"and ETA                    =to_date('%s','yyyy-mm-dd hh24:mi:ss')"//目的港ETA
		+"and FINISHEDTIME           =to_date('%s','yyyy-mm-dd hh24:mi:ss')"
		+"and BYORDEROFTIME          =to_date('%s','yyyy-mm-dd hh24:mi:ss')"
		+"and ASTHEGOODSTIME         =to_date('%s','yyyy-mm-dd hh24:mi:ss')"//截止收货时间
		+"and ESTIMATEDSHIPPINGDATE  =trunc(to_date('%s','yyyy-mm-dd hh24:mi:ss'))"
		+"and ESTIMATEDDATEOFARRIVAL =to_date('%s','yyyy-mm-dd hh24:mi:ss')"
		+"and DELIVERYTYPE           ='%s'"
		+"and CREATED           > to_date('2015-06-23','yyyy-mm-dd')";
		String ss = String.format(s, args);
		System.out.println(ss.replaceAll("&", "'||'&'||'"));
	}
	
	public void doItSea(String... args){
		String s = "select * from adempiere.WT_SeaVoage t where"
		+"    PLANNAME               ='%s'"	//空运计划名
		+"and SERVICETIME            ='%s'"	//服务时间
		+"and BOATNAME               ='%s'"//航班
		+"and SHIPNO                 ='%s'"//航班
		+"and START_COUNTRY_ID       = %s "//始发港国家
		+"and M_WAREHOUSESOURCE_ID   = %s "//始发仓库
//		+"and ORIGINALNAME           ='%s'"
		+"and ORIGINALCODE           ='%s'"//始发港代码
		+"and END_COUNTRY_ID         = %s "//目的港国家
		+"and M_WAREHOUSE_ID         = %s "//目的仓库
//		+"and DESTINATIONNAME        ='%s'"
		+"and DESTINATIONCODE        ='%s'"//目的港代码
		+"and ETD                    =to_date('%s','yyyy-mm-dd hh24:mi:ss')"//始发港ETD
		+"and ETA                    =to_date('%s','yyyy-mm-dd hh24:mi:ss')"//目的港ETA
		+"and FINISHEDTIME           =to_date('%s','yyyy-mm-dd hh24:mi:ss')"
		+"and BYORDEROFTIME          =to_date('%s','yyyy-mm-dd hh24:mi:ss')"
		+"and ASTHEGOODSTIME         =trunc(to_date('%s','yyyy-mm-dd hh24:mi:ss'))"//截止收货时间
		+"and ESTIMATEDSHIPPINGDATE  =to_date('%s','yyyy-mm-dd hh24:mi:ss')"
		+"and ESTIMATEDDATEOFARRIVAL =to_date('%s','yyyy-mm-dd hh24:mi:ss')"
		+"and DELIVERYTYPE           ='%s'"
		+"and CREATED           > to_date('2015-06-23','yyyy-mm-dd')";
		String ss = String.format(s, args);
		System.out.println(ss.replaceAll("&", "'||'&'||'"));
	}
	
}
