package com.poly.moneylover.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poly.moneylover.R;
import com.poly.moneylover.models.CaiDatCoBan;

import java.util.List;

public class CaiDatCoBanAdapter extends RecyclerView.Adapter<CaiDatCoBanAdapter.CaiDatCoBanViewHolder> {
    private List<CaiDatCoBan> caiDatCBList;

    public CaiDatCoBanAdapter(List<CaiDatCoBan> caiDatCBList) {
        this.caiDatCBList = caiDatCBList;
    }

    @NonNull
    @Override
    public CaiDatCoBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cai_dat_co_ban, parent, false);
        return new CaiDatCoBanViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CaiDatCoBanViewHolder holder, int position) {
        CaiDatCoBan caiDatCoBan = caiDatCBList.get(position);
        holder.imgCaiDatCoBan.setImageResource(caiDatCoBan.getImgCDCB());
        holder.nameCaiDatCoBan.setText(caiDatCoBan.getNameCDCB());
    }

    @Override
    public int getItemCount() {
        return caiDatCBList.size();
    }

    public static class CaiDatCoBanViewHolder extends RecyclerView.ViewHolder{

        ImageView imgCaiDatCoBan;
        TextView nameCaiDatCoBan;

        public CaiDatCoBanViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCaiDatCoBan = itemView.findViewById(R.id.img_CDCB);
            nameCaiDatCoBan = itemView.findViewById(R.id.tv_nameCDCB);
        }
    }
}
