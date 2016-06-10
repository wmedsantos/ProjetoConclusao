/**
 * 
 */
package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Cria��o, manuten��o e atualiza��o das tabelas
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
		
		//Tabela P�blico
		db.execSQL("CREATE TABLE publico(_id INTEGER PRIMARY KEY,nome TEXT NOT NULL"+
		"email TEXT NOT NULL,senha TEXT NOT NULL DEFAULT)");
		
		//Tabela Palestrante
		db.execSQL("CREATE TABLE palestrante(_id INTEGER PRIMARY KEY,nome TEXT NOT NULL"+
		"origem TEXT,cargo TEXT,observacao,email TEXT)");
		
		//Tabela Evento
		db.execSQL("CREATE TABLE evento(_id INTEGER PRIMARY KEY,tema TEXT NOT NULL"+
		"inicio NUMERIC,fim NUMERIC)");
		
		//Tabela Endere�o
		db.execSQL("CREATE TABLE endereco(_id INTEGER PRIMARY KEY,rua TEXT,numero TEXT"+
		"complemento TEXT,bairro TEXT,cidade TEXT,estado TEXT,cep TEXT)");
		
		//Tabela Sess�o
		db.execSQL("CREATE TABLE sessao(_id INTEGER PRIMARY KEY,_id_evento INTEGER NOT NULL"+
		"_id_palestrante INTEGER NOT NULL,id_endereco INTEGER NOT NULL,tema TEXT NOT NULL"+
				"sintese TEXT, inicio NUMERIC, fim NUMERIC, cargahora NUMERIC,imagem BLOB,"+
		"FOREIGN KEY(_id_evento) REFERENCES evento(_id),FOREIGN KEY(_id_palestrante) REFERENCES"+
				"palestrante(_id),FOREIGN KEY(_id_endereco) REFERENCES endereco(_id)");
		
		//Tabela Inscri��o
		db.execSQL("CREATE TABLE inscricao(_id INTEGER PRIMARY KEY, _id_publico INTEGER NOT NULL"+
		"_id_aluno INTEGER NOT NULL, _id_sessao INTEGER NOT NULL,data NUMERIC,FOREIGN KEY "+
				"(_id_publico) REFERENCES publico(_id),FOREIGN KEY (_id_aluno) REFERENCES"+
		"aluno(_id), FOREIGN KEY (_id_sessao) REFERENCES sessao(_id))");
		
		//Tabela opini�o
		db.execSQL("CREATE TABLE opiniao(_id INTEGER PRIMARY KEY, _id_sessao INTEGER NOT NULL"+
		"positiva NUMERIC, sugestao TEXT, FOREIGN KEY (_id_sessao) REFERENCES sessao(_id))");
		
		//Tabela Localiza��o
		db.execSQL("CREATE TABLE localizacao(_id_local INTEGER PRIMARY KEY, bloco TEXT, andar TEXT"+
		"sala TEXT, vaga INTEGER, FOREIGN KEY (_id_local) REFERENCES endereco(_id))");
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
