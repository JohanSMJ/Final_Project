package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.Commands;
import controller.ControllerApps;
import properties.HandlerLanguage;
import utilities.Utilities;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	JLabel imageMenu,bannerCenter,labelReport,labelGraphs;
	JMenuBar menuBar;
	JMenuItem logIn,itemSpanish,itemEnglish,itemExit,itemReportAllInstitutes,itemReportInstitutesDepartment,
	itemReportInstitute, itemGraphEstateInstrument,itemReportCups,itemGraphNumberInstitute,itemReportDirectorDepartment,
	itemReportAllDirector,itemGraphFundation,itemReportConfirmedEvents,itemsReportProcessEvents;

	JPanel panelMenu, panelCenter;
	JToolBar toolBar;
	JScrollPane scrollPane;
	JButton logInButton,buttonTotal, buttonAdmin;
	JMenu menuReports, menuLogIn, menuLanguage;
	GridSystem gridMenu,gridCenter;
	
	
	
	public MainWindow(ControllerApps controllerApps) {
	this.inItWindow(controllerApps);
	}
	private void inItWindow(ControllerApps controllerApps) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("PROYECTO");
		this.setLayout(new BorderLayout());
		this.setUIManager();
		this.inItComponents();
		this.changeLanguage();
		this.setCommands(controllerApps);
		this.setVisible(true);
	}
	
	private void setUIManager() {
		UIManager.put("MenuBar.background", ConstansGUI.COLOR_TOOLBAR);
		UIManager.put("MenuBar.opaque", false);
		UIManager.put("Menu.background", ConstansGUI.COLOR_TOOLBAR);
		UIManager.put("Menu.font", ConstansGUI.FONT_MENUS);
		UIManager.put("Menu.foreground", ConstansGUI.FOREGROUND_MENUS);
		UIManager.put("Menu.opaque", false);
		UIManager.put("MenuItem.background", ConstansGUI.COLOR_TOOLBAR);
		UIManager.put("MenuItem.foreground", ConstansGUI.FOREGROUND_MENU_ITEMS);
		UIManager.put("MenuItem.font", ConstansGUI.FONT_MENU_ITEMS);
		UIManager.put("Button.font", ConstansGUI.FONT_BUTTON);
		UIManager.put("Button.foreground", Color.BLACK);
	}
	
	
	
	private void inItComponents() {
		this.inItMenus();
		scrollPane=new JScrollPane();
		panelCenter=new JPanel(new GridBagLayout());
		gridCenter=new GridSystem(panelCenter);
		bannerCenter=new JLabel();
		gridCenter.addExternalBorder(50, 0, 50, 50);
		bannerCenter.setIcon(Utilities.resizeImage(1000, 500, "imgs/banner_center1.jpg"));
		panelCenter.add(bannerCenter,gridCenter.insertComponent(1, 2, 7, 4));
		
		buttonTotal=new JButton();
		buttonTotal.setBorderPainted(false);
		buttonTotal.setBackground(Color.WHITE);
		buttonTotal.setIcon(Utilities.resizeImage(200, 200, "imgs/total_button.png"));
		buttonTotal.setVerticalTextPosition(JButton.BOTTOM);
		buttonTotal.setHorizontalTextPosition(JButton.CENTER);
		panelCenter.add(buttonTotal,gridCenter.insertComponent(5, 3, 2, 2));
		
		buttonAdmin=new JButton();
		buttonAdmin.setBorderPainted(false);
		buttonAdmin.setBackground(Color.WHITE);
		buttonAdmin.setIcon(Utilities.resizeImage(200, 200, "imgs/user_button.png"));
		buttonAdmin.setVerticalTextPosition(JButton.BOTTOM);
		buttonAdmin.setHorizontalTextPosition(JButton.CENTER);
		panelCenter.add(buttonAdmin,gridCenter.insertComponent(5, 6, 2, 2));
		
		panelCenter.setBackground(ConstansGUI.PANEL_CENTER);
		
        this.add(scrollPane,BorderLayout.CENTER); 
        scrollPane.setViewportView(panelCenter); 
         
	}
	
	private void inItMenus() {
		panelMenu=new JPanel(new GridBagLayout());
		panelMenu.setBackground(ConstansGUI.COLOR_TOOLBAR);
		gridMenu=new GridSystem(panelMenu);
		gridMenu.addExternalBorder(2, 5, 2, 5);
		
//		gridMenu.addExternalBorder(top, right, bottom, left);
		gridMenu.addExternalBorder(20, 15, 5, 5);
		logInButton=new JButton();
		logInButton.setIcon(Utilities.resizeImage(40, 40, "imgs/user_button.png"));
		logInButton.setForeground(Color.black);
		logInButton.setOpaque(true);
		logInButton.setBackground(ConstansGUI.COLOR_IMPORTANT_BUTTON);
		logInButton.setBorderPainted(false);
		panelMenu.add(logInButton,gridMenu.insertComponent(0, 9, 2, 1));
		gridMenu.addExternalBorder(0, 0, 0, 0);
		
		imageMenu=new JLabel();
		imageMenu.setIcon(Utilities.resizeImage(110, 100, "imgs/menu_principal2.png"));
		panelMenu.add(imageMenu, gridMenu.insertComponent(0, 1, 2, 1));
		
		toolBar=new JToolBar();
		toolBar.setBackground(ConstansGUI.COLOR_TOOLBAR);
		toolBar.setBorderPainted(false);
		toolBar.setFloatable(false);
		
		menuBar=new JMenuBar();
		menuBar.setBorderPainted(false);
		

		
		menuReports=new JMenu();
		menuReports.setBorderPainted(false);
		
		labelReport=new JLabel();
		labelReport.setFont(ConstansGUI.FONT_MENUS);
		labelReport.setForeground(ConstansGUI.COLOR_TOOLBAR);
		menuReports.add(labelReport);
		menuReports.addSeparator();
		
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
		
		menuLanguage=new JMenu();
		menuLanguage.setBorderPainted(false);
		itemEnglish=new JMenuItem();
		itemEnglish.setIcon(Utilities.resizeImage(16, 16, "imgs/english_item.png"));
		itemEnglish.setBorderPainted(false);
		menuLanguage.add(itemEnglish);
		itemSpanish=new JMenuItem();
		itemSpanish.setIcon(Utilities.resizeImage(16, 16, "imgs/spanish_item.png"));
		itemSpanish.setBorderPainted(false);
		menuLanguage.add(itemSpanish);
		menuBar.add(menuLanguage);
		
		menuLogIn=new JMenu();
		logIn=new JMenuItem();
		logIn.setBorderPainted(false);
		menuLogIn.add(logIn);
		itemExit=new JMenuItem();
		itemExit.setBorderPainted(false);
		menuLogIn.add(itemExit);
		menuBar.add(menuLogIn);
		
		toolBar.add(menuBar);
		panelMenu.add(toolBar,gridMenu.insertComponent(1, 6,2 , 1));
		
		this.add(panelMenu,BorderLayout.NORTH);
		

	}
	
	public void changeLanguage() {
		menuReports.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.MENU_REPORTS.name()));
		menuLanguage.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.MENU_LANGUAGE.name()));
		itemEnglish.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.ITEM_ENGLISH.name()));
		itemSpanish.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.ITEM_SPANISH.name()));
		menuLogIn.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.MENU_USER.name()));
		logIn.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.ITEM_LOG_IN.name()));
		logInButton.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.ITEM_LOG_IN.name()));
		buttonAdmin.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.ITEM_LOG_IN.name()));
		buttonTotal.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.TOTAL_BUTTON.name()));
		itemExit.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.EXIT.name()));
		
		//_____________report--------------
		
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
	
	
	}
	
	private void setCommands(ControllerApps controllerApps) {
		logIn.setActionCommand(Commands.SHOW_LOG_IN.name());
		logIn.addActionListener(controllerApps);
		buttonAdmin.setActionCommand(Commands.SHOW_LOG_IN.name());
		buttonAdmin.addActionListener(controllerApps);
		logInButton.setActionCommand(Commands.SHOW_LOG_IN.name());
		logInButton.addActionListener(controllerApps);
		
		itemExit.setActionCommand(Commands.EXIT.name());
		itemExit.addActionListener(controllerApps);
		//----------------------reports
		buttonTotal.setActionCommand(Commands.REPORT_ALL_INSTITUTES.name());
		buttonTotal.addActionListener(controllerApps);
		itemReportAllInstitutes.setActionCommand(Commands.REPORT_ALL_INSTITUTES.name());
		itemReportAllInstitutes.addActionListener(controllerApps);
		itemReportInstitutesDepartment.setActionCommand(Commands.REPORT_DEPARMENT_INSTITUTES.name());
		itemReportInstitutesDepartment.addActionListener(controllerApps);
		itemReportInstitute.setActionCommand(Commands.REPORT_INSTITUTE.name());
		itemReportInstitute.addActionListener(controllerApps);
		itemReportCups.setActionCommand(Commands.REPORT_CUPS.name());
		itemReportCups.addActionListener(controllerApps);
		itemReportDirectorDepartment.setActionCommand(Commands.REPORT_DIRECTOR_BY_DEPARMENT.name());
		itemReportDirectorDepartment.addActionListener(controllerApps);
		itemReportAllDirector.setActionCommand(Commands.REPORT_ALL_DIRECTORS.name());
		itemReportAllDirector.addActionListener(controllerApps);
		itemReportConfirmedEvents.setActionCommand(Commands.REPORT_CONFIRMED_EVENTS.name());
		itemReportConfirmedEvents.addActionListener(controllerApps);
		itemsReportProcessEvents.setActionCommand(Commands.REPORT_PROCESS_EVENTS.name());
		itemsReportProcessEvents.addActionListener(controllerApps);
		itemGraphEstateInstrument.setActionCommand(Commands.GRAPHS_ESTATE_INSTRUMENT.name());
		itemGraphEstateInstrument.addActionListener(controllerApps);
		itemGraphNumberInstitute.setActionCommand(Commands.GRAPHS_NUMBER_INSTITUTE.name());
		itemGraphNumberInstitute.addActionListener(controllerApps);
		itemGraphFundation.setActionCommand(Commands.GRAPHS_FUNDATION.name());
		itemGraphFundation.addActionListener(controllerApps);
	}
	
	public void hideMe() {
		this.setVisible(false);
	}
	public void showMe() {
		this.setVisible(true);
	}
	
	
}
