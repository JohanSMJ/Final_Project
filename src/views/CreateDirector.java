package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import controller.Commands;
import controller.ControllerApps;
import model.entity.DocumentType;
import properties.HandlerLanguage;
import utilities.DateUtilities;
import utilities.Utilities;

public class CreateDirector extends JDialog{
	
	JPanel panelMenu,panelCenter;
	GridSystem gridCenter,gridMenu;
	JTextField textNameDirector,textNumberID;
	JLabel labelPrincipal, labelNameMember, labelTypeDocument,labelIdNumber,labelBirthDate,
	labelGender;
	JButton buttonBack,buttonAdd;
	JDateChooser dateChooser;
	
	JComboBox<DocumentType> typeDocument;
	JComboBox<String>gender;
	
	public CreateDirector(ControllerApps controllerApps) {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(400, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(Utilities.resizeImage(16, 16, "imgs/menu_principal2.png").getImage());
		this.setTitle("R.A.M.I.");
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
		
		labelPrincipal=new JLabel("NUEVO DIRECTOR");
		panelCenter.add(labelPrincipal,gridCenter.insertComponent(1, 6, 2, 1));
		
		labelNameMember=new JLabel("NOMBRE DEL DIRECROE");
		panelCenter.add(labelNameMember,gridCenter.insertComponent(2, 1, 10, 1));
		textNameDirector=new JTextField();
		panelCenter.add(textNameDirector,gridCenter.insertComponent(3, 1, 10, 1));
		
		labelBirthDate=new JLabel("FECHA");
		panelCenter.add(labelBirthDate, gridCenter.insertComponent(4, 1, 10, 1));
		dateChooser=new JDateChooser();
		dateChooser.setFont(ConstansGUI.FONT_TEXTFIELDS);
		dateChooser.setBackground(ConstansGUI.COLOR_TOOLBAR);
		panelCenter.add(dateChooser,gridCenter.insertComponent(5, 1, 10, 1));
		
		 labelTypeDocument=new JLabel("TIPO");
		 panelCenter.add(labelTypeDocument,gridCenter.insertComponent(6, 1, 10, 1));
		 
		 typeDocument=new JComboBox<>(DocumentType.values());
		 typeDocument.setFont(ConstansGUI.FONT_MENU_ITEMS);
		 typeDocument.setBackground(ConstansGUI.PANEL_CENTER);
		 typeDocument.setForeground(ConstansGUI.COLOR_TOOLBAR);
		 panelCenter.add(typeDocument,gridCenter.insertComponent(7, 1, 10, 1));
		 
		 
		 labelIdNumber=new JLabel("NUMERO DE IDENTIFICACION");
		 panelCenter.add(labelIdNumber,gridCenter.insertComponent(8, 1, 10, 1));
		 textNumberID=new JTextField();
		 panelCenter.add(textNumberID,gridCenter.insertComponent(9, 1, 10, 1));
		 
		 labelGender=new JLabel("Genero");
		 panelCenter.add(labelGender,gridCenter.insertComponent(10, 1, 10, 1));
		 String[] genders=Utilities.arrayToStringVector(ConstansGUI.getGenderLabels());
		 gender=new JComboBox<>(genders);
		 gender.setFont(ConstansGUI.FONT_MENU_ITEMS);
		 gender.setBackground(ConstansGUI.PANEL_CENTER);
		 gender.setForeground(ConstansGUI.COLOR_TOOLBAR);
		 panelCenter.add(gender,gridCenter.insertComponent(11, 1, 10, 1));
		 
		 
		 buttonAdd=new JButton("AGREGAR");
		 buttonAdd.setFont(ConstansGUI.FONT_BUTTON);
		 buttonAdd.setForeground(Color.BLACK);
		 buttonAdd.setBackground(ConstansGUI.COLOR_IMPORTANT_BUTTON);
		 buttonAdd.setBorderPainted(false);
		 gridCenter.addExternalBorder(5, 2, 5, 2);
		 panelCenter.add(buttonAdd,gridCenter.insertComponent(12, 5, 3, 1));
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
		buttonAdd.setActionCommand(Commands.FINISH_DIRECTOR.name());
		buttonAdd.addActionListener(controllerApps);
		buttonBack.setActionCommand(Commands.BACK_TO_ADMIN_WINDOW.name());
		buttonBack.addActionListener(controllerApps);
	}
	
	public void changeLanguage() {
		changeLanguageOfCombo();
		labelPrincipal.setText(HandlerLanguage.languageProperties.getProperty(
				LabelsGUI.ADD_DIRECTOR_TEXT.name()));
		
		labelNameMember.setText(HandlerLanguage.languageProperties.getProperty(
				LabelsGUI.NAME_DIRECTOR.name()));

		labelBirthDate.setText(HandlerLanguage.languageProperties.getProperty(
				LabelsGUI.BIRTHDATE_TEXT.name()));
		
		labelTypeDocument.setText(HandlerLanguage.languageProperties.getProperty(
				LabelsGUI.TYPE_DOCUMENT_TEXT.name()));
		 
		labelIdNumber.setText(HandlerLanguage.languageProperties.getProperty(
				LabelsGUI.NUMBER_ID_TEXT.name()));
		labelGender.setText(HandlerLanguage.languageProperties.getProperty(
				LabelsGUI.GENDER_MEMBER.name()));
		 
		buttonAdd.setText(HandlerLanguage.languageProperties.getProperty(
				LabelsGUI.ADD_BUTTON.name()));
	}
	
	@SuppressWarnings("deprecation")
	public void getDate() {
		Calendar date= dateChooser.getCalendar();
		JOptionPane.showMessageDialog(null, "fecha: "+DateUtilities.calendarToString(date));
		
	}
	
	private boolean validateData() {
		boolean val=true;
		
		if (textNameDirector.getText().equals("")) {
			val=false;
		}
		
		if (textNumberID.getText().equals("")) {
			val=false;
		}
		
		return val;
	}

	
	public Object[] getData() {
		Object[] data=null;
		if (this.validateData()) {
			System.out.println("-----------------------------------");
			
			System.out.println((String)gender.getSelectedItem());
			System.out.println("-----------------------------------");
			Object [] temp= new Object [5];
			temp[0]=textNameDirector.getText();
			temp[1]=dateChooser.getCalendar();
			temp[2]=(DocumentType) typeDocument.getSelectedItem();
			temp[3]=textNumberID.getText();
			temp[4]=gender.getSelectedItem();
				
			data=temp;
		}
		return data;
	}
	public void hideMe() {
		this.clear();
		this.setVisible(false);
	}

	private void changeLanguageOfCombo() {
		gender.removeAllItems();
		String[]items=Utilities.arrayToStringVector(ConstansGUI.getGenderLabels());
		for (int i = 0; i < items.length; i++) {
			gender.insertItemAt(items[i], i);
		}
	}
	private void clear() {
		textNameDirector.setText("");
		textNumberID.setText("");
		dateChooser.setCalendar(DateUtilities.getCalendarDateNow());
	}



	public void showMe() {
		dateChooser.setCalendar(DateUtilities.getCalendarDateNow());
		this.setVisible(true);
	}
}