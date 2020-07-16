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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    Button btnShowNum1, btnShowNum2, btnShowNum3, btnShowNum4;
    TextView txtroll, txttime, chk1, chkin;
    String getNum, getTime, getBinary, chkNum, cr, wr, getNumFormList, chklist, chklist2, numToText, getCurrent, numToText2;
    int num, convertNum, convertNum2, crCT, wrCT, bound = 255, count;
    Random rd = new Random();
    CountDownTimer cdt;
    ArrayList<String> numberlist = new ArrayList<>();
    ArrayList<String> numberForButtonList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        btnShowNum1 = (Button) findViewById(R.id.btnNum1);
        btnShowNum2 = (Button) findViewById(R.id.btnNum2);
        btnShowNum3 = (Button) findViewById(R.id.btnNum3);
        btnShowNum4 = (Button) findViewById(R.id.btnNum4);
        txtroll = (TextView) findViewById(R.id.txtroll);
        txttime = (TextView) findViewById(R.id.txttime);
        chk1 = (TextView) findViewById(R.id.chk);
        chkin = (TextView) findViewById(R.id.chk2);

        startGame();

        cdt = new CountDownTimer(61000, 1000) {

            public void onTick(long millisUntilFinished) {
                getTime = String.valueOf(millisUntilFinished / 1000);

                if(Integer.valueOf(getTime) < 10)
                    getTime = "0"+getTime;

                txttime.setText(getTime);
            }

            public void onFinish() {
                cr = String.valueOf(crCT);
                wr = String.valueOf(wrCT);
                Intent it = new Intent(getApplicationContext(), TimeUp.class);
                it.putExtra("mode", "BINARY");
                it.putExtra("cr", cr);
                it.putExtra("wr", wr);
                startActivity(it);
            }

        }.start();

        btnShowNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkNum = btnShowNum1.getText().toString();
                if (chkNum.equals(getNum)) {
                    numberlist.clear();
                    numberForButtonList.clear();
                    startGame();

                    chkin.setText("Correct!");
                    chkin.setTextColor(getColor(R.color.colorG));
                    crCT += 1;
                } else {
                    numberlist.clear();
                    numberForButtonList.clear();
                    startGame();

                    chkin.setText("Wrong!");
                    chkin.setTextColor(getColor(R.color.colorR));
                    wrCT += 1;
                }
            }
        });
        btnShowNum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkNum = btnShowNum2.getText().toString();
                if (chkNum.equals(getNum)) {
                    numberlist.clear();
                    numberForButtonList.clear();
                    startGame();

                    chkin.setText("Correct!");
                    chkin.setTextColor(getColor(R.color.colorG));
                    crCT += 1;
                } else {
                    numberlist.clear();
                    numberForButtonList.clear();
                    startGame();

                    chkin.setText("Wrong!");
                    chkin.setTextColor(getColor(R.color.colorR));
                    wrCT += 1;
                }

            }
        });
        btnShowNum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkNum = btnShowNum3.getText().toString();
                if (chkNum.equals(getNum)) {
                    numberlist.clear();
                    numberForButtonList.clear();
                    startGame();

                    chkin.setText("Correct!");
                    chkin.setTextColor(getColor(R.color.colorG));
                    crCT += 1;
                } else {
                    numberlist.clear();
                    numberForButtonList.clear();
                    startGame();

                    chkin.setText("Wrong!");
                    chkin.setTextColor(getColor(R.color.colorR));
                    wrCT += 1;
                }

            }
        });
        btnShowNum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkNum = btnShowNum4.getText().toString();
                if (chkNum.equals(getNum)) {
                    numberlist.clear();
                    numberForButtonList.clear();
                    startGame();

                    chkin.setText("Correct!");
                    chkin.setTextColor(getColor(R.color.colorG));
                    crCT += 1;
                } else {
                    numberlist.clear();
                    numberForButtonList.clear();
                    startGame();

                    chkin.setText("Wrong!");
                    chkin.setTextColor(getColor(R.color.colorR));
                    wrCT += 1;
                }

            }
        });
    }

    public void startGame() {
        for (int i = 0; i < 100; i++) {
            num = rd.nextInt(bound);
            getBinary = Integer.toBinaryString(num);
            if (!numberlist.contains(getBinary)) {
                numberlist.add(getBinary);
            }
        }
        getNumFormList = numberlist.get(rd.nextInt(numberlist.size()));
        txtroll.setText(getNumFormList);


        convertNum = Integer.parseInt(getNumFormList, 2);
        getNum = String.valueOf(convertNum);

        numberForButtonList.add(getNum);
        getCurrent = numberForButtonList.get(0);

        for (int j = 0; j < 3; j++) {
            chklist = numberlist.get(rd.nextInt(numberlist.size()));
            convertNum2 = Integer.parseInt(chklist, 2);
            numToText = String.valueOf(convertNum2);
            if (!numToText.equals(getCurrent)) {
                numberForButtonList.add(numToText);
            }
        }

        Collections.sort(numberForButtonList);

        for (int k = 0; k < numberForButtonList.size(); k++) {
            chklist2 = numberForButtonList.get(k);

            if (k == 0)
                btnShowNum1.setText(chklist2);
            if (k == 1)
                btnShowNum2.setText(chklist2);
            if (k == 2)
                btnShowNum3.setText(chklist2);
            if (k == 3)
                btnShowNum4.setText(chklist2);
        }


        chk1.setText(getNum);
        chk1.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        cdt.cancel();
    }


}
