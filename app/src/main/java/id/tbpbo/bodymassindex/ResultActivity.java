package id.tbpbo.bodymassindex;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import id.tbpbo.bodymassindex.Model.BMI.BmiCheck;
import id.tbpbo.bodymassindex.Model.BMI.Data;
import id.tbpbo.bodymassindex.Model.Category.CategoryModel;
import id.tbpbo.bodymassindex.Network.RestServiceClass;
import id.tbpbo.bodymassindex.Network.RestServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity {
    TextView commentTV;
    private RestServiceInterface restServiceInterface;
    CategoryModel categoryModel;
    String category,category_name;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        restServiceInterface    = RestServiceClass.getClient().create(RestServiceInterface.class);
        bundle = getIntent().getExtras();
        attemptCategory();
        LinearLayout containerL = findViewById(R.id.containerL);
        ImageView bmiFlagImgView = findViewById(R.id.bmiFlagImgView);
        TextView bmiLabelTV = findViewById(R.id.bmiLabelTV);
        commentTV = findViewById(R.id.commentTV);
        ImageView advice1IMG = findViewById(R.id.advice1IMG);
        TextView advice1TV = findViewById(R.id.advice1TV);
        ImageView advice2IMG = findViewById(R.id.advice2IMG);
        ImageView advice3IMG = findViewById(R.id.advice3IMG);
        TextView advice2TV = findViewById(R.id.advice2TV);
        TextView advice3TV = findViewById(R.id.advice3TV);
        TextView bmiValueTV = findViewById(R.id.bmiValueTV);
        DecimalFormat df = new DecimalFormat("#.##");
        String data = getIntent().getStringExtra("jumlah");
        Log.d("SDsf", "onCreate: "+data);
        Double bmi =Double.parseDouble(data);

        bmiLabelTV.setText(getIntent().getStringExtra("message"));
        Log.d("DSS", "onCreate: "+category );
        if (bmi == -1.0) {
            containerL.setVisibility( View.GONE);
        } else {
            bmiValueTV.setText(bmi.toString());
            if (bmi < 18.5) {
                containerL.setBackgroundResource(R.color.colorYellow);
                bmiFlagImgView.setImageResource(R.drawable.warning);
//                bmiLabelTV.setText("You have an UnderWeight!");
//                commentTV.setText(category);
                advice1IMG.setImageResource(R.drawable.nowater);
                advice1TV.setText("Don't drink water before meals");
                advice2IMG.setImageResource(R.drawable.bigmeal);
                advice2TV.setText("Use bigger plates");
                advice3TV.setText("Get quality sleep");

            } else {
                if (bmi > 25) {
                    containerL.setBackgroundResource(R.color.colorRed);
                    bmiFlagImgView.setImageResource(R.drawable.warning);
//                    bmiLabelTV.setText("You have an OverWeight!");
//                    commentTV.setText(category);
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

    @Override
    public void onBackPressed() {
        Intent a = new Intent(ResultActivity.this,MenuActivity.class);
        startActivity(a);
        finish();
    }

    private void attemptCategory(){
        Log.d("Category", "Head Attempt");
        Call<CategoryModel> getCategory= restServiceInterface.checkCategory();
        try {
            getCategory.enqueue(new Callback<CategoryModel>() {
                @Override
                public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                    categoryModel = response.body();
                    Log.d("Category Get", "onResponse: "+response.body().getSuccess());
                    Log.d("Category Message", "onResponse: "+response.body().getMessage());
                   if (categoryModel.getSuccess()){
                       Log.d("Category Size", "onResponse: "+response.body().getData().size());
                       for (int i = 0 ; i<categoryModel.getData().size(); i++){
                           if(categoryModel.getData().get(i).getIdKategori().equals(getIntent().getIntExtra("id_kategori",0))){
                               category = categoryModel.getData().get(i).getKeterangan();
                               category_name = categoryModel.getData().get(i).getNamaKategori();
                               Log.d("Category", "onResponse: "+category);

                               commentTV.setText(category);
                               break;
                           }
                           Log.d("Category Get", "onResponse: "+response.body().getData().get(i).getKeterangan());
                       }
                   }else {
                       Toast.makeText(ResultActivity.this, "Error Failed Get Category", Toast.LENGTH_SHORT).show();
                       Log.d("False", "onResponse: ");
                   }
                }

                @Override
                public void onFailure(Call<CategoryModel> call, Throwable t) {
                    Log.d("CategoryFailure", "onResponse: "+t.getMessage());
                }
            });
        }catch (Exception e){
            Log.e("ERROR CATEGORY", "attemptCategory: "+e.getMessage());
        }
    }
}