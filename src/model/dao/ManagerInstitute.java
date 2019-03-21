package model.dao;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.plaf.FontUIResource;

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
		while (i!=-1&&i<getNumberInstitutes()) {
			if(institutes.get(i).getID().equals(iD)) {
				institute=institutes.get(i);
				i=-2;
			}
			i++;
		}
		return institute;
	}
	public int searchPosInstitute(String iD) {
		int i=0;
		while (i!=-1&&i<getNumberInstitutes()) {
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
	
	public Object[] getStateInstrumentInstitute(){
		Object[] obj=new Object[3];
		int total=0;
		int totalG=0;
		int totalE=0;
		for (int i = 0; i < institutes.size(); i++) {
			total+=Integer.parseInt(institutes.get(i).getStateInstruments()[0].toString());
			totalG+=Integer.parseInt(institutes.get(i).getStateInstruments()[1].toString());
			totalE+=Integer.parseInt(institutes.get(i).getStateInstruments()[2].toString());
		}
		obj[0]=total;
		obj[1]=totalG;
		obj[2]=totalE;
		return obj;
	}
	public void removeMember(String iDInstitute,String iDMember) {
		institutes.get(searchPosInstitute(iDInstitute)).removeMember(iDMember);
	}
	public Object[][] getDataIntitutesCups(int numberRank) {
	Object[] temp=new Object[4];
	ArrayList<Object[]> temp2=new ArrayList<>();
	Institute institute=null;
	for (int i = 0; i < institutes.size(); i++) {
		institute=institutes.get(i);
		if (institute.getNumberCups()>=numberRank) {
			temp=institute.getDataInstitute();
			temp2.add(temp);
		} 
	}
	Object[][] cups=new Object[temp2.size()][temp.length];
	for (int i = 0; i < temp2.size(); i++) {
		cups[i]=temp2.get(i);
	}
		return cups;
	}
	public void addInstitute(Institute institute) {
		institutes.add(institute);
	}
	public void removeInstitute(String iD) {
		institutes.remove(searchPosInstitute(iD));
	}
	public void addMemberToSpecificInstitute(String iD,Member member) {
		institutes.get(searchPosInstitute(iD)).addMember(member);
	}
	public Object[][] getDirectoNames() {
		Object[][] data=new Object[institutes.size()][2];
		for (int i = 0; i < institutes.size(); i++) {
			data[i][0]=institutes.get(i).getNameDirector()[0];
			data[i][1]=institutes.get(i).getNameDirector()[1];
		}
	return data;
	}
	public void addCupTOInstitute(String iD) {
		Institute institute=institutes.get(searchPosInstitute(iD));
		institutes.remove(searchPosInstitute(iD));
		institute.addCup();
		institutes.add(institute);
	}
	public boolean validateIDMembers(String iDMember) {
		for (int i = 0; i < institutes.size(); i++) {
		if(!institutes.get(i).validateIdMember(iDMember))
			return false;
		}
		return true;
	}
	public boolean validateIDInstitutes(String iDInstitutes) {
		for (int i = 0; i <institutes.size(); i++) {
			if(institutes.get(i).getID().equals(iDInstitutes))
				return false;
		}
		return true;
	}
	public Object[] numberGenders() {
		Object[] obj=new Object[3];
		int male=0;
		int female=0;
		int others=0;
		for (int i = 0; i < institutes.size(); i++) {
			male+=Integer.parseInt(institutes.get(i).numberGenders()[0].toString());
			female+=Integer.parseInt(institutes.get(i).numberGenders()[1].toString());
			others+=Integer.parseInt(institutes.get(i).numberGenders()[2].toString());
		}
		obj[0]=male;
		obj[1]=female;
		obj[2]=others;
		return obj;
	}
	public int numberTotalCups() {
		int numberTotal=0;
		for (int i = 0; i < institutes.size(); i++) {
			numberTotal+=institutes.get(i).getNumberCups();
		}
		return numberTotal;
	}
}
