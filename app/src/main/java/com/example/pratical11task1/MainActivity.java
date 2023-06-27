package com.example.pratical11task1;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.CalendarView;
import android.widget.TimePicker;
import org.w3c.dom.Text;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;
    int mHour, mMinute;
    int d1,m1,y1,d2,m2,y2 = 0;
    int min1,min2,h1, h2;
    EditText firstdatetxt ;
    EditText firstTimetxt;
    EditText secondTimetxt, secondDatetxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button firstdate = (Button) findViewById(R.id.firstDate_btn);
        Button firsttime = (Button) findViewById(R.id.firstTime_btn);
        Button seconddate = (Button) findViewById(R.id.SecondDate_btn);
        Button secondtime = (Button) findViewById(R.id.SecondTime_btn);
        Button calc = (Button) findViewById(R.id.Cal_btn);
        TextView datedifftxt = (TextView) findViewById(R.id.DateDifftxt);
        TextView timedifftxt = (TextView) findViewById(R.id.TimeDifftxt);
        firstdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker(1);
            }
        });
        //FIRST TIME BUTTON CLICK
        firsttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker(1);
            }
        });
        seconddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker(2);
            }
        });
        //SECOND TIME BUTTON CLICK
        secondtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker(2);
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datedifftxt.setText("Date : "+(d1-d2)+"-"+(m1-m2)+"-"+(y1-y2));
                timedifftxt.setText("Time : "+(h1-h2)+" : "+(min1-min2));
            }
        });
    }
    private void datePicker(int i){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,int monthOfYear, int dayOfMonth) {
                        date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        if(i == 1) {
                            firstdatetxt = (EditText) findViewById(R.id.firstDatetxt);
                            firstdatetxt.setText(date_time);
                            d1 = dayOfMonth;
                            m1 = monthOfYear;
                            y1 = year;
                        }
                        else
                        {
                            secondDatetxt = (EditText) findViewById(R.id.SecondDatetxt);
                            secondDatetxt.setText(date_time);

                            d2 = dayOfMonth;
                            m2 = monthOfYear;
                            y2 = year;
                        }
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    private void TimePicker(int i)
    {
        final Calendar c=  Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        TimePickerDialog timepickerdialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int Minute) {
                if(i == 1) {
                    firstTimetxt = (EditText) findViewById(R.id.firstTimetxt);
                    firstTimetxt.setText(hourOfDay + ":" + Minute);
                    min1 = Minute;
                    h1 = hourOfDay;
                }
                else
                {
                    secondTimetxt = (EditText) findViewById(R.id.SecondTimetxt);
                    secondTimetxt.setText(hourOfDay+":"+Minute);
                    min2 = Minute;
                    h2 = hourOfDay;

                }
            }
        },mHour,mMinute,false);
        timepickerdialog.show();
    }
}
