package model.dao;

import java.util.ArrayList;
import java.util.Calendar;

import model.entity.Cup;
import model.entity.DirectorInstitute;
import model.entity.Event;
import model.entity.Member;
import utilities.DateUtilities;

public class Institute {
	private String name;
	private String iD;
	private DirectorInstitute directorInstitute;
	private Calendar dateFundation;
	private ArrayList<Member>members=new ArrayList<>();
	private ArrayList<Cup>cups=new ArrayList<>();
	private ArrayList<Event>eventsHistorial=new ArrayList<>();
	public Institute(String name, Calendar dateFundation,String iD, ArrayList<Member> members,DirectorInstitute directorInstitute) {
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


	public String getName() {
		return name;
	}
	public int getNumberMembers() {
		return members.size();
	}
	public int getNumberCups() {
		return cups.size();
	}
	public Object[] getDataInstitute() {
		Object[] data=new Object[5];
		data[0]=getName();
		data[1]=getID();
		data[2]=getNumberMembers();
		data[3]=getNumberCups();
		return data;
	}
	public Object[] getDataSpecificInstitute() {
		Object[] data=new Object[6];
		data[0]=getName();
		data[1]=getNumberMembers();
		data[2]=getNumberCups();
		data[3]=directorInstitute.getName();
		data[4]=DateUtilities.calendarToString(dateFundation);
		return data;
	}
	public String getID() {
		return iD;
	}
	public int getNumberEvents() {
		return eventsHistorial.size();
	}
	public Object[][] getDataMembers(){
		Object[][] data=new Object[members.size()][6];
		for (int i = 0; i < members.size(); i++) {
			data[i][0]=members.get(i).getName();
			data[i][1]=members.get(i).getAge();
			data[i][2]=members.get(i).getDocumentType();
			data[i][2]=members.get(i).getID();
			data[i][2]=members.get(i).getGenere();
			data[i][2]=members.get(i).getNameInstrument();

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
	public ArrayList<Calendar> datesRerve() {
		ArrayList<Calendar> dates=new ArrayList<>();
		for (int i = 0; i < eventsHistorial.size(); i++) {
			dates.add(eventsHistorial.get(i).getDate());
		}
		return dates;
	}
	public void addEvent(Event event) {
		eventsHistorial.add(event);
	}
	public Object[] getNameDirector() {
		Object[] data=new Object[2];
		data[0]=directorInstitute.getName();
		data[1]=getName();
	return data;
	}
}
