package id.tbpbo.bodymassindex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText height = findViewById(R.id.heightEDTX);
        TextView weight = findViewById(R.id.weightEDTX);
        double value;
        Button btn_calculate = findViewById(R.id.calculateBtn);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text =height.getText().toString();
                String text2 = weight.getText().toString();
                double val_height = Double.parseDouble(text)/100;
                double val_weight = Double.parseDouble(text2);
                calculateBMI(val_weight,val_height);
                Intent a = new Intent(MainActivity.this,ResultActivity.class);
                a.putExtra("value",calculateBMI(val_weight,val_height));
                startActivity(a);
            }
        });
    }

    private double calculateBMI(double weight, double height){
        BigDecimal currentDecimal = new BigDecimal(weight/(height*height)).setScale(2,RoundingMode.HALF_EVEN);
        double data = Double.parseDouble(currentDecimal.toString());
        return data;
    }
}