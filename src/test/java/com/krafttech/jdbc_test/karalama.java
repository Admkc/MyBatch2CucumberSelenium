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
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);

            ResultSetMetaData metaData=resultSet.getMetaData();

            System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());
            System.out.println("metaData.getColumnName(2) = " + metaData.getColumnName(2));
            System.out.println("metaData.getColumnName(3) = " + metaData.getColumnName(3));
            System.out.println("metaData.getColumnName(3) = " + metaData.getColumnName(4));
            System.out.println("metaData.getColumnName(3) = " + metaData.getColumnName(5));
            System.out.println("metaData.getColumnName(3) = " + metaData.getColumnName(6));

            int kolonsayisi=metaData.getColumnCount();

            for (int i=1;i<=kolonsayisi;i++){
                System.out.println("metaData.getColumnName(i) = " + metaData.getColumnName(i));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    }
