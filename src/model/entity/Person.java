package model.entity;

import java.util.Calendar;

import utilities.DateUtilities;

public class Person {
	private String name;
	private Calendar birthDate;
	private DocumentType documentType;
	private String iD;
	private Gender genere;
	
	public Person(String name, Calendar birthDate, DocumentType documentType, String iD, Gender genere) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.documentType = documentType;
		this.iD = iD;
		this.genere = genere;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getDocumentType() {
		return documentType.name();
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getGender() {
		return genere.name();
	}

	public void setGender(Gender genere) {
		this.genere = genere;
	}
	public String getAge() {
		String age=DateUtilities.getCalculeTime(birthDate); 
		return age;
	}
	public String getBirthDateString() {
		return  DateUtilities.calendarToString(birthDate);
	}
}
