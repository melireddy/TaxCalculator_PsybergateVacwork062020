package com.psybergate.vacwork202006.web.servlet;

import com.psybergate.vacwork202006.web.controller.PersonController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private PersonController personController;

    @Override
    public void init() throws ServletException {
        personController = new PersonController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String pathInfo = request.getPathInfo().substring(1); // strip pathinfo of the lead "/"
        try {
            String view = null;
            if (pathInfo.equals("register")) {
                view = personController.getRegisterPage(request, response);
                request.getRequestDispatcher(view).forward(request, response);
            } else if (pathInfo.equals("capture")) {
                view = personController.registerPerson(request, response);
                response.sendRedirect(view);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
