package Servlets;

import Service.UserHibService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "DeleteServlet",
        description = "Delete user servlet",
        urlPatterns = {"/delete"}
)

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Long id = Long.parseLong(request.getParameter("id"));
       UserHibService.getInstance().deleteUserHib(id);
       response.sendRedirect("users");
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
//        try {
//            if (UserHibService.getInstance().getUserByNameHib(name) != null) {
//                UserHibService.getInstance().deleteUserHib(name);
//                response.sendRedirect("users");
//            } else if (UserHibService.getInstance().getUserByNameHib(name) == null && name.equals("")) {
//                response.sendRedirect("users");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
