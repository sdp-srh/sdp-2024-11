package application;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import data.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadPersonsServlet
 */
public class ReadPersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadPersonsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read all persons from the database
		System.out.println(request.getRequestURI());
		
		DBHandler dbHandler = new DBHandler();
		ArrayList<Person> persons = dbHandler.readPersons();
		// create a simple html string
		String result = "<html>";
		result += "<body>";
		result += "<h1>Persons</h1>";
		int count =0;
		for (Person person : persons) {
			count++;
			// create a p tag for each person
			result += "<p>"+count+". "+person.getFirstName()+" "+person.getLastName()+"</p>";
		}
		result += "</body>";
		result += "</html>";
		// send the response to the browser
		response.setStatus(200);
		response.getWriter().append(result);
	}

}
