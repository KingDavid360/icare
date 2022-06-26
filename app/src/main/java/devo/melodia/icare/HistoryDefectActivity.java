package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;
public class HistoryDefectActivity extends AppCompatActivity {

    Button geneticEyeDefectNextBtn, geneticDefectMyopiaBtn, geneticDefectHypermyopiaBtn,
    geneticDefectAstigmatismBtn, geneticDefectCataractsBtn,  geneticDefectPresbyopiaBtn;
    ImageView historyDefectBackBtn;
    EditText  username;
    boolean registered = false;
    String geneticEyeDefect = "null";
    SharedPreferences  pref;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_defect);

        username = findViewById(R.id.namePlainText);
        geneticEyeDefectNextBtn = findViewById(R.id.finishBtn);
        geneticDefectMyopiaBtn = findViewById(R.id.historyDefectMyopiaFormBtn);
        geneticDefectHypermyopiaBtn = findViewById(R.id.historyDefectHypermyopiaFormBtn);
        geneticDefectAstigmatismBtn = findViewById(R.id.historyDefectAstimagtismFormBtn);
        geneticDefectCataractsBtn = findViewById(R.id.historyDefectCataractsFormBtn);
        geneticDefectPresbyopiaBtn = findViewById(R.id.historyPresbyopiaBtn);
        historyDefectBackBtn = findViewById(R.id.historyDefectBackBtn);

        geneticDefectMyopiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                geneticDefectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                geneticDefectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticEyeDefect = (String) geneticDefectMyopiaBtn.getText().toString();
                geneticEyeDefectNextBtn.setEnabled(!geneticEyeDefect.isEmpty());
            }
        });

        geneticDefectHypermyopiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                geneticDefectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                geneticDefectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticEyeDefect = (String) geneticDefectHypermyopiaBtn.getText().toString();
                geneticEyeDefectNextBtn.setEnabled(!geneticEyeDefect.isEmpty());
            }
        });

        geneticDefectAstigmatismBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                geneticDefectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                geneticDefectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticEyeDefect = (String) geneticDefectAstigmatismBtn.getText().toString();
                geneticEyeDefectNextBtn.setEnabled(!geneticEyeDefect.isEmpty());
            }
        });

        geneticDefectCataractsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                geneticDefectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                geneticDefectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticEyeDefect = (String) geneticDefectCataractsBtn.getText().toString();
                geneticEyeDefectNextBtn.setEnabled(!geneticEyeDefect.isEmpty());
            }
        });

        geneticDefectPresbyopiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                geneticDefectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                geneticDefectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticDefectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                geneticEyeDefect = (String) geneticDefectPresbyopiaBtn.getText().toString();
                geneticEyeDefectNextBtn.setEnabled(!geneticEyeDefect.isEmpty());
            }
        });

        pref = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        geneticEyeDefectNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("registration", true);
                editor.commit();
                editor.putString("geneticEyeDefect", geneticEyeDefect);
                editor.commit();
                pref = getApplicationContext().getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
                String defectConfirm = pref.getString("defectConfirmation","");
                String historyDefect = pref.getString("geneticEyeDefect","");
                String eyeDefect = pref.getString("eyeDefect","");
                if(eyeDefect == "null") {
                    String usernameInput = pref.getString("username", "");
                    String ageRange = pref.getString("ageRange", "");
                    historyDefect = pref.getString("geneticEyeDefect", "");
                    eyeDefect = "null";
                    System.out.println("REACHS HERE");

                    UUID id = UUID.randomUUID();
                    UsersData data = new UsersData(usernameInput, ageRange, eyeDefect, historyDefect);
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("user");
                    reference.child(String.valueOf(id)).setValue(data);

                }

                String historyConfirm = pref.getString("historyDefectConfirmation","");
                if(historyDefect == "null") {
                    String usernameInput = pref.getString("username", "");
                    String ageRange = pref.getString("ageRange", "");
                    eyeDefect = pref.getString("eyeDefect", "");
                    historyDefect = "null";

                    UUID id = UUID.randomUUID();
                    UsersData data = new UsersData(usernameInput, ageRange, eyeDefect, historyDefect);
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("user");
                    reference.child(String.valueOf(id)).setValue(data);

                }
                startActivity(new Intent(HistoryDefectActivity.this, ConfirmationActivity.class));
            }
        });
        historyDefectBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HistoryDefectActivity.this, HistoryActivity.class));
            }
        });
    }
}