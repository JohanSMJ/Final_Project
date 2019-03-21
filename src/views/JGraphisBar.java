package views;

import javax.swing.JDialog;
import javax.swing.JFrame;

import utilities.Utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
public class JGraphisBar extends JDialog{
	private int yMax;
	private int numberIntervalY;
	private int pixelsIntervalY;
	private int labelIntervalY;
	private int numberIntevalX;
	private int pixelsIntervalX;
	private ArrayList<String>labelAxisX;
	private String titlePrincipal;
	private String titleAxisY;
	private String titleAxisX;
	private ArrayList<Double>valuesInY;
	
	private static int PERCENTAGE_MARGIN=12;
	private static Color COLOR_AXIS=ConstansGUI.COLOR_TOOLBAR;
	private static Color COLOR_GRID=Color.gray;
	private static Color COLOR_BAR=ConstansGUI.COLOR_IMPORTANT_BUTTON;
	private static int SIZE_OF_LINE=6;
	private static int SIZE_OF_RECT=20;
	
	public JGraphisBar(int yMax,int numberIntervalY,ArrayList<String>labelsX,String titlePrincipal,String titleAxisY,String titleAxisX,ArrayList<Double>values) {
		this.setIconImage(Utilities.resizeImage(16, 16, "imgs/menu_principal2.png").getImage());
		this.setTitle("R.A.M.I.");
		getContentPane().setBackground(ConstansGUI.PANEL_CENTER);
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.yMax=yMax;
		this.numberIntervalY=numberIntervalY;
		this.labelIntervalY=this.getLabelIntervalY();
		this.labelAxisX=labelsX;
		this.numberIntevalX=this.labelAxisX.size();
		this.titlePrincipal=titlePrincipal;
		this.titleAxisY=titleAxisY;
		this.titleAxisX=titleAxisX;
		this.valuesInY=values;
		this.setVisible(true);
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		int leftMargin=this.getLeftMargin();
		int topMargin=this.getTopMargin();
		this.pixelsIntervalX=this.getPixelsAxisX(leftMargin);
		this.pixelsIntervalY=this.getPixelsAxisY(topMargin);
		int gridLineX=topMargin;
		int gridLineY=this.getHeight()-topMargin;
		g.setColor(COLOR_AXIS);
		g.drawLine(leftMargin, topMargin, leftMargin, (this.getHeight()-topMargin));
		g.drawLine(leftMargin, (this.getHeight()-topMargin), (this.getWidth()-leftMargin), (this.getHeight()-topMargin));
		g.setColor(COLOR_GRID);
		for (int i = 0; i < this.numberIntevalX; i++) {
			
			gridLineX+=this.pixelsIntervalX;
			g.drawLine(gridLineX, topMargin, gridLineX, (this.getHeight()-topMargin+SIZE_OF_LINE));
		}
		for (int i = 0; i <this.numberIntervalY; i++) {
			gridLineY-=this.pixelsIntervalY;
			g.drawLine((leftMargin-SIZE_OF_LINE), gridLineY, (this.getWidth()-leftMargin), gridLineY);
		}
		this.paintValues(g, leftMargin, topMargin, this.getHeight());
		this.paintLabels(g, topMargin, leftMargin,this.getHeight(),this.getWidth());
		
	}
	
	private void paintLabels(Graphics g,int topMargin,int leftMargin,int height,int width) {
		g.setColor(Color.BLACK);
		int labelYNum=0;
		int tempAxisY=height-topMargin;
		int tempAxisX=leftMargin;
		int titleTemp=topMargin;
		int [][]triangleXAxis= {{(width-leftMargin),(width-leftMargin),width-(leftMargin/2)},{(height-topMargin-SIZE_OF_LINE),(height-topMargin+SIZE_OF_LINE),(height-topMargin)}};
		int [][]trianleYAxis= {{(leftMargin-SIZE_OF_LINE),(leftMargin+SIZE_OF_LINE),leftMargin},{topMargin,topMargin,topMargin/2}};
		for (int i = 0; i < this.numberIntervalY; i++) {
			labelYNum+=labelIntervalY;
			tempAxisY-=pixelsIntervalY;
			g.drawString(""+labelYNum, (int)(leftMargin-4.5*SIZE_OF_LINE), (tempAxisY+SIZE_OF_LINE));
		}
		for (int i = 0; i < this.numberIntevalX; i++) {
			tempAxisX+=pixelsIntervalX;
			g.drawString(labelAxisX.get(i), (tempAxisX-3*SIZE_OF_LINE), (height-topMargin+3*SIZE_OF_LINE));
		}
		g.setColor(COLOR_AXIS);
		Polygon triangleX=new Polygon(triangleXAxis[0], triangleXAxis[1], 3);
		g.fillPolygon(triangleX);
		Polygon triangleY=new Polygon(trianleYAxis[0], trianleYAxis[1], 3);
		g.fillPolygon(triangleY);
		
		g.drawString(titlePrincipal, (width/2), topMargin/2);
		g.drawString(titleAxisX, (width/2), (height-(topMargin)/2));
		
		for (int i = 0; i < this.titleAxisY.length(); i++) {
			titleTemp+=2*SIZE_OF_LINE;
			g.drawString(""+titleAxisY.charAt(i), 2*SIZE_OF_LINE, titleTemp);
		}
		
	}
	
	private void paintValues(Graphics g,int leftMargin,int topMargin,int heigth) {
		g.setColor(COLOR_BAR);
		double value=0;
		int x=0;
		int y=0;
		for (int i = 0; i < this.valuesInY.size(); i++) {
			value=valuesInY.get(i).doubleValue();
			x=leftMargin+this.getReferecePixels(1, this.pixelsIntervalX, (i+1))-(SIZE_OF_RECT/2);
			y=(heigth-topMargin)-this.getReferecePixels(this.labelIntervalY, this.pixelsIntervalY, value);
			g.fillRect(x, y, (int)(1.5*SIZE_OF_RECT), (heigth-topMargin-y));
		}
	}
	
	private int getReferecePixels(int intervalRefernce,int pixels,double value) {
		//interval----->pixels
		//values[i]---->x
		return (int) ((value*pixels)/intervalRefernce);
		
	}
	
	private int getLeftMargin() {
		return (PERCENTAGE_MARGIN*this.getWidth())/100;
	}
	
	private int getTopMargin() {
		return (PERCENTAGE_MARGIN*this.getHeight())/100;
	}
	
	private int getLabelIntervalY() {
		return this.yMax/this.numberIntervalY;
	}
	
	private int getPixelsAxisY(int topMargin){
		return (this.getHeight()-topMargin-topMargin)/this.numberIntervalY;
	}
	
	private int getPixelsAxisX(int leftMargin){
		return (this.getWidth()-leftMargin-leftMargin)/this.numberIntevalX;
	}
	
}