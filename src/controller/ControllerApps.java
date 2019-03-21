package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.dao.Institute;
import model.dao.ModelManager;
import model.entity.IdentificationDepartment;
import model.entity.Member;
import persistence.IFiles;
import persistence.ManagerFiles;
import persistence.WebConsumptionFiles;
import persistence.XMLFile;
import properties.HandlerLanguage;
import utilities.DateUtilities;
import utilities.ReadUtilitites;
import utilities.Utilities;
import views.ConstansGUI;
import views.IOManager;
import views.LabelsGUI;

public class ControllerApps implements ActionListener{

		ModelManager modelManager;
		IOManager ioManager;
		IdentificationDepartment selectDep=null;
		String selectID="";
		private static final String NAME_FILE_CONFIG="resources/config.init";
		
		private HandlerLanguage config=null;
		
		public ControllerApps() {
			this.loadConfiguration();
			try {
				WebConsumptionFiles j=new WebConsumptionFiles();
				XMLFile x=new XMLFile();
				modelManager=new ModelManager(ReadUtilitites.Departments(ReadUtilitites.toMembers(x.readFile("resources/Personas.xml")),j.readFileInstruments(), j.readFileInstitutes()));
			}catch (Exception e) {
					
			}
			ioManager=new IOManager(this,modelManager.getDataTotal());
		}
		
		
//-------------------------------------------------EVENTS--------------------------------------------------
		@Override
		public void actionPerformed(ActionEvent e) {

			switch (Commands.valueOf(e.getActionCommand())) {
			
			case SHOW_LOG_IN:
				ioManager.showLogIn();
				break;
			case BACK_TO_ADMIN_WINDOW:
				ioManager.backToAdminWindow();
				break;
			case BACK_TO_MAIN_WINDOW:
				ioManager.backToMainWindow();
				break;
			case EXIT:
				System.exit(0);
				break;
			case LOG_IN_BUTTON:
				validateUser();
				break;
			case REPORT_ALL_INSTITUTES:
				getAllInstitutesReport(false);
				break;
			case REPORT_DEPARMENT_INSTITUTES:
				getDepartmentInstitutes(false);
				break;
			case REPORT_INSTITUTE:
				getInstituteData(false);
				break;
			case REPORT_CUPS:
				getReportByCups(false);
				break;
			case REPORT_DIRECTOR_BY_DEPARMENT:
				getDirectorByDeparment(false);
				break;
			case REPORT_ALL_DIRECTORS:
				getAllDirector(false);
				break;
			case REPORT_CONFIRMED_EVENTS:
				break;
			case GRAPHS_ESTATE_INSTRUMENT:
				getEstateInstrument();
				break;
			case GRAPHS_GENDER:
				getGraphGender();
				break;
			case REPORT_GENDER:
				getReportGender(false);
				break;
			case EXPORT_REPORT:
				exportReport();
				break;
			case REPORT_NUMBER_SCHOOLS:
				getReportNumberSchools(false);
				break;
				//-------------Admin---------------------
			case REPORT_NUMBER_SCHOOLS_A:
				getReportNumberSchools(true);
				break;
			case REPORT_GENDER_A:
				getReportGender(true);
				break;
			case ADD_INSTITUTE:
				addInstitute();
				break;
			case REPORT_ALL_INSTITUTES_A:
				getAllInstitutesReport(true);
				break;
			case REPORT_DEPARMENT_INSTITUTES_A:
				getDepartmentInstitutes(true);
				break;
			case REPORT_INSTITUTE_A:
				getInstituteData(true);
				break;
			case REPORT_CUPS_A:
				getReportByCups(true);
				break;
			case REPORT_DIRECTOR_BY_DEPARMENT_A:
				getDirectorByDeparment(true);
				break;
			case REPORT_ALL_DIRECTORS_A:
				getAllDirector(true);
				break;
			case REPORT_CONFIRMED_EVENTS_A:
				break;
			case REPORT_PROCESS_EVENTS_A:
				break;
			case GRAPHS_ESTATE_INSTRUMENT_A:
				getEstateInstrument();
				break;
			case GRAPHS_NUMBER_INSTITUTE_A:
				getGraphGender();
				break;
			case SHOW_ADD_INSTITUTE_WINDOW:
				showAddWindow();
				break;
			case SHOW_ADD_MEMBER_WINDOW:
				showAddMemberWindow();
				break;
			case GRAPHS_FUNDATION_A:
				getFundationInstitute();
				break;
			case SHOW_INSTRUMENT_WINDOW:
				showInstrumentWindow();
				break;
			case FINISH_MEMBER:
				finishAddMember();
				break;
			case FINISH_DIRECTOR:
				finishInstitute();
				break;
			case ADD_CUPS:
				addCup();
				break;
			
			//--------------LANGUAGE-----------------
			case CHANGE_TO_ENGLISH:
				try {
					changeToEnglish();
				} catch (IOException e1) {
					
				}
				break;
			case CHANGE_TO_SPANISH:
				try {
					changeToSpanish();
				} catch (IOException e1) {

				}
				break;
			default:
				break;
			}
		}
		
