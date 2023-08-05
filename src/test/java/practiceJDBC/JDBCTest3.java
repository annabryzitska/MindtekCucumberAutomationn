package practiceJDBC;

import utilities.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest3 {
    public static void main(String[] args) throws SQLException {
        JDBCUtils.establishConnection();

        List<Map<String, Object>> tableData = JDBCUtils.runQuery("select * from jobs order by job_id desc");

        for(Map data: tableData){
            System.out.println(data.get("job_id"));
        }
       JDBCUtils.closeDataBase();
    }
}
