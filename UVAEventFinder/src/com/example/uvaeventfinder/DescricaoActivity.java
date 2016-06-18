package com.example.uvaeventfinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DescricaoActivity  extends Activity {
	
	
	Button btnComentario;
	ImageView imgEvento;
	TextView txvDescricao;
	TextView txvLocal;	
	TextView txvDataInicio;
	TextView txvDataFim; 
	TextView txvNome;
	TextView txvVagas;
	TextView txvSite;
	TextView txvPalestrante;
		
    private Evento evento;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_descricao);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
		Context context = getApplicationContext();
		Bundle extras = getIntent().getExtras();
        if (extras != null) {
        	evento = (Evento)getIntent().getSerializableExtra("evento"); //Obtaining data 
        	if (evento != null){
                imgEvento  = (ImageView) findViewById(R.id.imgEvento);
                String strImagem = evento.getImagem();
                strImagem  = strImagem.substring(0, strImagem.length()-4);
                Log.i("imagem",strImagem);
                Log.i("pkg",context.getPackageName());
                int imgResId = context.getResources().getIdentifier(strImagem.toString(), "drawable", context.getPackageName());
                Log.i("pkg",String.valueOf(imgResId));
                Log.i("pkg",String.valueOf(R.drawable.sqlazure));
                Drawable draw = context.getResources().getDrawable(imgResId);
                if (draw != null){
                	imgEvento.setImageDrawable(draw);
                }
                txvNome = (TextView) findViewById(R.id.txvNome);
                txvNome.setText(evento.getNome());
                
				txvDescricao = (TextView) findViewById(R.id.txvDescricao);
				txvDescricao.setText(evento.getDescricao());
             
				txvLocal = (TextView) findViewById(R.id.txvLocal);
				txvLocal.setText(evento.getLocal());
             
				txvDataInicio = (TextView) findViewById(R.id.txvDataInicio);
				txvDataInicio.setText(evento.getDatainicio());

				txvDataFim = (TextView) findViewById(R.id.txvDataFim);
				txvDataFim.setText(evento.getDatafim());
	
				txvVagas = (TextView) findViewById(R.id.txvVagas);
				txvVagas.setText(String.valueOf(evento.getVagasdisponiveis()));

				txvSite = (TextView) findViewById(R.id.txvSite);
				txvSite.setText(evento.getSite());

				txvPalestrante = (TextView) findViewById(R.id.txvPalestrante);
				txvPalestrante.setText(evento.getPalestrante());
							
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
