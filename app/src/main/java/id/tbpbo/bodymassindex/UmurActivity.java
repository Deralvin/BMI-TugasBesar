package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.tbpbo.bodymassindex.Constanta.Constant;

public class UmurActivity extends AppCompatActivity {
    InternalStorage storage = new InternalStorage();
    @BindView(R.id.btnUmur)
    Button btnName;
    @BindView(R.id.umurText)
    EditText txtUmur;
    SharedPreferences mSettings;
    @OnClick(R.id.btnUmur)
    public void onButtonClick(View view) {

        if(txtUmur.getText().toString().equals(null)||txtUmur.getText().toString().equals("")){
            System.out.println("tesedsc");

            Toast.makeText(this, "Please Insert Your Age " ,
                    Toast.LENGTH_SHORT).show();
        }

        storage.setString(Constant.umur_shared,txtUmur.getText().toString());
        Intent i = new Intent(this,GenderActivity.class);
        startActivity(i);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umur);
        ButterKnife.bind(this);

        mSettings = storage.openShared(this);


    }
}