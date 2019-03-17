package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Commands;
import controller.ControllerApps;

import model.dao.Institute;
import model.entity.Event;
import properties.HandlerLanguage;
import utilities.DateUtilities;
import utilities.Utilities;

public class EventDataWindow extends JDialog{

	private static final long serialVersionUID = 1L;
	
	JPanel panelMenu,panelCenter;
	JScrollPane scrollPane;
	JButton buttonBack,buttonExport;
	JStaticTable jStaticTable;
	JButton buttonPrint;
	GridSystem gridMenu,gridCenter;
	JLabel labelFundation;
	
	public EventDataWindow( LabelsGUI[] headers,Object[][]matrix, ControllerApps controllerApps, boolean isAdmin,Event event) {
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.inItComponents(headers,matrix,controllerApps,isAdmin,event);
		this.setVisible(true);
	}
	private void inItComponents( LabelsGUI[] headers,Object[][]matrix,ControllerApps controllerApps,boolean isAdmin,Event event) {
		this.inItMenu();
		this.inItForm(headers,matrix,event);
		if (isAdmin) {
			this.setAdminCommands(controllerApps);
		}else {
			this.setCommands(controllerApps);
		}
		this.chanceLanguage(event);
		String titlePrincipal=event.getName().toUpperCase();
		this.setTitlePrincipal(titlePrincipal);
	}
	
	private void inItForm(LabelsGUI [] headers,Object[][]matrix ,Event event) {
		panelCenter=new JPanel();
		panelCenter.setBackground(ConstansGUI.PANEL_CENTER);
		panelCenter.setLayout(new GridBagLayout());
		gridCenter=new GridSystem(panelCenter);
		
		labelFundation=new JLabel();
		labelFundation.setFont(ConstansGUI.FONT_MENUS);
		labelFundation.setForeground(Color.BLACK);
		panelCenter.add(labelFundation,gridCenter.insertComponent(1, 1, 5, 1));
		
		
		
		jStaticTable=new JStaticTable(headers);
		jStaticTable.addElementsToTable(matrix);
		panelCenter.add(jStaticTable,gridCenter.insertComponent(2, 1, 10, 4));
		
		buttonPrint=new JButton();
		buttonPrint.setBackground(ConstansGUI.COLOR_IMPORTANT_BUTTON);
		buttonPrint.setBorderPainted(false);
		buttonPrint.setFont(ConstansGUI.FONT_BUTTON);
		buttonPrint.setForeground(Color.BLACK);
		gridCenter.addExternalBorder(10, 250, 10, 250);
		panelCenter.add(buttonPrint,gridCenter.insertComponent(6, 1, 10, 1));
		this.add(panelCenter,BorderLayout.CENTER);
	}
	
	private void inItMenu() {
		panelMenu=new JPanel();
		panelMenu.setLayout(new GridBagLayout());
		gridMenu=new GridSystem(panelMenu);
		panelMenu.setBackground(ConstansGUI.COLOR_TOOLBAR);
		
		buttonBack=new JButton();
		buttonBack.setBackground(ConstansGUI.COLOR_TOOLBAR);
		buttonBack.setBorderPainted(false);
		buttonBack.setIcon(Utilities.resizeImage(30, 30, "imgs/back_button.png"));
		panelMenu.add(buttonBack,gridMenu.insertComponent(1, 1, 1, 1));
		
		buttonExport=new JButton();
		buttonExport.setBackground(ConstansGUI.COLOR_TOOLBAR);
		buttonExport.setBorderPainted(false);
		buttonExport.setIcon(Utilities.resizeImage(30, 30, "imgs/export_button.png"));
		panelMenu.add(buttonExport,gridMenu.insertComponent(1, 10, 1, 1));
		
		this.add(panelMenu,BorderLayout.NORTH);
	}
	
	public void updateWindow(LabelsGUI[] headers,Object[][] matrix,String title) {
		jStaticTable.refreshTable();
		jStaticTable.setHeaders(headers);
		jStaticTable.addElementsToTable(matrix);
		this.setTitle(title);
		
	}
	
	private void setTitlePrincipal(String title) {
		labelFundation.setText(title);
	}
	private void setCommands(ControllerApps controllerApps) {
		buttonBack.setActionCommand(Commands.BACK_TO_MAIN_WINDOW.name());
		buttonBack.addActionListener(controllerApps);
		buttonExport.setActionCommand(Commands.EXPORT_REPORT.name());
		buttonExport.addActionListener(controllerApps);
		buttonPrint.setActionCommand(Commands.EXPORT_REPORT.name());
		buttonPrint.addActionListener(controllerApps);
		
	}
	
	public void setAdminCommands(ControllerApps controllerApps) {
		buttonBack.setActionCommand(Commands.BACK_TO_ADMIN_WINDOW.name());
		buttonBack.addActionListener(controllerApps);
	}
	
	public void chanceLanguage(Event event) {
		buttonPrint.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.PRINT.name()));
		labelFundation.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.EVENT_DATE.name())+": "+DateUtilities.calendarToString(event.getDate()));
	}
	
	public void hideMe() {
		this.setVisible(false);
	}
	public void showMe() {
		this.setVisible(true);

	}
}
