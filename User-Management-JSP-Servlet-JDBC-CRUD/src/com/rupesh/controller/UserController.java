package com.rupesh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rupesh.beans.User;
import com.rupesh.dao.UserDao;

@WebServlet("/")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {

		case "/new":
			try {
				showForm(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;

		case "/insert":
			try {
				insertUser(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;

		case "/edit":
			try {
				showUpdateForm(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;

		case "/update":
			try {
				updateUser(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;

		case "/delete":
			try {
				deleteUser(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
			
		default:
			try {
				listUser(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		}
	}

	//listing all users
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			request.setAttribute("userList", UserDao.getAllUser());
			request.getRequestDispatcher("list-user.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//delete existing user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserDao.deleteUser(getValue(request.getParameter("id")));
		response.sendRedirect("list");
	}

	// updating user
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = getValue(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		UserDao.updateUser(new User(name, email, address, country), id);
		response.sendRedirect("list");
	}

	// showing update form
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			request.setAttribute("user", UserDao.getUserById(getValue(request.getParameter("id"))));
			request.getRequestDispatcher("user-form.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// inserting user to database
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		UserDao.insertUser(new User(name, email, address, country));
		response.sendRedirect("list");
	}

	// show registration form
	private void showForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			request.getRequestDispatcher("user-form.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// helper method to convert String to integer
	public int getValue(String key) {
		return Integer.parseInt(key);
	}

}
