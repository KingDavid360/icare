package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.FirebaseDatabase;
public class EyeDefectActivity extends AppCompatActivity {

    Button eyeDefectNextBtn, defectMyopiaBtn, defectHypermyopiaBtn,  defectAstigmatismBtn, defectCataractsBtn, defectPresbyopiaBtn;
    ImageView eyeDefectBackBtn;
    String eyeDefect = "null";
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eye_defects);

        eyeDefectNextBtn = findViewById(R.id.eyeDefectNextBtn);
        eyeDefectBackBtn = findViewById(R.id.eyeDefectBackbtn);
        defectMyopiaBtn = findViewById(R.id.myopiaFormBtn);
        defectHypermyopiaBtn = findViewById(R.id.hypermyopiaFormBtn);
        defectAstigmatismBtn = findViewById(R.id.astimagtismFormBtn);
        defectCataractsBtn = findViewById(R.id.cataractsFormBtn);
        defectPresbyopiaBtn = findViewById(R.id.presbyopiaBtn);

        defectMyopiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                defectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                eyeDefect = (String) defectMyopiaBtn.getText().toString();
                eyeDefectNextBtn.setEnabled(!eyeDefect.isEmpty());
            }
        });

        defectHypermyopiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                defectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                eyeDefect = (String) defectHypermyopiaBtn.getText().toString();
                eyeDefectNextBtn.setEnabled(!eyeDefect.isEmpty());
            }
        });

        defectAstigmatismBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                defectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                eyeDefect = (String) defectAstigmatismBtn.getText().toString();
                eyeDefectNextBtn.setEnabled(!eyeDefect.isEmpty());
            }
        });

        defectCataractsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                defectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                eyeDefect = (String) defectCataractsBtn.getText().toString();
                eyeDefectNextBtn.setEnabled(!eyeDefect.isEmpty());
            }
        });

        defectPresbyopiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defectPresbyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                defectMyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectHypermyopiaBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectAstigmatismBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectCataractsBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                eyeDefect = (String) defectPresbyopiaBtn.getText().toString();
                eyeDefectNextBtn.setEnabled(!eyeDefect.isEmpty());
            }
        });

        pref = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        eyeDefectNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("eyeDefect", eyeDefect);
                editor.commit();
                startActivity(new Intent(EyeDefectActivity.this, HistoryActivity.class));
            }
        });

        eyeDefectBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EyeDefectActivity.this, DefectActivity.class));
            }
        });
    }
}