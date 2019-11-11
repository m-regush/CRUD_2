package Servlets;

import Model.User;
import Service.UserHibService;
import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        name = "AddServlet",
        description = "Add user servlet",
        urlPatterns = {"/add"}
)

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/add.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String job = request.getParameter("job");
        Long salary = Long.parseLong(request.getParameter("salary"));
        User user = new User(name, job, salary);
        try {
            if (UserHibService.getInstance().getUserByNameHib(name) != null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } else {
                UserHibService.getInstance().addUserHib(user);
            }
            response.sendRedirect("users");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
