package com.example.artid.cuubu;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.artid.cuubu.classes.Class;
import com.example.artid.cuubu.classes.Room;
import com.example.artid.cuubu.classes.Subject;
import com.example.artid.cuubu.models.RegisteredSubject;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore firebaseDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting the toolbar
        Toolbar toolbar =  findViewById(R.id.toolbar);
        TextView toolbarTitle = toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);

        firebaseDB = FirebaseFirestore.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();

        String studentEmail = "59110640147@ubu.ac.th";
        ArrayList<Subject> registerdSubject = RegisteredSubject.fetchRegisteredSubject(studentEmail);
    }
}
