package views;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ControllerApps;
import model.dao.Department;
import model.entity.IdentificationDepartment;
import properties.HandlerLanguage;
import utilities.DateUtilities;
import utilities.ReadUtilitites;
import utilities.Utilities;

public class IOManager {
	MainWindow mainWindow;
	LogIn logIn;
	AdminWindow adminWindow;
	ReportTable reportTable;
	JGraphisBar jGraphisBar;
	AddInstitute addInstitute;
	AddMember addMember;
	CreateInstrument createInstrument;
	CreateDirector createDirector;
	InstituteDataWindow instituteDataWindow;
	JFileChooser fileChooser;
	Object []newMember=null;
	Object []newInstrument=null;
	Object[] newDirector=new Object[5];
	Object[]newInstitute=null;
	IdentificationDepartment department=null;
	
	public IOManager(ControllerApps controllerApps,Object[][] matrix) {
		fileChooser=new JFileChooser();
		logIn=new LogIn(controllerApps);
		mainWindow=new MainWindow(controllerApps);
		adminWindow=new AdminWindow(controllerApps,ConstansGUI.PRINCIPAL_TABLE_HEADERS,matrix);
		addInstitute=new AddInstitute(controllerApps);
		addMember=new AddMember(controllerApps);
		createInstrument=new CreateInstrument(controllerApps);
		createDirector=new CreateDirector(controllerApps);
		this.changeLanguage();
	}
	
	public void showAddInstitute() {
		addInstitute.showMe();
	}
	
	public String requestId(LabelsGUI typeID) {
		String id="";
		String test;
		String messagge="";
		messagge=HandlerLanguage.languageProperties.getProperty(typeID.name());
		try {
			test=JOptionPane.showInputDialog(messagge);
			if (test==null) {
				test="";
			}
		} catch (NullPointerException e) {
			test="";
		}
		id=test;
		return id;
	}
	
	public IdentificationDepartment requestDepartment( ) {
		String messagge=HandlerLanguage.languageProperties.getProperty(LabelsGUI.SELECT_DEPARTMENT.name());
		String title=HandlerLanguage.languageProperties.getProperty(LabelsGUI.DEPARTMENT.name());
		IdentificationDepartment deparment=(IdentificationDepartment) JOptionPane.showInputDialog(null, messagge,title,JOptionPane.QUESTION_MESSAGE,null, IdentificationDepartment.values(),IdentificationDepartment.values()[0]);
		
		return deparment;
	}
	
	
	public void getDirectorData() {
		newDirector=createDirector.getData();
		createDirector.hideMe();
	}
	
	public Object[] getNewDirector() {
		return newDirector;
	}
	
	public Integer requestNumberCups() {
		String messagge="";
		Integer val=null;
		String test="";
		messagge=HandlerLanguage.languageProperties.getProperty(LabelsGUI.IN_CUPS_SEARCH.name());
		try {
			test=JOptionPane.showInputDialog(messagge);
			if (test==null) {
				val= null;
			}else {
				val=Integer.parseInt(test);
			}
		} catch (Exception e) {
			return requestNumberCups();	
		}
		return val;
	}
	
	public void showBarGraph() {
		JOptionPane.showMessageDialog(null, "GRAFICO DE BARRAS");
	}
	public void showBarGraph(int yMax,int numberIntervalY,ArrayList<String> labelsX,
			String titlePrincipal,String titleAxisY,String titleAxisX,ArrayList<Double> values) {
		
		jGraphisBar=new JGraphisBar(yMax, numberIntervalY, labelsX, titlePrincipal
				, titleAxisY, titleAxisX, values);
	}
	
	public void showDispersionGraph() {
		JOptionPane.showMessageDialog(null, "GRAFICO DE DISPERSIÓN");
	}
	public void showDispersionGraph(boolean b) {
		JOptionPane.showMessageDialog(null, "GRAFICO DE DISPERSIÓN");
	}
	public void showReport(LabelsGUI[]headers, Object[][] matrix,ControllerApps controllerApps,String titlePrincipal, boolean isAdmin) {
		reportTable=new ReportTable(headers, matrix, controllerApps, titlePrincipal, isAdmin);
		reportTable.showMe();
	}
	public void showDataInstitute(LabelsGUI [] headers, Object[][]matrix,
			ControllerApps controllerApps,boolean isAdmin, String date,String director,
			String title) {
		instituteDataWindow=new InstituteDataWindow(headers, matrix, controllerApps,
				isAdmin, date, director, title);
	}
	
