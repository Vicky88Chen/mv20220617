

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Coffee;
import model.DBDao;

/**
 * Servlet implementation class UpdateCoffeeServlet
 */
@WebServlet("/UpdateCoffeeServlet")
public class UpdateCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCoffeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCoffee</title>");            
            out.println("</head>");
            out.println("<body>");
            
    		InputStream in=request.getInputStream();
    		InputStreamReader ir=new InputStreamReader(in,"utf-8");
    		BufferedReader br=new BufferedReader(ir);
    		String data="";
            String temp=null;
            while((temp=br.readLine())!=null)
            	data+=temp;
            Gson g=new Gson();
    		Coffee   c=g.fromJson(data, Coffee.class);
    		
            //String coffee=request.getParameter("coffee");
            //String sale=request.getParameter("sale");
            //String total=request.getParameter("total");         
            try {
                 boolean f= DBDao.updateCoffeeSales(c.getCofName(),c.getSales(),c.getTotal());
                 if(f) {
                	 out.println("修改完成");
                 }else
                	 out.println("修改失敗");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
           
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
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
