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
		
		
		//Tabela Público
		db.execSQL("CREATE TABLE publico(_id INTEGER PRIMARY KEY,nome TEXT NOT NULL"+
		"email TEXT NOT NULL,senha TEXT NOT NULL)");
		
		//Tabela Palestrante
		db.execSQL("CREATE TABLE palestrante(_id INTEGER PRIMARY KEY,nome TEXT NOT NULL"+
		"origem TEXT,cargo TEXT,observacao TEXT,email TEXT)");
		
		//Tabela Evento
		db.execSQL("CREATE TABLE evento(_id INTEGER PRIMARY KEY,tema TEXT NOT NULL"+
		"inicio TEXT,fim TEXT)");
		
		//Tabela Local
		db.execSQL("CREATE TABLE local(_id INTEGER PRIMARY KEY,campus TEXT,tel TEXT,bloco TEXT, andar TEXT"+
		"sala TEXT, vaga INTEGER)");
		
		//Tabela Sessão
		db.execSQL("CREATE TABLE sessao(_id INTEGER PRIMARY KEY,_id_evento INTEGER NOT NULL"+
		"_id_palestrante INTEGER NOT NULL,_id_local INTEGER NOT NULL,tema TEXT NOT NULL"+
		"sintese TEXT, inicio TEXT, fim TEXT, cargahora TEXT,imagem TEXT,"+
		"FOREIGN KEY(_id_evento) REFERENCES evento(_id),FOREIGN KEY(_id_palestrante) REFERENCES"+
		"palestrante(_id),FOREIGN KEY(_id_local) REFERENCES local(_id)");
		
		//Tabela Inscrição
		db.execSQL("CREATE TABLE inscricao(_id INTEGER PRIMARY KEY, _id_publico INTEGER"+
		"_id_sessao INTEGER NOT NULL,data DATETIME DEFAULT CURRENT_TIMESTAMP,FOREIGN KEY (_id_publico) REFERENCES publico(_id),"+
		"FOREIGN KEY (_id_sessao) REFERENCES sessao(_id))");
		
		//Tabela opinião
		db.execSQL("CREATE TABLE opiniao(_id INTEGER PRIMARY KEY, _id_sessao INTEGER NOT NULL"+
		"positiva TEXT, sugestao TEXT, FOREIGN KEY (_id_sessao) REFERENCES sessao(_id))");
		
		
		//Start
		db.execSQL("INSERT INTO publico(_id,nome,email)VALUES(1,'Fukuda','fernando.fukuda@uva.br','1234')");
		db.execSQL("INSERT INTO palestrante(_id,nome,origem,cargo,observacao,email) VALUES(1,'Dra.Adriana Sicsú'"+
		"'Universidade Veiga de Almeida','Professora','Leciona: Aplicações em Dispositivos Móveis, Monografia I e LP 1'"+
				"'adriana.nascimento@uva.br')");
		db.execSQL("INSERT INTO evento(_id,tema,inicio,fim) VALUES (201601,'Semana da Ciência & Tecnologia'"+
				"'2016-06-13 09:30','2016-6-18 17:00')");		
		db.execSQL("INSERT INTO local(_id,campus,telefone,bloco,andar,sala,vaga) VALUES (11,'Tijuca','(21)2574-8888/0800-024-6172',"+
				"'B','Térreo','127','6',25)");
		db.execSQL("INSERT INTO sessao(_id,_id_evento,_id_palestrante,_id_local,tema,sintese,imagem"+
				"'inicio,fim,cargahora) VALUES (20160101,201601,1,11,'Programação para Dispositivos Móveis Android: Uma abrodagem prática'"+
				"'Minicurso com enfoque em boas práticas no gerenciamento e desenvolvimento Ágil','2016-06-23 13:00','2016-06-23 15:00',5,'ws1001.png')");
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public static class Publico{
		public static final String TABELA ="publico";
		public static final String _ID = "_id";
		public static final String NOME = "nome";
		public static final String EMAIL = "email";
		public static final String SENHA = "senha";
		
		public static final String[] COLUNAS = new String[]{
				_ID,NOME,EMAIL,SENHA
		};
	}
	
	public static class Palestrante{
		public static final String TABELA ="palestrante";
		public static final String _ID = "_id";
		public static final String NOME = "nome";
		public static final String ORIGEM = "origem";
		public static final String CARGO = "cargo";
		public static final String OBSERVACAO = "observacao";
		public static final String EMAIL = "email";
				
		public static final String[] COLUNAS = new String[]{
				_ID,NOME,ORIGEM,CARGO,OBSERVACAO,EMAIL
		};
	}
	
	public static class Evento{
		public static final String TABELA ="evento";
		public static final String _ID = "_id";
		public static final String TEMA = "tema";
		public static final String INICIO = "inicio";
		public static final String FIM = "fim";
						
		public static final String[] COLUNAS = new String[]{
				_ID,TEMA,INICIO,FIM
		};
	}
	
	public static class Local{
		public static final String TABELA ="localizacao";
		public static final String _ID = "_id";
		public static final String CAMPUS = "campus";
		public static final String TEL = "telefone";
		public static final String BLOCO = "bloco";
		public static final String ANDAR = "andar";
		public static final String SALA = "sala";
		public static final String VAGA = "vaga";		
		
				
		public static final String[] COLUNAS = new String[]{
				_ID,CAMPUS,TEL,BLOCO,ANDAR,SALA,VAGA
		};
	}
	
	public static class Sessao{
		public static final String TABELA ="sessao";
		public static final String _ID = "_id";
		public static final String _ID_EVENTO = "_id_evento";
		public static final String _ID_PALESTRANTE = "_id_palestrante";
		public static final String _ID_LOCAL = "_id_local";
		public static final String TEMA = "tema";
		public static final String SINTESE = "sintese";
		public static final String INICIO = "inicio";
		public static final String FIM = "fim";
		public static final String CARGAHORA = "cargahora";
		public static final String IMAGEM = "imagem";
		
				
		public static final String[] COLUNAS = new String[]{
				_ID,_ID_EVENTO,_ID_PALESTRANTE,_ID_LOCAL,TEMA,SINTESE,INICIO,FIM,CARGAHORA,IMAGEM
		};
	}
	
	public static class Inscricao{
		public static final String TABELA ="inscricao";
		public static final String _ID = "_id";
		public static final String _ID_PUBLICO = "_id_publico";
		public static final String _ID_SESSAO = "_id_sessao";
		public static final String DATA = "data";
		
				
		public static final String[] COLUNAS = new String[]{
				_ID,_ID_PUBLICO,_ID_SESSAO,DATA
		};
	}
	
	public static class Opiniao{
		public static final String TABELA ="inscricao";
		public static final String _ID = "_id";
		public static final String _ID_SESSAO = "_id_sessao";
		public static final String POSITIVA = "positiva";
		public static final String SUGESTAO = "sugestao";		
		
				
		public static final String[] COLUNAS = new String[]{
				_ID,_ID_SESSAO,POSITIVA,SUGESTAO
		};
	}


}
