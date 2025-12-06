import java.sql.*;

public class TestConn {
    public static void main(String[] args) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Driver encontrado!");
    }
}
