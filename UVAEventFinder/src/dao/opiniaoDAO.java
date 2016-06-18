/**
 * Opinião: Inserir
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import model.Inscricao;
import model.Opiniao;

/**
 * @author IEUser
 *
 */
public class opiniaoDAO {
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;

	public opiniaoDAO(Context context) {
		databaseHelper = new DatabaseHelper(context, null, null, 0);
	}

	private SQLiteDatabase getDatabase() {
		if (database == null) {
			database = databaseHelper.getWritableDatabase();
		}
		return database;
	}

	private Opiniao criarOpiniao(Cursor cursor) {
		Opiniao model = new Opiniao(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Opiniao._ID)),
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Opiniao._ID_SESSAO)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Opiniao.POSITIVA)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Opiniao.SUGESTAO)));
		return model;
	}

	public List<Opiniao> listarOpinioes() {
		Cursor cursor = getDatabase().query(DatabaseHelper.Opiniao.TABELA, DatabaseHelper.Opiniao.COLUNAS, null, null,
				null, null, null);
		List<Opiniao> opinioes = new ArrayList<Opiniao>();
		while (cursor.moveToNext()) {
			Opiniao model = criarOpiniao(cursor);
			opinioes.add(model);
		}
		cursor.close();
		return opinioes;
	}

	public long salvarOpiniao(Opiniao model) {
		ContentValues valores = new ContentValues();
		valores.put(DatabaseHelper.Opiniao._ID_SESSAO, model.get_id_sessao());
		valores.put(DatabaseHelper.Opiniao.POSITIVA, model.getPositiva());
		valores.put(DatabaseHelper.Opiniao.SUGESTAO, model.getSugestao());

		if (model.get_id() != null) {
			return getDatabase().update(DatabaseHelper.Opiniao.TABELA, valores, "_id = ?",
					new String[] { model.get_id().toString() });
		}
		return getDatabase().insert(DatabaseHelper.Opiniao.TABELA, null, valores);
	}

	public Opiniao buscarOpiniaoPorId(int id) {
		Cursor cursor = getDatabase().query(DatabaseHelper.Opiniao.TABELA, DatabaseHelper.Opiniao.COLUNAS, "id = ?",
				new String[] { Integer.toString(id) }, null, null, null);

		if (cursor.moveToNext()) {
			Opiniao model = criarOpiniao(cursor);
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
