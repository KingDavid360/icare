package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class EditCredentialActivity extends AppCompatActivity {
    TextView editTextAge, ediTextEyeDefect, editTextGeneticEyeDefect;
    ImageView backBtn, saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_credentials);
        editTextAge = findViewById(R.id.editBtnAgeRangeTextView);
        backBtn =  findViewById(R.id.editCredentialsBackBtn);
        ediTextEyeDefect = findViewById(R.id.editBtnEyeDefectTextView);
        editTextGeneticEyeDefect = findViewById(R.id.editBtnGeneticEyeDefectTextView);
        saveBtn = findViewById(R.id.saveBtnEditCredential);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditCredentialActivity.this, SettingsActivity.class));
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditCredentialActivity.this, SettingsActivity.class));
            }
        });

        editTextAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditCredentialActivity.this, AgeRangeActivity.class));
            }
        });

        ediTextEyeDefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditCredentialActivity.this, EyeDefectActivity.class));
            }
        });

        editTextGeneticEyeDefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditCredentialActivity.this, HistoryDefectActivity.class));
            }
        });
    }
}