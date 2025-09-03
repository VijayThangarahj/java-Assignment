import java.sql.*;
import java.util.Scanner;

public class Main{
    private static final String URL = "jdbc:mysql://localhost:3306/login_schema"; // Change DB name
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "Asta@1089"; // Your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("✅ Connected to Database!");

            while (true) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student Marks");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addStudent(conn, sc);
                    case 2 -> viewStudents(conn);
                    case 3 -> updateStudent(conn, sc);
                    case 4 -> deleteStudent(conn, sc);
                    case 5 -> {
                        System.out.println("👋 Exiting...");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice, try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 1. Add Student
    private static void addStudent(Connection conn, Scanner sc) throws SQLException {
        String sql = "INSERT INTO student (id, name, marks,contNumber) VALUES (?, ?, ?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            System.out.println("Enter ContactNumber");
            int contNumber = sc.nextInt();

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, marks);
            pstmt.setLong(4,contNumber);

            int rows = pstmt.executeUpdate();
            System.out.println("✅ " + rows + " student added successfully.");
        }
    }

    // 2. View Students
    private static void viewStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM student";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n📌 Student List:");
            System.out.println("ID | Name | Marks | ContNumber");
            System.out.println("-----------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("marks") + " | " + rs.getDouble("contNumber"));
            }
        }
    }

    // 3. Update Student Marks
    private static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        String sql = "UPDATE student SET marks = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            System.out.print("Enter new Marks: ");
            int marks = sc.nextInt();

            pstmt.setInt(1, marks);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Student updated successfully.");
            else
                System.out.println("❌ Student not found.");
        }
    }

    // 4. Delete Student
    private static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Student deleted successfully.");
            else
                System.out.println("❌ Student not found.");
        }
    }
}