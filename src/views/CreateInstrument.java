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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import controller.Commands;
import controller.ControllerApps;
import model.entity.DocumentType;
import properties.HandlerLanguage;
import utilities.DateUtilities;
import utilities.Utilities;

public class CreateInstrument extends JDialog{
		
		JPanel panelMenu,panelCenter;
		GridSystem gridCenter,gridMenu;
		JTextField textNameInstrument;
		JLabel labelPrincipal, labelNameInstrument, labelStateInstrument,labelDescription,labelTypeInstrument;
		JButton buttonBack,buttonAdd;
		JTextArea areaDescription;
		
		JComboBox<String> typeInstrument,stateInstrument;
		
		public CreateInstrument(ControllerApps controllerApps) {
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setSize(400, 600);
			this.setIconImage(Utilities.resizeImage(16, 16, "imgs/menu_principal2.png").getImage());
			this.setTitle("R.A.M.I.");
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
			
			labelPrincipal=new JLabel("INSTRUMENTO");
			panelCenter.add(labelPrincipal,gridCenter.insertComponent(1, 6, 2, 1));
			
			labelNameInstrument=new JLabel("NOMBRE");
			panelCenter.add(labelNameInstrument,gridCenter.insertComponent(2, 1, 10, 1));
			textNameInstrument=new JTextField();
			panelCenter.add(textNameInstrument,gridCenter.insertComponent(3, 1, 10, 1));
			
			labelTypeInstrument=new JLabel("TIPO");
			panelCenter.add(labelTypeInstrument, gridCenter.insertComponent(4, 1, 10, 1));
			String[]items=Utilities.arrayToStringVector(ConstansGUI.getTypeInstrument());
			typeInstrument=new JComboBox<>(items);
			typeInstrument.setBackground(ConstansGUI.PANEL_CENTER);
			typeInstrument.setFont(ConstansGUI.FONT_TABLE_ITEMS);
			typeInstrument.setForeground(ConstansGUI.COLOR_TOOLBAR);
			panelCenter.add(typeInstrument,gridCenter.insertComponent(5, 1, 10, 1));
			
			 labelStateInstrument=new JLabel("ESTADO");
			 panelCenter.add(labelStateInstrument,gridCenter.insertComponent(6, 1, 10, 1));
			 String[]states=Utilities.arrayToStringVector(ConstansGUI.getStateLabels());
			 stateInstrument=new JComboBox<>(states);
			 stateInstrument.setBackground(ConstansGUI.PANEL_CENTER);
			 stateInstrument.setFont(ConstansGUI.FONT_TABLE_ITEMS);
			 stateInstrument.setForeground(ConstansGUI.COLOR_TOOLBAR);
			 panelCenter.add(stateInstrument,gridCenter.insertComponent(7, 1, 10, 1));
			 
			 
			 labelDescription=new JLabel("description");
			 panelCenter.add(labelDescription,gridCenter.insertComponent(8, 1, 10, 1));
			 areaDescription=new JTextArea();
			 areaDescription.setBorder(ConstansGUI.BORDER_AREA);
			 areaDescription.setFont(ConstansGUI.FONT_TABLE_ITEMS);
			 areaDescription.setForeground(ConstansGUI.COLOR_TOOLBAR);
			 panelCenter.add(areaDescription,gridCenter.insertComponent(9, 1, 10, 2));
			 
			 buttonAdd=new JButton("AGREGAR");
			 buttonAdd.setFont(ConstansGUI.FONT_BUTTON);
			 buttonAdd.setForeground(Color.BLACK);
			 buttonAdd.setBackground(ConstansGUI.COLOR_IMPORTANT_BUTTON);
			 buttonAdd.setBorderPainted(false);
			 gridCenter.addExternalBorder(5, 2, 5, 2);
			 panelCenter.add(buttonAdd,gridCenter.insertComponent(11, 5, 3, 1));
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
			buttonAdd.setActionCommand(Commands.FINISH_MEMBER.name());
			buttonAdd.addActionListener(controllerApps);
			buttonBack.setActionCommand(Commands.BACK_TO_ADMIN_WINDOW.name());
			buttonBack.addActionListener(controllerApps);
		}
		
		public void changeLanguage() {
			this.changeLanguageOfCombos();
			
			labelPrincipal.setText(HandlerLanguage.languageProperties.getProperty(
					LabelsGUI.NEW_INSTRUMENT_TEXT.name()));
			
			labelNameInstrument.setText(HandlerLanguage.languageProperties.getProperty(
					LabelsGUI.NAME_INSTRUMENT_TEXT.name()));

			labelTypeInstrument.setText(HandlerLanguage.languageProperties.getProperty(
					LabelsGUI.TYPE_INSTRUMENT_TEXT.name()));
			
			labelStateInstrument.setText(HandlerLanguage.languageProperties.getProperty(
					LabelsGUI.STATE_INSTRUMENT_TEXT.name()));
			 
			labelDescription.setText(HandlerLanguage.languageProperties.getProperty(
					LabelsGUI.DESCRIPTION_INSTRUMENT_TEXT.name()));
			 
			buttonAdd.setText(HandlerLanguage.languageProperties.getProperty(
					LabelsGUI.ADD_BUTTON.name()));
		}
		

		private void changeLanguageOfCombos() {
			typeInstrument.removeAllItems();
			String[]items=Utilities.arrayToStringVector(ConstansGUI.getTypeInstrument());
			for (int i = 0; i < items.length; i++) {
				typeInstrument.insertItemAt(items[i], i);
			}
			stateInstrument.removeAllItems();
			String[]states=Utilities.arrayToStringVector(ConstansGUI.getStateLabels());
			for (int i = 0; i < states.length; i++) {
				stateInstrument.insertItemAt(states[i], i);
			}
		}



		public void hideMe() {
			this.clear();
			this.changeLanguage();
			this.setVisible(false);
		}

		public void showMe() {
			this.clear();
			this.changeLanguage();
			this.setVisible(true);
		}
		public void clear() {
			textNameInstrument.setText("");
			areaDescription.setText("");
		}



		public Object[] getData() {
			Object[] data=null;
			if (this.validateData()) {
				Object[]temp= {textNameInstrument.getText(),typeInstrument.getSelectedItem(),
						stateInstrument.getSelectedItem(),areaDescription.getText()};
				data=temp;
			}
			return data;
		}
		private boolean validateData() {
			boolean val=true;
			if (textNameInstrument.getText().equals("")) {
				val=false;
			}
			return val;
		}
		
}

