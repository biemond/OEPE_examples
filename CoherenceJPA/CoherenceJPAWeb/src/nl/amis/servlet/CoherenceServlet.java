package nl.amis.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.amis.model.hr.Department;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

/**
 * Servlet implementation class CoherenceServlet
 */
@WebServlet("/CoherenceServlet")
public class CoherenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoherenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CacheFactory.ensureCluster();	

        NamedCache employee = CacheFactory.getCache("Employee");
        for ( int i = 1 ; i < 1000 ; i++) {
           employee.get(Long.valueOf(i));
        }
        
        NamedCache department = CacheFactory.getCache("Department");

        for ( int i = 1 ; i < 300 ; i++) {
           department.get(Long.valueOf(i));
        }

        response.setContentType("text/html; charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Department/Employee CacheTest</title></head>");
        out.println("<body>");
        out.println("<p><br>Loading of the Cache is Done</p>");
        out.println("</body></html>");
        out.close();

	
	}

}
