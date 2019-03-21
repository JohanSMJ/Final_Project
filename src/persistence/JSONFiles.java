package persistence;

import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

public class JSONFiles implements IFiles{

	@Override
	public ArrayList<Object> readFile(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeFile(String path,Object[][] data) {
		JsonArray array=new JsonArray();
		JsonObject object=null;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				object=	new JsonObject();
				object.put("NameDepartment", data[i][0]);
				object.put("NameInstiute", data[i][1]);
				object.put("NumberMembers", data[i][2]);
				object.put("NumberCups", data[i][3]);
				object.put("NameDdirector", data[i][4]);
				object.put("DateFundation", data[i][5]);
			}
			array.add(object);
			JsonObject jsonObj=new JsonObject();
			jsonObj.put("Institutos",array);
		try {
			FileWriter file = new FileWriter(path);
			file.write(jsonObj.toJson());
			file.flush();
			file.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	}
}
