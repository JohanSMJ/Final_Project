package model.dao;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.plaf.FontUIResource;

import model.entity.Event;
import model.entity.Member;

public class ManagerInstitute {
	private String id;
	private ArrayList<Institute> institutes;
	public ManagerInstitute( ArrayList<Institute> institutes) {
		this.institutes=institutes;
	}
	public Object[][] getDataInstitutes(){
		Object[][] data=new Object[institutes.size()][6];
		for (int i = 0; i < institutes.size(); i++) {
			data[i]=institutes.get(i).getDataSpecificInstitute();
		}
		return data;
	}
	public Institute searchInstitute(String iD) {
		Institute institute=null;
		int i=0;
		boolean validate=false;
		System.out.println("0n");
		while (i!=-1&&i<getNumberInstitutes()) {
			if(institutes.get(i).getID().equals(iD)) {
				institute=institutes.get(i);
				i=-2;
				validate=true;
			}
			i++;
		}
		return institute;
	}
	public int searchPosInstitute(String iD) {
		int i=0;
		while (i!=-1) {
			if(institutes.get(i).getID().equals(iD)) {
				return i;
			}
			i++;
		}
		return i;
	}
	public int getNumberInstitutes() {
		return institutes.size();
	}
	public Object[] getDataInstitute(String iD) {
		return searchInstitute(iD).getDataSpecificInstitute();
	}
	public Object[][] getDataMembersInstitute(String iD){
		return searchInstitute(iD).getDataMembers();
	}
	public Object[] getStateInstrumentInstitute(String iD){
		return searchInstitute(iD).getStateInstruments();
	}
	public Object[][] getDataIntitutesCups(int numberRank) {
		ArrayList<Object[]> cupsTemp=new ArrayList<>();
		for (int i = 0; i <institutes.size(); i++) {
			if (institutes.get(i).getNumberCups()>=numberRank) {
				cupsTemp.add(institutes.get(i).getDataInstitute());
			}
		}
		Object[][] cups=new Object[cupsTemp.size()][5];
		for (int i = 0; i < cupsTemp.size(); i++) {
			cups[i]=cupsTemp.get(i);
		}
		return cups;
	}
	public void addInstitute(Institute institute) {
		institutes.add(institute);
	}
	public void addEventToInstitute(String iDInstitute,Event event) {
		Institute institute=institutes.get(searchPosInstitute(iDInstitute));
		institutes.remove(institute);
		institute.addEvent(event);
		institutes.add(institute);
	}
	public void removeInstitute(String iD) {
		institutes.remove(searchPosInstitute(iD));
	}
	public ArrayList<Calendar> datesRerveInstitute(String iD) {
	return searchInstitute(iD).datesRerve();
	}
	public void addMemberToSpecificInstitute(String iD,Member member) {
		institutes.get(searchPosInstitute(iD)).addMember(member);
	}
	public void addEventToInstituteSpecific(Event event,String iD) {
		institutes.get(searchPosInstitute(iD)).addEvent(event);
	}
	public Object[][] getDirectoNames() {
		Object[][] data=new Object[institutes.size()][2];
		for (int i = 0; i < institutes.size(); i++) {
			data[i]=institutes.get(i).getNameDirector();
		}
	return data;
	}
}
