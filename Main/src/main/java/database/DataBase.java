package database;

import java.sql.*;

/**
 * Created by raychen on 16/5/22.
 */
public class DataBase {

    private static DataBase dataBase = null;
    private Connection conn = null;
    private Statement statement = null;

    private DataBase() {
        connect();
    }

    public static DataBase getInstance(){
        if (dataBase != null) return dataBase;
        else {
            return new DataBase();
        }
    }

    public void connect(){
        try {
            Class.forName(Config.JDBC_DRIVER);
            System.out.printf("connect to ...");
            conn = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASS);

            System.out.println("success");
            statement = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql){
        ResultSet ret = null;
        if (statement == null) return null;
        try {
            ret = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("error in query: "+ e.getMessage());
            e.printStackTrace();
        }
        return ret;
    }

    public boolean excute(String sql){
        if (statement == null) return false;
        try {
            if (statement.execute(sql)) return true;
        } catch (SQLException e) {
            System.out.println("error in excute: "+ e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
