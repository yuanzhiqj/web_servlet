import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doneServlet",urlPatterns="/doneServlet")
public class doneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String a = request.getParameter("a");
        String b = request.getParameter("b");
        PrintWriter writer = response.getWriter();
        int shu1 = Integer.valueOf(a);
        int shu2 = Integer.valueOf(b);
        int sum = shu1+shu2;
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p>sumption</p>");
        writer.println("<p>sum: "+sum+"</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
