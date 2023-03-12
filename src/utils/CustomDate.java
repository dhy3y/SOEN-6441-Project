package utils;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
;

public class CustomDate {
   public static Calendar getDate (String inputDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;

    }
}
