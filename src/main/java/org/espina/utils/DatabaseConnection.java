package org.espina.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static ConstantVars constantVars = new ConstantVars();
    public static Connection connection(){

        try{
            //Registering driver
            Class.forName( constantVars.DRIVER );
            //We create the connection to db
            Connection conn = DriverManager.getConnection( constantVars.BBDD, constantVars.USER, constantVars.PASS );
            //Returning connection
            return conn;
        } catch (Exception e) {
            System.out.println(constantVars.ERR_CONN_DB
                    + e.getMessage().toString());
        }
        return null;
    }
    public static void closeConnection( Connection conn ){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println( constantVars.ERR_CLOSE_CONN + e.getMessage().toString());
            throw new RuntimeException(e);
        }
    }

}
