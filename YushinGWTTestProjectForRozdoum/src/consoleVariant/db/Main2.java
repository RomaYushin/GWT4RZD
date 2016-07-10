package consoleVariant.db;

import java.util.Date;

/**
 * Created by Roman on 07.07.2016.
 */
public class Main2 {
    private static String s = "1990-07-09";

    public static void main(String[] args) {
        Date today = new Date();
        int todayYear = today.getYear()+1900;
        int todayMonth = today.getMonth()+1;
        int todayDay = today.getDate();

        System.out.println(todayYear);
        System.out.println(todayMonth);
        System.out.println(todayDay);


        String arr[] = s.split("-");
        int days = Integer.parseInt(arr[2]);
        int month = Integer.parseInt(arr[1]);
        int years = Integer.parseInt(arr[0]);

        System.out.println(years);
        System.out.println(month);
        System.out.println(days);

        int age = todayYear - years;

        /*if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }*/

        if (todayMonth < month) {
            --age;
        } else  if ( (todayMonth >= month) && (todayDay < days)) {
            --age;
        }

        System.out.println(age);



    }
}
