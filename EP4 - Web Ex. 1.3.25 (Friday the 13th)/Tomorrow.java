/******************************************************************************
 *
 * What is the date tomorrow?
 * 
 * $ java Tomorrow 7 4 2017
 * 8/4/2017
 * $ java Tomorrow 30 4 2017
 * 1/5/2017
 * $ java Tomorrow 31 12 2017
 * 1/1/2018
 * $ java Tomorrow 28 2 2016
 * 29/2/2016
 * $ java Tomorrow 29 2 2016
 * 1/3/2016
 * 
 ******************************************************************************/

public class Tomorrow {

    public static void main(String[] args) {
	int d = Integer.parseInt(args[0]);
	int m = Integer.parseInt(args[1]);
	int y = Integer.parseInt(args[2]);

	boolean leapYear;
        if (y % 400 == 0) leapYear = true;
        else if (y % 100 == 0) leapYear = false;
        else leapYear = y % 4 == 0;
	
	int[] DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	if (d + 1 <= DAYS[m] || d == 28 && leapYear) d++;
	else if (m < 12) { d = 1; m++; }
	else { d = 1; m = 1; y++; }

	System.out.println(d + "/" + m + "/" + y);
    }

}
