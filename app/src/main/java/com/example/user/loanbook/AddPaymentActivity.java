package com.example.user.loanbook;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class AddPaymentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Context context;
    MyDb db;
    private DatePickerDialog.OnDateSetListener mDateSetLisener;
    public int id[];
    public String name[];
    Spinner spinner;
    TextView tv_ShowDate;
    String label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);
        context = this;
        db = new MyDb(this);
        spinner = (Spinner) findViewById(R.id.spn_name);
        tv_ShowDate = (TextView) findViewById(R.id.tv_showdate);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //first spinner complete
        spinner.setOnItemSelectedListener(this);
        loadSpineerData();

        //show date complete
        tv_ShowDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(context,
                        android.R.style.Theme_DeviceDefault_Dialog_Alert,
                        mDateSetLisener,
                        year, month, dayOfMonth);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                dialog.show();

            }
        });
        mDateSetLisener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = year + "/" + month + "/" + dayOfMonth;
                tv_ShowDate.setText(date);

            }
        };

    }
    //function to load the data from the spinner
    public void loadSpineerData() {
        //database handler
        MyDb db = new MyDb(this);
        List<String> labels = db.getName();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, labels);
        spinner.setAdapter(arrayAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        label = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(context, "You Selected:" + label, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
