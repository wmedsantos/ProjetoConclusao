/**
 * 
 */
package model;

/**
 * @author IEUser
 *
 */
public class Inscricao {
	private Integer _id;
	private Integer _id_publico;
	private Integer _id_sessao;
	private String data;
	
	
	public Inscricao(){
		
	}
	
	public Inscricao(Integer id, Integer idPublico,Integer idSessao,String data){
		this.set_id(id);
		this.set_id_publico(idPublico);
		this.set_id_sessao(idSessao);
		this.setData(data);
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
	 * @return the _id_publico
	 */
	public Integer get_id_publico() {
		return _id_publico;
	}

	/**
	 * @param _id_publico the _id_publico to set
	 */
	public void set_id_publico(Integer _id_publico) {
		this._id_publico = _id_publico;
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
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

}
