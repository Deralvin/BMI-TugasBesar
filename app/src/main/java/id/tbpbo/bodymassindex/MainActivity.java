package id.tbpbo.bodymassindex;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.tbpbo.bodymassindex.Constanta.Constant;
import id.tbpbo.bodymassindex.Model.BMI.BmiCheck;
import id.tbpbo.bodymassindex.Model.Category.CategoryModel;
import id.tbpbo.bodymassindex.Network.RestServiceClass;
import id.tbpbo.bodymassindex.Network.RestServiceInterface;
import ir.androidexception.andexalertdialog.AndExAlertDialog;
import ir.androidexception.andexalertdialog.Font;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RestServiceInterface restServiceInterface;

    Context mContext;
    ProgressDialog loading;
    InternalStorage storage = new InternalStorage();
    String valueGender;
    @BindView(R.id.heightEDTX)
    EditText height;
    @BindView(R.id.weightEDTX)
    EditText weight;
    @BindView(R.id.nameEdtx)
    EditText nama;
    @BindView(R.id.umurEdtx)
    EditText umurTxt;
    @BindView(R.id.gMen)
    RadioButton gender_pria;
    @BindView(R.id.gWomen)
    RadioButton gender_women;
    @BindView(R.id.opsi)
    RadioGroup gender;
    @OnClick({R.id.gMen,R.id.gWomen})
    public void onRadioButtonClicked(RadioButton radioButton) {
        // Is the button now checked?
        boolean checked = radioButton.isChecked();

        // Check which radio button was clicked
        switch (radioButton.getId()) {
            case R.id.gMen:
                if (checked) {
                    // 1 clicked
                    valueGender = radioButton.getText().toString();
                }
                break;
            case R.id.gWomen:
                if (checked) {
                    valueGender =  radioButton.getText().toString();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restServiceInterface    = RestServiceClass.getClient().create(RestServiceInterface.class);

        ButterKnife.bind(this);
        mContext = this;
        storage.openShared(this);
        nama.setText(storage.getString(Constant.name_shared));
//        umurTxt.setText(storage.getString(Constant.umur_shared));
//        valueGender = storage.getString(Constant.gender_shared);
//        if(storage.getString(Constant.gender_shared).equals("Pria")){
//            gender_pria.setChecked(true);
//            gender_women.setChecked(false);
//
//        }else if(storage.getString(Constant.gender_shared).equals("Wanita")){
//            gender_pria.setChecked(false);
//            gender_women.setChecked(true);
//        }

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
//                loading = ProgressDialog.show(mContext, null, "Calculate...", true, false);
                checkBMI(nama.getText().toString(),weight.getText().toString(),height.getText().toString(),umurTxt.getText().toString(),valueGender,getApplicationContext());
//                checkCategory();
            }
        });
    }
    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
    private void checkBMI(String nama, String bb, String tb, String age, String gender, Context context){
        Call<BmiCheck>calls = restServiceInterface.checkBmi(nama,bb,tb,age,gender,storage.getInt(Constant.id_shared));
//        loading.cancel();
        try{
            calls.enqueue(new Callback<BmiCheck>() {
                @Override
                public void onResponse(Call<BmiCheck> call, Response<BmiCheck> response) {

                    BmiCheck resp = response.body();
                    DecimalFormat df = new DecimalFormat("#.##");
                        if (resp.getSuccess()){
                            Log.d("TAGGS", "onResponse: "+resp.getData().getIdKategori());
                            Log.d("TAGGS", "onResponse: "+df.format(resp.getData().getJumlahBmi()));
                            Log.d("TAGGS", "onResponse: "+resp.getData().getMessage());
                            Bundle bundle = new Bundle();
                            Log.d("TAG APAPUN", "onResponse: "+resp.getData().getIdKategori());
                            Intent a = new Intent(MainActivity.this,ResultActivity.class);
                            a.putExtra("id_kategori",resp.getData().getIdKategori());
                            a.putExtra("message",resp.getData().getMessage());
                            a.putExtra("jumlah",df.format(resp.getData().getJumlahBmi()));


                            bundle.putInt("id_kategori",resp.getData().getIdKategori());
                            bundle.putString("message",resp.getData().getMessage());
                            bundle.putString("jumlah",df.format(resp.getData().getJumlahBmi()));
                            a.putExtras(bundle);
                            startActivity(a);
//                            generateNoteOnSD(mContext,"myname","dsa");

                        }
//                    new AndExAlertDialog.Builder(context)
//                            .setTitle("Berhasil")
//                            .setMessage("Berhasil Melakukan perhitungan")
//                            .setPositiveBtnText("Ok")
//                       .build();
//    .setFont(Font.IRAN_SANS)
//                            .setImage(image, imagePercent)
//                            .setEditText(true, false, hintText, InputType.TEXT_MULTI_LINE)
//                            .OnPositiveClicked(positiveClickListener)
//                            .OnNegativeClicked(negativeClickListener)
//                            .setTitleTextColor(color)
//                            .setMessageTextColor(color)
//                            .setButtonTextColor(color)

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