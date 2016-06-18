/**
 * 
 */
package model;

/**
 * @author IEUser
 *
 */
public class Opiniao {
	private Integer _id;
	private Integer _id_sessao;
	private String positiva;
	private String sugestao;
	
	public Opiniao(){
		
	}
	
	public Opiniao(Integer id, Integer idSessao, String positiva,String sugestao){
		this.set_id(id);
		this.set_id_sessao(idSessao);
		this.setPositiva(positiva);
		this.setSugestao(sugestao);
		
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
	 * @return the _id_sessao
	 */
	public Integer get_id_sessao() {
		return _id_sessao;
	}

	/**
	 * @param _id_sessao the _id_sessao to set
	 */
	public void set_id_sessao(Integer _id_sessao) {
		this._id_sessao = _id_sessao;
	}

	/**
	 * @return the positiva
	 */
	public String getPositiva() {
		return positiva;
	}

	/**
	 * @param positiva the positiva to set
	 */
	public void setPositiva(String positiva) {
		this.positiva = positiva;
	}

	/**
	 * @return the sugestao
	 */
	public String getSugestao() {
		return sugestao;
	}

	/**
	 * @param sugestao the sugestao to set
	 */
	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

}
