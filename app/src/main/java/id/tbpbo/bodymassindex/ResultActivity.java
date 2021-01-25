package id.tbpbo.bodymassindex;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = getIntent().getExtras();
        LinearLayout containerL = findViewById(R.id.containerL);
        ImageView bmiFlagImgView = findViewById(R.id.bmiFlagImgView);
        TextView bmiLabelTV = findViewById(R.id.bmiLabelTV);
        TextView commentTV = findViewById(R.id.commentTV);
        ImageView advice1IMG = findViewById(R.id.advice1IMG);
        TextView advice1TV = findViewById(R.id.advice1TV);
        ImageView advice2IMG = findViewById(R.id.advice2IMG);
        ImageView advice3IMG = findViewById(R.id.advice3IMG);
        TextView advice2TV = findViewById(R.id.advice2TV);
        TextView advice3TV = findViewById(R.id.advice3TV);
        TextView bmiValueTV = findViewById(R.id.bmiValueTV);
        Double bmi = bundle.getDouble("value",-1.0);

        if (bmi == -1.0) {
            containerL.setVisibility( View.GONE);
        } else {
            bmiValueTV.setText(bmi.toString());
            if (bmi < 18.5) {
                containerL.setBackgroundResource(R.color.colorYellow);
                bmiFlagImgView.setImageResource(R.drawable.warning);
                bmiLabelTV.setText("You have an UnderWeight!");
                commentTV.setText("Here are some advices To help you increase your weight");
                advice1IMG.setImageResource(R.drawable.nowater);
                advice1TV.setText("Don't drink water before meals");
                advice2IMG.setImageResource(R.drawable.bigmeal);
                advice2TV.setText("Use bigger plates");
                advice3TV.setText("Get quality sleep");

            } else {
                if (bmi > 25) {
                    containerL.setBackgroundResource(R.color.colorRed);
                    bmiFlagImgView.setImageResource(R.drawable.warning);
                    bmiLabelTV.setText("You have an OverWeight!");
                    commentTV.setText("Here are some advices To help you decrease your weight");
                    advice1IMG.setImageResource(R.drawable.water);
                    advice1TV.setText("Drink water a half hour before meals");
                    advice2IMG.setImageResource(R.drawable.twoeggs);
                    advice2TV.setText("Eeat only two meals per day and make sure that they contains a high protein");
                    advice3IMG.setImageResource(R.drawable.nosugar);
                    advice3TV.setText("Drink coffee or tea and Avoid sugary food");
                }
            }
        }

    }
}