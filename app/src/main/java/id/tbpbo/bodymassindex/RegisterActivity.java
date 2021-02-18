package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.name_register)
    EditText name ;
    @BindView(R.id.email_register)
    EditText email;
    @BindView(R.id.password_register)
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtSignIn:
                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}