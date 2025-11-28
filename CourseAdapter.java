package com.sololivre.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private List<Course> courses;

    public CourseAdapter(List<Course> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_item, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courses.get(position);
        
        holder.txtCourseName.setText(course.getName());
        holder.txtProfessor.setText(course.getProfessor());
        holder.txtRating.setText("⭐ " + course.getRating());
        holder.txtStudents.setText("👥 " + course.getStudents());
        holder.txtDuration.setText("🕐 " + course.getDuration());
        holder.txtPrice.setText(course.getPrice());
        holder.txtLevel.setText(course.getLevel());
        
        if (course.isCertified()) {
            holder.txtCertified.setVisibility(View.VISIBLE);
        } else {
            holder.txtCertified.setVisibility(View.GONE);
        }
        
        holder.imgCourse.setImageResource(course.getImageResource());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCourse;
        TextView txtCourseName, txtProfessor, txtRating, txtStudents;
        TextView txtDuration, txtPrice, txtLevel, txtCertified;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCourse = itemView.findViewById(R.id.imgCourse);
            txtCourseName = itemView.findViewById(R.id.txtCourseName);
            txtProfessor = itemView.findViewById(R.id.txtProfessor);
            txtRating = itemView.findViewById(R.id.txtRating);
            txtStudents = itemView.findViewById(R.id.txtStudents);
            txtDuration = itemView.findViewById(R.id.txtDuration);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtLevel = itemView.findViewById(R.id.txtLevel);
            txtCertified = itemView.findViewById(R.id.txtCertified);
        }
    }
}
