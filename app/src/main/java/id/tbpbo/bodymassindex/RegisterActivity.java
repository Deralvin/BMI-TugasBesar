package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.tbpbo.bodymassindex.Model.Register.RegisterModel;
import id.tbpbo.bodymassindex.Network.RestServiceClass;
import id.tbpbo.bodymassindex.Network.RestServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.name_register)
    EditText name ;
    @BindView(R.id.email_register)
    EditText email;
    @BindView(R.id.password_register)
    EditText password;
    ProgressDialog loading;
    Context mcontext;
    private RestServiceInterface restServiceInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mcontext = this;
        ButterKnife.bind(this);
        restServiceInterface    = RestServiceClass.getClient().create(RestServiceInterface.class);

    }

    private void attemptRegister(){
        loading = ProgressDialog.show(mcontext, null, "Proses SignUp...", true, false);
        Call<RegisterModel> resp = restServiceInterface.registerApi(name.getText().toString(),email.getText().toString(),password.getText().toString());
        try{
            loading.dismiss();

            resp.enqueue(new Callback<RegisterModel>() {
                @Override
                public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                    RegisterModel registerModel = response.body();
                    if (registerModel.getSuccess()){
                        Toast.makeText(mcontext, "Register Berhasil", Toast.LENGTH_SHORT).show();
                        Intent a = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(a);
                        finish();
                    }else{
                        Toast.makeText(mcontext, "Register Gagal "+registerModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<RegisterModel> call, Throwable t) {
                    Toast.makeText(mcontext, "Failure "+t.getCause(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            Toast.makeText(mcontext, "Failure "+e.getCause(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtSignIn:
                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
                break;
            case R.id.btnSignUp:

                attemptRegister();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}