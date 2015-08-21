package com.example.android.dsd;

import android.app.DatePickerDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A placeholder fragment containing a simple view.
 */
public class RegistrationActivityFragment extends Fragment implements View.OnFocusChangeListener {

    DatePickerDialog.OnDateSetListener bdateListener;
    Calendar bdateCalendar;
    EditText birth_date;

    public RegistrationActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_registration, container, false);
        birth_date = (EditText) rootView.findViewById(R.id.birth_date);
        birth_date.setOnFocusChangeListener(this);
        bdateCalendar = Calendar.getInstance();
        bdateListener = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                bdateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                bdateCalendar.set(Calendar.MONTH, monthOfYear);
                bdateCalendar.set(Calendar.YEAR, year);
                updateLabel(birth_date);
            }
        };

        return rootView;
    }

    public void updateLabel(EditText v) {

        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
            v.setText(sdf.format(bdateCalendar.getTime()));
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus)
        {
            new DatePickerDialog(getActivity(), bdateListener,
                        bdateCalendar.get(Calendar.YEAR),
                        bdateCalendar.get(Calendar.MONTH),
                        bdateCalendar.get(Calendar.DAY_OF_MONTH)).show();

        }
    }

}
