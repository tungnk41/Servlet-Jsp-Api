package controller.web.api;

import model.UserModel;
import org.codehaus.jackson.map.ObjectMapper;
import service.IUserService;
import service.impl.UserService;
import utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api-user"})
public class UserAPI extends HttpServlet {

    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("application/json");
        UserModel reqUser = HttpUtil.toModel(req.getReader(),UserModel.class);

        UserModel user = userService.findUserByNameAndPasswordAndStatus(reqUser.getUsername(), reqUser.getPassword(), reqUser.getStatus());
        if(user == null){
            printWriter.write("User not exist");
            return;
        }
        printWriter.write(HttpUtil.toJson(user));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        UserModel user = HttpUtil.toModel(req.getReader(),UserModel.class);
        userService.insert(user,1L);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
