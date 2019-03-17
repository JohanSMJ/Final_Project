package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import controller.Commands;
import controller.ControllerApps;
import properties.HandlerLanguage;
import utilities.Utilities;

public class ReportTable extends JDialog{

	private static final long serialVersionUID = 1L;
	
	JPanel panelMenu,panelCenter;
	JScrollPane scrollPane;
	JButton buttonBack,buttonExport;
	JStaticTable jStaticTable;
	JButton buttonPrint;
	GridSystem gridMenu,gridCenter;
	JLabel labelTitle;
	
	public ReportTable( LabelsGUI[] headers,Object[][]matrix, ControllerApps controllerApps,String titlePrincipal, boolean isAdmin) {
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.inItComponents(headers,matrix,controllerApps,titlePrincipal,isAdmin);
		this.setVisible(true);
	}
	private void inItComponents( LabelsGUI[] headers,Object[][]matrix,ControllerApps controllerApps,String titlePrincipal,boolean isAdmin) {
		this.inItMenu();
		this.inItForm(headers,matrix,titlePrincipal);
		if (isAdmin) {
			this.setAdminCommands(controllerApps);
		}else {
			this.setCommands(controllerApps);
		}
		this.chanceLanguage();
		this.setTitlePrincipal(titlePrincipal);
	}
	
	private void inItForm(LabelsGUI [] headers,Object[][]matrix,String titlePrincipal) {
		panelCenter=new JPanel();
		panelCenter.setBackground(ConstansGUI.PANEL_CENTER);
		panelCenter.setLayout(new GridBagLayout());
		gridCenter=new GridSystem(panelCenter);
		
		labelTitle=new JLabel("DEFAULT");
		labelTitle.setFont(ConstansGUI.FONT_MENUS);
		labelTitle.setForeground(Color.BLACK);
		panelCenter.add(labelTitle,gridCenter.insertComponent(1, 6, 2, 1));
		
		
		
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
		labelTitle.setText(title);
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
	
	public void chanceLanguage() {
		buttonPrint.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.PRINT.name()));
	}
	
	public void hideMe() {
		this.setVisible(false);
	}
	public void showMe() {
		this.setVisible(true);
	}
}
