package id.tbpbo.bodymassindex;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.tbpbo.bodymassindex.Constanta.Constant;
import id.tbpbo.bodymassindex.Model.BMI.BmiCheck;
import id.tbpbo.bodymassindex.Model.Category.CategoryModel;
import id.tbpbo.bodymassindex.Network.RestServiceClass;
import id.tbpbo.bodymassindex.Network.RestServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RestServiceInterface restServiceInterface;
    InternalStorage storage = new InternalStorage();
    @BindView(R.id.nameEdtx)
    EditText nama;
    @BindView(R.id.umurEdtx)
    EditText umurTxt;
    @BindView(R.id.gMen)
    RadioButton gender_pria;
    @BindView(R.id.gWomen)
    RadioButton gender_women;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText height = findViewById(R.id.heightEDTX);
        TextView weight = findViewById(R.id.weightEDTX);
        restServiceInterface    = RestServiceClass.getClient().create(RestServiceInterface.class);
        double value;
        ButterKnife.bind(this);
        storage.openShared(this);
        nama.setText(storage.getString(Constant.name_shared));
        umurTxt.setText(storage.getString(Constant.umur_shared));
        if(storage.getString(Constant.gender_shared).equals("Pria")){
            gender_pria.setChecked(true);
            gender_women.setChecked(false);
        }else if(storage.getString(Constant.gender_shared).equals("Wanita")){
            gender_pria.setChecked(false);
            gender_women.setChecked(true);
        }
        Button btn_calculate = findViewById(R.id.calculateBtn);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                String text =height.getText().toString();
//                String text2 = weight.getText().toString();
//                double val_height = Double.parseDouble(text)/100;
////                double val_weight = Double.parseDouble(text2);
//                calculateBMI(val_weight,val_height);
//                Intent a = new Intent(MainActivity.this,ResultActivity.class);
//                a.putExtra("value",calculateBMI(val_weight,val_height));
//                startActivity(a);
                checkBMI();
                checkCategory();
            }
        });
    }
    private void checkBMI(){
        Call<BmiCheck>calls = restServiceInterface.checkBmi("Alvin","60","180","20","P");
        try{
            calls.enqueue(new Callback<BmiCheck>() {
                @Override
                public void onResponse(Call<BmiCheck> call, Response<BmiCheck> response) {
//                    BmiCheck resp = response.body();
                    Log.d("FULL", "onResponse: "+response.body().getMessage());
                }

                @Override
                public void onFailure(Call<BmiCheck> call, Throwable t) {
                    Log.d("FAILESD", "onFailure: "+t.getMessage());
                    Log.d("FAILESD", "onFailure: "+t.getCause());
                }
            });

        }catch (Exception e){
            Log.d("EXCEPTION", "checkBMI: "+e.getMessage());
        }
    }

    private void checkCategory(){
        Call<CategoryModel> check = restServiceInterface.checkCategory();
        check.enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                Log.d("TESPR", "onResponse: "+response.body().getMessage().toString());
            }

            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {

            }
        });
    }
    private double calculateBMI(double weight, double height){
        BigDecimal currentDecimal = new BigDecimal(weight/(height*height)).setScale(2,RoundingMode.HALF_EVEN);
        double data = Double.parseDouble(currentDecimal.toString());
        return data;
    }
}