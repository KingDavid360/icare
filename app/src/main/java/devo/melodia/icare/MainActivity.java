package devo.melodia.icare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;
    boolean reg = false;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splah_screen);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pref = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
               boolean registered = false;
                reg = pref.getBoolean("registration",registered);
                if(reg = false){
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                }else if(reg = true) {
                    Intent intent = new Intent(MainActivity.this, NewActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 3000);
        Toast.makeText(MainActivity.this, "firebase connection successful", Toast.LENGTH_SHORT).show();

    }
}