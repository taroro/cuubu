package com.example.artid.cuubu.models;

import android.support.annotation.NonNull;

import com.example.artid.cuubu.classes.Subject;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SubjectModel {
    public static Subject getSubject(String subjectId) {
        final Subject subject = new Subject(subjectId);
        FirebaseFirestore subjectDB = FirebaseFirestore.getInstance();
        DocumentReference subjectDocRef = subjectDB.collection("subject").document("1143102-59");
        subjectDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                subject.setTitle(documentSnapshot.getString("title"));
            }
        });

        return subject;
    }
}
