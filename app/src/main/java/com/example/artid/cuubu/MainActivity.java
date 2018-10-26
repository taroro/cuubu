package com.example.artid.cuubu;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.artid.cuubu.classes.Class;
import com.example.artid.cuubu.classes.Room;
import com.example.artid.cuubu.models.ClassModel;
import com.example.artid.cuubu.models.RoomModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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

        CollectionReference classRef = firebaseDB.collection("class");
        classRef.whereEqualTo("subject", "1143102-59")
            .whereEqualTo("semester", 1)
            .whereEqualTo("year", "2560")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {@Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()) {
                        for (QueryDocumentSnapshot classData : task.getResult()) {
                            final Class classRoom = new Class();
                            firebaseDB.collection("class")
                                    .document(classData.getId())
                                    .collection("dateTime")
                                    .whereEqualTo("dayOfWeek", "MON")
                                    .get()
                                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> taskClass) {
                                            for (final QueryDocumentSnapshot classes : taskClass.getResult()) {
                                                String roomId = classes.getString("room");

                                                DocumentReference roomRef = firebaseDB.collection("room").document(roomId);
                                                roomRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                        DocumentSnapshot roomData = task.getResult();
                                                        Room room = new Room(roomData.getId());

                                                        room.setRoomBuilding(roomData.getString("building"));
                                                        room.setRoomNo(roomData.getString("number"));
                                                        room.setType(roomData.getString("type"));

                                                        classRoom.setDayOfWeek(classes.getString("dayOfWeek"));
                                                        classRoom.setStartTime(classes.getString("startTime"));
                                                        classRoom.setEndTime(classes.getString("endTime"));
                                                        classRoom.setRoomNo(roomData.getId());
                                                    }
                                                });
                                            }
                                        }
                                    });
                        }
                    } else { }
                }
            });



    }
}
