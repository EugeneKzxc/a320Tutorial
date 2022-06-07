package com.example.a320;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoursePage extends AppCompatActivity
{
    ContentAdapter contentAdapter;
    RecyclerView contentRecycler;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference myRef = db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int ID = getIntent().getIntExtra("course_id",0);
        String course_name;

        switch (ID)
        {
            case 1:
                course_name = "course_1";
                break;
            case 2:
                course_name = "course_2";
                break;
            case 3:
                course_name = "course_3";
                break;
            default:
                course_name = "";
        }

        myRef.child(course_name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if (snapshot.exists())
                {
                    long childrenCount = snapshot.getChildrenCount();
                    HashMap data = (HashMap) snapshot.getValue();
                    String itemName = "item_";
                    List<Content> contentList = new ArrayList<>();
                    for (int i = 0; i < childrenCount; i++)
                    {
                        itemName += i;
                        HashMap item = (HashMap) data.get(itemName);
                        String img = (String) item.get("img");
                        String text = (String) item.get("text");
                        contentList.add(new Content(i, img, text));
                        itemName = "item_";
                    }
                    setContentRecycler(contentList);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
            }
        });
    }

    private void setContentRecycler(List<Content> contentList)
    {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        contentRecycler = findViewById(R.id.ContentRecycler);
        contentRecycler.setLayoutManager(layoutManager);
        contentAdapter = new ContentAdapter(this, contentList);
        contentRecycler.setAdapter(contentAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
