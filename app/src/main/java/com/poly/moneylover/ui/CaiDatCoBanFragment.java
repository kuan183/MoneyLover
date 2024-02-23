package com.poly.moneylover.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poly.moneylover.R;
import com.poly.moneylover.adapters.CaiDatCoBanAdapter;
import com.poly.moneylover.models.CaiDatCoBan;

import java.util.ArrayList;
import java.util.List;

public class CaiDatCoBanFragment extends Fragment {
    private List<CaiDatCoBan> caiDatCBList;
    private RecyclerView caiDatCBrecyclerView;
    private CaiDatCoBanAdapter caiDatCBAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cai_dat_co_ban, container, false);
        caiDatCBList = genarateCaiDatCoBanItem();
        caiDatCBrecyclerView = view.findViewById(R.id.caiDatCoBanRCV);
        caiDatCBrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        caiDatCBAdapter = new CaiDatCoBanAdapter(caiDatCBList);
        caiDatCBrecyclerView.setAdapter(caiDatCBAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //handle event
    }


    private List<CaiDatCoBan> genarateCaiDatCoBanItem(){

        List<CaiDatCoBan> caiDatCoBan = new ArrayList<>();
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Chi phí cố định và thu nhâập định kỳ"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Thêm danh mục"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Thiết lập số dư ban đầu"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Hiển thị số dư đầu kỳ trên báo cáo"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Chế độ hỗ trợ nhập liên tục"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Bàn phím như máy tính"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Ngày bắt đầu của tháng"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Ngày bắt đầu của năm"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Số tiền trên lịch"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Thứ bắt đầu của lịch"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Thứ tự hiển thị của đồ thị"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Thay đổi ngôn ngữ"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Thay đổi ngoại tệ"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Thông báo"));
        caiDatCoBan.add(new CaiDatCoBan(R.drawable.icon_add,"Xóa tất cả dữ liệu"));

        return caiDatCoBan;
    }
}