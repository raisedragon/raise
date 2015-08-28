package net.raise.util;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LabelClassTest
{

    private String      SQL_UPDATE_APICALL = "UPDATE WT_APICALL T SET T.APICLASS='%s' WHERE T.APICLASS='%s';";
    private String      SQL_UPDATE_PROCESS = "UPDATE AD_PROCESS T SET T.CLASSNAME='%s' WHERE T.CLASSNAME='%s';";
    private String      SQL_SELECT_APICALL = "SELECT * FROM WT_APICALL T WHERE T.APICLASS='%s';";
    private String      SQL_SELECT_PROCESS = "SELECT * FROM AD_PROCESS T WHERE T.CLASSNAME='%s';";

    private Set<String> store              = new LinkedHashSet<String>();

    @BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

    // @Test
	public void testGetArray() throws IOException
	{
        String filename = "D:/work/MyWork/对接配置/Last Mile 配置项.xlsx";
        String[][] datas = PoiUtils.getArray(filename, "1.业务规则");
		int r=0;
        for (r = 2; r < 98; r++) {
            String sql = doItSea(datas[r][6], datas[r][5]);
            store.add(sql);
		}
        for (r = 98; r < 102; r++) {
            String sql = doItTrack(datas[r][6], datas[r][5]);
            store.add(sql);
        }


        for (r = 2; r < 102; r++) {
            if (StringUtils.isBlank(datas[r][10])) {
                continue;
            }
            String sql = doItTrack(datas[r][10], datas[r][11]);
            store.add(sql);
        }



        for (r = 2; r < 98; r++) {
            String sql = String.format(SQL_SELECT_APICALL, datas[r][5]);
            store.add(sql);
        }
        for (r = 98; r < 102; r++) {
            String sql = String.format(SQL_SELECT_PROCESS, datas[r][5]);
            store.add(sql);
        }


        for (r = 2; r < 102; r++) {
            if (StringUtils.isBlank(datas[r][10])) {
                continue;
            }
            String sql = String.format(SQL_SELECT_PROCESS, datas[r][10]);
            store.add(sql);
        }

        for (String s : store) {
            System.out.println(s);
        }
	}
	
    @Test
    public void back() throws IOException {
        String filename = "D:/work/MyWork/对接配置/Last Mile 配置项.xlsx";
        String[][] datas = PoiUtils.getArray(filename, "1.业务规则");
        int r = 0;
        for (r = 2; r < 98; r++) {
            String sql = doItSea(datas[r][5], datas[r][6]);
            store.add(sql);
        }
        for (r = 98; r < 102; r++) {
            String sql = doItTrack(datas[r][5], datas[r][6]);
            store.add(sql);
        }

        for (r = 2; r < 102; r++) {
            if (StringUtils.isBlank(datas[r][10])) {
                continue;
            }
            String sql = doItTrack(datas[r][11], datas[r][10]);
            store.add(sql);
        }

        for (r = 2; r < 98; r++) {
            String sql = String.format(SQL_SELECT_APICALL, datas[r][5]);
            store.add(sql);
        }
        for (r = 98; r < 102; r++) {
            String sql = String.format(SQL_SELECT_PROCESS, datas[r][5]);
            store.add(sql);
        }

        for (r = 2; r < 102; r++) {
            if (StringUtils.isBlank(datas[r][10])) {
                continue;
            }
            String sql = String.format(SQL_SELECT_PROCESS, datas[r][10]);
            store.add(sql);
        }

        for (String s : store) {
            System.out.println(s);
        }
    }

    public String doItSea(String... args) {
        return String.format(SQL_UPDATE_APICALL, args);
	}
	
    public String doItTrack(String... args) {
        return String.format(SQL_UPDATE_PROCESS, args);
    }
}
