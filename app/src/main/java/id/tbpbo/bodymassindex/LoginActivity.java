package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Space;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    View bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // ADD SPACE TOP DRAWER ON LOLLIPOP AND UP

        bg = findViewById(R.id.loginsignup19_bg);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.loginsignup_menu, menu);
//        return true;
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.btnCreateAccount:
//                Toast.makeText(this, "Create An Account button clicked!", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.btnSignIn:
                Toast.makeText(this, "Button Signin clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtSignUp:
                Toast.makeText(this, "Sign Up clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignFacebook:
                Toast.makeText(this, "Sign In with Facebook clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
