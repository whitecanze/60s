package androidprogrammingclass.testing.rollnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Mode extends AppCompatActivity {

    Button bin, oct, hex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bin = (Button) findViewById(R.id.btnbinary);
        oct = (Button) findViewById(R.id.btnOct);
        hex = (Button) findViewById(R.id.btnhex);

        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(it);
            }
        });

        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(it);
            }
        });

        hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), Main4Activity.class);
                startActivity(it);
            }
        });
    }
}
