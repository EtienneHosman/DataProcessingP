package p2.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {

    public static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    public static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
    public static final String DB_USER = "etiennep";
    public static final String DB_PASS = "admin";
    private  static Connection conn;

    public OracleBaseDao(){
        try{
            if(conn == null){
                conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return conn;
    }

    public void closeConnection(){
        try{
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
