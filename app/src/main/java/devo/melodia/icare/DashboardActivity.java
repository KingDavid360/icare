package devo.melodia.icare;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardActivity extends AppCompatActivity {
    TextView pleasantries, timerTextView;
    ImageView setting, eyeBtn;
    SharedPreferences pref;
    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;
    boolean timerStarted = false;
    Date currentTime= Calendar.getInstance().getTime();
    SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
    String stringCurrentTime = sdf.format(currentTime);
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    Date firstDate;

    {
        try {
            firstDate = format.parse(stringCurrentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    Date initialTime= Calendar.getInstance().getTime();
    String stringInitialTime = sdf.format(initialTime);
    Date finalDate ;
    {
        try {

            finalDate = format.parse(stringInitialTime);
        } catch (ParseException e) {

            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        System.out.println(firstDate.getTime());
        setting = findViewById(R.id.settingImageView);
        pleasantries = findViewById(R.id.pleasantriesTextView);
        eyeBtn = findViewById(R.id.eyeImageView);
        timerTextView = findViewById(R.id.timer);
        pref = getApplicationContext().getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        String username = pref.getString("username","");
        boolean registered = pref.getBoolean("registered", true);
//        registered = false;
        pleasantries.setText("Hello "+ username);
        timer = new Timer();
        boolean notify = pref.getBoolean("notification",true);
        System.out.println("notify is "+ notify);
        timer = new Timer();

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, SettingsActivity.class));
            }
        });

        timerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        eyeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eyeBtn.setVisibility(View.INVISIBLE);
                timerTextView.setVisibility(View.VISIBLE);
                startTimer();
                if(notify == true){
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            NotificationCompat.Builder builder = new NotificationCompat.Builder
                                    (getApplicationContext(), "My Notification");
                            builder.setContentTitle("ALERT!!!");
                            builder.setContentText("Get off your device");
                            builder.setSmallIcon(R.drawable.alert_icon);
                            builder.setAutoCancel(true);
                            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(DashboardActivity.this);
                            managerCompat.notify(1, builder.build());
                        }
                    }, 10000);
                }
            }
        });
    }

    public void resetTimer(){
        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle("Reset timer?");
        resetAlert.setMessage("Are you sure you want to reset the timer?");
        resetAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(timerTask != null){
                    timerTask.cancel();
                    time = 0.0;
                    timerTextView.setText(formatTime(0,0,0));
                    timerTextView.setVisibility(View.INVISIBLE);
                    eyeBtn.setVisibility(View.VISIBLE);
                }
            }
        });
        resetAlert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        resetAlert.show();
    }

    public void startStopTimer(){
        if(timerStarted == false){
            timerStarted = true;
            startTimer();
        }else{
            timerStarted = false;
            timerTask.cancel();
        }
    }

    public void startTimer(){
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerTextView.setText(getLastTimerText());
                        final boolean[] notification = {false};
                        while(notification[0]){
                            long timeDiff = firstDate.getTime() - finalDate.getTime();
                            String ageRange = pref.getString("ageRange", "");
                            String age = ageRange;
                            if(age.equals("5 - 10") ){
                                timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        notification[0] = true;
                                        resetTimer();
                                    }
                                }, 3000);

                            }else if(age.equals("11 - 15")){
                                timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        notification[1] = true;
                                        resetTimer();
                                    }
                                }, 3000);
                            }else if(age.equals("16 - 17")) {
                                timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        notification[2] = true;
                                        resetTimer();
                                    }
                                }, 3000);
                            }else if(age.equals("ADULT")) {
                                timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        notification[3] = true;
                                        resetTimer();
                                    }
                                }, 3000);
                            }
                        }
                    }
                });

            }
        };
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public String getLastTimerText(){
        int rounded = (int) Math.round(time);
        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);
        return formatTime(seconds, minutes, hours);
    }

    public String formatTime(int seconds, int minutes, int hours){

        return String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " +
                String.format("%02d", seconds);
    }


}