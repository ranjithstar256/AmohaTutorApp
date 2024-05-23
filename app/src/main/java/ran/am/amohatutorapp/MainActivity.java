package ran.am.amohatutorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextMobile;
    private EditText editTextTechnicalExpertise;
    private EditText editTextMail;
    private EditText editTextDescription;
    private Button buttonSubmit;
    TextView textView;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextTechnicalExpertise = findViewById(R.id.editTextTechnicalExpertise);
        editTextMail = findViewById(R.id.editTextMail);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textView = findViewById(R.id.tv);
        db = FirebaseFirestore.getInstance();
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String mobile = editTextMobile.getText().toString();
                String technicalExpertise = editTextTechnicalExpertise.getText().toString();
                String mail = editTextMail.getText().toString();
                String description = editTextDescription.getText().toString();

                String message = "Name: " + name + "\n" +
                        "Mobile: " + mobile + "\n" +
                        "Technical Expertise: " + technicalExpertise + "\n" +
                        "Mail ID: " + mail + "\n" +
                        "Description: " + description;


                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                textView.setText(message);


                Map<String, Object> tutor = new HashMap<>();
                tutor.put("name", name);
                tutor.put("mobile", mobile);
                tutor.put("technical_expertise", technicalExpertise);
                tutor.put("mail", mail);
                tutor.put("description", description);

                db.collection("tutors")
                        .add(tutor)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}