package model.dao;

import java.util.ArrayList;
import java.util.Calendar;

import model.entity.DirectorInstitute;
import model.entity.Gender;
import model.entity.Member;
import utilities.DateUtilities;

public class Institute {
	private String name;
	private String iD;
	private DirectorInstitute directorInstitute;
	private Calendar dateFundation;
	private ArrayList<Member>members=new ArrayList<>();
	private int cups=0;
	public Institute(String name, Calendar dateFundation,String iD, ArrayList<Member> members,DirectorInstitute directorInstitute) {
		this.iD=iD;
		this.name = name;
		this.dateFundation = dateFundation;
		this.members = members;
		this.directorInstitute=directorInstitute;
	}public Institute(String name, Calendar dateFundation,String iD, int numberCups,ArrayList<Member> members,DirectorInstitute directorInstitute) {
		this.cups=numberCups;
		this.iD=iD;
		this.name = name;
		this.dateFundation = dateFundation;
		this.members = members;
		this.directorInstitute=directorInstitute;
	}
	public Calendar getDateFundation() {
		return dateFundation;
	}


	public void setDateFundation(Calendar dateFundation) {
		this.dateFundation = dateFundation;
	}
	
	public void addCup() {
		cups++;
	}
	public String getName() {
		return name;
	}
	public int getNumberMembers() {
		return members.size();
	}
	public int getNumberCups() {
		return cups;
	}
	public Object[] getDataInstitute() {
		Object[] data=new Object[4];
		data[0]=getName();
		data[1]=getID();
		data[2]=getNumberMembers();
		data[3]=getNumberCups();
		return data;
	}
	public void removeMember(String iDMember) {
		members.remove(searhMember(iDMember));
	}
	public Object[] getDataSpecificInstitute() {
		Object[] data=new Object[6];
		data[0]=getName();
		data[1]=getNumberMembers();
		data[2]=getNumberCups();
		String director="";
		if (directorInstitute==null) {
			director="";
		}else {
			director=directorInstitute.getName();
		}
		data[3]=director;
		data[4]=DateUtilities.calendarToString(dateFundation);
		return data;
	}
	public String getID() {
		return iD;
	}
	public Object[][] getDataMembers(){
		Object[][] data=new Object[members.size()][6];
		for (int i = 0; i < members.size(); i++) {
			data[i][0]=members.get(i).getName();
			data[i][1]=members.get(i).getAge();
			data[i][2]=members.get(i).getDocumentType();
			data[i][3]=members.get(i).getID();
			data[i][4]=members.get(i).getGender();
			data[i][5]=members.get(i).getNameInstrument();
		}
		return data;
	}
	public Member searhMember(String iD) {
		Member member=null;
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).getID()==iD) 
				member=members.get(i);
		}
		return member;
	}
	public Object[]	getStateInstruments() {
		Object[] state=new Object[3];
		state[0]=members.size();
		int states=0;
		for (int i = 0; i < state.length; i++) {
			if(members.get(i).getState()==true)
				states++;
		}
		state[1]=states;
		state[2]=members.size()-states;
		return state;
	}
	public void addMember(Member member) {
		members.add(member);
	}
	public void deleteMember(String iD) {
		members.remove(searhMember(iD));
	}
	public boolean validateIdMember(String iD) {
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).getID().equals(iD))
				return false;
		}
		return true;
	}
	public Object[] getNameDirector() {
		Object[] data=new Object[2];
		data[0]=directorInstitute.getName();
		data[1]=getName();
	return data;
	}
	public Object[] numberGenders() {
		Object[] obj=new Object[3];
		int male=0;
		int female=0;
		int others=0;
		for (int i = 0; i <members.size(); i++) {
			if(members.get(i).getGender().equals(Gender.MASCULINE.toString())) {
				male++;
			}
			if(members.get(i).getGender().equals(Gender.FEMALE.toString())) {
				female++;
			}
			if(members.get(i).getGender().equals(Gender.COMUNITY_LGBTIQ_AND_OTHERS.toString())) {
				others++;
			}
			obj[0]=male;
			obj[1]=female;
			obj[2]=others;
		}
		return obj;
	}
}
