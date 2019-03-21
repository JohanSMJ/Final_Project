package model.dao;

import java.util.ArrayList;
import java.util.Calendar;

import model.entity.DocumentType;
import model.entity.IdentificationDepartment;
import model.entity.Member;
import utilities.DateUtilities;

public class Department {
	ManagerInstitute managerInstitute;
	private IdentificationDepartment identificationDepartment;

	public Department(IdentificationDepartment identificationDepartment, ArrayList<Institute> institutes) {
		this.identificationDepartment = identificationDepartment;
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

	public Object[][] getDataFundationInstitutes() {
		ArrayList<Calendar> datesFundation = new ArrayList<>();
		for (int i = 0; i < getDataDepartment().length; i++) {
			datesFundation.add((Calendar) getDataDepartment()[i][5]);
		}
		return DateUtilities.yearAmount(datesFundation);
	}

	public int getNumberInstitutes() {
		return managerInstitute.getNumberInstitutes();
	}

	public String getID() {
		return identificationDepartment.getiD();
	}

	public void addCupToInstitute(String iDInsitute) {
		managerInstitute.addCupTOInstitute(iDInsitute);
	}

	public Object[] getDataSpecificInstitute(String iD) {
		return managerInstitute.getDataInstitute(iD);
	}

	public Object[][] getDataMembersSpecificInstitute(String iD) {
		return managerInstitute.getDataMembersInstitute(iD);
	}


	public Object[] getStateInstrumetnSpecificInstitute() {
		return managerInstitute.getStateInstrumentInstitute();
	}
	public void removeInstitute(String iD) {
		managerInstitute.removeInstitute(iD);
	}
	public Object[][] getDataDepartmentCups(int numberRank) {
		Object[][] data = new Object[managerInstitute.getNumberInstitutes()][5];
		Object[][] temp = managerInstitute.getDataIntitutesCups(numberRank);
		if (temp != null) {
			for (int i = 0; i < temp.length; i++) {
				data[i][0] = identificationDepartment.getName();
				data[i][1] = temp[i][0];
				data[i][2] = temp[i][1];
				data[i][3] = temp[i][2];
				data[i][4] = temp[i][3];
			}
		} else {
			data = null;

		}
		return data;
	}
	public void removeMember(String iDInstitute,String iDMember) {
		managerInstitute.removeMember(iDInstitute, iDMember);
	}
	public Institute getSpecificInstitute(String iD) {
		return managerInstitute.searchInstitute(iD);
	}

	public Institute searchInstitute(String iDInstute) {
		return managerInstitute.searchInstitute(iDInstute);
	}
	public Object[] numberGenders() {
		return managerInstitute.numberGenders();
	}
	public void addMemberToInstituteSpecific(String iD, Member member) {
		managerInstitute.addMemberToSpecificInstitute(iD, member);
	}

	public boolean validateIDMember(String iDMember) {
		return managerInstitute.validateIDMembers(iDMember);
	}

	public boolean validateIDInstitute(String iDInstitute) {
		return managerInstitute.validateIDInstitutes(iDInstitute);
	}

	public void addInstitute(Institute institute) {
		managerInstitute.addInstitute(institute);
	}

	public String getName() {
		return identificationDepartment.getName();
	}

	public Object[][] getDirectorName() {
		Object[][] data = new Object[getNumberInstitutes()][3];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = managerInstitute.getDirectoNames()[i][0];
			data[i][1] = managerInstitute.getDirectoNames()[i][1];
			data[i][2] = getName();
		}
		return data;
	}


	public Institute getDataObjctInstiute(String iD) {
		return managerInstitute.searchInstitute(iD);
	}

	public int getNumberInstitute() {
		return managerInstitute.getNumberInstitutes();
	}
	public int numberTotalCups() {
		return  managerInstitute.numberTotalCups();
	}
}
