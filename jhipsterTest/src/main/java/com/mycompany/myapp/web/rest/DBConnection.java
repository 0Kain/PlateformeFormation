package com.mycompany.myapp.web.rest;

import org.json.JSONObject;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import com.mycompany.myapp.security.AuthoritiesConstants;
import com.mysql.jdbc.*;
import java.sql.*;

@RestController
//@Secured(AuthoritiesConstants.ADMIN)
@RequestMapping("/api/db")
public class DBConnection {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3307/platformation?useUnicode=true&characterEncoding=utf8&useSSL=false";
    static final String USER = "root";
    static final String PASS = "platformation";

    static void insert(String tableName, JSONObject obj){
        java.sql.Connection conn = null;
        java.sql.Statement stmt = null;

        System.out.println("Trying to insert data in db");

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
      
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            
            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();
            
            String columns = "";
            String toInsert = "";
            for(String x : obj.keySet()){
                String k = obj.getString(x).replace("\'","\\\'");
                if(x.equals("sujet") || x.equals("keywords"))k=k.substring(1,k.length()-2);
                toInsert += "\'"+k+"\',";
                columns += x+",";
            }
            toInsert = toInsert.substring(0,toInsert.length()-1);
            columns = columns.substring(0,columns.length()-1);

            String sql = "INSERT INTO " + tableName + "(" + columns +
                         ") VALUES (" + toInsert + ")";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
      
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
            }//end finally try
         }
    } 

}