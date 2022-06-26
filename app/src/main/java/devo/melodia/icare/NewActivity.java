package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class NewActivity extends AppCompatActivity {

    EditText username;
    Button usernameNextBtn;
    SharedPreferences pref;
    String usernameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.username_form);
        username = findViewById(R.id.namePlainText);
        usernameNextBtn = findViewById(R.id.nextUsernameBtn);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                usernameInput = username.getText().toString().trim();
                usernameNextBtn.setEnabled(!usernameInput.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        pref = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        usernameNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username", usernameInput);
                editor.commit();
                startActivity(new Intent(NewActivity.this, AgeRangeActivity.class));
            }

        });

    }

}