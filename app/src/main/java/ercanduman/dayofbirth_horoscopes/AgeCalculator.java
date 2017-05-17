package ercanduman.dayofbirth_horoscopes;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by 7380 on 17.05.2017.
 */

public class AgeCalculator {

    public int startYear, startMonth, startDay;
    public int endYear, endMonth, endDay;
    private int resultYear, resultMonth, resultDay;
    private Calendar startCalendar, endCalendar;

    private String currentDay, dayOfBirth;

    public String getCurrentDay() {
        endCalendar = Calendar.getInstance();
        endYear = endCalendar.get(Calendar.YEAR);
        endMonth = endCalendar.get(Calendar.MONTH);

        //month starts from 0
        endMonth++;

        endDay = endCalendar.get(Calendar.DAY_OF_MONTH);

        currentDay = endCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());

        return currentDay + ", " + endDay + "." + endMonth + "." + endYear;
    }


    public void getUserInputs(int yy, int mm, int dd) {
        startYear = yy;
        startMonth = mm;
        startDay = dd;

        startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.YEAR, startYear);
        startCalendar.set(Calendar.MONTH, startMonth);
        startCalendar.set(Calendar.DAY_OF_MONTH, startDay);

        dayOfBirth = startCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void calculateYear() {
        resultYear = endYear - startYear;
    }

    public void calculateMonth() {
        if (endMonth >= startMonth) {
            resultMonth = endMonth - startMonth;
        } else {
            resultMonth = endMonth - startMonth;
            resultMonth = 12 + resultMonth;
            resultYear--;
        }
    }

    public void calculateDay() {
        if (endDay >= startDay) resultDay = endDay - startDay;
        else {
            resultDay = endDay - startDay;
            resultDay = 30 + resultDay;
            if (resultMonth == 0) {
                resultMonth = 11;
                resultYear--;
            } else resultMonth--;
        }
    }

    public int getResultYear() {
        return resultYear;
    }
}
