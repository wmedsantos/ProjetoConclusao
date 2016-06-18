/**
 * 
 */
package model;

/**
 * @author IEUser
 *
 */
public class Sessao {
	private Integer _id;
	private Integer _id_evento;
	private Integer _id_palestrante;
	private Integer _id_local;
	private String tema;
	private String sintese;
	private String inicio;
	private String fim;
	private String cargahora;
	private String imagem;
	
	public Sessao(){
		
	}
	
	public Sessao(Integer id,Integer idEvento,Integer idPalestrante,Integer idLocal,
			String tema,String sintese,String inicio,String fim,String cargahora,String imagem){
		this.set_id(id);
		this.set_id_evento(idEvento);
		this.set_id_palestrante(idPalestrante);
		this.set_id_local(idLocal);
		this.setTema(tema);
		this.setSintese(sintese);
		this.setInicio(inicio);
		this.setFim(fim);
		this.setCargahora(cargahora);
		this.setImagem(imagem);
	}

	/**
	 * @return the _id
	 */
	public Integer get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(Integer _id) {
		this._id = _id;
	}

	/**
	 * @return the _id_evento
	 */
	public Integer get_id_evento() {
		return _id_evento;
	}

	/**
	 * @param _id_evento the _id_evento to set
	 */
	public void set_id_evento(Integer _id_evento) {
		this._id_evento = _id_evento;
	}

	/**
	 * @return the _id_palestrante
	 */
	public Integer get_id_palestrante() {
		return _id_palestrante;
	}

	/**
	 * @param _id_palestrante the _id_palestrante to set
	 */
	public void set_id_palestrante(Integer _id_palestrante) {
		this._id_palestrante = _id_palestrante;
	}

	/**
	 * @return the _id_local
	 */
	public Integer get_id_local() {
		return _id_local;
	}

	/**
	 * @param _id_local the _id_local to set
	 */
	public void set_id_local(Integer _id_local) {
		this._id_local = _id_local;
	}

	/**
	 * @return the tema
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * @param tema the tema to set
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * @return the sintese
	 */
	public String getSintese() {
		return sintese;
	}

	/**
	 * @param sintese the sintese to set
	 */
	public void setSintese(String sintese) {
		this.sintese = sintese;
	}

	/**
	 * @return the inicio
	 */
	public String getInicio() {
		return inicio;
	}

	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the fim
	 */
	public String getFim() {
		return fim;
	}

	/**
	 * @param fim the fim to set
	 */
	public void setFim(String fim) {
		this.fim = fim;
	}

	/**
	 * @return the cargahora
	 */
	public String getCargahora() {
		return cargahora;
	}

	/**
	 * @param cargahora the cargahora to set
	 */
	public void setCargahora(String cargahora) {
		this.cargahora = cargahora;
	}

	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}

	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
