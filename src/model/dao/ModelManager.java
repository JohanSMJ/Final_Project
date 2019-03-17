package model.dao;

import java.util.ArrayList;

import model.entity.Member;

public class ModelManager {
	 ManagerEvent managerEvent;
	 Region region;
	 public ModelManager(ArrayList<Department> departments) {
		 managerEvent=new ManagerEvent();
		 region=new Region(departments);
	 }
	public Object[][] getDataTotal(){
		return region.getDataRegion();
	}
	public Object[][] getDataDepartment(String iD){
		return region.getDataDepartment(iD);
	}
	public Object[] getDataSpecificInstitute(String iDDepartment,String iDInstitute) {
		return region.getDataSpecific(iDDepartment, iDInstitute);
	}
	public Object[] getDataMembersSpecificInstituteSpecificDeprtment(String iDDepartment,String iDInstitute) {
		return region.getDataMembersSpecificInstituteSpecificDeprtment(iDDepartment, iDInstitute);
	}
	public Object[] getStateInstrumentsSpcificInstititeSpecificDepartment(String iDDepartment,String iDInstitute){
		return region.getStateInstrumentsSpcificInstititeSpecificDepartment(iDDepartment, iDInstitute);
	}
	public Object[][] getDataDepartmentsCups(int numberRank){
		return region.getDataDepartmentsCups(numberRank);
	}
	public void addMemberToSpecificInstituteToSpecifcDepartment(String iDDepartment,String iDInstitute,Member member) {
		region.addMemberToSpecificInstituteToSpecifcDepartment(iDDepartment, iDInstitute, member);
	}
	public void addInstituteToSpecificDepartment(String iDDepartment,Institute institute) {
		region.addInstituteToSpecificDepartment(iDDepartment, institute);
	}
	public Object[][] dataNumbersIntitutesDepartments(){
		return region.dataNumbersIntitutesDepartments();
	}
	public Object[][] getDirectorsNamesToSpecificDeparment(String iDDepartment) {
		return region.getDirectorsNamesToSpecificDeparment(iDDepartment);
	}
	public Object[][] getDirectorsNamens(){
		return region.getDirectorsNamens();
	}
	public Object[][] getDateFundationInstitutes(String iDDepartment){
		return region.getDateFundationInstitutes(iDDepartment);
	}
	public Object[][] getDateEventsConfirmet(){
		return managerEvent.getDateEventsConfirmet();
	}
	public Object[][] getDateEventsInProcess(){
		return managerEvent.getDateEventsInProcess();
		
	}
}
