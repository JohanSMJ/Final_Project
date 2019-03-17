package utilities;

import java.awt.Image;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;

import model.entity.DocumentType;
import model.entity.Gender;
import model.entity.UserAdminister;

public class Utilities {
	
//	public static UserAdminister createAdmin() {
//		return new UserAdminister("JUAN", new GregorianCalendar(arg0, arg1, arg2), DocumentType.CC, "1212312", Gender.COMUNITY_LGBTIQ_AND_OTHERS);
//	}
	
	@SuppressWarnings("unused")
	public static ImageIcon resizeImage(int width,int height, String imagePath) {
		Image img= new ImageIcon(imagePath).getImage();
		return new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
	
	public static Object[][] testTabel(int lenght) {
		Object[][] matrix=new Object [100][lenght];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j]="test";
				}
			}
		return matrix;
	}
	
}
