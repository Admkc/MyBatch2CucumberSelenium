package com.krafttech.utilities;

import javax.sql.rowset.RowSetWarning;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Utilities {

    static String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;" +
            "encrypt=true;trustServerCertificate=true;";
    static String userName = "u0583688_vlk";
    static String password = "VolkanAntalya159*";
    static String query = "select * from u0583688_vlk.dbo.regions";
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static ResultSetMetaData resultSetMetaData;

    public static void main(String[] args) throws SQLException {
        connectJdbc();

         runQuery();

         getrowCount();

         getResultSetData();

         getcloumnCount();
         getcloumnNameaslist();






         closeJDBC();



        try {
            resultSet.next();
            System.out.println("resultSet1.absolute(1) = " + resultSet.absolute(1));
        }catch (SQLException e){
            System.out.println("abluled row failed");

        }





    }
    static void connectJdbc(){
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            System.out.println("Connection FAILED" );
            e.getMessage();
        }
    }
    static ResultSet runQuery(){
        try {
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet=statement.executeQuery(query);

            System.out.println("resultset get result from JDBC");
        } catch (SQLException e) {
            System.out.println("resulset failed");
        }
        return resultSet;

    }
    static void closeJDBC(){
        try {
            if (resultSet!=null){
                resultSet.close();
                System.out.println("resultset closed");
            }
            if (resultSet!=null){
               statement.close();
                System.out.println("statement closed");
            }
            if (resultSet!=null){
                connection.close();
                System.out.println("connection closed");
            }

        }
        catch (SQLException ee){
            System.out.println("failed close JBBC");
        }
    }

    static int getrowCount(){
        int row=0;

        try {
            resultSet.last();
            row=resultSet.getRow();
            System.out.println(row);

            resultSet.beforeFirst();

        }catch (SQLException e){
            System.out.println("row count can not get");
            e.getMessage();
        }
        return row;

    }
    static int getcloumnCount(){

        int cloumtcount=0;

        try {
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            cloumtcount=resultSetMetaData.getColumnCount();
            System.out.println("cloumtcount = " + cloumtcount);


        }catch (SQLException e){
            e.getMessage();
        }
        return cloumtcount;
    }

    static ResultSetMetaData getResultSetData(){

        try {
            resultSetMetaData=resultSet.getMetaData();
            System.out.println("metadata is got");

        }catch (SQLException e){
            e.getMessage();
        }
        return resultSetMetaData;


    }

    static List<String> getcloumnNameaslist(){

        List<String > cloumnnameList=new ArrayList<>();

        for (int i=1;i<=getcloumnCount();i++){
            try {
                cloumnnameList.add(resultSetMetaData.getColumnName(i));


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return cloumnnameList;

    }
    static List<String > getrowdatalist(int rownumber){

        List<String > rowdataList=new ArrayList<>();

        try {
            resultSet.absolute(rownumber);

                for (int i=1;i<=getcloumnCount();i++){
                String cell=resultSet.getString(i);
                rowdataList.add(cell);


            }
            }catch (SQLException e) {
                throw new RuntimeException(e);

        }
        return rowdataList;
    }

    static String getcellData(int rowNumber,int columnNum){
        String cellData="";

        try {
            resultSet.absolute(rowNumber);
            resultSet.getString(columnNum);
        }catch (SQLException e){
            e.getMessage();
        }
        return cellData;
    }

    static String getcellData(int rowNumber,String  columnLabel){
        String cellData="";

        try {
            resultSet.absolute(rowNumber);
            resultSet.getString(columnLabel);
        }catch (SQLException e){
            e.getMessage();
        }
        return cellData;
    }





}

