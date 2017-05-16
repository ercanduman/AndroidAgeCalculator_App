package ercanduman.dayofbirth_horoscopes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AgeFragment extends Fragment {

    private TextView todayTextView, bDateTextView, ageTextView, dayofBTextView, remaininDaysTextView;
    private Button setDateButton;

    View view;

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

            }
        });
    }

}
