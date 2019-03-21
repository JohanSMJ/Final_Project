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
import properties.HandlerLanguage;
import utilities.DateUtilities;
import utilities.Utilities;

public class InstituteDataWindow extends JDialog{

	private static final long serialVersionUID = 1L;
	
	JPanel panelMenu,panelCenter;
	JScrollPane scrollPane;
	JButton buttonBack,buttonExport;
	JStaticTable jStaticTable;
	JButton buttonPrint,buttonCup;
	GridSystem gridMenu,gridCenter;
	JLabel labelFundation,labelID, labelName;
	String id="";
	
	public InstituteDataWindow( LabelsGUI[] headers,Object[][]matrix, 
			ControllerApps controllerApps, boolean isAdmin,String date,
			String id,String title) {
		this.setSize(1200, 700);
		this.id=id;
		this.setIconImage(Utilities.resizeImage(16, 16, "imgs/menu_principal2.png").getImage());
		this.setTitle("R.A.M.I.");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.inItComponents(headers,matrix,controllerApps,isAdmin, date,  id,title);
		this.setVisible(true);
	}
	private void inItComponents( LabelsGUI[] headers,Object[][]matrix,ControllerApps controllerApps
			,boolean isAdmin,String date, String director,String title) {
		this.inItMenu();
		this.inItForm(headers,matrix, date,  director,title,isAdmin);
		if (isAdmin) {
			this.setAdminCommands(controllerApps);
		}else {
			this.setCommands(controllerApps);
		}
		this.chanceLanguage( date,  director);
		this.setTitlePrincipal(title.toUpperCase());
	}
	
	private void inItForm(LabelsGUI [] headers,Object[][]matrix , String date,
			String director,String name,boolean isAdmin) {
		panelCenter=new JPanel();
		panelCenter.setBackground(ConstansGUI.PANEL_CENTER);
		panelCenter.setLayout(new GridBagLayout());
		gridCenter=new GridSystem(panelCenter);
		
		labelName=new JLabel();
		labelName.setFont(ConstansGUI.FONT_MENUS);
		labelName.setText(name.toUpperCase());
		labelName.setForeground(Color.BLACK);
		panelCenter.add(labelName,gridCenter.insertComponent(1, 4, 1, 1));
		
		labelFundation=new JLabel();
		labelFundation.setFont(ConstansGUI.FONT_MENU_ITEMS);
		labelFundation.setForeground(Color.BLACK);
		panelCenter.add(labelFundation,gridCenter.insertComponent(2, 1, 1, 1));
		
		labelID=new JLabel();
		labelID.setFont(ConstansGUI.FONT_MENU_ITEMS);
		labelID.setForeground(Color.BLACK);
		panelCenter.add(labelID,gridCenter.insertComponent(3, 1, 1, 1));
		
		buttonCup=new JButton();
		buttonCup.setIcon(Utilities.resizeImage(36, 36, "imgs/add_cup.png"));
		buttonCup.setBorderPainted(false);
		buttonCup.setBackground(ConstansGUI.PANEL_CENTER);
		if (isAdmin) {
			panelCenter.add(buttonCup,gridCenter.insertComponent(3, 9, 1, 1));
		}
		
		jStaticTable=new JStaticTable(headers);
		jStaticTable.addElementsToTable(matrix);
		panelCenter.add(jStaticTable,gridCenter.insertComponent(4, 1, 10, 4));
		
		buttonPrint=new JButton();
		buttonPrint.setBackground(ConstansGUI.COLOR_IMPORTANT_BUTTON);
		buttonPrint.setBorderPainted(false);
		buttonPrint.setFont(ConstansGUI.FONT_BUTTON);
		buttonPrint.setForeground(Color.BLACK);
		gridCenter.addExternalBorder(10, 250, 10, 250);
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
		
		this.add(panelMenu,BorderLayout.NORTH);
	}
	
	public void updateWindow(LabelsGUI[] headers,Object[][] matrix,String title) {
		jStaticTable.refreshTable();
		jStaticTable.setHeaders(headers);
		jStaticTable.addElementsToTable(matrix);
		this.setTitle(title);
		
	}
	
	private void setTitlePrincipal(String title) {
		labelName.setText(title);
	}
	private void setCommands(ControllerApps controllerApps) {
		buttonBack.setActionCommand(Commands.BACK_TO_MAIN_WINDOW.name());
		buttonBack.addActionListener(controllerApps);
		buttonExport.setActionCommand(Commands.EXPORT_REPORT.name());
		buttonExport.addActionListener(controllerApps);
		buttonPrint.setActionCommand(Commands.EXPORT_REPORT.name());
		buttonPrint.addActionListener(controllerApps);
		buttonCup.setActionCommand(Commands.ADD_CUPS.name());
		buttonCup.addActionListener(controllerApps);
		
	}
	
	public void setAdminCommands(ControllerApps controllerApps) {
		buttonBack.setActionCommand(Commands.BACK_TO_ADMIN_WINDOW.name());
		buttonBack.addActionListener(controllerApps);
		buttonCup.setActionCommand(Commands.ADD_CUPS.name());
		buttonCup.addActionListener(controllerApps);
	}
	
	public void chanceLanguage(String date, String director) {
		buttonPrint.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.PRINT.name()));
		labelFundation.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.FUNDATION_DATE.name())+": "+date);
		labelID.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.ID_INSTITUTE.name())
				+" : "+director.toUpperCase());
	}
	
	public void hideMe() {
		this.setVisible(false);
	}
	public void showMe() {
		this.setVisible(true);
	}
	public String getIdInstitute() {
		return this.id;
	}
	
}

