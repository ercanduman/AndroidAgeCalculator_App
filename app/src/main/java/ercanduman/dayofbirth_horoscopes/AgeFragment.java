package ercanduman.dayofbirth_horoscopes;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class AgeFragment extends Fragment {

    //view components
    private TextView todayTextView, bDateTextView, ageTextView, dayofBTextView, remaininDaysTextView;
    private Button setDateButton;

    View view;
    DialogFragment dialogFragment;

    public AgeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_age, container, false);

        initializeViews();

        return view;
    }

    private void initializeViews() {
        todayTextView = (TextView) view.findViewById(R.id.tvCurrentDay);
        bDateTextView = (TextView) view.findViewById(R.id.tvUserBirthDay);
        ageTextView = (TextView) view.findViewById(R.id.tvUsersAge);
        dayofBTextView = (TextView) view.findViewById(R.id.tvTheDayOfBirth);
        remaininDaysTextView = (TextView) view.findViewById(R.id.tvRemainingDaysForNextBday);

        setDateButton = (Button) view.findViewById(R.id.btnSetDate);
        setDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Date picker dialog will be triggered
                triggerDatePickerDialog();

            }
        });
    }

    private void triggerDatePickerDialog() {
        dialogFragment = new DatePickerFragment();
        dialogFragment.show(getActivity().getFragmentManager(), "Date Picker");
    }


    @Override
    public void onPause() {
        super.onPause();
        if (dialogFragment != null && dialogFragment.isVisible())
            dialogFragment.dismiss();
    }

    // Dialog Fragment
    @SuppressLint("ValidFragment")
    private class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        DatePickerDialog datePickerDialog;

        int startYear = 1972;
        int startMonth = 1;
        int startDay = 29;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            datePickerDialog = new DatePickerDialog(getActivity(),
                        AlertDialog.THEME_HOLO_LIGHT, this,
                        startYear, startMonth, startDay);
            datePickerDialog.show();

            return datePickerDialog;
        }

        @Override
        public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
            startYear = selectedYear;
            startMonth = selectedMonth;
            startDay = selectedDay;

            Locale.setDefault(getResources().getConfiguration().locale);

            Calendar calendar = Calendar.getInstance();
            calendar.set(startYear, startMonth, startDay);

            // display birthday
            bDateTextView.setText(getString(R.string.birthdate) + " " +
                        selectedDay + "." + (selectedMonth + 1) + "." + selectedYear);


            //calculate age

        }
    }
}
