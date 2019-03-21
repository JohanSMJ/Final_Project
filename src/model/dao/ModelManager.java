package model.dao;

import java.util.ArrayList;
import java.util.Calendar;

import model.entity.Member;
import utilities.DateUtilities;

public class ModelManager {
	 Region region;
	 public ModelManager(ArrayList<Department> departments) {
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
	public Object[][] getDataMembersSpecificInstituteSpecificDeprtment(String iDDepartment,String iDInstitute) {
		return region.getDataMembersSpecificInstituteSpecificDeprtment(iDDepartment, iDInstitute);
	}
	public Object[] getStateInstrumentsSpcificInstititeSpecificDepartment(String iDDepartment){
		return region.getStateInstrumentsSpcificInstititeSpecificDepartment(iDDepartment);
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
	public void addCupToInstitute(String iDDepartment,String iDInstitute) {
		region.addCupToInstiute(iDDepartment, iDInstitute);
	}
	public Institute getDataObjctInstiute(String iDDepartment,String iDInstitute) {
		return region.getDataObjctInstiute(iDDepartment, iDInstitute);
	}
	public boolean validateIDMember(String iDMember) {
		return region.validateIDMember(iDMember);
	}
	public boolean validateIDIntitute(String iDInstitute) {
		return region.validateIDInstiute(iDInstitute);
	}
	public int getNumberTotalInstitutes() {
		return region.getNumberTotalInstitutes();
	}
	public void removeInstitute(String iDDepartment,String iDInstitute) {
		region.removeInstitute(iDDepartment, iDInstitute);
	}
	public void removeMember(String iDDepartment,String iDInstitute,String iDMember) {
		region.removeMember(iDDepartment, iDInstitute, iDMember);
	}
	public Object[] numberGenders() {
		return region.numberGenders();
	}
	public Object[][] twoMostCups(){
		return region.twoMostCups();
	}
}
