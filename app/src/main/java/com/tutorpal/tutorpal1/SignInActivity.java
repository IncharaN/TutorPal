package com.tutorpal.tutorpal1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        final EditText editText = (EditText) findViewById(R.id.editText) ;
        final Context con = this;
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String user = editText.getText().toString();
                Intent intent = new Intent (con, MeetingListActivity.class);
                intent.putExtra("name", user);
                isTeacher = "teacher".equalsIgnoreCase(user);
                startActivity(intent);
            }
        });

    }

    public static boolean isTeacher;


    public static List<Meeting> meetingList;

    public static List<Student> students;

    public static Student currentStudent;

    public static Meeting currentMeeting;

    public class Meeting{
        String dateTime;
        List <String> studentNames;

        public List<String> getStudentNames() {
            return studentNames;
        }

        public void setStudentNames(List<String> studentNames) {
            this.studentNames = studentNames;

        }

        public String getDateTime() {
            return dateTime;


        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        @Override
        public String toString() {
            return dateTime;

        }
    }

}