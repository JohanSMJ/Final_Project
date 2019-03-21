package model.entity;

import java.util.Calendar;

public class DirectorInstitute extends Person{
	private String nameInstitute;
	private String iDInstitute;
	public DirectorInstitute(String name, Calendar birthDate, DocumentType documentType, String iD, Gender genere,String nameInstitute,String iDInstitute) {
		super(name, birthDate, documentType, iD, genere);
		this.nameInstitute=nameInstitute;
		this.iDInstitute=iDInstitute;
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		super.setName(name);
	}
	public String getName() {
		return super.getName();
	}
	public void setID(String iD) {
		super.setiD(iD);
	}
	public String getID() {
		return super.getiD();
	}
	public void setBirtDate(Calendar birthDate) {
		super.setBirthDate(birthDate);
	}
	public String getBirthDateString() {
		return super.getBirthDateString();
	}
	public void setGender(Gender genere) {
		super.setGender(genere);
	}
	public String getGender() {
		return super.getGender();
	}
	public void setDocumentType(DocumentType documentType) {
		super.setDocumentType(documentType);
	}
	public String getDocumentType() {
		return super.getDocumentType();
	}
}
