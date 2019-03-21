package model.entity;

import java.util.Calendar;

public class UserAdminister extends Person{
	private String nickName;
	private String password;
	public UserAdminister(String name, Calendar birthDate, DocumentType documentType, String iD, Gender genere) {
		super(name, birthDate, documentType, iD, genere);
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
