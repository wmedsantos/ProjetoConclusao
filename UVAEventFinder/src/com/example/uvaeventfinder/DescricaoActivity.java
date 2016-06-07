package com.example.uvaeventfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class DescricaoActivity  extends Activity {
	
	TextView textView_temaResp;
	TextView textView_inicioResp;
	TextView textView_fimResp;
	TextView textView_localResp;
	TextView textView_siteResp;
	TextView textView_enderecoResp;
	TextView textView_vagasResp;
	TextView txvDescricao;
	
	ImageView imgEvento;
	
	Button button_OP;
	
	CheckBox checkBox_inscreverResp;
	
	//teste
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_descricao);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
	
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
