package com.shambhala.weightlosscalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.shambhala.adapter.ProfileAdapter;
import com.shambhala.calculations.Calculator;
import com.shambhala.entity.Person;

/*
The plan is to now clean up the look.
1) Aesthetics of the app.
2) Add more functionality, such as: a page of motivational messages and images.
   Update on point 2: maybe not that.
3) Settings activity for toggling of light and dark themes, as well as other things.
4) Add a notepad to track thoughts and feelings.
5) Add previous entries to a log.
6) Must add a slider from one activity to the next. There will only be two views to slide
   between.
 */

public class MainActivity extends AppCompatActivity {

    private EditText ageText;
    private EditText heightText;
    private EditText weightText;
    private TextView BMRText;
    private Spinner sexSpinner;
    private Spinner activitySpinner;
    private Button calculate;
    private ToggleButton BMRToggle;
    private RecyclerView rView;
    private RecyclerView.Adapter pAdapter;  //profileAdapter
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        rView = findViewById(R.id.r_view);
//
//        rView.setHasFixedSize(true);
//
//        lManager = new LinearLayoutManager(this);
//        rView.setLayoutManager(lManager);
//
//        pAdapter = new ProfileAdapter();

        ageText = findViewById(R.id.age_text);
        heightText = findViewById(R.id.height_text);
        weightText = findViewById(R.id.weight_text);
        BMRText = findViewById(R.id.BMR_text);
        sexSpinner = findViewById(R.id.sex_spinner);
        activitySpinner = findViewById(R.id.activity_spinner);
        calculate = findViewById(R.id.calculate_button);
        BMRToggle = findViewById(R.id.activity_toggle);

        BMRToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    BMRToggle.setChecked(true);
                }else{
                    BMRToggle.setChecked(false);
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person(Integer.parseInt(ageText.getText().toString()),
                        sexSpinner.getSelectedItem().toString(),
                        Double.parseDouble(weightText.getText().toString()),
                        Double.parseDouble(heightText.getText().toString()));

                Calculator calculator;

                if(BMRToggle.isChecked()){
                    calculator = new Calculator(person, activitySpinner.getSelectedItem().toString());
                }else{
                    calculator = new Calculator(person);
                }


                BMRText.setText(String.valueOf(calculator.getBMR()));
            }
        });


    }
}
