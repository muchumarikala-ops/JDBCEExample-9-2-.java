
import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {

        String url =
            "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "your_password";

        String query =
            "SELECT id, username, email FROM users";

        try (
            Connection con =
                DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query)
        ) {
            System.out.println("ID\tUsername\tEmail");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("username") + "\t" +
                    rs.getString("email")
                );
            }

        } catch (SQLException e) {
            System.out.println(
                "Database error: " + e.getMessage()
            );
        }
    }
}
