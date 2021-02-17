package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.tbpbo.bodymassindex.Constanta.Constant;
import ir.androidexception.andexalertdialog.AndExAlertDialog;
import ir.androidexception.andexalertdialog.AndExAlertDialogListener;
import ir.androidexception.andexalertdialog.Font;
import ir.androidexception.andexalertdialog.InputType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.flatdialoglibrary.dialog.FlatDialog;

import id.tbpbo.bodymassindex.Model.Login.LoginModel;
import id.tbpbo.bodymassindex.Network.RestServiceClass;
import id.tbpbo.bodymassindex.Network.RestServiceInterface;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG ="LOGINTAG";
    View bg;
    Context mContext;
    ProgressDialog loading;
    @BindView(R.id.unameL)
    EditText uname;
    InternalStorage internalStorage;
    @BindView(R.id.pnameL)
    EditText pname;
    private RestServiceInterface restServiceInterface;
    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        restServiceInterface    = RestServiceClass.getClient().create(RestServiceInterface.class);
        // ADD SPACE TOP DRAWER ON LOLLIPOP AND UP
        internalStorage = new InternalStorage();
        internalStorage.openShared(this);
        mSettings = getSharedPreferences(Constant.key_shared, Context.MODE_PRIVATE);
        ButterKnife.bind(this);
        bg = findViewById(R.id.loginsignup19_bg);
        mContext =this;

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.loginsignup_menu, menu);
//        return true;
//    }

    public void attemptLogin(String email, String password, Context context){
        Call<LoginModel> calls = restServiceInterface.loginApi(email, password);
        try {
            calls.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    LoginModel model = response.body();
                    if (model.getSuccess()){
                        // Jika login berhasil maka data nama yang ada di response API
                        // akan diparsing ke activity selanjutnya.
                        internalStorage.setString(Constant.name_shared,model.getData().getData().getName());
                        internalStorage.setInt(Constant.id_shared,model.getData().getData().getId());
                        internalStorage.setString(Constant.email_shared,model.getData().getData().getEmail());
                        internalStorage.setBoolean(Constant.logged_shared,true);
                        Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                        loading.dismiss();
                        Intent intent = new Intent(mContext, MainActivity.class);
                        startActivity(intent);
                    } else {
                        // Jika login gagal
                        loading.dismiss();
                        Toast.makeText(mContext, model.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    loading.dismiss();
                    Log.d(TAG, "onFailure: "+t.getMessage());
                }
            });
        }catch (Exception e ){
            loading.dismiss();
            Log.d(TAG, "onFailure: "+e.getMessage());
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.btnCreateAccount:
//                Toast.makeText(this, "Create An Account button clicked!", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.btnSignIn:
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                attemptLogin(uname.getText().toString(),pname.getText().toString(),getApplicationContext());
                break;
            case R.id.txtSignUp:
                Intent i = new Intent(this,RegisterActivity.class);
                startActivity(i);
                break;
            case R.id.btnAsGuest:
                Intent a = new Intent(this,NameActivity.class);
                startActivity(a);
                break;
            default:
                break;
        }
    }
}
