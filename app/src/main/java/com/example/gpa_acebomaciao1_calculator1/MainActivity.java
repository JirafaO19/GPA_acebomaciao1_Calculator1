package com.example.gpa_acebomaciao1_calculator1;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text5, button;
    EditText editText,editText2,editText3,editText4,editText5 ;
    double sumTotal,number1,number2,number3,number4,number5,ComputedGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        editText2=(EditText) findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);
        text5=findViewById(R.id.textView6);
        button=findViewById(R.id.button);

    }

    public void ComputingGPA(View view){

        try {

            if (!(editText.equals(""))||!(editText.equals(""))||(!editText.equals(""))||(!editText.equals(""))||(!editText.equals(""))){

                number1 = Double.parseDouble(editText.getText().toString());
                number2 = Double.parseDouble(editText2.getText().toString());
                number3 = Double.parseDouble(editText3.getText().toString());
                number4 = Double.parseDouble(editText4.getText().toString());
                number5 = Double.parseDouble(editText5.getText().toString());

            }


        }catch (NumberFormatException e){

            editText.setText(editText.getText().toString());
            editText2.setText(editText2.getText().toString());
            editText3.setText(editText3.getText().toString());
            editText4.setText(editText4.getText().toString());
            editText5.setText(editText5.getText().toString());


            new AlertDialog.Builder(this).setTitle("Error" )
                    .setMessage("You left an empty field, type a Number, please !")
                    .setPositiveButton("OK", null).show();

        }

        if (((number1>=0)&&(number1<=100))&&((number2>=0)&&(number2<=100))&&((number3>0)&&
                (number3<=100))&&((number4>=0)&&(number4<=100))&&((number5>=0)&&(number5<=100)))
        {
            sumTotal=number1+number2+number3+number4+number5;
            ComputedGPA=sumTotal/5;
            text5.setText("Computed GPA is: "+ComputedGPA);
            button.setText("Clear Form");
            Tying(editText);
            Tying(editText2);
            Tying(editText3);
            Tying(editText4);
            Tying(editText5);



            if (ComputedGPA<60){
               backgroundColor(Color.RED);

            }
            if ((ComputedGPA>=61)&(ComputedGPA<79)){
                backgroundColor(Color.YELLOW);

            }
            if ((ComputedGPA>=80)&(ComputedGPA<=100)){

                backgroundColor(Color.GREEN);


            }
        }


    }

    public void backgroundColor(int color){
        LinearLayout bgElement = (LinearLayout) findViewById(R.id.container);
        bgElement.setBackgroundColor(color);

    }

    public void Tying(TextView textView){
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Fires right as the text is being changed (even supplies the range of text)
                button.setText("Computes GPA");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
