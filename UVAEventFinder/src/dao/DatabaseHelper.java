/**
 * 
 */
package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Criação, manutenção e atualização das tabelas
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String BANCO_DADOS = "dbEvent";
	private static final int VERSAO = 1;
	
	public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, BANCO_DADOS, null, VERSAO);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		//Tabela Aluno
		db.execSQL("CREATE TABLE aluno(_matr INTEGER PRIMARY KEY,nome TEXT NOT NULL"+
		"email TEXT NOT NULL,curso TEXT NOT NULL,campus TEXT NOT NULL,"+
				"senha TEXT NOT NULL DEFAULT 'uva')");	
		
		//Tabela Público
		db.execSQL("CREATE TABLE publico(_id INTEGER PRIMARY KEY,nome TEXT NOT NULL"+
		"email TEXT NOT NULL,senha TEXT NOT NULL DEFAULT '123')");
		
		//Tabela Palestrante
		db.execSQL("CREATE TABLE palestrante(_id INTEGER PRIMARY KEY,nome TEXT NOT NULL"+
		"origem TEXT,cargo TEXT,observacao,email TEXT)");
		
		//Tabela Evento
		db.execSQL("CREATE TABLE evento(_id INTEGER PRIMARY KEY,tema TEXT NOT NULL"+
		"inicio TEXT,fim TEXT)");
		
		//Tabela Endereço
		db.execSQL("CREATE TABLE endereco(_id INTEGER PRIMARY KEY,rua TEXT,numero TEXT"+
		"complemento TEXT,bairro TEXT,cidade TEXT,estado TEXT,cep TEXT)");
		
		//Tabela Localização
		db.execSQL("CREATE TABLE localizacao(_id INTEGER PRIMARY KEY,_id_endereco INTEGER, bloco TEXT, andar TEXT"+
		"sala TEXT, vaga INTEGER, FOREIGN KEY (_id_local) REFERENCES endereco(_id))");
		
		//Tabela Sessão
		db.execSQL("CREATE TABLE sessao(_id INTEGER PRIMARY KEY,_id_evento INTEGER NOT NULL"+
		"_id_palestrante INTEGER NOT NULL,id_endereco INTEGER NOT NULL,_id_local INTEGER NOT NULL ,tema TEXT NOT NULL"+
		"sintese TEXT, inicio TEXT, fim TEXT, cargahora TEXT,imagem BLOB,"+
		"FOREIGN KEY(_id_evento) REFERENCES evento(_id),FOREIGN KEY(_id_palestrante) REFERENCES"+
		"palestrante(_id),FOREIGN KEY(_id_endereco) REFERENCES endereco(_id), FOREIGN KEY(_id_local)"+
		"REFERENCES localizacao(_id)");
		
		//Tabela Inscrição
		db.execSQL("CREATE TABLE inscricao(_id INTEGER PRIMARY KEY, _id_publico INTEGER NOT NULL"+
		"_id_aluno INTEGER NOT NULL, _id_sessao INTEGER NOT NULL,data NUMERIC,FOREIGN KEY "+
		"(_id_publico) REFERENCES publico(_id),FOREIGN KEY (_id_aluno) REFERENCES"+
		"aluno(_id), FOREIGN KEY (_id_sessao) REFERENCES sessao(_id))");
		
		//Tabela opinião
		db.execSQL("CREATE TABLE opiniao(_id INTEGER PRIMARY KEY, _id_sessao INTEGER NOT NULL"+
		"positiva TEXT, sugestao TEXT, FOREIGN KEY (_id_sessao) REFERENCES sessao(_id))");
		
		
		//Start
		db.execSQL("INSERT INTO aluno(_matr,nome,email,curso,campus) VALUES(20011002573,'Jose Carlos'"+
				"'jc.n900@gmail.com','Ciência da Computação','Tijuca')");
		db.execSQL("INSERT INTO publico(_id,nome,email)VALUES(1,'Fukuda','fernando.fukuda@uva.br')");
		db.execSQL("INSERT INTO palestrante(_id,nome,origem,cargo,observacao,email) VALUES(1,'Dra.Adriana Sicsú'"+
		"'Universidade Veiga de Almeida','Professora','Leciona: Aplicações em Dispositivos Móveis, Monografia I e LP 1'"+
				"'adriana.nascimento@uva.br')");
		db.execSQL("INSERT INTO evento(_id,tema,inicio,fim) VALUES (201601,'Semana da Ciência & Tecnologia'"+
				"'2016-06-20 09:30','2016-6-25 12:30')");
		db.execSQL("INSERT INTO endereco(_id,rua,numero,complemento,bairro,cidade,estado,cep) VALUES"+
				"(1,'Rua Ibituruna','108','Em frente ao metrô São Cristóvão','Tijuca','Rio de Janeiro','RJ','20.271-020')");
		db.execSQL("INSERT INTO localizacao(_id,_id_endereco,bloco,andar,sala,vaga,) VALUES (11,1,'B','Térreo','127','6',25)");
		db.execSQL("INSERT INTO sessao(_id,_id_evento,_id_palestrante,_id_endereco,_id_local,tema,sintese"+
				"'inicio,fim,cargahora) VALUES (20160101,201601,1,1,11,'Programação para Dispositivos Móveis Android: Uma abrodagem prática'"+
				"'Minicurso com enfoque em boas práticas no gerenciamento e desenvolvimento Ágil','2016-06-23 09:30','2016-06-23 11:30',4)");
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
