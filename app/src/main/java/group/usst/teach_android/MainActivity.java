package group.usst.teach_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import group.usst.teach_android.signdate.OnSignedSuccess;
import group.usst.teach_android.signdate.SignDate;
import group.usst.teach_android.utils.Course;


public class MainActivity extends AppCompatActivity {

    SignDate signDate;


    private List<Course> courses=new ArrayList<>();

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses.add(new Course(new Date(2018,4,11),1));
        courses.add(new Course(new Date(2018,4,12),2));
        courses.add(new Course(new Date(2018,4,3),2));
        courses.add(new Course(new Date(2018,5,3),2));
        courses.add(new Course(new Date(2018,4,13),2));

        signDate = findViewById(R.id.signDate);
        signDate.setCourses(courses);
        signDate.setView();
        signDate.setOnSignedSuccess(new OnSignedSuccess() {
            @Override
            public void OnSignedSuccess() {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }





}
