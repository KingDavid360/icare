package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class ConfirmationActivity extends AppCompatActivity {

    TextView username, ageRangeValue, defectConfirmation, defectValue, geneticDefectConfirmation,geneticDefectValue;
    Button dashboardBtn;
    SharedPreferences pref;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confrimation_page);

        username = findViewById(R.id.namePlainText);
        ageRangeValue = findViewById(R.id.ageRangeValueTextView);
        defectConfirmation = findViewById(R.id.eyeDefectConfirmationTextView);
        defectValue = findViewById(R.id.eyeDefectValueTextView);
        geneticDefectConfirmation = findViewById(R.id.geneticEyeDefectConfirmationTextView);
        geneticDefectValue = findViewById(R.id.geneticEyeDefectValueTextView);
        dashboardBtn = findViewById(R.id.dashBoardBtn);
        pref = getApplicationContext().getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        System.out.println();
        String historyDefect = pref.getString("geneticEyeDefect","");
        String eyeDefect = pref.getString("eyeDefect","");
        System.out.println(eyeDefect);

        if(eyeDefect == "null") {
            String usernameInput = pref.getString("username", "");
            String ageRange = pref.getString("ageRange", "");
            historyDefect = pref.getString("geneticEyeDefect", "");
            eyeDefect = "null";
            System.out.println("REACHES HERE");
            UUID id = UUID.randomUUID();
            UsersData data = new UsersData(usernameInput, ageRange, eyeDefect, historyDefect);
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("user");
            reference.child(String.valueOf(id)).setValue(data);

        }else{
            String usernameInput = pref.getString("username", "");
            String ageRange = pref.getString("ageRange", "");
            historyDefect = pref.getString("geneticEyeDefect", "");
            eyeDefect = pref.getString("eyeDefect", "");;
            System.out.println("REACHS HERE");

            if(eyeDefect.isEmpty()){eyeDefect = "null";}

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

        }else{
            String usernameInput = pref.getString("username", "");
            String ageRange = pref.getString("ageRange", "");
            eyeDefect = pref.getString("eyeDefect", "");
            historyDefect =  pref.getString("geneticEyeDefect", "");;

            if(historyDefect.isEmpty()){historyDefect = "null";}

            UUID id = UUID.randomUUID();
            UsersData data = new UsersData(usernameInput, ageRange, eyeDefect, historyDefect);
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("user");
            reference.child(String.valueOf(id)).setValue(data);
        }

        pref = getApplicationContext().getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        String ageRange = pref.getString("ageRange","");
        String defectConfirm = pref.getString("defectConfirmation","");
        if(eyeDefect == "null"){
            ageRangeValue.setText(ageRange);
            defectConfirmation.setText(defectConfirm);
            defectValue.setText("null");
        }else{
            ageRangeValue.setText(ageRange);
            defectConfirmation.setText(defectConfirm);
            defectValue.setText(eyeDefect);
        }

        if(historyDefect == "null"){
            ageRangeValue.setText(ageRange);
            geneticDefectConfirmation.setText(historyConfirm);
            geneticDefectValue.setText("null");
        }else{
            ageRangeValue.setText(ageRange);
            geneticDefectConfirmation.setText(historyConfirm);
            geneticDefectValue.setText(historyDefect);
        }

        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.remove("ageRange");
                editor.commit();
                editor.remove("defectConfirmation");
                editor.commit();
                editor.remove("eyeDefect");
                editor.commit();
                editor.remove("historyDefectConfirmation");
                editor.commit();
                editor.remove("geneticEyeDefect");
                editor.commit();
                startActivity(new Intent(ConfirmationActivity.this, DashboardActivity.class));
            }
        });

    }
}