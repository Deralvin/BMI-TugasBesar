package id.tbpbo.bodymassindex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class NameActivity extends AppCompatActivity {
    InternalStorage storage = new InternalStorage();
    @BindView(R.id.btnName) Button btnName;
    @BindView(R.id.tietText)
    EditText txtName;
//    @BindView(R.id.layoutName)
//    RelativeLayout relativeLayout;
    SharedPreferences mSettings;
    @OnClick(R.id.btnName)
    public void onButtonClick(View view) {

        if(txtName.getText().toString().equals(null)||txtName.getText().toString().equals("")){
            System.out.println("tesedsc");

            Toast.makeText(this, "Please Insert Your Name " ,
                    Toast.LENGTH_SHORT).show();
        }

        storage.setString(Constant.name_shared,txtName.getText().toString());

        Intent i = new Intent(this,UmurActivity.class);
        startActivity(i);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        ButterKnife.bind(this);

        mSettings = storage.openShared(this);


    }
}