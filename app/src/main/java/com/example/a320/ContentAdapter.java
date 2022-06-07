package com.example.a320;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.CourseItemViewHolder>
{

    Context context;
    List<Content> items;

    public ContentAdapter(Context context, List<Content> items)
    {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CourseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View courseContentItems = LayoutInflater.from(context).inflate(R.layout.course_content_item, parent, false);
        return new ContentAdapter.CourseItemViewHolder((courseContentItems));
    }

    @Override
    public void onBindViewHolder(@NonNull ContentAdapter.CourseItemViewHolder holder, int position)
    {
        int imgId = context.getResources().getIdentifier(items.get(position).getImg(), "drawable", context.getPackageName());
        holder.course_item_img.setImageResource(imgId);
        holder.course_item_text.setText(items.get(position).getText());

        String img = items.get(position).getImg();

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context, fullscreen_img.class);
                intent.putExtra("img_name", img);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    public static final class CourseItemViewHolder extends RecyclerView.ViewHolder
    {
        TextView course_item_text;
        ImageView course_item_img;
        public CourseItemViewHolder(@NonNull View itemView)
        {
            super(itemView);
            course_item_img = itemView.findViewById(R.id.course_item_img);
            course_item_text = itemView.findViewById(R.id.course_item_text);
        }
    }
}
