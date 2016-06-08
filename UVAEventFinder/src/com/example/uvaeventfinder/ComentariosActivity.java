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
import android.widget.ImageView;
import android.widget.RadioButton;

public class ComentariosActivity extends Activity {
	
	Button btnEnviar;
	EditText edit_opiniao;
	
	RadioButton radio_gostei;
	RadioButton radio_ngostei;
	
	ImageView image_evento;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comentarios);
		
		btnEnviar = (Button) findViewById(R.id.btnEnviar);
		btnEnviar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View a) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), DescricaoActivity.class );
				startActivity(intent);
			}
		}); 
		
	}
}
