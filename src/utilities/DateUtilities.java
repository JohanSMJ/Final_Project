package utilities;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.text.Utilities;

public class DateUtilities {
	public static String getStringDateNow() {
		String age = "";
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		int calendarTime = Calendar.DAY_OF_MONTH;
		int temp = now.get(calendarTime);
		now.set(calendarTime, temp);
		SimpleDateFormat formatoFecha = new SimpleDateFormat();
		formatoFecha.setTimeZone(TimeZone.getTimeZone("GMT-6"));
		Date fechaSum = now.getTime();
		formatoFecha.applyPattern("dd/MM/yyyy");
		String fechaRespuesta = formatoFecha.format(fechaSum);
		System.out.println(fechaRespuesta);
		return fechaRespuesta;
	}

	public static Calendar getCalendarDateNow() {
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		int calendarTime = Calendar.DAY_OF_MONTH;
		int temp = now.get(calendarTime);
		now.set(calendarTime, temp);
		return now;
	}

	public static String getCalculeTime(Calendar date) {
		String time = "";
		if (date.getTime().getMonth() < DateUtilities.getCalendarDateNow().getTime().getMonth())
			time = "" + (DateUtilities.getCalendarDateNow().getTime().getYear() - date.getTime().getYear()) ;
		if (date.getTime().getMonth() == DateUtilities.getCalendarDateNow().getTime().getMonth()) {
			if (date.getTime().getDate() <= DateUtilities.getCalendarDateNow().getTime().getDate()) {
				time = "" + (DateUtilities.getCalendarDateNow().getTime().getYear() - date.getTime().getYear()) ;
			} else {
				time = "" + (DateUtilities.getCalendarDateNow().getTime().getYear() - date.getTime().getYear()-1) ;
			}
		}
		if (date.getTime().getMonth() > DateUtilities.getCalendarDateNow().getTime().getMonth())
			time = "" + (DateUtilities.getCalendarDateNow().getTime().getYear() - date.getTime().getYear()-1) ;

		System.out.println(time);
		return time;
	}

	public static String calendarToString(Calendar date) {
		String year = date.getTime().getYear() + 1900 + "";
		String month = (date.getTime().getMonth() + 1) + "";
		String day = date.getTime().getDate() + "";
		return year + "/" + month + "/" + day;
	}
	public static boolean compareCalendar(Calendar date1,Calendar date2) {
		if(date1.equals(date2))
			return true;
		else
			return false;
	}
	public static Object[][] yearAmount(ArrayList<Calendar> list){
		ArrayList<String> years=new ArrayList<>();
		ArrayList<Object[]> demo=new  ArrayList<>();
		Object[] obj=new Object[2];
		for (int i = 0; i < list.size(); i++) {
			if(years.contains(list.get(i).getTime().getYear()+"")) {
				for (int j = 0; j < demo.size(); j++) {
					if(demo.get(i)[0].equals(list.get(i).getTime().getYear()+""))
						demo.get(i)[1]=(int)demo.get(i)[1]+1;
				}
			}else {
				years.add(list.get(i).getTime().getYear()+"");
				obj[0]=list.get(i).getTime().getYear()+"";
				obj[1]=1;
				demo.add(obj);
			}
		}
		Object[][] demoObj=new Object[demo.size()][2];
		for (int i = 0; i < demo.size(); i++) {
			demoObj[i]=demo.get(i);
		}
		return demoObj;
	}
	public static Calendar strigToCalendar(String calendar) {
		String [] dates=ReadUtilitites.splitSlash(calendar);
		Calendar date=Calendar.getInstance();
		date.set(Integer.parseInt(dates[0]), Integer.parseInt((String)dates[1]), Integer.parseInt((String)dates[2]));
		return date;
	}
	public static Calendar calendarAlAzar() {
		Calendar calendar=Calendar.getInstance();
		switch (ReadUtilitites.randomNumber(0, 15)) {
		case 1:
			calendar.set(1960,10,8);
			break;
		case 2:
			calendar.set(1961,11,21);
			break;
		case 3:
			calendar.set(1970,9,03);
			break;
		case 4:
			calendar.set(1970,6,21);
			break;
		case 5:
			calendar.set(1959,1,31);
			break;
		case 6:
			calendar.set(1958,5,16);
			break;
		case 7:
			calendar.set(1962,2,9);
			break;
		case 8:
			calendar.set(1980,10,11);
			break;
		case 9:
			calendar.set(1940,3,4);
			break;
		case 10:
			calendar.set(1961,6,19);
			break;
		case 11:
			calendar.set(1959,1,28);
			break;
		case 12:
			calendar.set(1980,9,19);
			break;
		case 13:
			calendar.set(1912,12,19);
			break;

		default:
			calendar.set(1960,10,8);
			break;
		}
		return calendar;
	}
}
