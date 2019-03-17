package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import controller.Commands;
import controller.ControllerApps;
import properties.HandlerLanguage;
import utilities.Utilities;

public class AdminWindow extends JFrame{
	JPanel panelMenu,panelCenter;
	JLabel imageMenu,labelGraphs,labelReport;
	JStaticTable staticTable;
	JButton buttonBack;
	JToolBar toolBar;
	JMenu menuReports,menuEvents;
	JMenuBar menuBar,menuBarUser;
	JMenuItem itemExit,itemBack,addInstitute,addMember,itemSearch,deleteInstitute,deleteMember,
	itemReportAllInstitutes,itemReportInstitutesDepartment,itemReportInstitute, itemGraphEstateInstrument,
	itemReportCups,itemGraphNumberInstitute,itemReportDirectorDepartment,itemReportAllDirector,itemGraphFundation,
	itemReportConfirmedEvents,itemsReportProcessEvents,itemSearchEvent,itemAddEvent;
	JMenu menuUser,instituteMenu,menuAdd,menuDelete;
	GridSystem gridMenu,gridCenter;
	
	
	public AdminWindow(ControllerApps controllerApps,LabelsGUI[]headers, Object[][]matrix) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setUIManager();
		this.inItComponents(headers,matrix);
		this.setCommands(controllerApps);
		this.changeLanguage();
	}
	
	
	private void setCommands(ControllerApps controllerApps) {
		itemBack.addActionListener(controllerApps);
		itemBack.setActionCommand(Commands.BACK_TO_MAIN_WINDOW.name());
		itemExit.addActionListener(controllerApps);
		itemExit.setActionCommand(Commands.EXIT.name());
		//-----------reports-------------
		itemReportAllInstitutes.setActionCommand(Commands.REPORT_ALL_INSTITUTES_A.name());
		itemReportAllInstitutes.addActionListener(controllerApps);
		itemReportInstitutesDepartment.setActionCommand(Commands.REPORT_DEPARMENT_INSTITUTES_A.name());
		itemReportInstitutesDepartment.addActionListener(controllerApps);
		itemReportInstitute.setActionCommand(Commands.REPORT_INSTITUTE_A.name());
		itemReportInstitute.addActionListener(controllerApps);
		itemReportCups.setActionCommand(Commands.REPORT_CUPS_A.name());
		itemReportCups.addActionListener(controllerApps);
		itemReportDirectorDepartment.setActionCommand(Commands.REPORT_DIRECTOR_BY_DEPARMENT_A.name());
		itemReportDirectorDepartment.addActionListener(controllerApps);
		itemReportAllDirector.setActionCommand(Commands.REPORT_ALL_DIRECTORS_A.name());
		itemReportAllDirector.addActionListener(controllerApps);
		itemReportConfirmedEvents.setActionCommand(Commands.REPORT_CONFIRMED_EVENTS_A.name());
		itemReportConfirmedEvents.addActionListener(controllerApps);
		itemsReportProcessEvents.setActionCommand(Commands.REPORT_PROCESS_EVENTS_A.name());
		itemsReportProcessEvents.addActionListener(controllerApps);
		itemGraphEstateInstrument.setActionCommand(Commands.GRAPHS_ESTATE_INSTRUMENT_A.name());
		itemGraphEstateInstrument.addActionListener(controllerApps);
		itemGraphNumberInstitute.setActionCommand(Commands.GRAPHS_NUMBER_INSTITUTE_A.name());
		itemGraphNumberInstitute.addActionListener(controllerApps);
		itemGraphFundation.setActionCommand(Commands.GRAPHS_FUNDATION_A.name());
		itemGraphFundation.addActionListener(controllerApps);
		
	}
	private void setUIManager() {
		UIManager.put("Label.font", ConstansGUI.FONT_TEXTFIELDS);
		UIManager.put("Label.foreground", Color.WHITE);
		UIManager.put("Label.font", ConstansGUI.FONT_TEXTFIELDS);
		UIManager.put("Label.foreground", Color.WHITE);
		UIManager.put("MenuBar.background", ConstansGUI.COLOR_TOOLBAR);
		UIManager.put("MenuBar.opaque", false);
		UIManager.put("Menu.background", ConstansGUI.COLOR_TOOLBAR);
		UIManager.put("Menu.font", ConstansGUI.FONT_MENUS);
		UIManager.put("Menu.foreground", ConstansGUI.FOREGROUND_MENUS);
		UIManager.put("Menu.opaque", false);
		UIManager.put("MenuItem.background", ConstansGUI.COLOR_TOOLBAR);
		UIManager.put("MenuItem.foreground", ConstansGUI.FOREGROUND_MENU_ITEMS);
		UIManager.put("MenuItem.font", ConstansGUI.FONT_MENU_ITEMS);
	}
	private void inItComponents(LabelsGUI[]headers, Object[][]matrix) {
		panelMenu=new JPanel(new GridBagLayout());
		panelMenu.setBackground(ConstansGUI.COLOR_TOOLBAR);
		gridMenu=new GridSystem(panelMenu);
		
		menuBarUser=new JMenuBar();
		menuBarUser.setBorderPainted(false);
		
		menuUser=new JMenu();
		menuUser.setIcon(Utilities.resizeImage(20, 20, "imgs/white_user.png"));
		menuUser.setBorderPainted(false);
		itemBack=new JMenuItem();
		itemBack.setBorderPainted(false);
		menuUser.add(itemBack);
		itemExit=new JMenuItem();
		itemExit.setBorderPainted(false);
		menuUser.add(itemExit);
		
		menuBarUser.add(menuUser);
		panelMenu.add(menuBarUser,gridMenu.insertComponent(1, 10, 1, 1));
		

		imageMenu=new JLabel();
		imageMenu.setIcon(Utilities.resizeImage(110, 100, "imgs/menu_principal2.png"));
		panelMenu.add(imageMenu, gridMenu.insertComponent(1, 1, 1, 1));
		
		this.inItMenuAdmin();
		
		this.add(panelMenu,BorderLayout.NORTH);
		
		panelCenter=new JPanel(new GridBagLayout());
		panelCenter.setBackground(ConstansGUI.PANEL_CENTER);
		gridCenter=new GridSystem(panelCenter);
		
		gridCenter.addExternalBorder(50, 0, 50, 0);
		staticTable=new JStaticTable(headers, matrix);
		panelCenter.add(staticTable,gridCenter.insertComponent(1, 1, 10, 10));
		
		
		this.add(panelCenter, BorderLayout.CENTER);
		
	}

	
	private void inItMenuAdmin() {
		menuBar=new JMenuBar();
		menuBar.setBorderPainted(false);
		
		menuReports=new JMenu();
		menuReports.setBorderPainted(false);
		
		labelReport=new JLabel();
		labelReport.setFont(ConstansGUI.FONT_MENUS);
		labelReport.setForeground(ConstansGUI.COLOR_TOOLBAR);
		menuReports.add(labelReport);
		
		itemReportAllInstitutes=new JMenuItem();
		menuReports.add(itemReportAllInstitutes);
		
		itemReportInstitutesDepartment= new JMenuItem();
		menuReports.add(itemReportInstitutesDepartment);
		
		
		itemReportInstitute=new JMenuItem();
		menuReports.add(itemReportInstitute);
		
		itemReportCups=new JMenuItem();
		menuReports.add(itemReportCups);
		
		itemReportDirectorDepartment=new JMenuItem();
		menuReports.add(itemReportDirectorDepartment);
		
		itemReportAllDirector=new JMenuItem();
		menuReports.add(itemReportAllDirector);
		
		itemReportConfirmedEvents=new JMenuItem();
		menuReports.add(itemReportConfirmedEvents);
		
		itemsReportProcessEvents=new JMenuItem();
		menuReports.add(itemsReportProcessEvents);
		
		labelGraphs=new JLabel();
		labelGraphs.setFont(ConstansGUI.FONT_MENUS);
		labelGraphs.setForeground(ConstansGUI.COLOR_TOOLBAR);
		
		menuReports.add(labelGraphs);
		menuReports.addSeparator();
		
		itemGraphEstateInstrument=new JMenuItem();
		menuReports.add(itemGraphEstateInstrument);
		
		itemGraphNumberInstitute=new JMenuItem();
		menuReports.add(itemGraphNumberInstitute);
		
		itemGraphFundation=new JMenuItem();
		menuReports.add(itemGraphFundation);
		
		menuBar.add(menuReports);
		
		instituteMenu=new JMenu();
		instituteMenu.setBorderPainted(false);
		
		menuAdd=new JMenu();
		menuAdd.setOpaque(true);
		menuAdd.setBorderPainted(false);
		
		addInstitute=new JMenuItem();
		addInstitute.setBorderPainted(false);
		menuAdd.add(addInstitute);
		addMember=new JMenuItem();
		addMember.setBorderPainted(false);
		menuAdd.add(addMember);
		
		instituteMenu.add(menuAdd);
		
		itemSearch=new JMenuItem();
		itemSearch.setBorderPainted(false);
		instituteMenu.add(itemSearch);
		
		menuDelete=new JMenu();
		menuDelete.setOpaque(true);
		menuDelete.setBorderPainted(false);
		
		instituteMenu.addSeparator();
		
		deleteInstitute=new JMenuItem();
		deleteInstitute.setBorderPainted(false);
		menuDelete.add(deleteInstitute);
		deleteMember=new JMenuItem();
		deleteMember.setBorderPainted(false);
		menuDelete.add(deleteMember);
		instituteMenu.add(menuDelete);
		menuBar.add(instituteMenu);
		
		//buscar evento
		menuEvents=new JMenu();
		
		itemAddEvent=new JMenuItem();
		menuEvents.add(itemAddEvent);
		
		itemSearchEvent=new JMenuItem();
		menuEvents.add(itemSearchEvent);
		
		menuBar.add(menuEvents);
		panelMenu.add(menuBar,gridMenu.insertComponent(1, 2, 9, 1));
	}
	public void setNickName(String nick) {
		menuUser.setText(nick);
	}
	public void showMe() {
		this.setVisible(true);
	}
	public void hideMe() {
		this.setVisible(false);
	}
	
	
	public void changeLanguage() {
		instituteMenu.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.INSTITUTE_MENU.name()));
		menuAdd.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.ADD_MENU.name()));
		itemExit.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.EXIT.name()));
		itemBack.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.BACK_TO_PRINCIPAL.name()));
		addInstitute.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.INSTITUTE_ITEM.name()));
		addMember.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.MEMBER_ITEM.name()));
		itemSearch.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.SEARCH_ITEM.name()));
		menuDelete.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.DELETE_MENU.name()));
		deleteInstitute.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.INSTITUTE_ITEM.name()));
		deleteMember.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.MEMBER_ITEM.name()));
		//_____________report--------------
		menuReports.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.MENU_REPORTS.name()));
		labelReport.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.TABLES.name()));
		itemReportAllInstitutes.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_ALL_INSTITUTES.name()));
		itemReportInstitutesDepartment.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_DEPARMENT_INSTITUTES.name()));
		itemReportInstitute.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_INSTITUTE.name()));
		itemReportCups.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_CUPS.name()));
		itemReportDirectorDepartment.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_DIRECTOR_BY_DEPARMENT.name()));
		itemReportAllDirector.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_ALL_DIRECTORS.name()));
		itemReportConfirmedEvents.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_CONFIRMED_EVENTS.name()));
		itemsReportProcessEvents.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.REPORT_PROCESS_EVENTS.name()));
		labelGraphs.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.GRAPHS.name()));
		itemGraphEstateInstrument.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.GRAPHS_ESTATE_INSTRUMENT.name()));
		itemGraphNumberInstitute.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.GRAPHS_NUMBER_INSTITUTE.name()));
		itemGraphFundation.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.GRAPHS_FUNDATION.name()));
		//---------events-------------
		menuEvents.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.MENU_EVENTS.name()));
		itemAddEvent.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.ADD_EVENTS.name()));
		itemSearchEvent.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.SEARCH_EVENT.name()));
	}
}
