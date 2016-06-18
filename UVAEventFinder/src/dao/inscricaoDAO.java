/**
 * Inscrição:Inserir,Remover,Buscar
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import model.Inscricao;

/**
 * @author IEUser
 *
 */
public class inscricaoDAO {
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;

	public inscricaoDAO(Context context) {
		databaseHelper = new DatabaseHelper(context, null, null, 0);
	}

	private SQLiteDatabase getDatabase() {
		if (database == null) {
			database = databaseHelper.getWritableDatabase();
		}
		return database;
	}

	private Inscricao criarInscricao(Cursor cursor) {
		Inscricao model = new Inscricao(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Inscricao._ID)),
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Inscricao._ID_PUBLICO)),
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Inscricao._ID_SESSAO)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Inscricao.DATA)));
		return model;
	}

	public List<Inscricao> listarIncricoes() {
		Cursor cursor = getDatabase().query(DatabaseHelper.Inscricao.TABELA, DatabaseHelper.Inscricao.COLUNAS, null,
				null, null, null, null);
		List<Inscricao> inscricoes = new ArrayList<Inscricao>();
		while (cursor.moveToNext()) {
			Inscricao model = criarInscricao(cursor);
			inscricoes.add(model);
		}
		cursor.close();
		return inscricoes;
	}

	// Inserir ID_sessao e recuperar ID_publico para efetivar inscrição
	public long salvarInscricao(Inscricao model) {
		ContentValues valores = new ContentValues();
		valores.put(DatabaseHelper.Inscricao._ID_PUBLICO, model.get_id_publico());
		valores.put(DatabaseHelper.Inscricao._ID_SESSAO, model.get_id_sessao());

		if (model.get_id() != null) {
			return getDatabase().update(DatabaseHelper.Inscricao.TABELA, valores, "_id = ?",
					new String[] { model.get_id().toString() });
		}
		return getDatabase().insert(DatabaseHelper.Inscricao.TABELA, null, valores);
	}

	public boolean removerInscricao(int id) {
		return getDatabase().delete(DatabaseHelper.Inscricao.TABELA, "id = ?",
				new String[] { Integer.toString(id) }) > 0;
	}

	public Inscricao buscarInscricaoPorId(int id) {
		Cursor cursor = getDatabase().query(DatabaseHelper.Inscricao.TABELA, DatabaseHelper.Inscricao.COLUNAS, "id = ?",
				new String[] { Integer.toString(id) }, null, null, null);

		if (cursor.moveToNext()) {
			Inscricao model = criarInscricao(cursor);
			cursor.close();
			return model;
		}
		return null;
	}

	public void fechar() {
		databaseHelper.close();
		database = null;
	}

}
