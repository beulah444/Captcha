package com.preethi.captcha;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String text;
    TextView et;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textOne = (TextView) findViewById(R.id.textView);
        Button pushMe = (Button) findViewById(R.id.button);
        final String[] RandomText = {"ROSE","JASMINE","LILLY","ALABAMA","ALASKA","GEORGIA","ARIZONA","CALIFORNIA","COLORADO","CONNECTICUT","DELAWARE","FLORIDA","GEORGIA","HAWAII","IDAHO","ILLINOIS","INDIANA","IOWA","KANSAS","LOUISIANA","MARYLAND",
                "COW","ANT","ANTELOPE","APE","BEE","BEAR","PIG","BUFFALO","ZEBRA","PIGEON","DOVE","SNAKE","TIGER","LION","HOUSE","BAT","BUTTERFLY","CAMEL","KANGAROO","CHICKEN","CRAB","DEER","DINOSAUR","DOLPHIN","DONKEY","DRAGON","DUCK","EAGLE","FISH","CAR","VAN","BUS","TRAIN","PLANE","SHIP","PEN","DONUT","CUP",
                "PLATE","MOUSE","MUG","CHAIR","TABLE","PENCIL","CARROT","BEETROOT","BULL","BAG","LOVE","PAPER","MEAT","MILK","CAKE","FRUIT","FOX","MOON","SUN","MOM","DAD","DAY","NIGHT","SLEEP","SNOW","RED","GREEN","PINK","YELLOW","BLUE","BLACK","ORANGE","HAPPY","CRY","ANGRY","PAIN","CANDY","TREE",
                "TRUCK","PLANT","ICE","CHILD","ADULT","KID","HILL","ROAD","WATER","WEEK","ROOM","SCHOOL","JOB","FALL","EGG","KING","WORLD","WALL","QUEEN","EAT","ZOO","GYM","DOOR","DOLL","RAIN","WARM","WASH","WALK","RUN","ROCK","LAKE","OCEAN","SEA","DRESS","DRIVE","DRY","START","END"};

        pushMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int random1 = (int) (Math.random()*135);
                final int random2 = (int) (Math.random()*135);
                final int random3 = (int) (Math.random()*135);
                final int random4 = (int) (Math.random()*135);
                final String[] RandomText2 = new String[]{RandomText[random1], RandomText[random2], RandomText[random3], RandomText[random4]};
                final int random_final = (int) (Math.random()*4);
                textOne.setText(RandomText2[random_final]);
                et=(TextView)findViewById(R.id.textView);
                tts=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {

                    @Override
                    public void onInit(int status) {
                        // TODO Auto-generated method stub
                        if(status == TextToSpeech.SUCCESS){
                            int result=tts.setLanguage(Locale.US);
                            if(result==TextToSpeech.LANG_MISSING_DATA ||
                                    result==TextToSpeech.LANG_NOT_SUPPORTED){
                                Log.e("error", "This Language is not supported");
                            }
                            else{
                                ConvertTextToSpeech();
                            }
                        }
                        else
                            Log.e("error", "Initilization Failed!");
                    }
                }
                );
                Intent myIntent = new Intent(MainActivity.this,ChildActivity.class);
                myIntent.putExtra("Ran1", RandomText[random1]);
                myIntent.putExtra("Ran2", RandomText[random2]);
                myIntent.putExtra("Ran3", RandomText[random3]);
                myIntent.putExtra("Ran4", RandomText[random4]);
                myIntent.putExtra("Fin_Ran", RandomText2[random_final]);
                startActivity(myIntent);
            }
        });

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub

        if(tts != null){

            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

    public void onClick(View v){

        ConvertTextToSpeech();

    }

    private void ConvertTextToSpeech() {
        // TODO Auto-generated method stub
        text = et.getText().toString();
        if(text==null||"".equals(text))
        {
            text = "Content not available";
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }else
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

}



