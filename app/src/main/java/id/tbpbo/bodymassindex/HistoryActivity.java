package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity {
//    @BindView(R.id.recyclerViewHistory)
//    RecyclerView.Recycler recyclerHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
    }
}