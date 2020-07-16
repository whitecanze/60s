package androidprogrammingclass.testing.rollnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Main3Activity extends AppCompatActivity {

    EditText input1;
    Button btnEnter;
    TextView txtroll, txttime,chk1,chkin;
    String getNum, getTime, getOctal, chkNum,cr,wr;
    int num, convertNum,crCT,wrCT;
    Random rd = new Random();
    CountDownTimer cdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnEnter = (Button) findViewById(R.id.enter);
        txtroll = (TextView) findViewById(R.id.txtroll);
        txttime = (TextView) findViewById(R.id.txttime);
        chk1 = (TextView) findViewById(R.id.chk);
        chkin = (TextView) findViewById(R.id.chk2);
        input1 = (EditText) findViewById(R.id.inputnum);

        num = rd.nextInt(255);
        getOctal = Integer.toOctalString(num);
        txtroll.setText(getOctal);
        convertNum = Integer.parseInt(getOctal, 8);
        getNum = String.valueOf(convertNum);
        chk1.setText(getNum);
        chk1.setVisibility(View.INVISIBLE);
        cdt = new CountDownTimer(61000, 1000) {
            public void onTick(long millisUntilFinished) {
                getTime = String.valueOf(millisUntilFinished / 1000);
                txttime.setText(getTime);
            }
            public void onFinish() {
                cr = String.valueOf(crCT);
                wr = String.valueOf(wrCT);
                Intent it = new Intent(getApplicationContext(),TimeUp.class);
                it.putExtra("mode","OCTAL");
                it.putExtra("cr",cr);
                it.putExtra("wr",wr);
                startActivity(it);
            }

        }.start();

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkNum = input1.getText().toString();
                if (chkNum.equals(getNum)) {
                    num = rd.nextInt(255);
                    getOctal = Integer.toOctalString(num);
                    txtroll.setText(getOctal);
                    convertNum = Integer.parseInt(getOctal, 8);
                    getNum = String.valueOf(convertNum);
                    chk1.setText(getNum);
                    chkin.setText("Correct!");
                    chkin.setTextColor(getColor(R.color.colorG));
                    crCT+=1;
                    input1.setText("");
                }
                else
                {
                    chkin.setText("Wrong!");
                    chkin.setTextColor(getColor(R.color.colorR));
                    wrCT+=1;
                    input1.setText("");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        cdt.cancel();
    }
}
