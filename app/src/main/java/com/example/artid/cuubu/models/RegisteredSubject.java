package com.example.artid.cuubu.models;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.artid.cuubu.classes.Subject;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class RegisteredSubject {
    private static final String COLLECTION_STUDENTS = "student";
    private static final String COLLECTION_SUBJECT = "registeredSubject";
    private static final String TAG = "Registered Subject";

    public static ArrayList<Subject> fetchRegisteredSubject(String docId) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference colRefStudents = db.collection(COLLECTION_STUDENTS)
                .document(docId).collection(COLLECTION_SUBJECT);
        ArrayList<Subject> registerdSubject = new ArrayList<>();

        colRefStudents.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                    }
                } else {
                    Log.d(TAG, "No such document");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        return null;
    }
}
