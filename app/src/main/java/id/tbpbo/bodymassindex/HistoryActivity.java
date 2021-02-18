package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.tbpbo.bodymassindex.Constanta.Constant;
import id.tbpbo.bodymassindex.Model.History.Datum;
import id.tbpbo.bodymassindex.Model.History.HistoryModel;
import id.tbpbo.bodymassindex.Network.RestServiceClass;
import id.tbpbo.bodymassindex.Network.RestServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {
    private HistoryAdapter adapter;
    private RecyclerView recyclerView;
    private HistoryModel historyArrayList;

    @BindView(R.id.recyclerViewHistory)
    RecyclerView recyclerHistory;

    @BindView(R.id.fab_add_bmi)
    FloatingActionButton fab;
    HistoryModel historyModel = new HistoryModel();
    private RestServiceInterface restServiceInterface;
    private static final String TAG = "HISTOY";
    InternalStorage storage = new InternalStorage();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);
        storage.openShared(this);
        ButterKnife.bind(this);
        restServiceInterface    = RestServiceClass.getClient().create(RestServiceInterface.class);
        getAllData();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HistoryActivity.this,MainActivity.class);
                startActivity(a);
            }
        });



    }

    private void getAllData(){
        Call<HistoryModel> historyModelCall = restServiceInterface.getHistory(storage.getInt(Constant.id_shared));
        historyModelCall.enqueue(new Callback<HistoryModel>() {
            @Override
            public void onResponse(Call<HistoryModel> call, Response<HistoryModel> response) {
                Log.d(TAG, "onResponse: "+response.body().getData().size());
                historyArrayList = response.body();
                adapter = new HistoryAdapter(historyArrayList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HistoryActivity.this);

                recyclerHistory.setLayoutManager(layoutManager);

                recyclerHistory.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<HistoryModel> call, Throwable t) {

            }
        });
    }
}