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
    
    public Evento(int id, String nome, String descricao, String datainicio,String datafim, 
    		String local, String endereco,String site, String vagasdisponiveis, String url)
    {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.local = local;
        this.endereco = endereco;
        this.site = site;
        this.vagasdisponiveis = Integer.parseInt(vagasdisponiveis);
        this.url = url;
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
}
