/**
 * Buscar & Listar Local da sessão
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import model.Local;

/**
 * @author IEUser
 *
 */
public class localDAO {
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;

	public localDAO(Context context) {
		databaseHelper = new DatabaseHelper(context, null, null, 0);
	}

	private SQLiteDatabase getDatabase() {
		if (database == null) {
			database = databaseHelper.getWritableDatabase();
		}
		return database;
	}

	private Local criarLocal(Cursor cursor) {
		Local model = new Local(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Local._ID)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.CAMPUS)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.TEL)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.BLOCO)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.ANDAR)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.SALA)),
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Local.VAGA)));
		return model;
	}
	
	public Local buscarLocalPorId(int id){
		Cursor cursor = getDatabase().query(DatabaseHelper.Local.TABELA,DatabaseHelper.Local.COLUNAS,
				"id = ?", new String[] { Integer.toString(id) }, null, null, null);

		if (cursor.moveToNext()) {
			Local model = criarLocal(cursor);
			cursor.close();
			return model;
		}
		return null;
		}
	public List<Local> listarLocal(){
		Cursor cursor = getDatabase().query(DatabaseHelper.Local.TABELA,DatabaseHelper.Local.COLUNAS,null,null,null,null,null);
		List<Local> localizacao = new ArrayList<Local>();
		while (cursor.moveToNext()) {
			Local model = criarLocal(cursor);
			localizacao.add(model);
		}
		cursor.close();
		return localizacao;
	}
	}


