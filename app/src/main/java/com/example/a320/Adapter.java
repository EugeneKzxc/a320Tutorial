package com.example.a320;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CourseViewHolder>
{

    Context context;
    List<Course> courses;

    public Adapter(Context context, List<Course> courses)
    {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new Adapter.CourseViewHolder((courseItems));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.CourseViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        int courseID = courses.get(position).getId();

        int imgId = context.getResources().getIdentifier(courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImg.setImageResource(imgId);
        imgId = context.getResources().getIdentifier(courses.get(position).getContent(), "drawable", context.getPackageName());
        holder.courseContentImg.setImageResource(imgId);

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context, CoursePage.class);
                intent.putExtra("course_id", courseID);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout courseBg;
        ImageView courseImg;
        ImageView courseContentImg;
        public CourseViewHolder(@NonNull View itemView)
        {
            super(itemView);
            courseBg = itemView.findViewById(R.id.courseBg);
            courseImg = itemView.findViewById(R.id.course_img);
            courseContentImg = itemView.findViewById(R.id.course_content);
        }
    }
}
