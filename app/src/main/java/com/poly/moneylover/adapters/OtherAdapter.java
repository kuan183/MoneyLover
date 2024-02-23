package com.poly.moneylover.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poly.moneylover.R;
import com.poly.moneylover.models.otherItem;
import com.poly.moneylover.ui.OtherFragment;

import java.util.List;

public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.OtherViewHolder> {

    private List<otherItem> otherList;
//    private Context mContext;

    public OtherAdapter(List<otherItem> otherList) {
//        this.mContext = context;
        this.otherList = otherList;
    }

    @NonNull
    @Override
    public OtherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_other, parent, false);
        return new OtherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OtherViewHolder holder, int position) {
        final otherItem otherItem = otherList.get(position);
        holder.imgOther.setImageResource(otherItem.getImgOther());
        holder.nameOther.setText(otherItem.getNameOther());

//        holder.layoutItemOther.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onClickGoToCaiDatCoBan(otherItem);
//            }
//        });

    }

//    private void onClickGoToCaiDatCoBan (otherItem otherItem){
//        Intent intent = new Intent(mContext, CaiDatCoBanAdapter.class);
//        mContext.startActivity(intent);
//    }

    @Override
    public int getItemCount() {
        return otherList.size();
    }

    public static class OtherViewHolder extends RecyclerView.ViewHolder{
        LinearLayout layoutItemOther;
        ImageView imgOther;
        TextView nameOther;

        public OtherViewHolder(@NonNull View itemView) {
            super(itemView);

            imgOther = itemView.findViewById(R.id.img_other);
            nameOther = itemView.findViewById(R.id.tv_nameOther);
            layoutItemOther = itemView.findViewById(R.id.layout_ItemOther);
        }
    }
}
