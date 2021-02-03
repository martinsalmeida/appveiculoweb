package br.com.garagem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.garagem.action.VeiculoAction;


@WebServlet("/VeiculoSV")
public class VeiculoSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html;charset=UTF-8");
		
		new VeiculoAction().execute(request, response);
	}

}
