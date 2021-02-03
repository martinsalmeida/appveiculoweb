package br.com.garagem.entity;

public class Veiculo {

	private int id;
	private String marca;
	private String modelo;
	private String descricao;
	private String placa;
	private int ano;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca.toUpperCase();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa.toUpperCase();
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = Math.abs(ano);
	}

}
