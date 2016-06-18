/**
 * Listar & Buscar Palestrantes
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import model.Palestrante;

/**
 * @author IEUser
 *
 */
public class palestranteDAO {
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;

	public palestranteDAO(Context context) {
		databaseHelper = new DatabaseHelper(context, null, null, 0);
	}

	private SQLiteDatabase getDatabase() {
		if (database == null) {
			database = databaseHelper.getWritableDatabase();
		}
		return database;
	}

	private Palestrante criarPalestrante(Cursor cursor) {
		Palestrante model = new Palestrante(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Palestrante._ID)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Palestrante.NOME)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Palestrante.ORIGEM)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Palestrante.CARGO)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Palestrante.OBSERVACAO)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Palestrante.EMAIL)));
		return model;

	}

	public Palestrante buscarPalestrantePorId(int id) {
		Cursor cursor = getDatabase().query(DatabaseHelper.Palestrante.TABELA, DatabaseHelper.Palestrante.COLUNAS,
				"id = ?", new String[] { Integer.toString(id) }, null, null, null);

		if (cursor.moveToNext()) {
			Palestrante model = criarPalestrante(cursor);
			cursor.close();
			return model;
		}
		return null;
	}

	public List<Palestrante> listarPalestrante() {
		Cursor cursor = getDatabase().query(DatabaseHelper.Palestrante.TABELA, DatabaseHelper.Palestrante.COLUNAS, null,
				null, null, null, null);
		List<Palestrante> palestrantes = new ArrayList<Palestrante>();
		while (cursor.moveToNext()) {
			Palestrante model = criarPalestrante(cursor);
			palestrantes.add(model);
		}
		cursor.close();
		return palestrantes;
	}

	public void fechar() {
		databaseHelper.close();
		database = null;
	}
}