		private void getReportGender(boolean isAdmin) {
			Object[][] matrix=Utilities.changeVectorToMatrix(modelManager.numberGenders());
			LabelsGUI[] headers=ConstansGUI.GENDER_TABLE;
			String titlePrincipal=HandlerLanguage.languageProperties.getProperty(
					LabelsGUI.REPORT_GENDER.name());
			ioManager.showReport(headers, matrix, this, titlePrincipal, isAdmin);
		}


		private void getReportNumberSchools(boolean isAdmin) {
			Object[][] matrix=modelManager.dataNumbersIntitutesDepartments();
			LabelsGUI[] headers=ConstansGUI.NUMBER_SCHOOLS;
			String titlePrincipal=HandlerLanguage.languageProperties.getProperty(
					LabelsGUI.REPORT_NUMBER_SCHOOLS.name());
			ioManager.showReport(headers, matrix, this, titlePrincipal, isAdmin);
		}


		private void exportReport() {
			String path=ioManager.exportFile();
			if (path.equals("")) {
			}else {
				ioManager.showErr(path);
				String type=ReadUtilitites.splitPoint(path);
				Object[][]matrix=ioManager.getReportContentTable();
				ManagerFiles managerFiles=new ManagerFiles();
				IFiles iFiles=managerFiles.selctType(type);
				iFiles.writeFile(path, matrix);
			}
			
		}
		private void addCup() {
			String id= ioManager.getIdInstituteWindow();
			if (id.equals("")) {
			}else {
				modelManager.addCupToInstitute(selectDep.getiD(), id);
				ioManager.showErr(HandlerLanguage.languageProperties.getProperty(
						LabelsGUI.ADD_CUP_TEXT.name()));
			}
		}

		private void deleteInstitute() {
			IdentificationDepartment d=ioManager.requestDepartment();
			if(d!=null) {
				String id=ioManager.requestId(LabelsGUI.TYPE_ID_INSTITUTE);
				if (id.equals("")) {
				}else {
					//enviar al método
				}
			}
		}
		private void deleteMember() {
			IdentificationDepartment d=ioManager.requestDepartment();
			if(d!=null) {
				String idIns=ioManager.requestId(LabelsGUI.TYPE_ID_INSTITUTE);
				if (idIns.equals("")) {
				}else {
					String idMem=ioManager.requestId(LabelsGUI.TYPE_ID_MEMBER);
					if (idMem.equals("")) {
					} else {
						//enviar al método
					}
				}
			}
		}

		private void finishInstitute() {
			ioManager.getDirectorData();
			Object[]institute= ioManager.getNewInstitute();
			String iD=""+Utilities.iDInstituteNew(modelManager.getNumberTotalInstitutes());
			Object[]director= ioManager.getNewDirector();
			Institute i=Utilities.createInstitute(institute, iD, director);
			IdentificationDepartment dep=ioManager.getDepartment();
			if (director!=null) {
				if (i!=null) {
				modelManager.addInstituteToSpecificDepartment(dep.getiD(), i);
				}
			}else {
				ioManager.showErr(HandlerLanguage.languageProperties.getProperty(
						LabelsGUI.CANNOT_CREATE_INSTITUTE.name()));
			}
			
		}
		
		
		private void finishAddMember() {
			ioManager.getDataInstrument();
			Object[]member=ioManager.getNewMember();
			Object[]instrument=ioManager.getNewInstrument();
			if (instrument!=null) {
				boolean b=modelManager.validateIDIntitute(selectID);
				if (!b) {
					Member m=Utilities.createMember(member, instrument);
					modelManager.addMemberToSpecificInstituteToSpecifcDepartment(this.selectDep.getiD(), this.selectID, m);
					
				}else {
					ioManager.showErr("YA ESTA");
				}
				
			}
		}


		private void showInstrumentWindow() {
			ioManager.getDataMember();
			Object[]member=ioManager.getNewMember();
			if (member!=null) {
				ioManager.showInstrumentWindow();
			}
		}


