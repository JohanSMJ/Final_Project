package model.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import utilities.DateUtilities;

public class Member extends Person{
	private Instrument instrument;
	public Member(String name, Calendar birthDate, DocumentType documentType, String iD, Gender genere,Instrument instrument) {
		super(name, birthDate, documentType, iD, genere);
		this.instrument=instrument;
	}
	public String getNameInstrument() {
		return instrument.getName();
	}
	public void setNameInstrument(String name) {
		instrument.setName(name);
	}
	public boolean getState() {
		return instrument.isState();
	}
	public void setState(boolean state) {
		instrument.setState(state);
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
	public String toString() {
		return super.getName()+"/"+super.getDocumentType()+"/"+super.getiD()+"/"+super.getAge()+"/"+super.getGender()+"/"+instrument.getName()+"/"+instrument.isState();
	}
}
