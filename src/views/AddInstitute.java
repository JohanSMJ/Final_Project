package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import controller.Commands;
import controller.ControllerApps;
import utilities.DateUtilities;
import utilities.Utilities;

public class AddInstitute extends JDialog{
	
	JPanel panelMenu,panelCenter;
	GridSystem gridCenter,gridMenu;
	JTextField textNameInstitute,textNameDirector,textIdDirector;
	JLabel labelPrincipal, labelNameInstitute, labelNameDirector,labelIdDirector,labelFoundationDate;
	JButton buttonBack,buttonAdd;
	JDateChooser dateChooser;
	 
	 public AddInstitute(ControllerApps controllerApps) {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setUIManager();
		this.inItComponents();
		this.setCommands(controllerApps);
		this.changeLanguage();
	}



	private void inItComponents() {
		inItMenu();
		panelCenter=new JPanel(new GridBagLayout());
		panelCenter.setBackground(ConstansGUI.PANEL_CENTER);
		gridCenter=new GridSystem(panelCenter);
		
		labelPrincipal=new JLabel("AGREGAR INSITUTO");
		panelCenter.add(labelPrincipal,gridCenter.insertComponent(1, 6, 2, 1));
		
		labelNameInstitute=new JLabel("NOMBRE DEL INSTIRUTO");
		panelCenter.add(labelNameInstitute,gridCenter.insertComponent(2, 1, 10, 1));
		textNameInstitute=new JTextField();
		panelCenter.add(textNameInstitute,gridCenter.insertComponent(3, 1, 10, 1));
		
		labelFoundationDate=new JLabel("FECHA DE FUNDACION");
		panelCenter.add(labelFoundationDate, gridCenter.insertComponent(4, 1, 10, 1));
		dateChooser=new JDateChooser();
		dateChooser.setFont(ConstansGUI.FONT_TEXTFIELDS);
		dateChooser.setBackground(ConstansGUI.COLOR_TOOLBAR);
		panelCenter.add(dateChooser,gridCenter.insertComponent(5, 1, 10, 1));
		
		//nombre director //id
		 labelNameDirector=new JLabel("NOMBRE DEL DIRECOTOR");
		 panelCenter.add(labelNameDirector,gridCenter.insertComponent(6, 1, 10, 1));
		 textNameDirector=new JTextField();
		 panelCenter.add(textNameDirector,gridCenter.insertComponent(7, 1, 10, 1));
		 
		 labelIdDirector=new JLabel("ID DEL DIRECTOR");
		 panelCenter.add(labelIdDirector,gridCenter.insertComponent(8, 1, 10, 1));
		 textNameInstitute=new JTextField();
		 panelCenter.add(textNameInstitute,gridCenter.insertComponent(9, 1, 10, 1));
		 
		 buttonAdd=new JButton("AGREGAR");
		 buttonAdd.setFont(ConstansGUI.FONT_BUTTON);
		 buttonAdd.setForeground(Color.BLACK);
		 buttonAdd.setBackground(ConstansGUI.COLOR_IMPORTANT_BUTTON);
		 buttonAdd.setBorderPainted(false);
		 gridCenter.addExternalBorder(5, 2, 5, 2);
		 panelCenter.add(buttonAdd,gridCenter.insertComponent(10, 5, 3, 1));
		 gridCenter.addExternalBorder(0, 0, 0, 0);
		 
		
		this.add(panelCenter,BorderLayout.CENTER);
		
	}

	private void inItMenu() {
		panelMenu=new JPanel(new GridBagLayout());
		panelMenu.setBackground(ConstansGUI.COLOR_TOOLBAR);
		gridMenu=new GridSystem(panelMenu);
		
		buttonBack=new JButton();
		buttonBack.setBackground(ConstansGUI.COLOR_TOOLBAR);
		buttonBack.setBorderPainted(false);
		buttonBack.setIcon(Utilities.resizeImage(40, 40, "imgs/back_button.png"));
		panelMenu.add(buttonBack,gridMenu.insertComponent(1, 1, 1, 1));
		
		
		
		this.add(panelMenu,BorderLayout.NORTH);
	}



	private void setUIManager() {
		UIManager.put("Label.font", ConstansGUI.FONT_MENUS);
		UIManager.put("Label.foreground", Color.BLACK);
		UIManager.put("TextField.font", ConstansGUI.FONT_TEXTFIELDS);
		UIManager.put("TextField.foreground", Color.BLACK);
		
	}
	private void setCommands(ControllerApps controllerApps) {
		buttonAdd.setActionCommand(Commands.ADD_INSTITUTE.name());
		buttonAdd.addActionListener(controllerApps);
	}
	
	private void changeLanguage() {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("deprecation")
	public void getDate() {
		Calendar date= dateChooser.getCalendar();
		JOptionPane.showMessageDialog(null, "fecha: "+DateUtilities.calendarToString(date));
		
	}
}
