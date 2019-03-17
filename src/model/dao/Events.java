package model.dao;

import java.awt.Event;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
public class Events {
	private model.entity.Event event;
	private String iDEvent;
	private ArrayList<Institute>challengers=new ArrayList<>();
	private ManagerDepartment managerDepartment;
	public Events(String name,Calendar date,String iDDepartemnt,String iD) {
		managerDepartment=new ManagerDepartment();
		event=new model.entity.Event(name,date,iDDepartemnt,iD);
	}
	public Calendar dateEvent() {
		return event.getDate();
	}
	public String getName() {
		return event.getName();
	}
	public model.entity.Event getEvent() {
		return event;
	}
	public boolean addChalenger(String iDInstitute) {
		boolean validate=true;
		Department department=managerDepartment.searchDepartment(event.getIDDepartment());
		Iterator<Calendar> iterator=department.datesRerveInstitute(iDInstitute).iterator();
		while(iterator.hasNext()&&validate) {
			Calendar date=iterator.next();
			if(event.getDate().equals(date)) {
				validate=false;
				challengers.add(department.getSpecificInstitute(iDInstitute));
			}
		}
		return validate;
	}
	public void confirmEvent() {
		for (int i = 0; i < challengers.size(); i++) {
			managerDepartment.addEventToinstitutSpecific(event.getIDDepartment(), challengers.get(i).getID(), event);
		}
	}
	public Object[] toObjectVector() {
		Object[] obj=new Object[5];
		obj[0]=event.toObjectVector()[0];
		obj[1]=event.toObjectVector()[1];
		obj[2]=event.toObjectVector()[2];
		obj[3]=managerDepartment.searchDepartment(event.getIDDepartment()).getName();
		obj[4]=challengers.size();
		return obj;
	}
}
