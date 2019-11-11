package DAO;

import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    private Connection connection;

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAllUser() throws SQLException {
        List<User> allUsers = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("select * from users");
            ResultSet result = stmt.getResultSet();
            while (result.next()) {
                allUsers.add(new User(result.getLong("id"), result.getString("name"),
                        result.getString("job"), result.getLong("salary")));
            }
        }
        return allUsers;
    }

    public void addUser(User user) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("INSERT INTO users (name, job, salary) " +
                    "VALUES ('" + user.getName() + "', '" + user.getJob() + "'," + user.getSalary() + ")");

        }
    }

    public boolean deleteUser(Long id) {
        int delete = 0;
        try (Statement stmt = connection.createStatement()) {
            delete = stmt.executeUpdate("DELETE FROM users WHERE id= '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (delete > 0) {
            return true;
        }
        return false;
    }


    public void updateUser(User user) {
        String query = "update users set name= ?, job = ?, salary = ? where id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getJob());
            stmt.setLong(3, user.getSalary());
            stmt.setLong(4, user.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByName(String name) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            ResultSet result = stmt.executeQuery("SELECT * FROM users WHERE name= '" + name + "'");
            if (result.next()) {
                return new User(result.getLong("id"), name,
                        result.getString("job"), result.getLong("salary"));
            }
        }
        return null;
    }

    public User getUserById(Long id) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            ResultSet result = stmt.executeQuery("select * from users where id= " + id);
            if (result.next()) {
                return new User(id, result.getString("name"),
                        result.getString("job"), result.getLong("salary"));
            }
        }
        return null;
    }

    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists users (id bigint auto_increment, name varchar(256), job varchar(256), salary bigint, primary key (id))");
        stmt.close();
    }
}
