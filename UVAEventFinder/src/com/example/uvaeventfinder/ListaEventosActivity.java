package com.example.uvaeventfinder;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class ListaEventosActivity extends Activity {
	
	
	private ListView ltvEventos;

 
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_listaeventos);
	        	       
//	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        
	        ltvEventos = (ListView) findViewById(R.id.ltvEventos);
	        ltvEventos.setLongClickable(true);
	         // Instanciating an array list (you don't need to do this, 
	         // you already have yours).
	         List<String> listaEventos = new ArrayList<String>();
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");
	         listaEventos.add("Web Day 2016 - 16/06/16");
	         listaEventos.add("UVA Tech Meeting - 20/06/16");	         
	         // This is the array adapter, it takes the context of the activity as a 
	         // first parameter, the type of list view as a second parameter and your 
	         // array as a third parameter.
	         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
	                 this, 
	                 android.R.layout.simple_list_item_checked,
	                 listaEventos );

	         ltvEventos.setAdapter(arrayAdapter); 

	         ltvEventos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

	             public boolean onItemLongClick(AdapterView<?> arg0, View v,
	                     int index, long arg3) {
	            	 //Toast.makeText(list.this,myList.getItemAtPosition(index).toString(), Toast.LENGTH_LONG).show();
	            	 Intent intent = new Intent(getApplicationContext(), DescricaoActivity.class );

	 				startActivity(intent);
	                 return false;
	             }
	         }); 
	        

	    }


}
