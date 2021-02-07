package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.tbpbo.bodymassindex.Constanta.Constant;

public class GenderActivity extends AppCompatActivity {
    InternalStorage storage = new InternalStorage();
    @BindView(R.id.btnGender)
    Button btnGender;
    @OnClick(R.id.btnGender)
    public void onButtonClick(View view) {
        storage.setString(Constant.gender_shared,valueGender);
        Intent a = new Intent(this,MainActivity.class);
        startActivity(a);
        finish();

    }

    String valueGender;
    @BindView(R.id.opsi)
    RadioGroup rdGender;
    SharedPreferences mSettings;
    @OnClick({R.id.priaRd,R.id.wanitaRd})

    public void onRadioButtonClicked(RadioButton radioButton) {
        // Is the button now checked?
        boolean checked = radioButton.isChecked();

        // Check which radio button was clicked
        switch (radioButton.getId()) {
            case R.id.priaRd:
                if (checked) {
                    // 1 clicked
                    valueGender = radioButton.getText().toString();
                    Toast.makeText(this, "Please Insert Your Age "+valueGender ,
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.wanitaRd:
                if (checked) {
                   valueGender =  radioButton.getText().toString();
                    Toast.makeText(this, "Please Insert Your Age " +valueGender,
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        ButterKnife.bind(this);

        mSettings = storage.openShared(this);

    }
}