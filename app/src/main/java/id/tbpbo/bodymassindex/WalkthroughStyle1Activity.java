package id.tbpbo.bodymassindex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import id.tbpbo.bodymassindex.Constanta.Constant;
import id.tbpbo.bodymassindex.Model.Walktrough.WalkthroughModel;
import id.tbpbo.bodymassindex.Utils.DatabaseHandler;

public class WalkthroughStyle1Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private View indicator1;
    private View indicator2;
    private View indicator3;
    private View indicator4;
    Button getStarted = findViewById(R.id.btnGetStarted);
//    private DatabaseHandler db;
SharedPreferences mSettings;
    InternalStorage storage = new InternalStorage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkthrough1_layout);
        mSettings = getSharedPreferences("Storage", Context.MODE_PRIVATE);
        indicator1 = findViewById(R.id.indicator1);
        indicator2 = findViewById(R.id.indicator2);
        indicator3 = findViewById(R.id.indicator3);
        indicator4 = findViewById(R.id.indicator4);

//        db = new DatabaseHandler(this);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new WizardPageChangeListener());
        viewPager.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.walkthrough1_viewpager_margin));
        viewPager.setOffscreenPageLimit(4);

        updateIndicators(0);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private int WIZARD_PAGES_COUNT = 4;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new WalkthroughStyle1Fragment(position,
                            "https://www.adobe.com/content/dam/cc/us/en/creativecloud/design/discover/vector-file/vector-file_P1_900x420.jpg.img.jpg",
                            "Body Mass Index 1",
                            "Sebuah aplikasi untuk mengukur ideal tubuh kita");
                case 1:
                    return new WalkthroughStyle1Fragment(position,
                            "https://www.adobe.com/content/dam/cc/us/en/creativecloud/design/discover/vector-file/vector-file_P1_900x420.jpg.img.jpg",
                            "Body Mass Index 2",
                            "Sebuah aplikasi untuk mengukur ideal tubuh kita");
                case 2:
                    return new WalkthroughStyle1Fragment(position,
                            "https://www.adobe.com/content/dam/cc/us/en/creativecloud/design/discover/vector-file/vector-file_P1_900x420.jpg.img.jpg",
                            "Body Mass Index 3",
                            "Sebuah aplikasi untuk mengukur ideal tubuh kita");
                case 3:
                    return new WalkthroughStyle1Fragment(position,
                            "https://www.adobe.com/content/dam/cc/us/en/creativecloud/design/discover/vector-file/vector-file_P1_900x420.jpg.img.jpg",
                            "Body Mass Index 4",
                            "Sebuah aplikasi untuk mengukur ideal tubuh kita");


            }
            return new WalkthroughStyle1Fragment(position,
                    "https://www.adobe.com/content/dam/cc/us/en/creativecloud/design/discover/vector-file/vector-file_P1_900x420.jpg.img.jpg",
                    "Body Mass Index 0",
                    "Sebuah aplikasi untuk mengukur ideal tubuh kita");


        }

        @Override
        public int getCount() {
            return WIZARD_PAGES_COUNT;
        }

    }

    private class WizardPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int position) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int position) {
            updateIndicators(position);
        }
    }

    public void updateIndicators(int position) {
        switch (position) {
            case 0:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                getStarted.setEnabled(false);
                break;
            case 1:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                getStarted.setEnabled(false);
                break;
            case 2:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                getStarted.setEnabled(false);
                break;
            case 3:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot));
                getStarted.setEnabled(true);

                break;
        }
    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.btnGetStarted:
//
//                break;
//            default:
//                break;
//        }
//    }
//
//      private void createNote() {
//        // inserting note in db and getting
//        // newly inserted note id
//          WalkthroughModel walkthroughModel = new WalkthroughModel();
//          walkthroughModel.setName("walk");
//          walkthroughModel.setStatus("true");
//          long id = db.addRecord(walkthroughModel);
//          if(!db.getAllRecord().isEmpty()){
//              Intent in = new Intent(WalkthroughStyle1Activity.this,LoginActivity.class);
//              startActivity(in);
//              finish();
//          }
//
//    }

}
