package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import properties.HandlerLanguage;

public class JStaticTable extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel defaultTableModel;
	private JTable table;
	private JScrollPane scrollPane;
	private LabelsGUI[] headers;
	
	 JStaticTable(LabelsGUI [] headers) {
		 inItComponents();
		 this.headers=headers;
		 this.setHeader();
	 }
	 JStaticTable(LabelsGUI [] headers,Object[][] matrix) {
		 inItComponents();
		 this.headers=headers;
		 this.setHeader();
		 this.addElementsToTable(matrix);
	 }
	 
	 private void inItComponents() {
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			defaultTableModel=new DefaultTableModel();
			
			table=new JTable();
			table.setOpaque(false);

			table.setModel(defaultTableModel);
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setBackground(ConstansGUI.COLOR_IMPORTANT_BUTTON);
			table.getTableHeader().setFont(ConstansGUI.FONT_TABLE);
			table.getTableHeader().setForeground(Color.black);
			table.getTableHeader().setDoubleBuffered(true);
			table.setFont(ConstansGUI.FONT_TABLE_ITEMS);
			table.setFillsViewportHeight(true);
			table.setBorder(null);
			scrollPane=new JScrollPane(table);
			scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
			this.add(scrollPane,BorderLayout.PAGE_END);
			this.setBorder(null);
	}
	private void setHeader() {
		String [] headers=new String[this.headers.length];
		String property="";
		for (int i = 0; i < this.headers.length; i++) {
			property=this.headers[i].name();
			headers[i]=HandlerLanguage.languageProperties.getProperty(property);
		}
		defaultTableModel.setColumnIdentifiers(headers);
	}
		
		

		
		public void addElement(Object[] vector) {
			defaultTableModel.addRow(vector);
		}
		
		public void addElementsToTable(Object[][] matriz) {
			for (int i = 0; i < matriz.length; i++) {
				this.addElement(matriz[i]);
			}
		}
		
		public void refreshTable() {
			defaultTableModel.setRowCount(0);
		}

		public LabelsGUI[] getHeaders() {
			return headers;
		}

		public void setHeaders(LabelsGUI[] headers) {
			this.headers = headers;
		}
		
		public void printTable() {
		}
		
		public Object[][] getContentTable() {
			Object[][] matrix=new Object [defaultTableModel.getRowCount()+1][defaultTableModel.getColumnCount()];
			String property="";
			for (int k = 0; k < this.headers.length; k++) {
				property=this.headers[k].name();
				matrix[0][k]=HandlerLanguage.languageProperties.getProperty(property);
			}
			for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
				for (int j = 0; j < defaultTableModel.getColumnCount(); j++) {
					matrix[(i+1)][j]=defaultTableModel.getValueAt(i, j);
				}
			}
			
			return matrix;
		}
		
	
}
	


