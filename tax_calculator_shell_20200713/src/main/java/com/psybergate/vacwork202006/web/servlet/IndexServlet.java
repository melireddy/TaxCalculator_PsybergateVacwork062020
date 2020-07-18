package com.psybergate.vacwork202006.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psybergate.vacwork202006.domain.Person;
import com.psybergate.vacwork202006.web.controller.PersonController;

public class IndexServlet extends HttpServlet {

  private static final String INDEX_PAGE = "/WEB-INF/jsp/index.jsp";

  private static final long serialVersionUID = 1L;

  private PersonController personController;

  @Override
  public void init()
      throws ServletException {
    personController = new PersonController();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      List<Person> people = personController.getAllPeople();
      req.setAttribute("people", people);
      req.getRequestDispatcher(INDEX_PAGE).forward(req, resp);
    }
    catch (final Exception ex) {
      throw new RuntimeException(ex);
    }
  }

}
