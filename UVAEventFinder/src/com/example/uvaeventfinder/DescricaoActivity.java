package com.example.uvaeventfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DescricaoActivity  extends Activity {
	
	
	Button btnComentario;
	TextView txvDescricao;
	
    private Evento evento;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_descricao);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		Bundle extras = getIntent().getExtras();
        if (extras != null) {
        	evento = (Evento)getIntent().getSerializableExtra("evento"); //Obtaining data 
        	if (evento != null){
        		Toast.makeText(getApplicationContext(), evento.getDescricao(),
						   Toast.LENGTH_LONG).show();
        	 txvDescricao = (TextView) findViewById(R.id.txvDescricao);
             txvDescricao.setText(evento.getDescricao());
        	}
        }
        
       
        
		btnComentario = (Button) findViewById(R.id.btnComentario);
		btnComentario.setOnClickListener(new OnClickListener() {
       	 //imgEvento.src="@drawable/" + String.substring(Evento.Imagem, 0, String.length(Evento.Imagem)-4);	
			@Override
			public void onClick(View a) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), ComentariosActivity.class );
				startActivity(intent);
			}
		}); 
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
	
	
}
