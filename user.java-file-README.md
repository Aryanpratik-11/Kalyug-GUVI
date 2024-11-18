
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String role;

    // Constructor
    public User(int userId, String name, String email, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Create a new user (Admin or Customer)
    public static void createUser(Connection connection, String name, String email, String password, String role) {
        String query = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, role);
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve a user by email
    public static User getUserByEmail(Connection connection, String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update user details
    public static void updateUser(Connection connection, int userId, String name, String email, String role) {
        String query = "UPDATE users SET name = ?, email = ?, role = ? WHERE user_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, role);
            stmt.setInt(4, userId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a user
    public static void deleteUser(Connection connection, int userId) {
        String query = "DELETE FROM users WHERE user_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, userId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