	public void hideReport() {
		if (reportTable!=null) {
			reportTable.hideMe();
		}
	}
	public void changeLanguage() {
		mainWindow.changeLanguage();
		logIn.changeLanguage();
		adminWindow.changeLanguage();
		addInstitute.changeLanguage();
		addMember.changeLanguage();
		createInstrument.changeLanguage();
	}
	
	public Object[][] getReportContentTable() {
		Object[][]matrix=null;
		if (reportTable!=null) {
			matrix=reportTable.getContentTable();
		}
		return matrix;
	}
	
	public void addMember() {
		addMember.showMe();
	}
	
	public void showInstituteData(LabelsGUI[] headers,Object[][] matrix,ControllerApps controllerApps,
			boolean isAdmin, String date, String director,String title) {
		instituteDataWindow=new InstituteDataWindow(headers, matrix, controllerApps,
				isAdmin, date, director, title);
}
	public void logInAdmin(String nick) {
		this.showAdminWindow();
		adminWindow.setNickName(nick);
		
	}
	public void showLogIn() {
		logIn.showMe();
		
	}
	private void showAdminWindow() {
		logIn.hideMe();
		mainWindow.hideMe();
		adminWindow.showMe();
	}
	public void invalidUser() {
		this.showErr("USUARIO INCORRECTO");
		logIn.clearWindow();
	}
	
	public String[] getInsertUser() {
		return logIn.getInsertUser();
	}
	
	public void showErr(String e) {
		JOptionPane.showMessageDialog(null, e);
	}
	
	
	public void backToMainWindow() {
		logIn.hideMe();
		adminWindow.hideMe();
		mainWindow.showMe();
		hideReport();
		
	}

	public void addInstitute() {
		newInstitute= addInstitute.getData();
	}
	public void clearAddInstitute() {
		addInstitute.clear();
	}

	public void backToAdminWindow() {
		logIn.hideMe();
		mainWindow.hideMe();
		adminWindow.showMe();
		addInstitute.hideMe();
		hideReport();
	}

	public void showInstrumentWindow() {
		addMember.hideMe();
		createInstrument.showMe();
	}
	public void getDataMember() {
		Object[]member= addMember.getData();
		newMember=member;
	}
	
	public void getDataInstrument() {
		Object[]instrument= createInstrument.getData();
		newInstrument=instrument;
		createInstrument.hideMe();
	}

	public Object[] getNewMember() {
		return newMember;
	}

	public void setNewMember(Object[] newMember) {
		this.newMember = newMember;
	}

	public Object[] getNewInstrument() {
		return newInstrument;
	}

	public void setNewInstrument(Object[] newInstrument) {
		this.newInstrument = newInstrument;
	}

	public IdentificationDepartment getDepartment() {
		return department;
	}

	public void setDepartment(IdentificationDepartment department) {
		this.department = department;
	}

	public Object[] getNewInstitute() {
		return newInstitute;
	}

	public void setNewInstitute(Object[] newInstitute) {
		this.newInstitute = newInstitute;
	}

	public void getDataInstitute() {
		newInstitute=addInstitute.getData();
	}

	public void showDirectorWindow() {
		createDirector.showMe();
		addInstitute.hideMe();
	}
	
	
	public String getIdInstituteWindow() {
		if (instituteDataWindow!=null) {
			return instituteDataWindow.getIdInstitute();
		}else {
			return "";
		}
	}
	
	public String exportFile() {
		addFilters();
		String path="";
		int selection=fileChooser.showOpenDialog(null);
		if (selection==fileChooser.APPROVE_OPTION) {
			String extension=fileChooser.getFileFilter().getDescription();
			fileChooser.setFileSelectionMode(fileChooser.DIRECTORIES_ONLY);
			path= fileChooser.getSelectedFile().getPath()+extension.toLowerCase();
		}
		return path;
	}
	
	private void addFilters() {
		fileChooser.resetChoosableFileFilters();
		FileNameExtensionFilter text=new FileNameExtensionFilter(".TXT", "txt");
		FileNameExtensionFilter bin=new FileNameExtensionFilter(".BIN", "bin");
		FileNameExtensionFilter xml=new FileNameExtensionFilter(".XML", "xml");
		FileNameExtensionFilter json=new FileNameExtensionFilter(".JSON", "json");
		fileChooser.setFileFilter(text);
		fileChooser.setFileFilter(bin);
		fileChooser.setFileFilter(xml);
		fileChooser.setFileFilter(json);
	}
	
	
}
