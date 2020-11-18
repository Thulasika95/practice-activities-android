package com.example.task2;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ImageView ImageView;
    private ImageView ImageView1;
    private ImageView ImageView2;
    private ImageView ImageView3;
    private TextView TextView;
    private TextView textViewScore;
    private Button Button;
    Dialog level_finished;
    DatabaseHelper db;
    SharedPreferences loginPreferences;

    TextView textView;

    public int score =0;
    public int a;
    public int i;
    public int[] Array= new int[4];
    public int count=0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        db=new DatabaseHelper(this);

        level_finished = new Dialog(this);

        loginPreferences = getSharedPreferences ( "loginPrefs",Context.MODE_PRIVATE );

        ImageView = (ImageView) findViewById ( R.id.imageView );
        ImageView1 = (ImageView) findViewById ( R.id.imageView1 );
        ImageView2 = (ImageView) findViewById ( R.id.imageView2 );
        ImageView3 = (ImageView) findViewById ( R.id.imageView3 );
        TextView = (TextView) findViewById ( R.id.fact );
        Button = (Button) findViewById ( R.id.factButton );
        textViewScore = (TextView)findViewById ( R.id.textViewScore ) ;

        ImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String img = ImageView.getTooltipText ().toString ();
                String input = TextView.getText ().toString ();
                if (input == img) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));
                    Button.performClick();

                }
                else {
                    Toast.makeText ( getApplicationContext (),"Wrong Answer",Toast.LENGTH_SHORT ).show ();
                }
            }
        });

        ImageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String img = ImageView1.getTooltipText ().toString ();
                String input = TextView.getText ().toString ();
                if (input == img) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));
                    Button.performClick();

                }
                else {
                    Toast.makeText ( getApplicationContext (),"Wrong Answer",Toast.LENGTH_SHORT ).show ();
                }
            }
        });

        ImageView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String img = ImageView2.getTooltipText ().toString ();
                String input = TextView.getText ().toString ();
                if (input == img) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));
                    Button.performClick();

                }
                else {
                    Toast.makeText ( getApplicationContext (),"Wrong Answer",Toast.LENGTH_SHORT ).show ();
                }
            }
        });

        ImageView3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String img = ImageView3.getTooltipText ().toString ();
                String input = TextView.getText ().toString ();
                if (input == img) {

                    score = score+ 10;
                    textViewScore.setText(String.valueOf(score));
                    Button.performClick();

                }
                else {
                    Toast.makeText ( getApplicationContext (),"Wrong Answer",Toast.LENGTH_SHORT ).show ();
                }
            }
        });

        showRandomFact ();
        //showRandomFact1 ();
        //showRandomFact2 ();
        //showRandomFact3 ();

        Button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                /*if (count==2) {

                    updatescore(score);

                    if (score >= 70) {

                        showSuccessMessage();
                        updatescore(score);
                    }

                    else {
                        showUncompletedMessage();
                        updatescore(score);
                    }
                }*/

                showRandomFact ();
                showRandomFact1 ();
                showRandomFact2 ();
                showRandomFact3 ();
            }
        } );
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showRandomFact(){
        shuffleFacts ();
        ImageView.setImageResource ( factArray[0].getmImage () );
        ImageView1.setImageResource ( factArray[1].getmImage () );
        ImageView2.setImageResource ( factArray[2].getmImage () );
        ImageView3.setImageResource ( factArray[3].getmImage () );

        ImageView.setTooltipText ( factArray[0].getmFact () );
        ImageView1.setTooltipText ( factArray[1].getmFact () );
        ImageView2.setTooltipText ( factArray[2].getmFact () );
        ImageView3.setTooltipText ( factArray[3].getmFact () );

        count +=1;

        for (int i=0; i<Array.length; i++){
            Array[i] = (int) (Math.random ()*4);
        }
        for (int i=0; i<Array.length; i++){
            a = Array[i];
            TextView.setText ( factArray[a].getmFact () );
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showRandomFact1(){
        shuffleFacts1 ();
        ImageView.setImageResource ( factArray1[0].getmImage () );
        ImageView1.setImageResource ( factArray1[1].getmImage () );
        ImageView2.setImageResource ( factArray1[2].getmImage () );
        ImageView3.setImageResource ( factArray1[3].getmImage () );

        ImageView.setTooltipText ( factArray1[0].getmFact () );
        ImageView1.setTooltipText ( factArray1[1].getmFact () );
        ImageView2.setTooltipText ( factArray1[2].getmFact () );
        ImageView3.setTooltipText ( factArray1[3].getmFact () );

        count +=1;

        for (int i=0; i<Array.length; i++){
            Array[i] = (int) (Math.random ()*4);
        }
        for (int i=0; i<Array.length; i++){
            a = Array[i];
            TextView.setText ( factArray1[a].getmFact () );
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showRandomFact2(){
        shuffleFacts2 ();
        ImageView.setImageResource ( factArray2[0].getmImage () );
        ImageView1.setImageResource ( factArray2[1].getmImage () );
        ImageView2.setImageResource ( factArray2[2].getmImage () );
        ImageView3.setImageResource ( factArray2[3].getmImage () );

        ImageView.setTooltipText ( factArray2[0].getmFact () );
        ImageView1.setTooltipText ( factArray2[1].getmFact () );
        ImageView2.setTooltipText ( factArray2[2].getmFact () );
        ImageView3.setTooltipText ( factArray2[3].getmFact () );

        count +=1;

        for (int i=0; i<Array.length; i++){
            Array[i] = (int) (Math.random ()*4);
        }
        for (int i=0; i<Array.length; i++){
            a = Array[i];
            TextView.setText ( factArray2[a].getmFact () );
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showRandomFact3(){
        shuffleFacts3 ();
        ImageView.setImageResource ( factArray3[0].getmImage () );
        ImageView1.setImageResource ( factArray3[1].getmImage () );
        ImageView2.setImageResource ( factArray3[2].getmImage () );
        ImageView3.setImageResource ( factArray3[3].getmImage () );

        ImageView.setTooltipText ( factArray3[0].getmFact () );
        ImageView1.setTooltipText ( factArray3[1].getmFact () );
        ImageView2.setTooltipText ( factArray3[2].getmFact () );
        ImageView3.setTooltipText ( factArray3[3].getmFact () );

        count +=1;

        for (int i=0; i<Array.length; i++){
            Array[i] = (int) (Math.random ()*4);
        }
        for (int i=0; i<Array.length; i++){
            a = Array[i];
            TextView.setText ( factArray3[a].getmFact () );
        }

    }

    Facts f01 = new Facts ( R.raw.annamunna, "அன்னமுன்னா பழம்" );
    Facts f02 = new Facts ( R.raw.apple, "ஆப்பிள் பழம்" );
    Facts f03 = new Facts ( R.raw.banana, "வாழைப்பழம்" );
    Facts f04 = new Facts ( R.raw.grapes, "திராட்சைப்பழம்" );
    Facts f05 = new Facts ( R.raw.jackfruit, "பலாப்பழம்" );
    Facts f06 = new Facts ( R.raw.mango, "மாம்பழம்" );
    Facts f07 = new Facts ( R.raw.mathulai, "மாதுளம்பழம்" );
    Facts f08 = new Facts ( R.raw.orange1, "ஆரஞ்சு பழம்" );
    Facts f09 = new Facts ( R.raw.pineapple, "அன்னாசிப்பழம்" );
    Facts f010 = new Facts ( R.raw.strawberry, "ஸ்ட்ராவ்பெரிப்பழம்" );
    Facts f011 = new Facts ( R.raw.watermelon, "தர்பூசணி" );
    Facts f012 = new Facts ( R.raw.woodapple, "விளாம்பழம்" );


    Facts f101 = new Facts ( R.raw.april, "சித்திரை மாதம்" );
    Facts f102 = new Facts ( R.raw.august, "ஆவணி மாதம்" );
    Facts f103 = new Facts ( R.raw.december, "மார்கழிமாதம்" );
    Facts f104 = new Facts ( R.raw.february, "மாசிமாதம்" );
    Facts f105 = new Facts ( R.raw.january, "தைமாதம்" );
    Facts f106 = new Facts ( R.raw.july, "ஆடிமாதம்" );
    Facts f107 = new Facts ( R.raw.march, "பங்குனிமாதம்" );
    Facts f108 = new Facts ( R.raw.may, "வைகாசிமாதம்" );
    Facts f109 = new Facts ( R.raw.june, "ஆனிமாதம்" );
    Facts f1010 = new Facts ( R.raw.november, "கார்த்திகைமாதம்" );
    Facts f1011 = new Facts ( R.raw.october, "ஐப்பசிமாதம்" );
    Facts f1012 = new Facts ( R.raw.septemper, "புரட்டாதிமாதம்" );


    Facts f201 = new Facts ( R.raw.black, "கறுப்புநிறம்" );
    Facts f202 = new Facts ( R.raw.blue, "நீலநிறம்" );
    Facts f203 = new Facts ( R.raw.brown, "மண்ணிறம்" );
    Facts f204 = new Facts ( R.raw.gray, "சாம்பல்நிறம்" );
    Facts f205 = new Facts ( R.raw.green, "பச்சைநிறம்" );
    Facts f206 = new Facts ( R.raw.orange, "செம்மஞ்சள்நிறம்" );
    Facts f207 = new Facts ( R.raw.pink, "இளம்சிவப்புநிறம்" );
    Facts f208 = new Facts ( R.raw.purple, "ஊதாநிறம்" );
    Facts f209 = new Facts ( R.raw.red, "சிவப்புநிறம்" );
    Facts f2010 = new Facts ( R.raw.yellow, "மஞ்சள்நிறம்" );


    Facts f301 = new Facts ( R.raw.friday, "வெள்ளிக்கிழமை" );
    Facts f302 = new Facts ( R.raw.monday, "திங்கட்கிழமை" );
    Facts f303 = new Facts ( R.raw.saturday, "சனிக்கிழமை" );
    Facts f304 = new Facts ( R.raw.sunday, "ஞாயிறுக்கிழமை" );
    Facts f305 = new Facts ( R.raw.thursday, "வியாழக்கிழமை" );
    Facts f306 = new Facts ( R.raw.tuesday, "செவ்வாய்க்கிழமை" );
    Facts f307 = new Facts ( R.raw.wednesday, "புதன்கிழமை" );

    Facts[] factArray = new Facts[]{
            f01,f02,f03,f04,f05,f06,f07,f08,f09,f010,
            f011,f012
    };

    Facts[] factArray1 = new Facts[]{
            f101,f102,f103,f104,f105,f106,f107,f108,f109,f1010,
            f1011,f1012
    };

    Facts[] factArray2 = new Facts[]{
            f201,f202,f203,f204,f205,f206,f207,f208,f209,f2010
    };

    Facts[] factArray3 = new Facts[]{
            f301,f302,f303,f304,f305,f306,f307
    };



    public void shuffleFacts(){
        Collections.shuffle ( Arrays.asList ( factArray ) );
    }

    public void shuffleFacts1(){
        Collections.shuffle ( Arrays.asList ( factArray1 ) );
    }

    public void shuffleFacts2(){
        Collections.shuffle ( Arrays.asList ( factArray2 ) );
    }

    public void shuffleFacts3(){
        Collections.shuffle ( Arrays.asList ( factArray3 ) );
    }

    public void showSuccessMessage() {

        TextView Congra,level;
        Button btnclk;

        Congra = findViewById(R.id.congrats);

        level = findViewById(R.id.levelname);

        btnclk = (Button)findViewById(R.id.button4);

        level_finished.setContentView(R.layout.level_finished);
        level_finished.show();

    }

    public void showUncompletedMessage() {

        level_finished.setContentView(R.layout.level_uncompleted);
        level_finished.show();

    }

    public void updatescore(int score) {

        String id =loginPreferences.getString("userid","");
        Cursor cursor=  db.viewScore (id);
        final String[] arr2= new String[400];
        int i=0;

        while(cursor.moveToNext()){
            arr2[i] = cursor.getString(2);
            i= i+1;
        }

        Toast.makeText(getApplicationContext(),"updated "+ id+" "+ arr2[0] +" "+score,Toast.LENGTH_SHORT).show();



    }

}
