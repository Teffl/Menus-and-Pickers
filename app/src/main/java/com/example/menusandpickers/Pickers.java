package com.example.menusandpickers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.widget.TimePicker;
import android.app.TimePickerDialog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Pickers extends AppCompatActivity {
    private TextView tvSelectedTime;
    private TextView tvSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickers);

        tvSelectedTime = findViewById(R.id.tv_selected_time);
        Button btnPickTime = findViewById(R.id.btn_pick_time);
        tvSelectedDate = findViewById(R.id.tv_selected_date);
        Button btnPickDate = findViewById(R.id.btn_pick_date);


        btnPickTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);


            TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, hourOfDay, minute1) -> {
                Calendar selectedTime = Calendar.getInstance();
                selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                selectedTime.set(Calendar.MINUTE, minute1);

                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                String time = sdf.format(selectedTime.getTime());

                tvSelectedTime.setText("Selected Time: " + time);
            }, hour, minute, false);
            timePickerDialog.show();
        });


        btnPickDate.setOnClickListener(v -> {
            DatePickerFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "datePicker");
        });
    }


    public void updateDate(int year, int month, int dayOfMonth) {

        String date = String.format(Locale.getDefault(), "%02d/%02d/%04d", dayOfMonth, month + 1, year);
        tvSelectedDate.setText("Selected Date: " + date);
    }


    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Pickers activity = (Pickers) getActivity();
            if (activity != null) {
                activity.updateDate(year, month, dayOfMonth);
            }
        }
    }
}


