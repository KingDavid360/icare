package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HistoryActivity extends AppCompatActivity {

    Button historyNextBtn, historyYesBtn, historyNoBtn;
    ImageView historyBackBtn;
    String defectConfirmation;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        historyNextBtn = findViewById(R.id.historyNextBtn);
        historyBackBtn = findViewById(R.id.historyBackBtn);
        historyYesBtn = findViewById(R.id.historyYesBtn);
        historyNoBtn = findViewById(R.id.historyNoBtn);

        historyYesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyYesBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                historyNoBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectConfirmation = (String) historyYesBtn.getText().toString();
                historyNextBtn.setEnabled(!defectConfirmation.isEmpty());
            }
        });

        historyNoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyNoBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                historyYesBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                defectConfirmation = (String) historyNoBtn.getText().toString();
                historyNextBtn.setEnabled(!defectConfirmation.isEmpty());
            }
        });

        pref = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        historyNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("historyDefectConfirmation", defectConfirmation);
                editor.commit();
                if(defectConfirmation.equals("YES".trim())) {
                    startActivity(new Intent(HistoryActivity.this, HistoryDefectActivity.class));
                }else if(defectConfirmation.equals("NO".trim())){
                    startActivity(new Intent(HistoryActivity.this, ConfirmationActivity.class));
                }
            }
        });

        historyBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HistoryActivity.this, EyeDefectActivity.class));
            }
        });

    }
}