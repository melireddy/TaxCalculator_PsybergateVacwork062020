package com.psybergate.vacwork202006.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psybergate.vacwork202006.web.controller.PersonController;
import com.psybergate.vacwork202006.web.controller.TaxReturnController;

public class TaxReturnServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TaxReturnController taxReturnController;

    @Override
    public void init() throws ServletException {
       taxReturnController = new TaxReturnController();
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
        String test = request.getParameter("taxNumber");
        int length = test.length()-1;
        test = test.substring(0,length);

            try {
                String view = null;
                if (pathInfo.equals("view")) {
                    view = taxReturnController.getCaptureTaxPage(request,response);
                    request.getRequestDispatcher(view).forward(request, response);
                } else if (pathInfo.equals("calculate")) {
                    view = taxReturnController.addTaxReturn(request,response);
                    view = taxReturnController.getViewTaxPage(request,response);
                    request.getRequestDispatcher(view).forward(request, response);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
    }



//doget
    //dispatch view


}
