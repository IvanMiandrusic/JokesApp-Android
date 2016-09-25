package app.miandrusic.ivan.com.onlyjokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private static final int PARA_NINIOS = 1;
    private static final int DE_SALON = 2;
    private static final int MAL_GUSTO = 3;
    private int jokeInt = 0;
    private int jokeAnt = 0;
    private int cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_ninios);

        Bundle datos = getIntent().getExtras();
        this.cat = datos.getInt("categoria");
        this.showJoke(cat, 0);

    }

    public void lastJoke(View v){
        this.showJoke(cat, this.jokeAnt);
    }

    public void nextJoke(View v){
            showJoke(cat, 0);
    }

    public void showJoke(int cat, int id_joke){
        TextView txtJoke = (TextView) findViewById(R.id.txtJoke);
        txtJoke.setText(this.takeJoke(cat, id_joke));
    }



    public void back(View v){
        super.onBackPressed();
    }

    public String takeJoke(int categoria, int last) {
        int myRandInt = 0;
        int arrayLenght = 0;
        Random r = new Random();
        String[] array = null;
        switch (categoria) {
            case PARA_NINIOS:
                array = getResources().getStringArray(R.array.ninios);
                arrayLenght = array.length;
            break;

            case DE_SALON:
                array = getResources().getStringArray(R.array.saolon);
                arrayLenght = array.length;
                break;

            case MAL_GUSTO:
                array = getResources().getStringArray(R.array.mGusto);
                arrayLenght = array.length;
                break;
        }

        if(last == 0){
            this.jokeAnt = jokeInt;
            myRandInt = r.nextInt(arrayLenght);
            if(myRandInt == this.jokeInt){
                myRandInt = r.nextInt(arrayLenght);
            }
            this.jokeInt = myRandInt;
        }else{
            this.jokeInt = this.jokeAnt;
            myRandInt = last;
        }



        return  array[myRandInt];
    }
}

