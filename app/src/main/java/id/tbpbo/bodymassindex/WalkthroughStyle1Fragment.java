package id.tbpbo.bodymassindex;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import id.tbpbo.bodymassindex.Utils.ImageViewCircleTransform;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class WalkthroughStyle1Fragment extends Fragment {
    int wizard_page_position;
    String urls;
    String title;
    String desc;

    public WalkthroughStyle1Fragment(int position,String urls,String title,String desc) {
        this.wizard_page_position = position;
        this.title = title;
        this.urls = urls;
        this.desc = desc;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.walkthrough1_fragment;
        View view = inflater.inflate(layout_id, container, false);
        TextView titlewalk = view.findViewById(R.id.title_walk);
        TextView descwalk = view.findViewById(R.id.description_walk);

        titlewalk.setText(title);
        descwalk.setText(desc);
        String url = urls;

        ImageView img = (ImageView) view.findViewById(R.id.imagePage1);
        loadImageRequest(img, url);

        return view;
    }

    private void loadImageRequest(ImageView img, String url) {
        Glide.with(getActivity())
                .load(url)
                .transform(new ImageViewCircleTransform(getActivity()))
//                .thumbnail(0.01f)
                .centerCrop()
                .into(img);
    }
}
