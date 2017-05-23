package ercanduman.dayofbirth_horoscopes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HoroscopeFragment extends Fragment {

    public HoroscopeFragment() {
        // Required empty public constructor
    }

    private View view;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_horoscope, container, false);

        initializeViews();
        return view;
    }

    public void sentVariables(int day, int month) {
        Log.v("initializeViews", "day: " + day + " month: " + month);

        textView.setText("the variables from Age fragment\n " +
                    "day: " + day +
                    "\nmonth: " + month);
    }

    private void initializeViews() {
        textView = (TextView) view.findViewById(R.id.horoscope_textview);
    }


}
