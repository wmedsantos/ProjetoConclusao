/**
 * 
 */
package model;

/**
 * @author IEUser
 *
 */
public class Evento {
	private Integer _id;
	private String tema;
	private String inicio;
	private String fim;

	public Evento() {

	}

	public Evento(Integer id, String tema, String inicio, String fim) {
		this.set_id(id);
		this.setTema(tema);
		this.setInicio(inicio);
		this.setFim(fim);

	}

	/**
	 * @return the _id
	 */
	public Integer get_id() {
		return _id;
	}

	/**
	 * @param _id
	 *            the _id to set
	 */
	public void set_id(Integer _id) {
		this._id = _id;
	}

	/**
	 * @return the tema
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * @param tema
	 *            the tema to set
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * @return the inicio
	 */
	public String getInicio() {
		return inicio;
	}

	/**
	 * @param inicio
	 *            the inicio to set
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
	 * @param fim
	 *            the fim to set
	 */
	public void setFim(String fim) {
		this.fim = fim;
	}

}
