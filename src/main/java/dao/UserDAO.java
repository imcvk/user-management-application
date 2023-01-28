package dao;

import DBConnection.DBConnection;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UserDAO {
    public static String USER_INSERTER = "INSERT INTO User VALUES(?,?,?,?,?,?,?,?)";

    public static String USER_SELECTOR = "SELECT * FROM User u WHERE u.userid=?";

    public static int createUser(User u) throws SQLException {
        int r = 0;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(USER_INSERTER);
        statement.setInt(1, u.getUserid());
        statement.setString(2, u.getEmailAddress());
        statement.setString(3, u.getPhoneNumber());
        statement.setString(4, u.getAddress());
        statement.setString(5, u.getPassword());
        statement.setDate(6, toSqlDateFromUtilDate(u.getDOB()));
        statement.setString(7, u.getGender());
        statement.setString(8, u.getName());
        r = statement.executeUpdate();
        return r;
    }

    public static Date toSqlDateFromUtilDate(java.util.Date date) {
        java.util.Date utilDate = date;
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    public static String USER_UPDATER = "UPDATE User u set u.name =?,u.emailAddress =?,u.phoneNumber =?,u.address =?," +
            "u.DOB =?,u.gender =? WHERE u.userid =?";

    public static int updateUser(User u) {
        int r = 0;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(USER_UPDATER);
            statement.setInt(7, u.getUserid());
            statement.setString(1, u.getName());
            statement.setString(2, u.getEmailAddress());
            statement.setString(3, u.getPhoneNumber());
            statement.setString(4, u.getAddress());
            statement.setDate(5, toSqlDateFromUtilDate(u.getDOB()));
            statement.setString(6, u.getGender());

            r = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return r;
    }

    public static String LOGIN_QUERY = "select * from User where userid=?";

    public static User validateUser(User user) {
        User u = new User();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(LOGIN_QUERY);
            statement.setString(1, user.getEmailAddress());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setEmailAddress(rs.getString("emailAddress"));
                u.setPhoneNumber(rs.getString("phoneNumber"));
                u.setAddress(rs.getString("address"));
                u.setPassword(rs.getString("password"));
                u.setDOB(toSqlDateFromUtilDate(rs.getDate("DOB")));
                u.setGender(rs.getString("gender"));
                u.setName(rs.getString("name"));
                u.setUserid(rs.getInt("userid"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user.getPassword().equals(u.getPassword())) {
            return u;
        } else {
            u = null;
            return u;
        }
    }

    public static int generateRandomUserId() {
        int i = ThreadLocalRandom.current().nextInt(1111, 999999999);
        return i;
    }

    public static String ALL_USER_SELECTOR = "SELECT * FROM User";

    public static ArrayList<User> getAllUsers() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ArrayList<User> users = new ArrayList<>();
        try {
            statement = connection.prepareStatement(ALL_USER_SELECTOR);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setEmailAddress(rs.getString("emailAddress"));
                u.setPhoneNumber(rs.getString("phoneNumber"));
                u.setAddress(rs.getString("address"));
                u.setPassword(rs.getString("password"));
                u.setDOB(toSqlDateFromUtilDate(rs.getDate("DOB")));
                u.setGender(rs.getString("gender"));
                u.setName(rs.getString("name"));
                u.setUserid(rs.getInt("userid"));
                users.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static String DELETER = "DELETE FROM User u WHERE u.userid=?";

    public static int deleteUser(int userid) {
        int r = 0;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETER);
            statement.setInt(1, userid);
            r = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return r;
    }
}
