package utilities;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;

import model.dao.Institute;
import model.entity.DirectorInstitute;
import model.entity.DocumentType;
import model.entity.Gender;
import model.entity.IInstrumentType;
import model.entity.Instrument;
import model.entity.Member;
import model.entity.PercussionInstrument;
import model.entity.StringInstrument;
import model.entity.UserAdminister;
import model.entity.WindInstrument;

public class Utilities {
	
	private static int iDInstitute=1;
	
	public static int iDInstituteNew(int numberInstitutes) {
		int newNumberInstitutes=numberInstitutes+iDInstitute;
		iDInstitute++;
		return newNumberInstitutes;
	}
	
	public static ArrayList<Double> getValuesState(Object [] vector) {
		ArrayList<Double> max=new ArrayList<>();
		for (int i = 0; i < vector.length; i++) {
			Integer in=(Integer) vector[i];
			Double val=Double.parseDouble(""+in.intValue());
			max.add(val);
		}
		return max;
	}
	
	public static ArrayList<Double> getGenderValues(Object[] vector) {
		ArrayList<Double>arrayList=new ArrayList<>();
		
		for (int i = 0; i < vector.length; i++) {
			Integer in=(Integer) vector[i];
			Double val=Double.parseDouble(""+in.intValue());
			arrayList.add(val);
		}
		
		return arrayList;
	}
	
	public static Object[][] changeVectorToMatrix(Object[] vector) {
		Object[][]matrix=new Object[1][vector.length];
		matrix[0]=vector;
		return matrix;
	}
	public static int getTotalVector(Object [] vector) {
		int max=0;
		try {
			for (int i = 0; i < vector.length; i++) {
				
				Integer g=(Integer) vector[i];
				max+=g.intValue();
			}
		} catch (Exception e) {
			max=-1;
		}
		return max;
	}
	
	public static Member createMember(Object[] member,Object[]instrument) {
		String name=(String) member[0];
		
		Calendar birthDate=(Calendar) member[1];
		DocumentType documentType=(DocumentType) member[2];
		String iD=(String) member[3];
		String nameGenere=(String) member[4];
		Gender genere=getGender(nameGenere);
		Instrument instrument2=createInstrument(instrument);
		return new Member(name, birthDate, documentType, iD, genere, instrument2);
	}
	
	public static Gender getGender(String nameGender) {
		Gender gender=null;
		
		if (nameGender.equals("MASCULINO")||nameGender.equals("MASCULINE")) {
			gender=Gender.MASCULINE;
		}
		if (nameGender.equals("FEMENINO")||nameGender.equals("FEMALEw")) {
			gender=Gender.FEMALE;
		}
		if (nameGender.equals("COMUNIDAD LGBTIQ")||nameGender.equals("COMUNITY LGBTIQ")) {
			gender=Gender.COMUNITY_LGBTIQ_AND_OTHERS;
		}
		
		return gender;
	}
	
	public static Institute createInstitute(Object[] institute,String iD,Object[] director) {
		Institute i;
		try {
			String name=(String) institute[0];
			Calendar dateFundation=(Calendar) institute[1];
			ArrayList<Member> members=new ArrayList<>();
			DirectorInstitute directorInstitute=createDirector(director,name,iD);
			//		Object[] temp= {textNameInstitute.getText(),dateChooser.getCalendar()};
			i= new Institute(name, dateFundation, iD, members, directorInstitute);
		}catch (Exception e) {
			i=null;
		}
		return i;
	}
	
	public static DirectorInstitute createDirector(Object[] director, String nameInstitute,String iDInstitute) {
//		Object [] temp= {textNameDirector.getText(),dateChooser.getCalendar(),
//				(DocumentType) typeDocument.getSelectedItem(),textNumberID.getText()
//		gender.getSelectedItem()};
		System.out.println("length director: "+director.length);
		
		DirectorInstitute directorInstitute;
		try {
			String name=(String) director[0];
			System.out.println("name director: "+name);
			
			Calendar birthDate=(Calendar) director[1];
			System.out.println("fechaDirector: "+birthDate.toString());
			
			DocumentType documentType=(DocumentType) director[2];
			System.out.println("tipoDocumento: "+documentType.name());
			
			String iD=(String) director[3];
			System.out.println("Documento: "+iD);
			String gender=(String) director[4];
			System.out.println("-------------------gender----------"+gender);
			Gender genere=getGender(gender);
			System.out.println("genero: "+genere.name());
			
			directorInstitute= new DirectorInstitute(name, birthDate, documentType,
				iD, genere, nameInstitute, iDInstitute);
		}
		catch (Exception e) {
			directorInstitute=null;
			System.out.println("null director: ");
		}
		return directorInstitute;
				
	}
	
	public static Instrument createInstrument(Object[] instrument) {
		String name=(String) instrument[0];
		String nameType=(String) instrument[1];
		String des=(String) instrument[3];
		IInstrumentType type=getIntrumemtType(nameType, des);
		String nameState=(String) instrument[2];
		boolean state=getIntrumentState(nameState);
		return new Instrument(name, type, state);
	}
	
	public static boolean getIntrumentState(String state) {
		boolean sta=false;
		if (state.equals("BUEN ESTADO")||state.equals("GOOD STATE")) {
			sta=true;
		}
		return sta;
	}
	
	public static IInstrumentType getIntrumemtType(String type, String des) {
		IInstrumentType iInstrumentType=null;
		if (type.equals("CUERDA")||type.equals("STRING")) {
			StringInstrument s=new StringInstrument();
			s.setInstrumentDescription(des);
			iInstrumentType=s;
		}
		if (type.equals("VIENTO")||type.equals("WIND")) {
			WindInstrument s=new WindInstrument();
			s.setInstrumentDescription(des);
			iInstrumentType=s;
		}
		if (type.equals("PERCUSIÓN")||type.equals("PERCUSSION")) {
			PercussionInstrument s=new PercussionInstrument();
			s.setInstrumentDescription(des);
			iInstrumentType=s;
		}
		
		return iInstrumentType;
	}
	
	public static String objectToString(Object[] vector) {
		String out="NO TIENE NADA EL VECTOR";
		if (vector!=null) {
			out="";
		
			for (int i = 0; i < vector.length; i++) {
				out+=" "+vector[i].toString();
				System.out.println(vector[i].toString());
			}
		}
		
		return out;
	}
	
	public static String[] arrayToStringVector(ArrayList<String> arrayList) {
		String[]vector=new String [arrayList.size()];
		for (int i = 0; i < vector.length; i++) {
			vector[i]=arrayList.get(i);
		}
		return vector;
	}
	
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
	public static ArrayList<Integer> objectToInteger(Object[] vector) {
		ArrayList<Integer>arrayList=new ArrayList<>();
		
		for (int i = 0; i < vector.length; i++) {
			arrayList.add((Integer) vector[i]);
		}
		
		return arrayList;
	}
	public static int getMayorNumberArray(ArrayList<Integer>arrayList) {
		int num=arrayList.get(0);
		int com=0;
		for (int i = 0; i < arrayList.size(); i++) {
			com=arrayList.get(i);
			if (com>num) {
				num=com;
			}
		}
		return num;
	}
	
}
