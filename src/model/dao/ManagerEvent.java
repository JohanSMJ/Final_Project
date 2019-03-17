package model.dao;

import java.util.ArrayList;

import model.entity.Event;

public class ManagerEvent {
	private ArrayList<Events>events=new ArrayList<>();
	private ArrayList<Events>eventsInProcess=new ArrayList<>();
	public ManagerEvent() {
		
	}
	public void createEvent(Event event) {
		Events events=new Events(event.getName(), event.getDate(), event.getIDDepartment(),genertaID());
		eventsInProcess.add(events);
	}
	public void addChallengerToEvent(String iD,String IDInstitute) {
		eventsInProcess.get(searchEvntsInEventsInProcess(iD)).addChalenger(IDInstitute);
	}
	public void confirmEvent(String iD) {
		Events event=eventsInProcess.get(searchEvntsInEventsInProcess(iD));
		eventsInProcess.remove(event);
		events.add(event);
		event.confirmEvent();
	}
	public String genertaID(){
		String iD="";
		boolean validate=false;
		while(!validate) {
			int iDnumber=(int) Math.random()*(1000-0)+0;
			for (int i = 0; i < events.size(); i++) {
				if(iDnumber==Integer.parseInt(events.get(i).getEvent().getiD())) {
					validate=true;
					iD=iDnumber+"";
				}
			}
			for (int i = 0; i < eventsInProcess.size(); i++) {
				if(iDnumber==Integer.parseInt(eventsInProcess.get(i).getEvent().getiD())) {
					validate=true;
					iD=iDnumber+"";
				}
			}
			
		}
		return iD;
	}
	public int searchEvntsInEvents(String iD) {
		int poss=-1;
		for (int i = 0; i < events.size(); i++) {
			if(iD.equals(events.get(i).getEvent().getiD()))
				poss=i;
		}
		return poss;
	}
	public int searchEvntsInEventsInProcess(String iD) {
		int poss=-1;
		for (int i = 0; i < eventsInProcess.size(); i++) {
			if(iD.equals(eventsInProcess.get(i).getEvent().getiD()))
				poss=i;
		}
		return poss;
	}
	public Object[][] getDateEventsConfirmet(){
		Object[][]obj=new Object[events.size()][5];
		for (int i = 0; i < events.size(); i++) {
			obj[i]=events.get(i).toObjectVector();
		}
		return obj;
	}
	public Object[][] getDateEventsInProcess(){
		Object[][]obj=new Object[eventsInProcess.size()][5];
		for (int i = 0; i < eventsInProcess.size(); i++) {
			obj[i]=eventsInProcess.get(i).toObjectVector();
		}
		return obj;
	}
}
