package persistence;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PlainFile implements IFiles {

	@Override
	public ArrayList<Object> readFile(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeFile(String path, Object[][] data) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(path);
			printWriter = new PrintWriter(fileWriter);
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					printWriter.print(data[i][j]+"#");
				}
				printWriter.println("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fileWriter)
					fileWriter.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
