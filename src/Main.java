import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/taskdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Task Tracker ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addTask(sc);
                case 2 -> viewTasks();
                case 3 -> updateTask(sc);
                case 4 -> deleteTask(sc);
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addTask(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.print("Task Title: ");
            String title = sc.nextLine();
            System.out.print("Description: ");
            String desc = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO tasks(title, description) VALUES(?, ?)");
            ps.setString(1, title);
            ps.setString(2, desc);
            ps.executeUpdate();

            System.out.println("Task Added!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static void viewTasks() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tasks");

            System.out.println("\n--- All Tasks ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("------------------------");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static void updateTask(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.print("Task ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("New Title: ");
            String title = sc.nextLine();
            System.out.print("New Description: ");
            String desc = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement(
                "UPDATE tasks SET title=?, description=? WHERE id=?");
            ps.setString(1, title);
            ps.setString(2, desc);
            ps.setInt(3, id);
            ps.executeUpdate();

            System.out.println("Task Updated!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static void deleteTask(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.print("Task ID to delete: ");
            int id = sc.nextInt();

            PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM tasks WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Task Deleted!");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
