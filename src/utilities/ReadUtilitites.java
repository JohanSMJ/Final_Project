package utilities;

import java.util.ArrayList;
import java.util.Random;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.dao.Department;
import model.dao.Institute;
import model.entity.DirectorInstitute;
import model.entity.DocumentType;
import model.entity.Gender;
import model.entity.IInstrumentType;
import model.entity.IdentificationDepartment;
import model.entity.Instrument;
import model.entity.Member;
import model.entity.PercussionInstrument;
import model.entity.StringInstrument;
import model.entity.WindInstrument;

public class ReadUtilitites {
	private static int conIdsInstitute=0;
	private static int conIdsMember=0;
	private static int conIdsDirector=0;
	public static ArrayList<Department> Departments(ArrayList<String> personas,ArrayList<String> instruments,ArrayList<String> instituts){
		ArrayList<Department> departments=new ArrayList<>();
		Department department=null;
		for (int i = 0; i < 16; i++) {
			department=new Department(ReadUtilitites.identificationDepartment(i), Institutes(ReadUtilitites.randomNumber(15, 25), personas, instruments, instituts));
			System.out.println(department.getName());
			departments.add(department);
		}
		return departments;
	}
	public static IdentificationDepartment identificationDepartment(int iD) {
		switch (iD) {
		case 0:
			return IdentificationDepartment.BOYACA;
		case 1:
			return IdentificationDepartment.CUNDINAMARCA;
		case 2:
			return IdentificationDepartment.ANTIOQUIA;
		case 3:
			return IdentificationDepartment.CALDAS;
		case 4:
			return IdentificationDepartment.CAUCA;
		case 5:
			return IdentificationDepartment.CAQUETA;
		case 6:
			return IdentificationDepartment.CESAR;
		case 7:
			return IdentificationDepartment.CHOCO;
		case 8:
			return IdentificationDepartment.HUILA;
		case 9:
			return IdentificationDepartment.NARIÑO;
		case 10:
			return IdentificationDepartment.NORTE_DE_SANTANDER;
		case 11:
			return IdentificationDepartment.PUTUMAYO;
		case 12:
			return IdentificationDepartment.QUINDIO;
		case 13:
			return IdentificationDepartment.RISARALDA;
		case 14:
			return IdentificationDepartment.SANTANDER;
		case 15:
			return IdentificationDepartment.TOLIMA;
		default:
			break;
		}
		return IdentificationDepartment.BOYACA;
	}
	public static ArrayList<Institute> Institutes(int numberInstitutes,ArrayList<String> personas,ArrayList<String> instruments,ArrayList<String> instituts){
		ArrayList<Institute> institutes=new ArrayList<>();
		Institute institute=null;
		int cons=0;
		int random=0;
		for (int i = ReadUtilitites.conIdsInstitute; i <(ReadUtilitites.conIdsInstitute+numberInstitutes); i++) {
			random=ReadUtilitites.randomNumber(1, 20);
			institute=new Institute(instituts.get(random), DateUtilities.calendarAlAzar(),
					""+i,ReadUtilitites.randomNumber(0, 10), Member(personas, instruments,
							randomNumber(15, 25)), ReadUtilitites.director(personas, instituts.get(random), ""+i));
			institutes.add(institute);
			cons=i-ReadUtilitites.conIdsInstitute;
		}
		ReadUtilitites.conIdsInstitute+=cons+1;
		return institutes;
	}
	public static ArrayList<Member> Member(ArrayList<String> personas,ArrayList<String> instruments,int numberMembers) {
		ArrayList<Member> members=new ArrayList<>();
		Member member=null;
		int cons=0;
		for (int i = ReadUtilitites.conIdsMember; i <(ReadUtilitites.conIdsMember+numberMembers); i++) {
			String[] linePerson=splitNumeral(personas.get(i));
			member=new Member(linePerson[0], DateUtilities.strigToCalendar(linePerson[1]),createDocupentType(linePerson[3]), linePerson[2],ReadUtilitites.genereGender(linePerson[4]),instrument(instruments));
			members.add(member);
			cons=i-ReadUtilitites.conIdsMember;
		}
		ReadUtilitites.conIdsMember+=cons+1;
		return members;
	}
	public static Gender genereGender(String gender) {
		if(gender.equals(Gender.FEMALE.name())) {
			return Gender.FEMALE;
		}else{
			return Gender.MASCULINE;
		}
	}
	public static DirectorInstitute director(ArrayList<String> personas,String nameInstitute,String iDInstitute) {
		 DirectorInstitute directorInstitute=null;
		 int i=ReadUtilitites.randomNumber(5, 1000);
			String[] linePerson=splitNumeral(personas.get(i));
			directorInstitute=new DirectorInstitute(linePerson[0], DateUtilities.strigToCalendar(linePerson[1]),createDocupentType(linePerson[2]),""+ReadUtilitites.randomNumber(10000,9900),ReadUtilitites.genereGender(linePerson[4]),nameInstitute,iDInstitute);
			ReadUtilitites.conIdsDirector++;
		
		return directorInstitute;
	}
	public static String[] splitNumeral(String lineText){
		String[] line=lineText.split("#+");
		return line;
	}
	public static String[] splitSlash(String lineText){
		String[] line=lineText.split("/+");
		return line;
	}
	
