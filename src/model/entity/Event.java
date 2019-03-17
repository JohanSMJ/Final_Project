package model.entity;

import java.util.Calendar;

import utilities.DateUtilities;

public class Event {
	private String name;
	private Calendar date;
	private String iDDepartment;
	private String iD;
	public Event(String name,Calendar date,String iDDepartment,String iD) {
		this.iD=iD;
		this.iDDepartment=iDDepartment;
		this.name=name;
		this.date=date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getIDDepartment() {
		return iDDepartment;
	}
	public void setIDDepartment(String iDDepartment) {
		this.iDDepartment = iDDepartment;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public Object[] toObjectVector() {
		Object[] obj=new Object[3];
		obj[0]=getName();
		obj[1]=DateUtilities.calendarToString(getDate());
		obj[2]=getiD();
		return obj;
	}
}
