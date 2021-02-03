package br.com.garagem.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.garagem.entity.Veiculo;
import br.com.garagem.persistence.VeiculoDAO;

public class VeiculoAction {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		
		if(action.equals("novo")) {
			request.setAttribute("objVeiculo", new Veiculo());
			request.getRequestDispatcher("frmveiculo.jsp").forward(request, response);
			return;
		}
		
		if(action.equals("listar")) {
			
			request.setAttribute("lstVeiculos",new VeiculoDAO().getVeiculos());
			request.getRequestDispatcher("lstveiculos.jsp").forward(request, response);
			return;
		}
		
		if(action.equals("salvar")) {
			if(save(request)) {
				request.setAttribute("msg", "Operação realizada com sucesso!!");
			}else {
				request.setAttribute("msg", "Erro ao realizar a operação");
			}
			request.setAttribute("objVeiculo", new Veiculo());
			request.getRequestDispatcher("frmveiculo.jsp").forward(request, response);
			return;
		}
		
		if(action.equals("editar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("objVeiculo", new VeiculoDAO().getVeiculoById(id));
			request.getRequestDispatcher("frmveiculo.jsp").forward(request, response);
			return;
		}
		
		if(action.equals("excluir")) {
			int id = Integer.parseInt(request.getParameter("id"));
			new VeiculoDAO().excluir(id);
			request.setAttribute("objVeiculo", new VeiculoDAO().getVeiculoById(id));
			request.setAttribute("lstVeiculos",new VeiculoDAO().getVeiculos());
			request.getRequestDispatcher("lstveiculos.jsp").forward(request, response);
			
			
		}
	}
	
	private boolean save(HttpServletRequest request) {
		
		Veiculo veiculo = getParametros(request);
		
		if(veiculo.getId() == 0) {
			return new VeiculoDAO().incluir(veiculo);
		}else {
			return new VeiculoDAO().alterar(veiculo);
		}
		
	}
	
	private Veiculo getParametros(HttpServletRequest request) {
		Veiculo veiculo = new Veiculo();
		
		
		veiculo.setId(Integer.parseInt(request.getParameter("id")));
		veiculo.setMarca((request.getParameter("marca")));
		veiculo.setModelo(request.getParameter("modelo"));
		veiculo.setDescricao(request.getParameter("descricao"));
		veiculo.setPlaca(request.getParameter("placa"));
		veiculo.setAno(Integer.parseInt(request.getParameter("ano")));
		
		return veiculo;
		
	}
	
	
	
}
