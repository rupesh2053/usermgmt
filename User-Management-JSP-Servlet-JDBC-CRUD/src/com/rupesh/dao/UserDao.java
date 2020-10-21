package com.rupesh.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.rupesh.beans.User;
import com.rupesh.utils.DbUtil;

public class UserDao {

	private static final String INSERT_SQL = "insert into user(name,email,address,country) values(?,?,?,?)";
	private static final String SELECT_SQL = "select * from user where id=?";
	private static final String SELECT_ALL_SQL = "select * from user";
	private static final String UPDATE_SQL = "update user set name=?,email=?,address=?,country=? where id=?";
	private static final String DELETE_SQL = "delete from user where id=?";
	private static User user = new User();

	public static void insertUser(User user) {
		try {
			PreparedStatement statement = DbUtil.getConnection().prepareStatement(INSERT_SQL);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getCountry());
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static User getUserById(int userId) {
		try {
			PreparedStatement statement = DbUtil.getConnection().prepareStatement(SELECT_SQL);
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setCountry(rs.getString("country"));
			}
			statement.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

	public static List<User> getAllUser() {
		List<User> userList = new ArrayList<User>();
		try {
			PreparedStatement statement = DbUtil.getConnection().prepareStatement(SELECT_ALL_SQL);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String country = rs.getString("country");
				userList.add(new User(id, name, email, address, country));
			}

			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return userList;
	}

	public static void updateUser(User user, int userId) {
		try {
			PreparedStatement statement = DbUtil.getConnection().prepareStatement(UPDATE_SQL);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getCountry());
			statement.setInt(5, userId);
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void deleteUser(int userId) {
		try {
			PreparedStatement statement = DbUtil.getConnection().prepareStatement(DELETE_SQL);
			statement.setInt(1, userId);
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
