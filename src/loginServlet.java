import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet",urlPatterns={"/loginServlet"})
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        if(userid.equals("admin") && password.equals("123456"))
            System.out.println("True");
        else
            response.sendRedirect("/Add_war_exploded/login.html");
        System.out.println(userid);
        System.out.println(password);
        request.getSession().setAttribute("loginFlag","True");
        //request.setAttribute("newName", "RequestDispatcher");
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BlogServlet2");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p>login successfully!</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
