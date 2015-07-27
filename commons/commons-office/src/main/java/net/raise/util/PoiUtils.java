package net.raise.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class PoiUtils
{

//	@Test
//	public void test() throws IOException
//	{
//		Map<String, String> map = getMap("D:\\work\\MyWork\\面单服务\\DATA_UBI.xls", "sheet");
//		for (Entry<String, String> entry : map.entrySet())
//		{
//			System.out.println(entry.getKey() + ":\t" + entry.getValue());
//		}
//	}

	public Map<String, String> getMap(String file, String sheetfile) throws IOException
	{
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheet(sheetfile);

		Map<String, String> map = new HashMap<String, String>();

		int rowNum = 0;
		HSSFRow row = null;
		while ((row = sheet.getRow(rowNum++)) != null)
		{
			int colNum = 0;
			HSSFCell cell = null;
			while (null != (cell = row.getCell(colNum++)))
			{
				map.put(getKey(rowNum, colNum), getStringCellValue(cell));
			}
		}

		return map;
	}

	public static String[][] getArray(String file, String sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = null;
		try
		{
			wb = new XSSFWorkbook(fis);
		}
		catch (Exception ex)
		{
			if(fis!=null){
				fis.close();
			}
			fis = new FileInputStream(file);
			wb = new HSSFWorkbook(fis);
		}
		Sheet sheet = wb.getSheet(sheetname);

		List<List<String>> sheetdatas = new ArrayList<List<String>>();
		int rowNum = 0;
		Row row = null;
		
		
		while (rowNum<=sheet.getLastRowNum())
		{
			row = sheet.getRow(rowNum++);
			List<String> rowdatas = new ArrayList<String>();
			if(row!=null){
				int colNum = 0;
				Cell cell = null;
				while (colNum<=row.getLastCellNum()){
					cell = row.getCell(colNum++);
					if(cell!=null){
						rowdatas.add(getStringCellValue(cell));
					}
				}
			}
			sheetdatas.add(rowdatas);
		}

		int d1 = sheetdatas.size();
		int d2 = 0;
		for (List<String> rd : sheetdatas)
		{
			if (d2 < rd.size())
			{
				d2 = rd.size();
			}
		}

		String[][] s = new String[d1][d2];
		for (int i = 0; i < sheetdatas.size(); i++)
		{
			for (int j = 0; j < sheetdatas.get(i).size(); j++)
			{
				s[i][j] = sheetdatas.get(i).get(j);
			}
		}
		return s;
	}

	static String getStringCellValue(Cell cell)
	{
		String value = null;
		switch (cell.getCellType())
		{
			case Cell.CELL_TYPE_NUMERIC:
				cell.setCellType(Cell.CELL_TYPE_STRING);
				// double v = cell.getNumericCellValue();
				// value = String.valueOf(v);
				break;
			default:
				value = cell.getStringCellValue();
				break;
		}
		value = cell.getStringCellValue();
		if (StringUtils.isBlank(value))
		{
			value = null;
		}
		return value;
	}

	private String getKey(int rowNum, int colNum)
	{
		String key = rowNum + "," + colNum;
		return key;
	}

}