		private void showAddMemberWindow() {
			this.selectDep=ioManager.requestDepartment();
			if (selectDep!=null) {
				this.selectID=ioManager.requestId(LabelsGUI.TYPE_ID_INSTITUTE);
				if (selectID.equals("")) {
				}else {					
					ioManager.addMember();
				}
			}
		}


		private void showAddWindow() {
			IdentificationDepartment deparment=ioManager.requestDepartment();
			if (deparment!=null) {
				ioManager.setDepartment(deparment);
				ioManager.showAddInstitute();
			}
		}


		private void getFundationInstitute() {
			ioManager.showDispersionGraph();
		}
		
		private void getGraphGender() {
			Object[]vector=modelManager.numberGenders();
			int yMax=Utilities.getTotalVector(vector);
			if(yMax!=-1) {
				int numberIntervalY=10;
				ArrayList<String> labelsX=ConstansGUI.getGenderLabels();
				String titlePrincipal=HandlerLanguage.languageProperties.getProperty(
						LabelsGUI.GRAPH_GENDER.name());
				String titleAxisY=HandlerLanguage.languageProperties.getProperty(
						LabelsGUI.NUMBER_GENDER.name());
				String titleAxisX=HandlerLanguage.languageProperties.getProperty(
						LabelsGUI.GENDER_MEMBER.name());
				ArrayList<Double> values=Utilities.getGenderValues(vector);
				ioManager.showBarGraph(yMax, numberIntervalY, labelsX, titlePrincipal,
					titleAxisY, titleAxisX, values);
			}
		}
		
