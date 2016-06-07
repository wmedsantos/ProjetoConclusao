package com.example.uvaeventfinder;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaEventosActivity extends Activity {
	
	
	private ListView ltvEventos;

 
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_listaeventos);
	        	       
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        
	        ltvEventos = (ListView) findViewById(R.id.ltvEventos);

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

	        
	    }


}