	public static String splitPoint(String lineText){
		String[] line=lineText.split("\\.");
		for (int i = 0; i < line.length; i++) {
			System.out.println(line[i]);
		}
		return line[line.length-1];
	}
	public static DocumentType createDocupentType(String documentType) {
		if(DocumentType.CC.name().equals(documentType))
			return DocumentType.CC;
		if(DocumentType.CE.name().equals(documentType))
			return DocumentType.TI;
		if(DocumentType.TI.name().equals(documentType))
			return DocumentType.CE;
		return DocumentType.RN;
	}
	public static Instrument instrument(ArrayList<String> instruments) {
		Instrument instrument=null;
		String[] dates=null;
			dates=ReadUtilitites.splitSlash((instruments.get(ReadUtilitites.randomNumber(1, 13))));
			instrument=new Instrument(dates[0], createIInstrumentType(dates[0], dates[1]), alAzarBoolean());
		return instrument;
	}
	public static IInstrumentType createIInstrumentType(String name,String description) {
		IInstrumentType instrument=null;
		if(name.equals("Teclado")||name.equals("maracas")||name.equals("Bateria")) {
			instrument=new PercussionInstrument();
			instrument.setInstrumentDescription(description);
		}
		if(name.equals("Guitarra")||name.equals("Cuatro")||name.equals("Contrapunteo")||name.equals("Arpa")||name.equals("Bateria")) {
			instrument=new StringInstrument();
			instrument.setInstrumentDescription(description);
		}
		if(name.equals("Cantos de Trabajo  de Llano")||name.equals("Trompeta")||name.equals("Artes plasticas")||name.equals("Tecnica Vocal")||name.equals("Literatura Llanera")||name.equals("Teatro")) {
			instrument=new WindInstrument();
			instrument.setInstrumentDescription(description);
		}
		return instrument;
	}
	public static boolean alAzarBoolean() {
		if(randomNumber(0, 2)==1) 
			return false;
		return true;
	}
	public static int randomNumber(int min,int max) {
		return (int) (Math.random()*(max-min) + min );
	}
	public static ArrayList<String> toMembers(ArrayList<Object> list){
		ArrayList<String> datas=new ArrayList<>();
		String data="";
		for (int i = 0; i < 10000; i++) {
			NodeList node=(NodeList)list.get(i);
			data=node.item(0).getTextContent()+"#"+node.item(1).getTextContent()+"#"+node.item(2).getTextContent()+"#"+node.item(3).getTextContent()+"#"+node.item(4).getTextContent();
			datas.add(data);
		}
		return datas;
	}
}
