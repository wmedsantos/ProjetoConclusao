/**
 * Inclusão de publico
 */
package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import model.Publico;

/**
 * @author IEUser
 *
 */
public class publicoDAO {
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;
	
	public publicoDAO(Context context){
		databaseHelper = new DatabaseHelper(context, null, null, 0);
	}
	
	private SQLiteDatabase getDatabase(){
		if (database == null){
			database = databaseHelper.getWritableDatabase();
		}
		return database;
	}
	
	private Publico criarPublico(Cursor cursor){
		Publico model = new Publico(
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Publico._ID)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Publico.NOME)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Publico.EMAIL)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Publico.SENHA))
				);
		return model;
	}
	
	public long salvarPublico(Publico publico){
		ContentValues valores = new ContentValues();
		valores.put(DatabaseHelper.Publico.NOME, publico.getNome());
		valores.put(DatabaseHelper.Publico.EMAIL, publico.getEmail());
		valores.put(DatabaseHelper.Publico.SENHA, publico.getSenha());
		
		if (publico.get_id() != null){
			return getDatabase().update(DatabaseHelper.Publico.TABELA, valores, "_id = ?", new String[]{publico.get_id().toString()});
		}
		return getDatabase().insert(DatabaseHelper.Publico.TABELA, null, valores);
	}
	
	//Método buscar publico
		public Publico buscarPublicoPorId (int id){
			Cursor cursor = getDatabase().query(DatabaseHelper.Publico.TABELA, DatabaseHelper.Publico.COLUNAS,"id = ?",new String[]{Integer.toString(id)},null,null,null);
			
			if(cursor.moveToNext()){
				Publico model = criarPublico(cursor);
				cursor.close();
				return model;
			}
			return null;
		}

}
