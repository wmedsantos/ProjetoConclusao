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
import android.widget.Toast;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListaEventosActivity extends Activity {
	
	
	private ListView ltvEventos;
	private ArrayList<Evento> listEventos;
 
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_listaeventos);
	        	       
//	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        //
	        ltvEventos = (ListView) findViewById(R.id.ltvEventos);
	        ltvEventos.setLongClickable(true);
	         // Instanciating an array list (you don't need to do this, 
	         // you already have yours).
//	         List<String> listaEventos = new ArrayList<String>();
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");
//	         listaEventos.add("Web Day 2016 - 16/06/16");
//	         listaEventos.add("UVA Tech Meeting - 20/06/16");	         
	         // This is the array adapter, it takes the context of the activity as a 
	         // first parameter, the type of list view as a second parameter and your 
	         // array as a third parameter.
//	         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//	                 this, 
//	                 android.R.layout.simple_list_item_checked,
//	                 listaEventos );
//
//	         ltvEventos.setAdapter(arrayAdapter); 
	         
//	         int count = ltvEventos.getCount();
//	         for (int i = 0; i < count; i++)
//	        	 ltvEventos.setItemChecked(i, true);
	         
	         ltvEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	             public void onItemClick(AdapterView<?> parent, View itemClicked, int 
	                                                     position, long id) {
	            	 
	            	   CheckedTextView textView = (CheckedTextView)itemClicked;
			           textView.setChecked(!textView.isChecked());
	             } 
	         });

	         ltvEventos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

	             public boolean onItemLongClick(AdapterView<?> arg0, View v,
	                     int index, long arg3) {
	            	 //Toast.makeText(list.this,myList.getItemAtPosition(index).toString(), Toast.LENGTH_LONG).show();
	            	 Intent intent = new Intent(getApplicationContext(), DescricaoActivity.class );
	            	Bundle bundle = new Bundle();
	            	Evento evento = (Evento)listEventos.get(index);
	            	if (evento != null){
	            		
	            		bundle.putSerializable("evento", evento); 
	            		intent.putExtras(bundle);
	            	}
	 				startActivity(intent);
	                 return false;
	             }
	         }); 
	        
	         new AsyncGetEventos().execute();

	    }

	    @Override
	    protected void onRestart()
	    {
	        super.onRestart();
	        new AsyncGetEventos().execute();
	    }
	 
	 private class AsyncGetEventos extends AsyncTask<Void, Void, Void>{

	        private ProgressDialog pDialog;
	        private JSONArray jsonArray;
	        
	        private ArrayList<String> listStrEventos;
	        private ArrayAdapter<Evento> adapter;
	        //public static final String getUrl = "http://189.60.228.5:3000/posts.json";
	        public static final String getUrl = "https://eventfinder-wmedsantos.c9users.io/eventos.json";

	        @Override
	        protected void onPreExecute()
	        {
	            super.onPreExecute();

	            pDialog = new ProgressDialog(ListaEventosActivity.this);
	            pDialog.setMessage("Lendo dados...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }

	        @Override
	        protected Void doInBackground(Void... args)
	        {
	            String s;
	            WebRequest webreq = new WebRequest();

	            s = webreq.makeWebServiceGET(getUrl);

	            try {
	                jsonArray = new JSONArray(s);
	            }catch (Exception e)
	            {
	                e.printStackTrace();
	            }
	            finally {
	                Log.i("jsonArray: ", "> " + jsonArray.toString());
	                return null;
	            }
	        }

	        @Override
	        protected void onPostExecute(Void result)
	        {
	            //montar o ArrayAdapter a partir do JSONObject
	            if(jsonArray != null) {
	            	listEventos = new ArrayList<Evento>();
	            	listStrEventos = new ArrayList<String>();
	                try {
	                    for (int i = 0; i < jsonArray.length(); i++) {
	                        JSONObject jsonObject = jsonArray.getJSONObject(i);
	                        //Log.i("Token:", jsonArray.getJSONObject(i).toString());
	                        
	                        
	                        String nome = jsonObject.getString("nome");
	                        String descricao = jsonObject.getString("descricao");
	                        String datainicio = jsonObject.getString("datainicio");
	                        String datafim = jsonObject.getString("datafim");
	                        String local = jsonObject.getString("local");
	                        String endereco = jsonObject.getString("endereco");
	                        String site = jsonObject.getString("site");
	                        String vagasdisponiveis = jsonObject.getString("vagasdisponiveis");
	                        String url = jsonObject.getString("url");
	                        int id = jsonObject.getInt("id");
	                        listEventos.add(new Evento(id, nome, descricao, datainicio,datafim, 
	                        		local, endereco,site, vagasdisponiveis, url));
	                        listStrEventos.add(nome.concat(" - ").concat(
	                        		datainicio.substring(2,8)));
	                    }
	                }
	                catch(Exception e)
	                {
	                    e.printStackTrace();
	                }
	                finally {
	                	  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
	         	                 ListaEventosActivity.this, 
	         	                 android.R.layout.simple_list_item_checked,
	         	                listStrEventos );

	         	         ltvEventos.setAdapter(arrayAdapter); 
	                    //adapter = new ListViewAdapter<Post>(MainActivity.this,android.R.layout.simple_list_item_1,list);
	                     
	                    pDialog.cancel();
	                }
	            }
	            else
	            {
	                Log.i("Error: ", "> " + "jsonObject is null");
	            }
	        }

	    }

}
