package com.poly.moneylover.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.poly.moneylover.R;
import com.poly.moneylover.adapters.Adapter_list;
import com.poly.moneylover.adapters.CalendarAdapter;
import com.poly.moneylover.models.Dto_item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarFragment extends Fragment {
    private TextView search;
    private ImageButton btnPrev;
    private TextView title;
    private ImageButton btnNext;
    private GridView calendarGrid;
    private TextView thunhap;
    private TextView chitieu;
    private TextView tong;
    private TextView sodudauki;
    private TextView soduhientai;
    private RecyclerView recList;

    Adapter_list adapter;
    CalendarAdapter adapter1;
    private ArrayList<Dto_item> arrayList = new ArrayList<>();

    private Calendar currentDate = Calendar.getInstance();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        calendarGrid = view.findViewById(R.id.calendarGrid);
        btnPrev = view.findViewById(R.id.btnPrev);
        btnNext =view. findViewById(R.id.btnNext);

        title= view.findViewById(R.id.title);

        search = (TextView) view.findViewById(R.id.search);
        thunhap = (TextView) view.findViewById(R.id.thunhap);
        chitieu = (TextView) view.findViewById(R.id.chitieu);
        tong = (TextView)view. findViewById(R.id.tong);
        sodudauki = (TextView)view. findViewById(R.id.sodudauki);
        soduhientai = (TextView)view. findViewById(R.id.soduhientai);
        recList = (RecyclerView) view.findViewById(R.id.rec_list);

        adapter = new Adapter_list(getActivity());
        ArrayList<Dto_item> sampleData = generateSampleData();
        adapter.setData(sampleData);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recList.setLayoutManager(linearLayoutManager2);
        recList.setAdapter(adapter);
        updateCalendar();

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });
        // Thêm OnItemClickListener cho GridView
        calendarGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Date selectedDate = (Date) parent.getItemAtPosition(position);
                SimpleDateFormat selectedDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String formattedDate = selectedDateFormat.format(selectedDate);

                // Hiển thị Toast khi ngày được chọn
                Toast.makeText(getContext(), "Selected Date: " + formattedDate, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void updateCalendar() {
        ArrayList<Date> cells = new ArrayList<>();
        Calendar calendar = (Calendar) currentDate.clone();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        while (cells.size() < 42) {
            cells.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        // Định dạng số tháng và năm
        SimpleDateFormat numberFormat = new SimpleDateFormat("MM/yyyy");
        String monthAndYear = numberFormat.format(currentDate.getTime());

        // Hiển thị số tháng và năm trong title
        title.setText(monthAndYear);

        CalendarAdapter calendarAdapter = new CalendarAdapter(getContext(), cells, currentDate);
        calendarGrid.setAdapter(calendarAdapter);
    }
    private ArrayList<Dto_item> generateSampleData() {
        ArrayList<Dto_item> data = new ArrayList<>();

        // Thêm một số dữ liệu mẫu
        data.add(new Dto_item(1, 1, "khong co", "1.000.000", "01/02/2024"));
        data.add(new Dto_item(2, 2, "", "200.000", "06/02/2024"));
        data.add(new Dto_item(3, 3, "", "99.000", "09/02/2024"));
        data.add(new Dto_item(4, 4, "", "20.000", "1/2/2024"));
        // Thêm một số dữ liệu mẫu
        data.add(new Dto_item(5, 5, "khong co", "1.000.000", "10/02/2024"));
        data.add(new Dto_item(6, 6, "", "200.000", "17/02/2024"));
        data.add(new Dto_item(7, 7, "", "99.000", "16/02/2024"));
        data.add(new Dto_item(8, 8, "", "20.000", "15/02/2024"));

        // Thêm một số dữ liệu mẫu
        data.add(new Dto_item(9, 4, "khong co", "1.000.000", "21/02/2024"));
        data.add(new Dto_item(10, 2, "", "200.000", "22/02/2024"));
        data.add(new Dto_item(11, 1, "", "99.000", "11/02/2024"));
        data.add(new Dto_item(12, 0, "", "20.000", "11/02/2024"));

        // ...

        // Khởi tạo CalendarAdapter với dữ liệu và trả về adapter


        return data;
    }

}