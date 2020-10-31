import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet",urlPatterns = {"/addServlet"})
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        PrintWriter writer = response.getWriter();
        String flag = (String)request.getSession().getAttribute("loginFlag");
        System.out.println(flag);
        writer.println("<html>");
        writer.println("<body>");
        if(flag==null || !flag.equals("True") ) {
            System.out.println("Enter");
            writer.println("<p>please login</p>");
            writer.println("</body>");
            writer.println("</html>");
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
        if(a == null || b == null || !isNum(a) || !isNum(b))
            writer.println("<p>error parameters!</p>");
        else{
            writer.println("<p>para:a= "+a+" para:b= "+b+"</p>");
            writer.println("</body>");
            writer.println("</html>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/doneServlet");
            requestDispatcher.forward(request, response);
        }
    }

    public static boolean isNum(String num) {
        String validateStr="0123456789";
        for(int i=0; i < num.length(); i ++) {
            char ch = num.charAt(i);
            if (validateStr.indexOf(ch) < 0 ) return false;
        }
        return true;
    }
}
