package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class DefectActivity extends AppCompatActivity {

    Button defectNextBtn, defectYesBtn, defectNoBtn;
    ImageView defectBackBtn;
    String defectConfirmation;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.defect);
        defectNextBtn = findViewById(R.id.defectNextBtn);
        defectBackBtn = findViewById(R.id.defectBackBtn);
        defectYesBtn = findViewById(R.id.historyYesBtn);
        defectNoBtn = findViewById(R.id.historyNoBtn);

        defectYesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defectYesBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                defectNoBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectConfirmation = (String) defectYesBtn.getText().toString();
                defectNextBtn.setEnabled(!defectConfirmation.isEmpty());
            }
        });

        defectNoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defectNoBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                defectYesBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectConfirmation = (String) defectNoBtn.getText().toString();
                defectNextBtn.setEnabled(!defectConfirmation.isEmpty());
            }
        });

        pref = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        defectNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("defectConfirmation", defectConfirmation);
                editor.commit();
                if(defectConfirmation.equals("YES".trim())) {
                    startActivity(new Intent(DefectActivity.this, EyeDefectActivity.class));
                }else if(defectConfirmation.equals("NO".trim())){
                    startActivity(new Intent(DefectActivity.this, HistoryActivity.class));
                }
            }
        });

        defectBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DefectActivity.this, AgeRangeActivity.class));
            }
        });

    }
}