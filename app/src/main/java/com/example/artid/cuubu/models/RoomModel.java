package com.example.artid.cuubu.models;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.artid.cuubu.classes.Room;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class RoomModel {
    public static Room getRoom (String roomId) {
        final Room room = new Room(roomId);
        FirebaseFirestore db = FirebaseFirestore.getInstance();




        DocumentReference roomRef = db.collection("room").document(roomId);
        roomRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()) {
                        DocumentSnapshot roomData = task.getResult();
                        if (roomData.exists()) {
                            Log.d("document", "DocumentSnapshot data: " + roomData.getData());
                        } else {
                            Log.d("document", "No such document");
                        }
                        room.setRoomBuilding(roomData.getString("building"));
                        room.setRoomNo(roomData.getString("number"));
                        room.setType(roomData.getString("type"));
                    } else {
                        Log.d("document", "No such document");
                    }
                }
            });

        return room;
    }
}
