package com.example.uvaeventfinder;

import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;

public class LoginActivity extends Activity {
	private String strLogin;
	private String strEmail;
	private String strSenha;
	
	Button btnLogin;
	Button btnCriarUsuario;
	EditText edtLogin;
	EditText edtSenha;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        

		edtLogin = (EditText) findViewById(R.id.edtLogin);
		edtSenha = (EditText) findViewById(R.id.edtSenha);

		btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener() {
    		
			@Override
			public void onClick(View a) {
				// TODO Auto-generated method stub
				strLogin = edtLogin.getText().toString();
				strEmail = strLogin; 
				strSenha = edtSenha.getText().toString();

				if (!strLogin.isEmpty() && !strSenha.isEmpty() ) {
					
		                new AsyncLoginUsuario(getApplicationContext()).execute();
		                
				}else{
					Toast.makeText(getApplicationContext(), "É necessário preencher todos os campos.",
							   Toast.LENGTH_LONG).show();
				}
			}
		}); 
        

        btnCriarUsuario = (Button) findViewById(R.id.btnCriarConta);
        btnCriarUsuario.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View a) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), UsuarioActivity.class );
				
				startActivity(intent);
			}
		}); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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
    

    private class AsyncLoginUsuario extends AsyncTask<Void, Void, Void>
    {
    	 private Context context;

    	    public AsyncLoginUsuario(Context context){
    	        this.context=context;
    	    }
    	    
        private String response;
        private JSONObject jsonUsuario,param;
        private ProgressDialog pDialog;
        private String usuario;
        private String email;
        private String senha;
        //public static final String postUrl = "http://189.60.228.5:3000/posts.json";
        public static final String UsuarioUrl = "https://eventfinder-wmedsantos.c9users.io/api/sessions";


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(LoginActivity.this);
            pDialog.setMessage("Efetuando login...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

            usuario = strLogin.toString();
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
                //param.put("nome", usuario);                
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
            
            if (response.contains("Logged in")){
            //finish(); //retorna a atividade anterior
			
			Intent intent = new Intent(context, ListaEventosActivity.class );
			startActivity(intent);
			
            }else{
            	Toast.makeText(getApplicationContext(), "Falha no login",
						   Toast.LENGTH_LONG).show();
                  
            }

        }

    }
}
