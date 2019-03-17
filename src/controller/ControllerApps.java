package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JOptionPane;

import model.dao.ModelManager;
import model.entity.IdentificationDepartment;
import persistence.JsonFile;
import persistence.XMLFile;
import properties.HandlerLanguage;
import utilities.ReadUtilitites;
import utilities.Utilities;
import views.ConstansGUI;
import views.IOManager;
import views.LabelsGUI;

public class ControllerApps implements ActionListener{

		ModelManager modelManager;
		IOManager ioManager;
		private static final String NAME_FILE_CONFIG="resources/config.init";
		private HandlerLanguage config=null;
		
		public ControllerApps() {
			this.loadConfiguration();
			try {
				JsonFile j=new JsonFile();
				XMLFile x=new XMLFile();
				modelManager=new ModelManager(ReadUtilitites.Departments(ReadUtilitites.toMembers(x.readFile()),j.readFileInstruments(), j.readFileInstitutes()));
			}catch (Exception e) {
					
			}
			ioManager=new IOManager(this);
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
			case ADD_INSTITUTE:
				addInstitute();
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
				getEventsConfirmed(false);
				break;
			case REPORT_PROCESS_EVENTS:
				getEventsProcess(false);
				break;
			case GRAPHS_ESTATE_INSTRUMENT:
				getEstateInstrument();
				break;
			case GRAPHS_NUMBER_INSTITUTE:
				getNumberInstitute();
				break;
			case GRAPHS_FUNDATION:
				getFundationInstitute();
				break;
		//-------------Admin
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
				getEventsConfirmed(true);
				break;
			case REPORT_PROCESS_EVENTS_A:
				getEventsProcess(true);
				break;
			case GRAPHS_ESTATE_INSTRUMENT_A:
				getEstateInstrument();
				break;
			case GRAPHS_NUMBER_INSTITUTE_A:
				getNumberInstitute();
				break;
			case GRAPHS_FUNDATION_A:
				getFundationInstitute();
				break;
			default:
				break;
			}
		}
		
		private void getFundationInstitute() {
			ioManager.showDispersionGraph();
		}
		
		private void getNumberInstitute() {
			ioManager.showBarGraph();
		}
		
		private void getEstateInstrument() {
			ioManager.showBarGraph();
		}
		
		private void getEventsProcess(boolean isAdmin) {
			LabelsGUI[] headers=ConstansGUI.EVENTS_IN_PROCESS;
			ioManager.showReport(headers, Utilities.testTabel(headers.length), this,
			HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_PROCESS_EVENTS.name()), isAdmin);
		}
		
		private void getEventsConfirmed(boolean isAdmin) {
			LabelsGUI[] headers=ConstansGUI.CORFIMED_EVENTS;
			ioManager.showReport(headers, Utilities.testTabel(headers.length), this,
			HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_CONFIRMED_EVENTS.name()), isAdmin);
		}
		
		private void getAllDirector(boolean isAdmin) {
			LabelsGUI[] headers=ConstansGUI.DIRECTORS_BY_DEPARTMENT;
			ioManager.showReport(headers, Utilities.testTabel(headers.length), this,
			HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_DIRECTOR_BY_DEPARMENT.name()), isAdmin);
		}
		
		private void getDirectorByDeparment(boolean isAdmin) {
			LabelsGUI[] headers=ConstansGUI.DIRECTORS_BY_DEPARTMENT;
			ioManager.showReport(headers, Utilities.testTabel(headers.length), this,
			HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_DIRECTOR_BY_DEPARMENT.name()), isAdmin);
		}
		
		private void getReportByCups(boolean isAdmin) {
			int id=-1;
			while (id==-1) {
				id=ioManager.requestNumberCups();
			}
			
			ioManager.showErr(""+id);
			LabelsGUI[] headers=ConstansGUI.INTITUTES_BY_CUP;
			ioManager.showReport(headers, Utilities.testTabel(headers.length), this,
			HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_CUPS.name()), isAdmin);
		}

		private void getInstituteData(boolean isAdmin) {
			LabelsGUI[] headers=ConstansGUI.INSTITUTE_DATA;
			ioManager.showReport(headers, Utilities.testTabel(headers.length), this,
			"DEPARTAMENTO SELECCIONADO", isAdmin);
		}
		
		private void getDepartmentInstitutes(boolean isAdmin) {
			IdentificationDepartment deparment=ioManager.requestDepartment();
			if (deparment!=null) {
				LabelsGUI[] headers=ConstansGUI.INSTITUTES_BY_DEPARTMENT;
				ioManager.showReport(headers, Utilities.testTabel(headers.length), this,
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
			ioManager.addInstitute();
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


		
}
