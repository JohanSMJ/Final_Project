package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;


public class JsonFile {
	public ArrayList<String> readFileInstruments() throws FileNotFoundException,IOException,ParseException,org.json.simple.parser.ParseException{
		String url="https://www.datos.gov.co/resource/ram5-xjq2.json";
		ArrayList<String> data=new ArrayList<>();
		try {
		URL conect=new URL(url);
//		Proxy proxy=new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73",8080));
		HttpsURLConnection conn=(HttpsURLConnection) conect.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("acept","application/java");
		String demo="";
		if(conn.getResponseCode()==200) {
			InputStreamReader inputStreamReader=new InputStreamReader((conn.getInputStream()));
			JsonArray array=(JsonArray) Jsoner.deserialize(inputStreamReader);
			for (int i = 0; i < array.size(); i++) {
				JsonObject jsonObject=(JsonObject)array.get(i);
				String descripcion=jsonObject.getString("descripcion");
				String name=jsonObject.getString("instrumentomusicalbasicodetodalamusica");
				demo=name+"/"+descripcion;
				data.add(demo);
				}
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	public ArrayList<String> readFileInstitutes() throws FileNotFoundException,IOException,ParseException,org.json.simple.parser.ParseException{
		String url="https://www.datos.gov.co/resource/k5aq-t8t2.json";
		ArrayList<String> data=new ArrayList<>();
		try {
		URL conect=new URL(url);
//		Proxy proxy=new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73",8080));
		HttpsURLConnection conn=(HttpsURLConnection) conect.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("acept","application/java");
		System.out.println(conn.getResponseCode());
		if(conn.getResponseCode()==200) {
			InputStreamReader inputStreamReader=new InputStreamReader((conn.getInputStream()));
			JsonArray array=(JsonArray) Jsoner.deserialize(inputStreamReader);
			for (int i = 0; i < array.size(); i++) {
				JsonObject jsonObject=(JsonObject)array.get(i);
				String sede=jsonObject.getString("sede");
				data.add(sede);
				}
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
}
