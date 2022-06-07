package com.example.a320;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView courseRecycler;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "land_course", "land_content"));
        courseList.add(new Course(2,"takeoff_course", "takeoff_content"));
        courseList.add(new Course(3,"landing_course", "landing_content"));

        setCourseRecycler(courseList);
    }



    private void setCourseRecycler(List<Course> courseList)
    {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.Recycler);
        courseRecycler.setLayoutManager(layoutManager);
        adapter = new Adapter(this, courseList);
        courseRecycler.setAdapter(adapter);
    }
}
