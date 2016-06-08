package com.example.uvaeventfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class ComentariosActivity extends Activity {
	
	Button button_enviar;
	EditText edit_opiniao;
	
	RadioButton radio_gostei;
	RadioButton radio_ngostei;
	
	ImageView image_evento;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comentarios);
	}
}
