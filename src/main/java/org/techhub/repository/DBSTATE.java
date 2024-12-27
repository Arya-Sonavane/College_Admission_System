package org.techhub.repository;

import java.sql.*;

public class DBSTATE {
    static DBConfig config=DBConfig.getInstance();
    
    protected static Connection conn=config.getConn();
    protected PreparedStatement stmt=config.getStatement();
    protected ResultSet rs= config.getResult();
    protected CallableStatement cstmt=config.getCallStatement();
    DBSTATE(){
    	System.out.println(config.getConn());
    	
    } 
}
