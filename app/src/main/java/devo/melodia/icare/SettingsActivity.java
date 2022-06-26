package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    ImageView editCredentials, backBtn;
    Switch notificationToggle, dailyTipToggle;
    TextView dailyTip;
    final Context context = this;
    SharedPreferences pref;
    boolean notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);
        editCredentials = findViewById(R.id.editCredentialRectangleSettings);
        notificationToggle = findViewById(R.id.notificationToggle);
        dailyTipToggle = findViewById(R.id.dailyTipsToggle);
        dailyTip = findViewById(R.id.eyeDistanceTipTextView);
        backBtn = findViewById(R.id.settingsBackBtn);

        editCredentials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, EditCredentialActivity.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, DashboardActivity.class));
            }
        });

        dailyTipToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dailyTipToggle.setText("On");
                   dailyTip.setText("Keep a proper viewing distance of 20-28 inches from your phone screen");
                } else {
                    // The toggle is disabled
                }
            }
        });

        pref = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        notification = pref.getBoolean("notification" , false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification",
                    "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        notificationToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    System.out.println(isChecked);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("notification", true);
                    editor.commit();
                    notificationToggle.setText("On");
                } else {
                    // The toggle is disabled
                }
            }
        });
    }
}