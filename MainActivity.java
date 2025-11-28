package com.sololivre.app;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCourses;
    private CourseAdapter courseAdapter;
    private List<Course> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerViewCourses = findViewById(R.id.recyclerViewCourses);
        recyclerViewCourses.setLayoutManager(new LinearLayoutManager(this));

        // Create sample data
        courseList = new ArrayList<>();
        courseList.add(new Course(
            "Violão do Zero ao Avançado",
            "Prof. Carlos Silva",
            4.9f,
            1243,
            "12 horas",
            "R$ 299",
            "Iniciante",
            true,
            R.drawable.course_guitar
        ));
        
        courseList.add(new Course(
            "Piano Clássico - Fundamentos",
            "Profa. Ana Martins",
            4.8f,
            892,
            "15 horas",
            "R$ 349",
            "Iniciante",
            true,
            R.drawable.course_piano
        ));
        
        courseList.add(new Course(
            "Guitarra Rock - Técnicas Essenciais",
            "Prof. Bruno Costa",
            4.7f,
            654,
            "10 horas",
            "R$ 279",
            "Intermediário",
            true,
            R.drawable.course_electric_guitar
        ));
        
        courseList.add(new Course(
            "Bateria para Iniciantes",
            "Prof. Ricardo Santos",
            4.6f,
            423,
            "8 horas",
            "R$ 249",
            "Iniciante",
            true,
            R.drawable.course_drums
        ));

        // Set adapter
        courseAdapter = new CourseAdapter(courseList);
        recyclerViewCourses.setAdapter(courseAdapter);

        // Featured course button
        MaterialButton btnStartFeatured = findViewById(R.id.btnStartFeatured);
        btnStartFeatured.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, 
                "Iniciando Curso Completo de Violão!", 
                Toast.LENGTH_SHORT).show();
        });
    }
}
