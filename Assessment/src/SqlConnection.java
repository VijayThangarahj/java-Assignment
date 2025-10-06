import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SqlConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school"; // replace with your DB name
        String username = "root";   // replace with your DB username
        String password = "Asta@1089"; // replace with your DB password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            String insertQuery = "INSERT INTO student (id, name, age) VALUES (" + id + ", '" + name + "', " + age + ")";
            stmt.executeUpdate(insertQuery);
            System.out.println("✅ Record inserted successfully!");

            String selectQuery = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("\nID\tName\tAge");
            while (rs.next()) {
                int sid = rs.getInt("id");
                String sname = rs.getString("name");
                int sage = rs.getInt("age");
                System.out.println(sid + "\t" + sname + "\t" + sage);
            }

            rs.close();
            stmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
