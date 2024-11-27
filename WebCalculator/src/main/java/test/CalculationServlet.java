package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class CalculationServlet
 */
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// here we read the parameters from the request
		// http://localhost:8080/WebCalculator/calculate?a=5&b=2&op=add
		
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		String operation = request.getParameter("op");
		int result = 0;
		if (operation.equals("add")) result = a + b;
		if (operation.equals("minus")) result = a - b;
		if (operation.equals("multiply")) result = a * b;
		if (operation.equals("div")) result = a / b;
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();
		json.put("result", result);
	    response.getWriter().print(json.toString());
	    response.getWriter().flush(); 
		
	}

}
