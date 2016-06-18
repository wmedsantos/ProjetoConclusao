/**
 * Buscar & Listar Eventos
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import model.Evento;

/**
 * @author IEUser
 *
 */
public class eventoDao {
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;

	public eventoDao(Context context) {
		// TODO Auto-generated constructor stub

		databaseHelper = new DatabaseHelper(context, null, null, 0);
	}

	private SQLiteDatabase getDatabase() {
		if (database == null) {
			database = databaseHelper.getWritableDatabase();
		}
		return database;
	}

	private Evento criarEvento(Cursor cursor) {
		Evento model = new Evento(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Evento._ID)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Evento.TEMA)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Evento.INICIO)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Evento.FIM)));
		return model;
	}

	public Evento buscarEventoPorId(int id) {
		Cursor cursor = getDatabase().query(DatabaseHelper.Evento.TABELA, DatabaseHelper.Evento.COLUNAS, "id = ?",
				new String[] { Integer.toString(id) }, null, null, null);

		if (cursor.moveToNext()) {
			Evento model = criarEvento(cursor);
			cursor.close();
			return model;
		}
		return null;
	}

	public List<Evento> listarEvento() {
		Cursor cursor = getDatabase().query(DatabaseHelper.Evento.TABELA, DatabaseHelper.Evento.COLUNAS, null, null,
				null, null, null);
		List<Evento> eventos = new ArrayList<Evento>();
		while (cursor.moveToNext()) {
			Evento model = criarEvento(cursor);
			eventos.add(model);
		}
		cursor.close();
		return eventos;
	}

	public void fechar() {
		databaseHelper.close();
		database = null;
	}

}
