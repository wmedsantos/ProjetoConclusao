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
		db.execSQL("create table aluno(_id integer autoincrement,"+
		"nome text not null,curso text not null,campus text not null,"+
				"login text not null,senha text not null)");	
		
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
