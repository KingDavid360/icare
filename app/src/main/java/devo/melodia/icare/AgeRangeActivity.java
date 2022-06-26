package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class AgeRangeActivity extends AppCompatActivity {

    Button ageRangeNextBtn, _5_10Btn, _11_15Btn, _16_17Btn, adultBtn;
    String ageRange;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageRangeNextBtn = findViewById(R.id.nextBtn);
        _5_10Btn = findViewById(R.id._10_25FormBtn);
        _11_15Btn = findViewById(R.id._26_41FormBtn);
        _16_17Btn = findViewById(R.id._42_57FormBtn);
        adultBtn = findViewById(R.id._58_67FormBtn);

        _5_10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _5_10Btn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                _11_15Btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                _16_17Btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                adultBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                ageRange = (String) _5_10Btn.getText().toString();
                ageRangeNextBtn.setEnabled(!ageRange.isEmpty());
            }
        });

        _11_15Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _11_15Btn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                _5_10Btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                _16_17Btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                adultBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                ageRange = (String) _11_15Btn.getText().toString();
                ageRangeNextBtn.setEnabled(!ageRange.isEmpty());
            }
        });

        _16_17Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _16_17Btn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                _5_10Btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                _11_15Btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                adultBtn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                ageRange = (String) _16_17Btn.getText().toString();
                ageRangeNextBtn.setEnabled(!ageRange.isEmpty());
            }
        });

        adultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adultBtn.setBackground(getResources().getDrawable(R.drawable.custom_button2));
                _5_10Btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                _11_15Btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
                _16_17Btn.setBackground(getResources().getDrawable(R.drawable.custom_button));

                ageRange = (String) adultBtn.getText().toString();
                ageRangeNextBtn.setEnabled(!ageRange.isEmpty());

            }
        });

        pref = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        ageRangeNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = pref.edit();
                editor.putString("ageRange", ageRange);
                editor.commit();

                startActivity(new Intent(AgeRangeActivity.this, DefectActivity.class));
            }
        });

    }
}