package id.tbpbo.bodymassindex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.tbpbo.bodymassindex.Model.History.Datum;
import id.tbpbo.bodymassindex.Model.History.HistoryModel;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {


    private HistoryModel dataList;

    public HistoryAdapter(HistoryModel dataList) {
        this.dataList = dataList;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        holder.txtNama.setText(dataList.getData().get(position).getNama());
        switch (dataList.getData().get(position).getIdKategori()){
            case 1:
                holder.txtNpm.setText("Kategori Underweight >18,5");
                break;
            case 2:
                holder.txtNpm.setText("Kategori Normal 18,5 - 22,9");
                break;
            case 3:
                holder.txtNpm.setText("Kategori overweight skor 23 - 24,9");
                break;
            case 4:
                holder.txtNpm.setText("Kategori obesitas 25 dan seterusnya");
                break;
            default:
                holder.txtNpm.setText("Kategori Tidak Ditemukan");
                break;
        }
        holder.txtNoHp.setText(dataList.getData().get(position).getJumlahBmi().toString());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.getData().size() : 0;
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNpm, txtNoHp;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtNpm = (TextView) itemView.findViewById(R.id.txt_npm_mahasiswa);
            txtNoHp = (TextView) itemView.findViewById(R.id.txt_nohp_mahasiswa);
        }
    }
}