package com.example.uvaeventfinder;

import android.util.Log;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.*;

public class WebRequest {
    static String response = null;

    //Constructor with no parameter
    public WebRequest() {  }

    public String makeWebServiceGET(String urladdress){
        URL url;
        String response = "";
        try {
            url = new URL(urladdress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(15001);
            conn.setConnectTimeout(15001);
            //conn.setDoInput(false);
            //conn.setDoOutput(false);

            conn.setRequestMethod("GET");

            int reqresponseCode = conn.getResponseCode();

            Log.i("response code >> ", ""  + reqresponseCode);

            if (reqresponseCode == HttpURLConnection.HTTP_OK) {
                String line;
                Log.i("response >>","ok");
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response += line;
                }
            } else {
                //Log.i("T4", "ELSE");
                response = "<error>";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            Log.i(">>","Teste");
            return response;
        }
    }

    public String makeWebServicePOST(String urladdress, JSONObject params) {
        URL url;
        String response = "";
        StringBuilder sb = new StringBuilder();

        try {
            url = new URL(urladdress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15001);
            conn.setConnectTimeout(15001);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept","application/json");

            if (params != null) {
                OutputStreamWriter ostream = new OutputStreamWriter(conn.getOutputStream());

                ostream.write(params.toString());

                ostream.flush();
                ostream.close();

                int HttpResult =conn.getResponseCode();
                if(HttpResult ==HttpURLConnection.HTTP_OK){
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            conn.getInputStream(),"utf-8"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();

                    System.out.println("" + sb.toString());

                }else{
                    System.out.println(conn.getResponseMessage());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String makeWebServiceDELETE(String urladdress, int id) {
        URL url;
        String response = "";
        StringBuilder sb = new StringBuilder();
        try {
            url = new URL(urladdress + id + ".json");
            Log.i("delete url> ", url.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(15001);
            conn.setConnectTimeout(15001);
            //conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            //conn.setRequestProperty("Content-Type", "application/json");

            //conn.connect();

            int reqresponseCode =conn.getResponseCode();

            if (reqresponseCode == HttpURLConnection.HTTP_OK) {
                String line;
                Log.i("response >>", "ok");
            } else {
                //Log.i("T4", "ELSE");
                response = "<error>";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String makeWebServicePUT(String urladdress, int id, JSONObject params) {
        URL url;
        String response = "";
        StringBuilder sb = new StringBuilder();
        try {
            url = new URL(urladdress + id + ".json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15001);
            conn.setConnectTimeout(15001);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept","application/json");
            conn.setRequestProperty("X-HTTP-Method-Override", "PATCH"); //fake patch

            if (params != null) {
                OutputStreamWriter ostream = new OutputStreamWriter(conn.getOutputStream());

                ostream.write(params.toString());

                ostream.flush();
                ostream.close();

                int HttpResult =conn.getResponseCode();
                if(HttpResult ==HttpURLConnection.HTTP_OK){
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            conn.getInputStream(),"utf-8"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();

                    System.out.println("" + sb.toString());

                }else{
                    System.out.println(conn.getResponseMessage());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}