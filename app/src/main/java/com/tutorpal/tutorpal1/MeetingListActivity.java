package com.tutorpal.tutorpal1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

import static com.tutorpal.tutorpal1.SignInActivity.isTeacher;
import static com.tutorpal.tutorpal1.SignInActivity.students;

public class MeetingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        final Intent two = getIntent();
        final Context con = this;
        ListView listView = (ListView) findViewById(R.id.time);
        ArrayAdapter<DateAndTime> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.tutor_time);
        Random numbers = new Random();
        ArrayList<DateAndTime> data = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String a = numbers.nextInt(12) + 1 + "/" + numbers.nextInt(28) + 1;
            String b = numbers.nextInt(12) + 1 + " " + (numbers.nextInt() % 2 == 0 ? "a.m" : "p.m");
            DateAndTime date = new DateAndTime();
            date.setDate(a);
            date.setTime(b);
            data.add(date);
        }
        adapter.addAll(data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bundle = two.getExtras();
                final String j = bundle.getString("name");

                if (isTeacher) {
                    Intent intent = new Intent(con, MeetingListActivity.class);
                    startActivity(intent);
                } else {
                    AlertDialog alert = new AlertDialog.Builder(getApplicationContext())
                            .setTitle("Session Times")
                            .setMessage("RSVP?")
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //TODO get data of yes students and put it in a list that is visible for the teachers
                                    if (students==null) students=new ArrayList<>();
                                    Student student=new Student();
                                    student.name=j;
                                    students.add(student);
                                    dialog.cancel();

                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            }).create();
                    alert.show();
                }

            }
        });


    }
}




