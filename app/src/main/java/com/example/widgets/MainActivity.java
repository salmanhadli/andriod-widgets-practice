package com.example.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    CheckBox cheeseBox, tomatoBox;
    Button btn;

//    RadioButton withDeliveryRadioBtn;

    RadioGroup deliveryRadioGrp;

    Spinner spinner;

    TimePicker timePicker;
    Button b2, b3;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // checkboxes
        cheeseBox = findViewById(R.id.checkboxCheese);
        tomatoBox = findViewById(R.id.checkboxTomoato);

        // button
        btn = findViewById(R.id.btn);

        // radio button
//        withDeliveryRadioBtn = findViewById(R.id.withDeliveryRadioBtn);

        // radio group
        deliveryRadioGrp = findViewById(R.id.deliveryRadioGrp);

        // spinner
        spinner = findViewById(R.id.spinner);
        String[] courses = {"C++", "Java", "Kotlin", "Data Structures"};
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);

        // time picker
//        timePicker = findViewById(R.id.timePicker);
//        timePicker.setIs24HourView(true);

        // setting current time
        // depreciated
//        String currentTime = "Time: " + timePicker.getCurrentHour()+" : " + timePicker.getCurrentMinute();
//        String currentTime = "Time: " + timePicker.getHour() + " : " + timePicker.getMinute();
//        Toast.makeText(this, "Time : " + currentTime, Toast.LENGTH_LONG).show();


        // time picker dialog
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(v -> {
            // Display the time picker
            DialogFragment timeFragment = new TimePickerFragment();
            timeFragment.show(getSupportFragmentManager(), "Pick Time Now!");
        });

        // date picker dialog
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(v -> {
            DialogFragment dateFragment = new DatePickerFragment();
            dateFragment.show(getSupportFragmentManager(), "Pick Date");
        });

        // progress-bar, default 100 value (max)
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
//        progressBar.incrementProgressBy();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Selected " + courses[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        deliveryRadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "Selected " + radioButton.getText(), Toast.LENGTH_LONG).show();
            }
        });

//        deliveryRadioGrp.setOnCheckedChangeListener((group, checkedId) -> {
//        });

//        withDeliveryRadioBtn.setOnClickListener(v -> {
//            Toast.makeText(this, "With Delivery selected", Toast.LENGTH_SHORT).show();
//        });

        btn.setOnClickListener(v -> {
            progressBar.incrementProgressBy(10);
            if (cheeseBox.isChecked()) {
                Toast.makeText(this, "Cheese topping is added", Toast.LENGTH_SHORT).show();
                cheeseBox.setChecked(false);
            }
            if (tomatoBox.isChecked()) {
                Toast.makeText(this, "Tomato topping is added", Toast.LENGTH_SHORT).show();
                tomatoBox.setChecked(false);
            }
        });

    }
}