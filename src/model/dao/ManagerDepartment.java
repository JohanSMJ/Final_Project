package model.dao;

import java.util.ArrayList;

import javax.sound.midi.Synthesizer;

import model.entity.IdentificationDepartment;
import model.entity.Member;

public class ManagerDepartment {
	private ArrayList<Department> departments;

	public ManagerDepartment(ArrayList<Department> departments) {
		this.departments = departments;
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
		for (int i = 0, l = 0; i < departments.size(); i++) {
			for (int j = 0; j < getNumberInstitutes(i); j++, l++) {
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

	public void removeInstitute(String iDDepartment, String iDInstitute) {
		departments.get(searchPosDepartment(iDDepartment)).removeInstitute(iDInstitute);
	}

	public Object[][] getDataDepartment(int numberDepartment) {
		return departments.get(numberDepartment).getDataDepartment();
	}

	public Department searchDepartment(String iD) {
		Department department = null;
		int i = 0;
		while (i != -1 && i < departments.size()) {
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
		while (i != -1 && i < departments.size()) {
			if (departments.get(i).getID().equals(iD)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void removeMember(String iDDepartment, String iDInstitute, String iDMember) {
		departments.get(searchPosDepartment(iDDepartment)).removeMember(iDInstitute, iDMember);
	}

	public boolean validateIDInstitute(String iDInstitute) {
		for (int i = 0; i < departments.size(); i++) {
			if (!departments.get(i).validateIDInstitute(iDInstitute))
				return false;
		}
		return true;
	}

	public Object[] numberGenders() {
		Object[] obj = new Object[3];
		int male = 0;
		int female = 0;
		int others = 0;
		for (int i = 0; i < departments.size(); i++) {
			male += Integer.parseInt(departments.get(i).numberGenders()[0].toString());
			female += Integer.parseInt(departments.get(i).numberGenders()[1].toString());
			others += Integer.parseInt(departments.get(i).numberGenders()[2].toString());
		}
		obj[0] = male;
		obj[1] = female;
		obj[2] = others;
		return obj;
	}

	public boolean validateIDMember(String iDMember) {
		for (int i = 0; i < departments.size(); i++) {
			if (!departments.get(i).validateIDMember(iDMember))
				return false;
		}
		return true;
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

	public Object[] getStateInstrumentsSpcificInstititeSpecificDepartment(String iDDepartment) {
		return searchDepartment(iDDepartment).getStateInstrumetnSpecificInstitute();
	}

	public void addCupToInstitute(String iDDepartment, String iDInstitute) {
		Department department = departments.get(searchPosDepartment(iDDepartment));
		departments.remove(department);
		department.addCupToInstitute(iDInstitute);
		departments.add(department);
	}

	public Object[][] getDataDepartmentsCups(int numberRank) {
		Object[][] data = new Object[getTotalInstitutes()][5];
		for (int i = 0, l = 0; i < departments.size(); i++) {
			for (int j = 0; j < getNumberInstitutes(i); j++, l++) {
				for (int k = 0; k < 5; k++) {
					data[l][k] = departments.get(i).getDataDepartmentCups(numberRank)[j][k];
				}
			}
		}
		return data;
	}

	public Institute searchInstituteTotal(String iDInstitute) {
		Institute institute = null;
		for (int i = 0; i < departments.size(); i++) {
			institute = departments.get(i).searchInstitute(iDInstitute);
			if (institute == null) {
			} else {
				return institute;
			}
		}
		return institute;
	}

	public int searchInstituteTotalPosDepartment(String iDInstitute) {
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).searchInstitute(iDInstitute) != null)
				return i;
		}
		return -1;
	}

	public int getnumberTotalInstitutes() {
		int numberTotal = 0;
		for (int i = 0; i < departments.size(); i++) {
			numberTotal += departments.get(i).getNumberInstitute();
		}
		return numberTotal;
	}

	public void addMemberToInstituteSpecificToSpecificDepartment(String idDepartemnt, String iDInstitute,
			Member member) {
		departments.get(searchPosDepartment(idDepartemnt)).addMemberToInstituteSpecific(iDInstitute, member);
	}

	public void addInstituteToSpecificDepartment(String iDDepartment, Institute institute) {
		departments.get(searchPosDepartment(iDDepartment)).addInstitute(institute);
	}

	public Object[][] dataNumbersIntitutesDepartments() {
		Object[][] data = new Object[departments.size()][2];
		for (int i = 0; i < departments.size(); i++) {
			data[i][0] = departments.get(i).getName();
			data[i][1] = departments.get(i).getNumberInstitutes();
		}
		return data;
	}

	public Object[][] getDirectorsNamesToSpecificDeparment(String iDDepartment) {
		return searchDepartment(iDDepartment).getDirectorName();
	}

	public Object[][] getDirectorsNamens() {
		Object[][] data = new Object[getTotalInstitutes()][3];
		for (int i = 0, l = 0; i < departments.size(); i++) {
			for (int j = 0; j < getNumberInstitutes(i); j++, l++) {
				for (int k = 0; k < 3; k++) {
					data[l][k] = departments.get(i).getDirectorName()[j][k];
				}
			}
		}
		return data;
	}


	public Object[][] dataYearsInstitutes(String iDDepartment) {
		return searchDepartment(iDDepartment).getDataFundationInstitutes();
	}

	public Institute getDataObjctInstiute(String iDDepartment, String iDInstitute) {
		return searchDepartment(iDDepartment).getDataObjctInstiute(iDInstitute);
	}

	public Object[][] twoMostCups() {
		Object[][] obj = new Object[2][2];
		obj[0][1] = 0;
		obj[0][0] = "";
		obj[1][1] = 0;
		obj[1][0] = "";
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).numberTotalCups() >=Integer.parseInt(obj[0][1].toString())) {
				if(Integer.parseInt(obj[0][1].toString())>=Integer.parseInt(obj[1][1].toString())) {
					obj[1][1]=obj[0][1];
					obj[1][0]=obj[0][0];
				}
				obj[0][0]=departments.get(i).getName();
				obj[0][1] = departments.get(i).numberTotalCups();
			} else {
				if (departments.get(i).numberTotalCups() >= Integer.parseInt(obj[1][1].toString()))
					obj[1][0]=departments.get(i).getName();
					obj[1][1] = departments.get(i).numberTotalCups();
			}
		}
		return obj;
	}
	public Object[][] numberInstitutesToDepartments(){
		Object[][] obj=new Object[departments.size()][2];
		for (int i = 0; i < obj.length; i++) {
			obj[i][0]=departments.get(i).getName();
			obj[i][1]=departments.get(i).getNumberInstitute();
		}
		return obj;
	}
}
