package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.tbpbo.bodymassindex.Constanta.Constant;

public class MenuActivity extends AppCompatActivity {
    @BindView(R.id.card_bmr)
    CardView bmr;
    @BindView(R.id.card_bmi)
    CardView bmi;
    InternalStorage internalStorage = new InternalStorage();
    Toolbar mActionBarToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        internalStorage.openShared(this);
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_menu);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Hello");
        getSupportActionBar().setSubtitle(internalStorage.getString(Constant.name_shared));
        ButterKnife.bind(this);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MenuActivity.this,HistoryActivity.class);
                startActivity(a);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.logout:
            //add the function to perform here
            return(true);
    }
        return(super.onOptionsItemSelected(item));
    }
}