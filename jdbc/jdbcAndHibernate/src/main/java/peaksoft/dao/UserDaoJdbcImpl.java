package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    public final Util util1 = new Util();

    public UserDaoJdbcImpl() {
    }

    public void createUsersTable() {
        String createUT = "create table if not exists users(" +
                "id serial primary key," +
                "name varchar," +
                "last_name varchar," +
                "age int);";

        try (Connection connection = util1.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createUT);
            System.out.println("table created!");
        } catch (SQLException e) {
            System.out.println("!!!");
        }
    }

    public void dropUsersTable() {
        String dropUT = "drop table if exists users";
        try (Connection connection = util1.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropUT);
            System.out.println("table cleaned");
        } catch (SQLException e) {
            System.out.println("!!!!");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "insert into users (name, last_name, age) values (?,?,?)";
        try (Connection connection = util1.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println(name + " successfully added to database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String query = "delete from users where id = ?";
        try (Connection connection = util1.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String query = "select * from users";
        List<User> allUser = new ArrayList<>();
        try(Connection connection = util1.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte(4));
                allUser.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUser;
    }

        public void cleanUsersTable() {
            String sql = "delete from users;";
            try (Connection connection = util1.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
                System.out.println("you have successfully deleted all users in users table");

            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
    }
