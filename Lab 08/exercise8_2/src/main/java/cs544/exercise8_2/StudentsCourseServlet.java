package cs544.exercise8_2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);//.getWebApplicationContext(servletContext);
		StudentService serv = context.getBean("studentService", StudentService.class);
		
		String studentIdStr = request.getParameter("studentid");

		long studentid = -1;
		Student student = null;
		serv.createStudent();
		
		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			studentid = Long.parseLong(studentIdStr);
			StudentService studentService = serv;
			student = studentService.getStudent(studentid);
		}

		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("tst");
	}

}
