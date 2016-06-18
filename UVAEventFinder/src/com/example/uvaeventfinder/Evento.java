package com.example.uvaeventfinder;

import java.io.Serializable;

public class Evento implements Serializable {

    private int	id;
	private String nome;
    private String descricao;
    private String datainicio;
    private String datafim;
    private String local;
    private String endereco;
    private String site;
    private int vagasdisponiveis;
    private String url;
    private String palestrante; 
    private String imagem;
    
    public Evento(int id, String nome, String descricao, String datainicio,String datafim, 
    		String local, String endereco,String site, String vagasdisponiveis, String url,
    		String palestrante,String imagem)
    {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setDatainicio(datainicio);
        this.setDatafim(datafim);
        this.setLocal(local);
        this.setEndereco(endereco);
        this.setSite(site);
        this.setVagasdisponiveis(Integer.parseInt(vagasdisponiveis));
        this.setUrl(url);
        this.setPalestrante(palestrante); 
        this.setImagem(imagem); 
    }
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}
	public String getDatafim() {
		return datafim;
	}
	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getVagasdisponiveis() {
		return vagasdisponiveis;
	}
	public void setVagasdisponiveis(int vagasdisponiveis) {
		this.vagasdisponiveis = vagasdisponiveis;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
