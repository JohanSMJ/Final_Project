package model.dao;

import java.util.ArrayList;

import model.entity.Event;
import model.entity.Member;

public class Region {
	ManagerDepartment managerDepartment;
	public Region(ArrayList<Department> departments) {
		managerDepartment= new ManagerDepartment(departments);
	}
	public Object[][] getDataRegion(){
		return managerDepartment.getDataDepartments();
	}
	public Object[][] getDataDepartment(String iD){
		return managerDepartment.getDataSpecificDepartment(iD);
	}
	public Object[] getDataSpecific(String iDDepartment,String iDInstitute) {
		return managerDepartment.getDataSpecificInstitute(iDDepartment, iDInstitute);
	}
	public Object[][] getDataMembersSpecificInstituteSpecificDeprtment(String iDDepartment,String iDInstitute){
		return managerDepartment.getDataMembersSpcificInstititeSpecificDepartment(iDDepartment, iDInstitute);
	}
	public Object[] getStateInstrumentsSpcificInstititeSpecificDepartment(String iDDepartment,String iDInstitute){
		return managerDepartment.getStateInstrumentsSpcificInstititeSpecificDepartment(iDDepartment, iDInstitute);
	}
	public Object[][] getDataDepartmentsCups(int numberRank){
		return managerDepartment.getDataDepartmentsCups(numberRank);
	}
	public void addMemberToSpecificInstituteToSpecifcDepartment(String iDDepartment,String iDInstitute,Member member) {
		managerDepartment.addMemberToInstituteSpecificToSpecificDepartment(iDDepartment, iDInstitute, member);
	}
	public void addInstituteToSpecificDepartment(String iDDepartment,Institute institute) {
		managerDepartment.addInstituteToSpecificDepartment(iDDepartment, institute);
	}
	public Object[][] dataNumbersIntitutesDepartments(){
		return managerDepartment.dataNumbersIntitutesDepartments();
	}
	public Object[][] getDirectorsNamesToSpecificDeparment(String iDDepartment) {
		return managerDepartment.getDirectorsNamesToSpecificDeparment(iDDepartment);
	}
	public Object[][] getDirectorsNamens(){
		return managerDepartment.getDirectorsNamens();
	}
	public Object[][] getDateFundationInstitutes(String iDDepartment){
		return managerDepartment.dataYearsInstitutes(iDDepartment);
	}
	public void createDepartment() {
		
	}
}
