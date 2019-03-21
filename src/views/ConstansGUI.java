package views;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import properties.HandlerLanguage;

public class ConstansGUI {
	public static final LabelsGUI[]PRINCIPAL_TABLE_HEADERS = {LabelsGUI.DEPARTMENT,LabelsGUI.NAME_INSTITUTE,LabelsGUI.NUMBER_MEMBERS_INSTITUTE,LabelsGUI.NUMBER_CUPS_INSTITUTE,LabelsGUI.NAME_DIRECTOR,LabelsGUI.FUNDATION_DATE};
	public static final LabelsGUI[]INSTITUTES_BY_DEPARTMENT= {LabelsGUI.DEPARTMENT,LabelsGUI.NAME_INSTITUTE,LabelsGUI.NUMBER_MEMBERS_INSTITUTE,LabelsGUI.NUMBER_CUPS_INSTITUTE,LabelsGUI.NAME_DIRECTOR,LabelsGUI.FUNDATION_DATE};
	public static final LabelsGUI[]INSTITUTE_DATA= {LabelsGUI.NAME_INSTITUTE,LabelsGUI.NUMBER_MEMBERS_INSTITUTE,LabelsGUI.NUMBER_CUPS_INSTITUTE,LabelsGUI.NAME_DIRECTOR,LabelsGUI.FUNDATION_DATE,LabelsGUI.NUMBER_EVENTS};
	public static final LabelsGUI[]MEMBER_OF_INSTITUTE= {LabelsGUI.NAME_MEMBER,LabelsGUI.AGE_MEMBER,LabelsGUI.TYPE_DOCUMENT_MEMBER,LabelsGUI.MEMBER_ID,LabelsGUI.GENDER_MEMBER,LabelsGUI.NAME_INSTRUMENT};
	public static final LabelsGUI[]INTITUTES_BY_CUP= {LabelsGUI.DEPARTMENT,LabelsGUI.NAME_INSTITUTE,LabelsGUI.NUMBER_MEMBERS_INSTITUTE,LabelsGUI.NUMBER_CUPS_INSTITUTE,LabelsGUI.NAME_DIRECTOR,LabelsGUI.FUNDATION_DATE};
	public static final LabelsGUI[]DIRECTORS_BY_DEPARTMENT= {LabelsGUI.NAME_DIRECTOR,LabelsGUI.NAME_INSTITUTE,LabelsGUI.DEPARTMENT};
	public static final LabelsGUI[]ALL_DIRECTORS= {LabelsGUI.NAME_DIRECTOR,LabelsGUI.NAME_INSTITUTE,LabelsGUI.DEPARTMENT};
	public static final LabelsGUI[]CORFIMED_EVENTS= {LabelsGUI.EVENT_NAME,LabelsGUI.EVENT_DATE,LabelsGUI.EVENT_ID,LabelsGUI.PLACE,LabelsGUI.EVENTS_CORFIMED};	
	public static final LabelsGUI[]EVENTS_IN_PROCESS= {LabelsGUI.EVENT_NAME,LabelsGUI.EVENT_DATE,LabelsGUI.EVENT_ID,LabelsGUI.PLACE,LabelsGUI.EVENTS_GUESTS};
	public static final LabelsGUI[]EVENTS_DATA= {LabelsGUI.CONFIRMED};
	public static final LabelsGUI[]NUMBER_SCHOOLS= {LabelsGUI.DEPARTMENT,LabelsGUI.NUMBER_SCHOOLS};
	public static final LabelsGUI[]INSTITUTE_TABLE = {LabelsGUI.DEPARTMENT,LabelsGUI.NAME_INSTITUTE,LabelsGUI.NUMBER_MEMBERS_INSTITUTE,LabelsGUI.NUMBER_CUPS_INSTITUTE,LabelsGUI.NAME_DIRECTOR,LabelsGUI.FUNDATION_DATE};
	public static final LabelsGUI[]GENDER_TABLE= {LabelsGUI.MASCULINE,LabelsGUI.FEMALE,LabelsGUI.COMUNITY_LGBTIQ};
	
	
	public static final Color COLOR_TOOLBAR= Color.BLACK;
	public static final Color COLOR_IMPORTANT_BUTTON= Color.decode("#99A1FF");
	public static final Font FONT_MENUS= new Font("Gabriola", 0, 30);
	public static final Color FOREGROUND_MENUS= Color.WHITE;
	public static final Font FONT_BUTTON= new Font("Tw Cen MT Condensed Extra Bold", 0, 30);
	public static final Font FONT_MENU_ITEMS= new Font("Century Gothic", 0, 24);
	public static final Font FONT_TABLE= new Font("Gabriola", 0, 20);
	public static final Font FONT_TABLE_ITEMS= new Font("Century Gothic", 0, 16);
	public static final Color FOREGROUND_MENU_ITEMS= Color.WHITE;
	public static final Color PANEL_CENTER= Color.white;
	public static final Font FONT_TEXTFIELDS= new Font("Century Gothic", 0, 20);
	public static final Border BORDER_AREA=new LineBorder(ConstansGUI.COLOR_TOOLBAR);
	
	public static ArrayList<String> getStateLabels() {
		ArrayList<String>arrayList=new ArrayList<>();
		arrayList.add(HandlerLanguage.languageProperties.getProperty(LabelsGUI.GOOD_STATE.name()));
		arrayList.add(HandlerLanguage.languageProperties.getProperty(LabelsGUI.BAD_STATE.name()));
		return arrayList;
	}
	
	public static ArrayList<String> getGenderLabels() {
		ArrayList<String>arrayList=new ArrayList<>();
		arrayList.add(HandlerLanguage.languageProperties.getProperty(LabelsGUI.FEMALE.name()));
		arrayList.add(HandlerLanguage.languageProperties.getProperty(LabelsGUI.MASCULINE.name()));
		arrayList.add(HandlerLanguage.languageProperties.getProperty(LabelsGUI.COMUNITY_LGBTIQ.name()));
		return arrayList;
	}
	
	public static ArrayList<String> getTypeInstrument() {
		ArrayList<String>arrayList=new ArrayList<>();
		arrayList.add(HandlerLanguage.languageProperties.getProperty(LabelsGUI.STRING_INSTUMENT.name()));
		arrayList.add(HandlerLanguage.languageProperties.getProperty(LabelsGUI.WIND_INSTRUMENT.name()));
		arrayList.add(HandlerLanguage.languageProperties.getProperty(LabelsGUI.PERCUSSION_INSTRUMENT.name()));
		return arrayList;
	}
}
