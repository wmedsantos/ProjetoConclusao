/**
 * 
 */
package model;

/**
 * @author IEUser
 *
 */
public class Local {
	private Integer _id;
	private String campus;
	private String tel;
	private String bloco;
	private String andar;
	private String sala;
	private Integer vaga;
	
	public Local(){
		
	}
	
	public Local(Integer id,String campus,String tel,String bloco,String andar,String sala,Integer vaga){
		this.set_id(id);
		this.setCampus(campus);
		this.setTel(tel);
		this.setBloco(bloco);
		this.setAndar(andar);
		this.setSala(sala);
		this.setVaga(vaga);
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
	 * @return the campus
	 */
	public String getCampus() {
		return campus;
	}

	/**
	 * @param campus the campus to set
	 */
	public void setCampus(String campus) {
		this.campus = campus;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the bloco
	 */
	public String getBloco() {
		return bloco;
	}

	/**
	 * @param bloco the bloco to set
	 */
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	/**
	 * @return the andar
	 */
	public String getAndar() {
		return andar;
	}

	/**
	 * @param andar the andar to set
	 */
	public void setAndar(String andar) {
		this.andar = andar;
	}

	/**
	 * @return the sala
	 */
	public String getSala() {
		return sala;
	}

	/**
	 * @param sala the sala to set
	 */
	public void setSala(String sala) {
		this.sala = sala;
	}

	/**
	 * @return the vaga
	 */
	public Integer getVaga() {
		return vaga;
	}

	/**
	 * @param vaga the vaga to set
	 */
	public void setVaga(Integer vaga) {
		this.vaga = vaga;
	}
	
	

}
