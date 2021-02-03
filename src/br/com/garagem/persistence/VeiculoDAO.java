package br.com.garagem.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.garagem.connection.ConnectionFactory;
import br.com.garagem.entity.Veiculo;

public class VeiculoDAO {

	private String sql = "";

	public boolean incluir(Veiculo veiculo) {

		boolean isOk = false;

		Connection conn = null;
		PreparedStatement ps = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return isOk;
		}

		sql = "INSERT INTO veiculo(marca, modelo, descricao, placa, ano) VALUES (?,?,?,?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getMarca());
			ps.setString(2, veiculo.getModelo());
			ps.setString(3, veiculo.getDescricao());
			ps.setString(4, veiculo.getPlaca());
			ps.setInt(5, veiculo.getAno());

			ps.executeUpdate();
			isOk = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return isOk;
	}

	public boolean alterar(Veiculo veiculo) {

		boolean isOk = false;

		Connection conn = null;
		PreparedStatement ps = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return isOk;
		}

		sql = "UPDATE veiculo SET marca=?, modelo=?, descricao=?, placa=?, ano=? WHERE id=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getMarca());
			ps.setString(2, veiculo.getModelo());
			ps.setString(3, veiculo.getDescricao());
			ps.setString(4, veiculo.getPlaca());
			ps.setInt(5, veiculo.getAno());
			ps.setInt(6, veiculo.getId());

			ps.executeUpdate();
			isOk = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return isOk;
	}

	public boolean excluir(int id) {

		boolean isOk = false;

		Connection conn = null;
		PreparedStatement ps = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return isOk;
		}

		sql = "DELETE FROM veiculo WHERE id=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
			isOk = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return isOk;
	}

	public Veiculo getVeiculoById(int id) {

		Veiculo veiculo = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return veiculo;
		}

		sql = "SELECT * FROM veiculo WHERE id=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				veiculo = new Veiculo();
				veiculo.setId(rs.getInt("id"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setMarca(rs.getString("modelo"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setDescricao(rs.getString("descricao"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setAno(rs.getInt("ano"));
			}
			return veiculo;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return veiculo;

	}

	public List<Veiculo> getVeiculos() {

		List<Veiculo> veiculos = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		conn = ConnectionFactory.getConnection();
		if (conn == null) {
			return veiculos;
		}

		sql = "SELECT * FROM veiculo ORDER BY marca, modelo";

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			veiculos = new ArrayList<Veiculo>();

			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("id"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setDescricao(rs.getString("descricao"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setAno(rs.getInt("ano"));

				veiculos.add(veiculo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return veiculos;

	}
}
