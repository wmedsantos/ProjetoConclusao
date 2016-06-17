package com.example.uvaeventfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONObject;
import android.util.Log;

public class UsuarioActivity extends Activity {

	private String strUsuario;
	private String strEmail;
	private String strSenha;
	private String strConfirmarSenha;
	
	Button btnSalvarUsuario;
	EditText edtUsuario;
	EditText edtEmail;
	EditText edtSenha;
	EditText edtConfirmarSenha;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usuario);

		edtUsuario = (EditText) findViewById(R.id.edtUsuario);
		edtEmail = (EditText) findViewById(R.id.edtEmail);
		edtSenha = (EditText) findViewById(R.id.edtSenha);
		edtConfirmarSenha = (EditText) findViewById(R.id.edtConfirmarSenha);

		btnSalvarUsuario = (Button) findViewById(R.id.btnSalvarUsuario);
		btnSalvarUsuario.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View a) {
				// TODO Auto-generated method stub
				strUsuario = edtUsuario.getText().toString();
				strEmail = edtEmail.getText().toString();
				strSenha = edtSenha.getText().toString();
				strConfirmarSenha = edtConfirmarSenha.getText().toString();

				if (!strUsuario.isEmpty() && !strEmail.isEmpty() && !strSenha.isEmpty()  && !strConfirmarSenha.isEmpty() ) {
					if (strSenha.equals(strConfirmarSenha)){
						
		                new AsyncPutUsuario().execute();
						
					}else{
						Toast.makeText(getApplicationContext(), "É necessário preencher todos os campos.",
								   Toast.LENGTH_LONG).show();
					}
					
				}else{
					Toast.makeText(getApplicationContext(), "É necessário preencher todos os campos.",
							   Toast.LENGTH_LONG).show();
//					Toast.makeText(getApplicationContext(), strUsuario.concat("U"),
//							   Toast.LENGTH_LONG).show();
//					Toast.makeText(getApplicationContext(), strEmail.concat("E"),
//							   Toast.LENGTH_LONG).show();
//					
//					Toast.makeText(getApplicationContext(), strSenha.concat("S") ,
//							   Toast.LENGTH_LONG).show();  					
//					Toast.makeText(getApplicationContext(), strConfirmarSenha.concat("SC"),
//							   Toast.LENGTH_LONG).show();
					
					
				}
			}
		}); 	
	
	
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.usuario, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
    private class AsyncPutUsuario extends AsyncTask<Void, Void, Void>
    {
        private String response;
        private JSONObject jsonUsuario,param;
        private ProgressDialog pDialog;
        private String usuario;
        private String email;
        private String senha;
        //public static final String postUrl = "http://189.60.228.5:3000/posts.json";
        public static final String UsuarioUrl = "https://eventfinder-wmedsantos.c9users.io/usuarios";


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(UsuarioActivity.this);
            pDialog.setMessage("Gravando usuário...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

            usuario = strUsuario.toString();
            email = strEmail.toString();
            senha = strSenha.toString();
        }

        @Override
        protected Void doInBackground(Void... args)
        {
            WebRequest webreq = new WebRequest();

            param = new JSONObject();

            jsonUsuario = new JSONObject();
            try {
                param.put("nome", usuario);
                param.put("password_confirmation", senha);
                param.put("password", senha);
                param.put("email", email);
                jsonUsuario.put("usuario", param);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Log.i("jsonObject: ", "> ERRO");
            }
            finally {
                Log.i("jsonObject: ", "> " + jsonUsuario.toString());
                response = webreq.makeWebServicePOST(UsuarioUrl, jsonUsuario);
                return null;
            }
        }

        @Override
        protected void onPostExecute(Void requestresult) {
            super.onPostExecute(requestresult);

            Log.i("Usuario Response >", response);

            pDialog.cancel();
            finish(); //retorna a atividade anterior
        }

    }

}
