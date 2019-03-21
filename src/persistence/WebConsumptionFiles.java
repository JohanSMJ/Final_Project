package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;


public class WebConsumptionFiles {
	public ArrayList<String> readFileInstruments() throws FileNotFoundException,IOException,ParseException,org.json.simple.parser.ParseException{
		String url="https://www.datos.gov.co/resource/ram5-xjq2.json";
		ArrayList<String> data=new ArrayList<>();
		String demo="";
		try {
			InputStream inputStream = getHttpURLConnection( false, url);
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
			JsonArray array=(JsonArray) Jsoner.deserialize(inputStreamReader);
			for (int i = 0; i < array.size(); i++) {
				JsonObject jsonObject=(JsonObject)array.get(i);
				String descripcion=jsonObject.getString("descripcion");
				String name=jsonObject.getString("instrumentomusicalbasicodetodalamusica");
				demo=name+"/"+descripcion;
				data.add(demo);
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
		InputStream inputStream = getHttpURLConnection( false, url);
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
			JsonArray array=(JsonArray) Jsoner.deserialize(inputStreamReader);
			for (int i = 0; i < array.size(); i++) {
				JsonObject jsonObject=(JsonObject)array.get(i);
				String sede=jsonObject.getString("sede");
				data.add(sede);
				}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	public static InputStream getHttpURLConnection(boolean isProxy, String filePath) {
		HttpURLConnection httpURLConnection;
		URL url = null;
		InputStream inputStream = null;
		try {
			url = new URL( filePath );
			if ( !isProxy ) {
				httpURLConnection = (HttpURLConnection) url.openConnection();	
				inputStream = httpURLConnection.getInputStream();
			}else {
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
				httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
				inputStream = httpURLConnection.getInputStream();
				if(inputStream == null )
					System.out.println( "Este input no quiere funcionar" );
			}

		}catch(ConnectException connectException) {
			isProxy = true;
			return getHttpURLConnection( isProxy, filePath );
		} catch (UnknownHostException e) {
			isProxy = true;
			System.out.println( "Catch: " + e.getMessage()  );
			return getHttpURLConnection( isProxy, filePath );
		} catch (MalformedURLException e1) {
			System.out.println(  e1.getMessage()  );
			e1.printStackTrace();
		}catch (IOException e) {
			System.out.println(  e.getMessage()  );
			e.printStackTrace();
		}
		return inputStream;
	}

}
