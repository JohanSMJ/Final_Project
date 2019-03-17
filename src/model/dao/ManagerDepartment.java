package model.dao;

import java.util.ArrayList;

import model.entity.Event;
import model.entity.IdentificationDepartment;
import model.entity.Member;

public class ManagerDepartment {
	private ArrayList<Department> departments = new ArrayList<>();

	public ManagerDepartment(ArrayList<Department> departments) {
	this.departments=departments;
	}
	public ManagerDepartment() {
		
	}
	public int getTotalInstitutes() {
		int total = 0;
		for (int i = 0; i < departments.size(); i++) {
			total += departments.get(i).getNumberInstitutes();
		}
		return total;
	}
	public Object[][] getDataDepartments() {
		Object[][] data = new Object[getTotalInstitutes()][7];
		for (int i = 0,l=0; i < departments.size(); i++) {
			for (int j = 0; j < getNumberInstitutes(i); j++,l++) {
				for (int k = 0; k < data[0].length; k++) {
						data[l][k] = getDataDepartment(i)[j][k];
				}
			}
		}
		return data;
	}

	public int getNumberInstitutes(int numberDepartment) {
		return departments.get(numberDepartment).getNumberInstitutes();
	}

	public Object[][] getDataDepartment(int numberDepartment) {
		return departments.get(numberDepartment).getDataDepartment();
	}

	public Department searchDepartment(String iD) {
		Department department = null;
		int i = 0;
		while (i != -1) {
			if (departments.get(i).getID().equals(iD)) {
				department = departments.get(i);
				i = -2;
			}
			i++;
		}
		return department;
	}
	public int searchPosDepartment(String iD) {
		int i = 0;
		while (i != -1) {
			if (departments.get(i).getID().equals(iD)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public Object[][] getDataSpecificDepartment(String iD) {
		return searchDepartment(iD).getDataDepartment();
	}

	public Object[] getDataSpecificInstitute(String iDDepertment, String IDInstitute) {
		return searchDepartment(iDDepertment).getDataSpecificInstitute(IDInstitute);
	}
	public Object[][] getDataMembersSpcificInstititeSpecificDepartment(String iDDepartment, String iDInstitute) {
		return searchDepartment(iDDepartment).getDataMembersSpecificInstitute(iDInstitute);
	}

	public Object[] getStateInstrumentsSpcificInstititeSpecificDepartment(String iDDepartment, String iDInstitute) {
		return searchDepartment(iDDepartment).getStateInstrumetnSpecificInstitute(iDInstitute);
	}

	public Object[][] getDataDepartmentsCups(int numberRank) {
		Object[][] data = new Object[getTotalInstitutes()][4];
		for (int i = 0,l=0; i < departments.size(); i++) {
			for (int j = 0; j < getNumberInstitutes(i); j++,l++) {
				for (int k = 0; k < 4; k++) {
						data[l][k] = departments.get(i).getDataDepartmentCups(numberRank)[j][k];
				}
			}
		}
		return data;
	}
	public void addMemberToInstituteSpecificToSpecificDepartment(String idDepartemnt,String iDInstitute,Member member) {
		departments.get(searchPosDepartment(idDepartemnt)).addMemberToInstituteSpecific(iDInstitute, member);
	}
	public void addInstituteToSpecificDepartment(String iDDepartment,Institute institute) {
		departments.get(searchPosDepartment(iDDepartment)).addInstitute(institute);
	}
	public Object[][] dataNumbersIntitutesDepartments() {
		Object[][] data=new Object[departments.size()][2];
		for (int i = 0; i < departments.size(); i++) {
			data[i][0]=departments.get(i).getName();
			data[i][1]=departments.get(i).getNumberInstitutes();
		}
		return data;
	}
	public Object[][] getDirectorsNamesToSpecificDeparment(String iDDepartment) {
		return searchDepartment(iDDepartment).getDirectorName();
	}
	public Object[][] getDirectorsNamens(){
		Object[][] data = new Object[getTotalInstitutes()][3];
		for (int i = 0,l=0; i < departments.size(); i++) {
			for (int j = 0; j < getNumberInstitutes(i); j++,l++) {
				for (int k = 0; k < 3; k++) {
						data[l][k] = departments.get(i).getDirectorName()[j][k];
				}
			}
		}
		return data;
	}
	public void addEventToinstitutSpecific(String iDDepartment,String iDInstitute,Event event) {
		Department department=departments.get(searchPosDepartment(iDDepartment));
		departments.remove(department);
		department.managerInstitute.addEventToInstitute(iDInstitute, event);
		departments.add(department);
	}
	public Object[][] dataYearsInstitutes(String iDDepartment){
		return searchDepartment(iDDepartment).getDataFundationInstitutes();
	}
}
