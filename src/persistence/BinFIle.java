package persistence;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BinFIle implements IFiles{

	@Override
	public ArrayList<Object> readFile(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeFile(String path,Object[][] data) {
		FileOutputStream fileOutputStream=null;
		DataOutputStream dataOutputStrem=null;
		try {
			fileOutputStream=new FileOutputStream(path,true);
			dataOutputStrem=new DataOutputStream(fileOutputStream);
			DataOutputStream print;
			for (int i = 0; i < data.length; i++) {
					dataOutputStrem.writeUTF(encripted((String)data[i][0]));
					dataOutputStrem.writeUTF(encripted(((String)data[i][1])));
					dataOutputStrem.writeInt(Integer.parseInt(data[i][2].toString()));
					dataOutputStrem.writeInt(Integer.parseInt(data[i][3].toString()));
					dataOutputStrem.writeUTF(encripted(((String)data[i][4])));
					dataOutputStrem.writeUTF(encripted(((String)data[i][5])));
			}
			dataOutputStrem.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		 catch (IOException e) {
				System.out.println(e.getMessage());
			}
	}
	public char[][] createMatrizEncripted(String string) {
		int size = (string.length() / 2) + 1;
		char[] charArray = string.toCharArray();
		char[][] charMatriz = new char[size][size];
		for (int i = 0, k = 0; i < charMatriz.length; i++) {
			for (int j = 0; j < charMatriz.length; j++) {
				charMatriz[j][i] = charArray[k];
				k++;
				if (k > charArray.length - 1)
					k = 0;
			}
		}
		return charMatriz;
	}
	public String encripted(String string) {
		String encripted = "";
		char[][] matriz = this.createMatrizEncripted(string);
		for (int i = matriz.length - 1, k = 0; i > 0; i--) {
			for (int j = matriz.length - 1; j >= 0; j--) {
				if (k == string.length()) {
					break;
				}
				encripted += matriz[j][i];
				k++;
			}
		}
		return encripted;
	}
}
