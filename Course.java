package com.sololivre.app;

public class Course {
    private String name;
    private String professor;
    private float rating;
    private int students;
    private String duration;
    private String price;
    private String level;
    private boolean certified;
    private int imageResource;

    public Course(String name, String professor, float rating, int students, 
                  String duration, String price, String level, boolean certified, int imageResource) {
        this.name = name;
        this.professor = professor;
        this.rating = rating;
        this.students = students;
        this.duration = duration;
        this.price = price;
        this.level = level;
        this.certified = certified;
        this.imageResource = imageResource;
    }

    public String getName() { return name; }
    public String getProfessor() { return professor; }
    public float getRating() { return rating; }
    public int getStudents() { return students; }
    public String getDuration() { return duration; }
    public String getPrice() { return price; }
    public String getLevel() { return level; }
    public boolean isCertified() { return certified; }
    public int getImageResource() { return imageResource; }
}
