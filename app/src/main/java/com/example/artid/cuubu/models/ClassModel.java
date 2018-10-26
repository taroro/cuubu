package com.example.artid.cuubu.models;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.artid.cuubu.classes.Class;
import com.example.artid.cuubu.classes.Room;
import com.example.artid.cuubu.classes.Subject;
import com.example.artid.cuubu.classes.Teacher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ClassModel {

    public static Class getClassRoom(String subjectId, int semester, String year, final String dayOfWeek) {
        final Class classRoom = new Class();
        final FirebaseFirestore firebaseDB = FirebaseFirestore.getInstance();
        firebaseDB.collection("class")
            .whereEqualTo("subject", subjectId)
            .whereEqualTo("semester", semester)
            .whereEqualTo("year", year)
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()) {
                        for (QueryDocumentSnapshot classData : task.getResult()) {
                            firebaseDB.collection("class")
                                .document(classData.getId())
                                .collection("dateTime")
                                .whereEqualTo("dayOfWeek", "MON")
                                .get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> taskClass) {
                                        for (QueryDocumentSnapshot classes : taskClass.getResult()) {
                                            String dayOfWeek = classes.getString("dayOfWeek");
                                            String startTime = classes.getString("startTime");
                                            String endTime = classes.getString("endTime");
                                            String roomId = classes.getString("room");

                                            classRoom.setDayOfWeek(dayOfWeek);
                                            classRoom.setStartTime(startTime);
                                            classRoom.setEndTime(endTime);
                                            classRoom.setRoomNo(roomId);
                                        }
                                    }
                                });
                        }

                    } else {

                    }
                }
            });

        return classRoom;
    }
}
