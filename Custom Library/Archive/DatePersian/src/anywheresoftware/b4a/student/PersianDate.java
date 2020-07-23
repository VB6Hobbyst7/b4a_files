package anywheresoftware.b4a.student;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("PersianDate")
public class PersianDate {
	
	/**
	 * Get Perisan Date
	 * For Get Current Persian Date set all Parameter(year,month,day) to 0
	 */
	public String getDate(int year, int month, int day,String Separator)
	{
		Main m1;
		 if (year == 0 && month == 0 && day == 0)
		   m1 = new Main();	 
		 else
		   m1 = new Main(year,month,day);
		 
		return m1.getIranianYear() + Separator + m1.getIranianMonth() + Separator + m1.getIranianDay();
	}
}
