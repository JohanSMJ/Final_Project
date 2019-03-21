package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.GrayFilter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import controller.Commands;
import controller.ControllerApps;
import properties.HandlerLanguage;
import properties.HandlerProperties;
import utilities.Utilities;

public class LogIn extends JDialog{
	JLabel labelPrincipal,labelNickName,labelPassword;
	JPanel panelLogIn;
	JToolBar toolBar;
	JTextField textNickName;
	JPasswordField password;
	JButton buttonBack,buttonLogIn;
	GridSystem gridSystem;
	
	

	public LogIn(ControllerApps controllerApps) {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setIconImage(Utilities.resizeImage(16, 16, "imgs/menu_principal2.png").getImage());
		this.setTitle("R.A.M.I.");
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setUIManager();
		this.inItComponents(controllerApps);
		this.changeLanguage();
	}
	
	private void setUIManager() {
		UIManager.put("Label.font", ConstansGUI.FONT_MENU_ITEMS);
		UIManager.put("Label.foreground", Color.BLACK);
		UIManager.put("TextField.font", ConstansGUI.FONT_TEXTFIELDS);
		UIManager.put("TextField.foreground", Color.BLACK);
		UIManager.put("PasswordField.font", ConstansGUI.FONT_TEXTFIELDS);
		UIManager.put("PasswordField.foreground", Color.BLACK);
	}
	private void inItComponents(ControllerApps controllerApps) {
		
		toolBar=new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBorderPainted(false);
		toolBar.setBackground(ConstansGUI.COLOR_TOOLBAR);
		buttonBack=new JButton();
		buttonBack.setBorderPainted(false);
		buttonBack.setBackground(ConstansGUI.COLOR_TOOLBAR);
		buttonBack.setIcon(Utilities.resizeImage(30, 30, "imgs/back_button.png"));
		toolBar.add(buttonBack);
		this.add(toolBar, BorderLayout.NORTH);
		
		panelLogIn=new JPanel();
		panelLogIn.setBackground(ConstansGUI.PANEL_CENTER);
		gridSystem=new GridSystem(panelLogIn);
		
		labelPrincipal=new JLabel();
		labelPrincipal.setIcon(Utilities.resizeImage(120, 120, "imgs/user_button.png"));
//		gridSystem.insertComponent(row, column, width, height)
		panelLogIn.add(labelPrincipal, gridSystem.insertComponent(0, 6, 1, 1));
		
		labelNickName=new JLabel();
		panelLogIn.add(labelNickName,gridSystem.insertComponent(1, 1, 10, 1));
		textNickName=new JTextField();
		panelLogIn.add(textNickName, gridSystem.insertComponent(2,1,10,1));
		
		labelPassword=new JLabel();
		panelLogIn.add(labelPassword, gridSystem.insertComponent(3, 1, 10, 1));
		password=new JPasswordField();
//		password.setEchoChar('*');
		panelLogIn.add(password, gridSystem.insertComponent(4, 1, 10, 1));
		
		buttonLogIn=new JButton();
		buttonLogIn.setBorderPainted(false);
		buttonLogIn.setFont(ConstansGUI.FONT_BUTTON);
		buttonLogIn.setForeground(Color.BLACK);
		buttonLogIn.setBackground(ConstansGUI.COLOR_IMPORTANT_BUTTON);
		gridSystem.addExternalBorder(10, 0, 10, 0);
		panelLogIn.add(buttonLogIn,gridSystem.insertComponent(5, 4, 4, 1));
		gridSystem.addExternalBorder(0, 0, 0, 0);
		
		this.add(panelLogIn, BorderLayout.CENTER);
		
		this.setCommands(controllerApps);
	}
	public String[] getInsertUser() {
		@SuppressWarnings("deprecation")
		String user[]= {textNickName.getText(),password.getText()};
		return user;
	}
	
	private void setCommands(ControllerApps controllerApps) {
		buttonBack.setActionCommand(Commands.BACK_TO_MAIN_WINDOW.name());
		buttonBack.addActionListener(controllerApps);
		buttonLogIn.setActionCommand(Commands.LOG_IN_BUTTON.name());
		buttonLogIn.addActionListener(controllerApps);
	}
	
	public void changeLanguage() {
		buttonLogIn.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.LOG_IN_INSERT.name()));
		labelNickName.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.LOG_IN_NICKNAME.name()));
		labelPassword.setText(HandlerLanguage.languageProperties.getProperty(LabelsGUI.LOG_IN_PASSWORD.name()));
		this.setTitle(HandlerLanguage.languageProperties.getProperty(LabelsGUI.ITEM_LOG_IN.name()));
	}
	
	public void showMe() {
		this.setVisible(true);
	}
	public void hideMe() {
		this.clearWindow();
		this.setVisible(false);
	}

	public void clearWindow() {
		textNickName.setText("");
		password.setText("");
	}
	
	
}
