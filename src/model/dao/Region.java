package model.dao;

import java.util.ArrayList;

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
	public Object[] getStateInstrumentsSpcificInstititeSpecificDepartment(String iDDepartment){
		return managerDepartment.getStateInstrumentsSpcificInstititeSpecificDepartment(iDDepartment);
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
	public void addCupToInstiute(String iDDepartment,String iDInstitute) {
		managerDepartment.addCupToInstitute(iDDepartment, iDInstitute);
	}
	public Institute getDataObjctInstiute(String iDDepartment,String iDInstitute) {
		return managerDepartment.getDataObjctInstiute(iDDepartment, iDInstitute);
	}
	public boolean validateIDMember(String iDMember) {
		return managerDepartment.validateIDMember(iDMember);
	}
	public boolean validateIDInstiute(String iDInstitute) {
		return managerDepartment.validateIDInstitute(iDInstitute);
	}
	public Institute searchInstituteTotal(String iDInstitute) {
		return managerDepartment.searchInstituteTotal(iDInstitute);
	}
	public int getNumberTotalInstitutes() {
		return managerDepartment.getnumberTotalInstitutes();
	}
	public void removeInstitute(String iDDepartment,String iDInstitute) {
		managerDepartment.removeInstitute(iDDepartment, iDInstitute);
	}
	public void removeMember(String iDDepartment,String iDInstitute,String iDMember) {
		managerDepartment.removeMember(iDDepartment, iDInstitute, iDMember);
	}
	public Object[] numberGenders() {
		return managerDepartment.numberGenders();
	}
	public Object[][] twoMostCups(){
		return managerDepartment.twoMostCups();
	}
}
