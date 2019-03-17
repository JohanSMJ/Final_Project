package views;

import javax.swing.JOptionPane;

import controller.ControllerApps;
import model.entity.IdentificationDepartment;
import properties.HandlerLanguage;
import utilities.Utilities;

public class IOManager {
	MainWindow mainWindow;
	LogIn logIn;
	AdminWindow adminWindow;
	AddInstitute addInstitute;
	ReportTable reportTable;
	
	public IOManager(ControllerApps controllerApps) {
		logIn=new LogIn(controllerApps);
		mainWindow=new MainWindow(controllerApps);
		adminWindow=new AdminWindow(controllerApps,ConstansGUI.PRINCIPAL_TABLE_HEADERS,Utilities.testTabel(ConstansGUI.PRINCIPAL_TABLE_HEADERS.length));
		
		this.changeLanguage();
	}
	
	public String requestId(LabelsGUI typeID) {
		String id="";
		String messagge="";
		messagge=HandlerLanguage.languageProperties.getProperty(typeID.name());
		id=JOptionPane.showInputDialog(messagge);
		return id;
	}
	
	public IdentificationDepartment requestDepartment( ) {
		String messagge=HandlerLanguage.languageProperties.getProperty(LabelsGUI.SELECT_DEPARTMENT.name());
		String title=HandlerLanguage.languageProperties.getProperty(LabelsGUI.DEPARTMENT.name());
		
		IdentificationDepartment deparment=(IdentificationDepartment) JOptionPane.showInputDialog(null, messagge,title,JOptionPane.QUESTION_MESSAGE,null, IdentificationDepartment.values(),IdentificationDepartment.values()[0]);
		
		return deparment;
	}
	
	public int requestNumberCups() {
		int id=-1;
		String messagge="";
		messagge=HandlerLanguage.languageProperties.getProperty(LabelsGUI.IN_CUPS_SEARCH.name());
		try {
			id=Integer.parseInt(JOptionPane.showInputDialog(messagge));
		} catch (Exception e) {
			return requestNumberCups();
			
		}
		return id;
	}
	
	public void showBarGraph() {
		JOptionPane.showMessageDialog(null, "GRAFICO DE BARRAS");
	}
	public void showDispersionGraph() {
		JOptionPane.showMessageDialog(null, "GRAFICO DE DISPERSIÓN");
	}
	
	public void showReport(LabelsGUI[]headers, Object[][] matrix,ControllerApps controllerApps,String titlePrincipal, boolean isAdmin) {
		reportTable=new ReportTable(headers, matrix, controllerApps, titlePrincipal, isAdmin);
		reportTable.showMe();
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
		addInstitute.getDate();
		
	}

	public void backToAdminWindow() {
		logIn.hideMe();
		mainWindow.hideMe();
		adminWindow.showMe();
	}
}
