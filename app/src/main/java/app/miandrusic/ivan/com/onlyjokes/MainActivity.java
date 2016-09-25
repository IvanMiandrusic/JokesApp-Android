package app.miandrusic.ivan.com.onlyjokes;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int PARA_NINIOS = 1;
    private static int DE_SALON = 2;
    private static int MAL_GUSTO = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        Intent i = new Intent(this, SecondActivity.class);
        switch (v.getId()){
            case R.id.btnCat1:
                i.putExtra("categoria", PARA_NINIOS);
                startActivity(i);
                break;
            case R.id.btnCat2:
                i.putExtra("categoria", DE_SALON);
                startActivity(i);
                break;
            case R.id.btnCat3:
                i.putExtra("categoria", MAL_GUSTO);
                startActivity(i);
                break;
            case R.id.btnCat4:
                break;
            case R.id.btnCat5:
                break;
            case R.id.btnCat6:
                break;
            case R.id.btnCat7:
                break;
            case R.id.btnInfo:
                Intent info = new Intent(this, InfoActivity.class);
                startActivity(info);
                break;
        }
    }
}
