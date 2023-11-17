package controller;

public class Config {
    public class Database {
        public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        public static final String URL = "jdbc:mysql://localhost:3306/uas_pbo";
        public static final String USER = "root";
        public static final String PASSWORD = "";
    }

    public static class Path {
        public static final String TEMP_DIR = System.getProperty("java.io.tmpdir") + "/uas_pbo/";
    }
}
