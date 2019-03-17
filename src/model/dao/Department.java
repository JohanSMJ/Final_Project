package model.dao;

import java.util.ArrayList;
import java.util.Calendar;

import model.entity.Event;
import model.entity.IdentificationDepartment;
import model.entity.Member;
import utilities.DateUtilities;

public class Department {
	ManagerInstitute managerInstitute;
	private IdentificationDepartment identificationDepartment;

	public Department(IdentificationDepartment identificationDepartment,ArrayList<Institute> institutes) {
		this.identificationDepartment=identificationDepartment;
		managerInstitute = new ManagerInstitute(institutes);
	}
	public Object[][] getDataDepartment() {
		Object[][] data = new Object[managerInstitute.getNumberInstitutes()][7];
		for (int i = 0; i < managerInstitute.getNumberInstitutes(); i++) {
			data[i][0] = identificationDepartment.getName();
			data[i][1] = managerInstitute.getDataInstitutes()[i][0];
			data[i][2] = managerInstitute.getDataInstitutes()[i][1];
			data[i][3] = managerInstitute.getDataInstitutes()[i][2];
			data[i][4] = managerInstitute.getDataInstitutes()[i][3];
			data[i][5] = managerInstitute.getDataInstitutes()[i][4];
		}
		return data;
	}
	public Object[][] getDataFundationInstitutes(){
		ArrayList<Calendar> datesFundation=new ArrayList<>();
		for (int i = 0; i < getDataDepartment().length; i++) {
			datesFundation.add((Calendar)getDataDepartment()[i][5]);
		}
		return DateUtilities.yearAmount(datesFundation);
	}
	public int getNumberInstitutes() {
		return managerInstitute.getNumberInstitutes();
	}

	public String getID() {
		return identificationDepartment.getiD();
	}

	public Object[] getDataSpecificInstitute(String iD) {
		return managerInstitute.getDataInstitute(iD);
	}

	public Object[][] getDataMembersSpecificInstitute(String iD) {
		return managerInstitute.getDataMembersInstitute(iD);
	}
	public ArrayList<Calendar> datesRerveInstitute(String iD) {
		return managerInstitute.datesRerveInstitute(iD);
	}
	public Object[] getStateInstrumetnSpecificInstitute(String iD){
		return managerInstitute.getStateInstrumentInstitute(iD);
	}
	public Object[][] getDataDepartmentCups(int numberRank) {
		Object[][] data = new Object[managerInstitute.getNumberInstitutes()][6];
		for (int i = 0; i < managerInstitute.getNumberInstitutes(); i++) {
			data[i][0] = identificationDepartment.getName();
			data[i][1] = managerInstitute.getDataIntitutesCups(numberRank)[i][1];
			data[i][2] = managerInstitute.getDataIntitutesCups(numberRank)[i][2];
			data[i][3] = managerInstitute.getDataIntitutesCups(numberRank)[i][3];		
			data[i][4] = managerInstitute.getDataIntitutesCups(numberRank)[i][4];		
		}
		return data;
	}
	public Institute getSpecificInstitute(String iD) {
		return managerInstitute.searchInstitute(iD);
	}
	public void addMemberToInstituteSpecific(String iD,Member member) {
//		managerInstitute.addMemberToInstituteSpecific(iD, member);
	}
	public void addInstitute(Institute institute) {
		managerInstitute.addInstitute(institute);
	}
	public String getName() {
		return identificationDepartment.getName();
	}
	public Object[][] getDirectorName() {
		Object[][] data=new Object[getNumberInstitutes()][3];
		for (int i = 0; i < data.length; i++) {
			data[i][0]= managerInstitute.getDirectoNames()[0];
			data[i][1]= managerInstitute.getDirectoNames()[1];
			data[i][0]= getName();
		}
		return data;
	}
	public void addEventToSpecificInstitute(String IDInstitute,Event event) {
		managerInstitute.addEventToInstitute(IDInstitute, event);
	}
}
