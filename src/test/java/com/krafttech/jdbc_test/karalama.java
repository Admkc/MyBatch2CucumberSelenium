package com.krafttech.jdbc_test;

import java.sql.*;

public class karalama {

    public static void main(String[] args) {

        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password ="VolkanAntalya159*";
        String query="select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";


        try {
            Connection connection=DriverManager.getConnection(url,userName,password);
            Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet=statement.executeQuery(query);

            ResultSetMetaData metaData= resultSet.getMetaData();

            System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());

        //    resultSet.next();

            while (resultSet.next()){
               for (int i=1;i<metaData.getColumnCount();i++){

                   System.out.println("resultSet.getString(i) = " + resultSet.getString(i)+"\t");

               }
                System.out.println();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }





}