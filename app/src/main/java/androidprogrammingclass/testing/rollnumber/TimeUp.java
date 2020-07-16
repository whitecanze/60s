package androidprogrammingclass.testing.rollnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class TimeUp extends AppCompatActivity {

    Button btnhome;
    String getMode,getCr,getWr;
    TextView cr,wr,mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_up);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        getMode = intent.getStringExtra("mode");
        getCr = intent.getStringExtra("cr");
        getWr = intent.getStringExtra("wr");
        btnhome = (Button)findViewById(R.id.button);
        cr = (TextView)findViewById(R.id.crpoint);
        wr = (TextView)findViewById(R.id.wrpoint);
        mode = (TextView)findViewById(R.id.txtMode);

        cr.setText(getCr);
        wr.setText(getWr);
        mode.setText(getMode);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(it);
            }
        });
    }
}
