/**
 * Sessão:Consultar
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import model.Sessao;

/**
 * @author IEUser
 *
 */
public class sessaoDAO {
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;

	public sessaoDAO(Context context) {
		databaseHelper = new DatabaseHelper(context, null, null, 0);
	}

	private SQLiteDatabase getDatabase() {
		if (database == null) {
			database = databaseHelper.getWritableDatabase();
		}
		return database;
	}

	private Sessao criarSessao(Cursor cursor) {
		Sessao model = new Sessao(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Sessao._ID)),
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Sessao._ID_EVENTO)),
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Sessao._ID_PALESTRANTE)),
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Sessao._ID_LOCAL)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.TEMA)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.SINTESE)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.INICIO)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.FIM)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.CARGAHORA)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.IMAGEM)));
		return model;
	}

	public List<Sessao> listarSessaoCampos() {
		Cursor cursor = getDatabase().query(DatabaseHelper.Sessao.TABELA, DatabaseHelper.Sessao.COLUNAS, null, null,
				null, null, null);
		List<Sessao> sessoes = new ArrayList<Sessao>();
		while (cursor.moveToNext()) {
			Sessao model = new Sessao(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Sessao._ID)),
					cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Sessao._ID_EVENTO)),
					cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Sessao._ID_PALESTRANTE)),
					cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Sessao._ID_LOCAL)),
					cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.TEMA)),
					cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.SINTESE)),
					cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.INICIO)),
					cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.FIM)),
					cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.CARGAHORA)),
					cursor.getString(cursor.getColumnIndex(DatabaseHelper.Sessao.IMAGEM)));
			sessoes.add(model);
		}
		return sessoes;
	}

	public Sessao buscarSessaoPorId(int id) {
		Cursor cursor = getDatabase().query(DatabaseHelper.Sessao.TABELA, DatabaseHelper.Sessao.COLUNAS, "id = ?",
				new String[] { Integer.toString(id) }, null, null, null);

		if (cursor.moveToNext()) {
			Sessao model = criarSessao(cursor);
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