		private void getEstateInstrument() {
			IdentificationDepartment idDeparment=ioManager.requestDepartment();
			if (idDeparment!=null) {
				Object[]states=modelManager.getStateInstrumentsSpcificInstititeSpecificDepartment(
						idDeparment.getiD());
				//buenos, malos
				int yMax=Utilities.getTotalVector(states);
				int numberIntervalY=10;
				ArrayList<String> labelsX=ConstansGUI.getStateLabels();
				String titlePrincipal=HandlerLanguage.languageProperties.getProperty(LabelsGUI.GRAPHS_ESTATE_INSTRUMENT.name());
				String titleAxisY=HandlerLanguage.languageProperties.getProperty(LabelsGUI.NUMBER_STATE.name());
				String titleAxisX=HandlerLanguage.languageProperties.getProperty(LabelsGUI.STATE_INSTRUMENT_TEXT.name());
				ArrayList<Double>values=Utilities.getValuesState(states);
				System.out.println("----------------------------");
				System.out.println("yMax="+yMax);
				System.out.println("labels="+labelsX.size());
				System.out.println("values="+values.toString());
				
				System.out.println("----------------------------");
				ioManager.showBarGraph(yMax, numberIntervalY, labelsX, titlePrincipal,
						titleAxisY, titleAxisX, values);
			}
//			modelManager.getStateInstrumentsSpcificInstititeSpecificDepartment(iDDepartment, iDInstitute)
//			ioManager.showBarGraph(arrayH, maxV, intervalV, corespondes, nameY, nameH, title);
		}
		
		
		private void getAllDirector(boolean isAdmin) {
			LabelsGUI[] headers=ConstansGUI.DIRECTORS_BY_DEPARTMENT;
			Object[][]matrix=modelManager.getDirectorsNamens();
			ioManager.showReport(headers,matrix , this,
			HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_DIRECTOR_BY_DEPARMENT.name()), isAdmin);
		}
		
		private void getDirectorByDeparment(boolean isAdmin) {
			IdentificationDepartment idDeparment=ioManager.requestDepartment();
			if (idDeparment!=null) {
				LabelsGUI[] headers=ConstansGUI.DIRECTORS_BY_DEPARTMENT;
				Object[][]matrix=modelManager.getDirectorsNamesToSpecificDeparment(idDeparment.getiD());
				ioManager.showReport(headers, matrix, this,
				HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_DIRECTOR_BY_DEPARMENT.name())+": "+idDeparment.getName().toUpperCase(), isAdmin);
			}
		}
		private void getReportByCups(boolean isAdmin) {
			
			Integer id=ioManager.requestNumberCups();
			if(id!=null) {
				LabelsGUI[] headers=ConstansGUI.INTITUTES_BY_CUP;
				Object[][] matrix=this.dataMostCups(id);
				ioManager.showReport(headers, matrix, this,
				HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_CUPS.name()), isAdmin);
			}
		}

		private void getInstituteData(boolean isAdmin) {
			IdentificationDepartment idDeparment=ioManager.requestDepartment();
			if (idDeparment!=null) {
				this.selectDep=idDeparment;
				String idInstitute=ioManager.requestId(LabelsGUI.TYPE_ID_INSTITUTE);
				
				if (idInstitute.equals("")) {
					
				}else {
					LabelsGUI [] headers=ConstansGUI.MEMBER_OF_INSTITUTE;
					Institute i=modelManager.getDataObjctInstiute(idDeparment.getiD(), idInstitute);
					if (i!=null) {
						Object[][] matrix=modelManager.getDataMembersSpecificInstituteSpecificDeprtment(idDeparment.getiD(), idInstitute);
						String date=DateUtilities.calendarToString(i.getDateFundation());
						String id=i.getID();
						String title=i.getName();
						
						ioManager.showDataInstitute(headers, matrix, this, isAdmin
								, date, id, title);
					}else {
						ioManager.showErr(HandlerLanguage.languageProperties.getProperty(
								LabelsGUI.NOT_FOUND_INSTITUTE.name()));
					}
					
					
					
				}
			}
		}
		
		
		private void getDepartmentInstitutes(boolean isAdmin) {
			IdentificationDepartment deparment=ioManager.requestDepartment();
			if (deparment!=null) {
				LabelsGUI[] headers=ConstansGUI.INSTITUTES_BY_DEPARTMENT;
				Object[][]matrix=modelManager.getDataDepartment(deparment.getiD());
				ioManager.showReport(headers, matrix, this,
				deparment.getName().toUpperCase(), isAdmin);
			}
		}
		
		
		private void getAllInstitutesReport(boolean isAdmin) {
			LabelsGUI[] headers=ConstansGUI.PRINCIPAL_TABLE_HEADERS;
			Object[][] matrix=modelManager.getDataTotal();
			ioManager.showReport(headers, matrix, this,
			HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_ALL_INSTITUTES.name()), isAdmin);
		}


		private void addInstitute() {
			ioManager.getDataInstitute();
			Object[] newInstitute=ioManager.getNewInstitute();
			if(newInstitute!=null) {
				ioManager.showDirectorWindow();
			}else {
				ioManager.clearAddInstitute();
				ioManager.showErr(HandlerLanguage.languageProperties.getProperty(
						LabelsGUI.INVALID_INSTITUTE.name()));
			}
		}

		private void addMember() {
		
		}

		private void validateUser() {
			String[] user=ioManager.getInsertUser();
			if (user[0].equals("admin")&&user[1].equals("1234")) {
				ioManager.logInAdmin(user[0]);
			}else {
				ioManager.invalidUser();
			}
		}


		//-------------------------------------------------LANGUAGE--------------------------------------------------
		public void manageChangeLanguageUS(){
			try {
				changeToEnglish();
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
			manageChangeLanguage();
			
		}
		
		public void manageChangeLanguageES(){
			try {
				changeToSpanish();
			} catch (IOException e1) {
				ioManager.showErr(e1.getMessage());
			}	
			manageChangeLanguage();
			
		}
		
		
		private void manageChangeLanguage(){
			changeLanguage();		
		}
		
		public void loadConfiguration(){
			if(config == null){
				config = new HandlerLanguage(NAME_FILE_CONFIG);
			}
			try{
				config.loadLanguage();
			}catch(Throwable e){
				ioManager.showErr("file not found : NAME_FILE_CONFIG");
			}
		}
		
		public void loadLanguage() throws IOException{
			try {
				config.loadLanguage();
			} catch (Exception e) {			
			}
			
		}
		
		public void saveConfig() throws IOException{
			try {
				new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
			} catch (Exception e) {
			}
		}
		
		public void changeToEnglish() throws IOException{
			HandlerLanguage.language = "language/languageUS.properties";
			saveConfig();
			loadLanguage();	
			changeLanguage();
		}

		public void changeToSpanish() throws IOException{
			HandlerLanguage.language = "language/languageES.properties";
			saveConfig();
			loadLanguage();
			changeLanguage();
		}
		
		public void changeLanguage() {
			ioManager.changeLanguage();
		}

		public Object[][] dataMostCups(int number){
			ArrayList<Object[]> temp=new ArrayList<>();
			Object[][] data1=modelManager.getDataTotal();
			for (int i = 0; i < modelManager.getNumberTotalInstitutes(); i++) {
				if(Integer.parseInt(data1[i][3].toString())>=number) {
					temp.add(data1[i]);
				}
			}
			Object[][] data=new Object[temp.size()][data1[1].length];
			for (int i = 0; i < temp.size(); i++) {
				data[i]=temp.get(i);
			}
			return data;
		}
		
}
