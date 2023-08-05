package practiceJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest2 {
    public static void main(String[] args) throws SQLException {
//        Connection connection = DriverManager.getConnection(
//                "jdbc:postgresql://localhost:5434/postgres",
//                "postgres",
//                "Admin12345"
//        );
//
//        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        ResultSet resultSet = statement.executeQuery("select * from jobs ");
//        resultSet.next();
//
//        System.out.println(resultSet.getString("first_name"));
//        List<Map<String, Object>> tableData = new ArrayList<>();
//
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        while (resultSet.next()) {
//
//            Map<String, Object> rowData = new HashMap<>();
//            for (int columnIndex = 1; columnIndex <= metaData.getColumnCount(); columnIndex++) {
//                rowData.put(metaData.getColumnName(columnIndex), resultSet.getString(metaData.getColumnName(columnIndex)));
//            }
//            tableData.add(rowData);
//        }
//        for (Map columnData : tableData) {
//            System.out.println(columnData.get("first_name"));
        System.out.println(getMinAndMaxSalaryForJob("select * from jobs", "Sales manager"));
      }
    //Get min and max salary for salary manager
        public static String getMinAndMaxSalaryForJob(String query, String jobTitle) throws SQLException {

            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5434/postgres",
                    "postgres",
                    "Admin12345");

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);


            List<Map<String, Object>>  tableData = new ArrayList<>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            while(resultSet.next()){

                Map<String, Object> rowData = new HashMap<>();

                for(int columnIndex=1; columnIndex<=metaData.getColumnCount(); columnIndex++){
                    rowData.put(metaData.getColumnName(columnIndex), resultSet.getString(metaData.getColumnName(columnIndex)));
                }
                tableData.add(rowData);
            }

            String result = "";

            for(Map columnData: tableData){

                if(columnData.get("job_title").toString().equalsIgnoreCase(jobTitle)){
                    result = "Min and max salary for "+jobTitle+": "+columnData.get("min_salary") + " "+columnData.get("max_salary");
                    break;
                }
            }

            connection.close();
            statement.close();
            resultSet.close();
            return  result;
        }
    }

