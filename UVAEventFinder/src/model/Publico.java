/**
 * 
 */
package model;

/**
 * @author IEUser
 *
 */
public class Publico {
	private Integer _id;
	private String nome;
	private String email;
	private String senha;
	
	public Publico(){
		
	}
	public Publico(Integer id,String nome,String email,String senha){
		this.set_id(id);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
