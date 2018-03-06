package com.servlet.servletController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.DBData;
import com.servlet.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBData db = new DBData();
	 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertStudent(request, response);
                break;
            case "/delete":
                deleteStudent(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateStudent(request, response);
                break;
            default:
                listStudent(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
		

	 private void listStudent(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        List<Student> liststudent = db.getStudentList();
	        request.setAttribute("studentList", liststudent);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	   private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentForm.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int studentId = Integer.parseInt(request.getParameter("studentid"));
	        Student existingStudent = db.getStudentById(studentId);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentForm.jsp");
	        request.setAttribute("student", existingStudent);
	        dispatcher.forward(request, response);
	 
	    }
	 
	    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        String firstname = request.getParameter("firstname");
	        String lastname = request.getParameter("lastname");
	        int yearLevel = Integer.parseInt(request.getParameter("yearLevel"));
	        long marks = Long.parseLong(request.getParameter("marks"));
	 
	        Student newStudent=new Student(firstname,lastname,yearLevel,marks);
	       db.addStudent(newStudent);
	        response.sendRedirect("home");
	    }
	 
	    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	    	
	    	String firstname = request.getParameter("firstname");
	        String lastname = request.getParameter("lastname");
	        int yearLevel = Integer.parseInt(request.getParameter("yearLevel"));
	        long marks = Long.parseLong(request.getParameter("marks"));
	 
	        Student student=new Student(firstname,lastname,yearLevel,marks);
		       db.updateStudent(student);
		        response.sendRedirect("home");
	    }
	 
	    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("studentid"));
	        Student student=new Student(id);
	        db.deleteStudent(student);
	        response.sendRedirect("home");
	 
	    }
	
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
