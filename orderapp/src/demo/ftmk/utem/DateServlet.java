package demo.ftmk.utem;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DateServlet
 */
@WebServlet("/dateServlet")
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Get link parameter
		int paramValue = Integer.parseInt(
		request.getParameter("param"));
		
		// Get writer
		PrintWriter writer = response.getWriter();
		
		// Get current date
		LocalDate now = LocalDate.now();
		
		switch(paramValue) {
		case -1:
			// Display yesterday’s date
			LocalDate yesterday = now.minusDays(1);
			writer.println("Yesterday is " + yesterday.toString());
			break;
		case 0:
			// Display current date
			writer.println("Today is " + now.toString());
			break;
		case 1:
			// Display tomorrow's date
			LocalDate tomorrow = now.plusDays(1);
			writer.println("Tomorrow is " + tomorrow.toString());
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
