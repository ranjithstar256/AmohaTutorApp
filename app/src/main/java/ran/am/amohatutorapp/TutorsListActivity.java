package ran.am.amohatutorapp;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class TutorsListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTutors;
    private TutorsAdapter tutorsAdapter;
    private List<Tutor> tutorsList = new ArrayList<>();
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors_list);

        recyclerViewTutors = findViewById(R.id.recyclerViewTutors);
        recyclerViewTutors.setLayoutManager(new LinearLayoutManager(this));
        tutorsAdapter = new TutorsAdapter(tutorsList);
        recyclerViewTutors.setAdapter(tutorsAdapter);

        db = FirebaseFirestore.getInstance();

        db.collection("tutors")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Tutor tutor = document.toObject(Tutor.class);
                                tutorsList.add(tutor);
                            }
                            tutorsAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(TutorsListActivity.this, "Error getting documents: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
