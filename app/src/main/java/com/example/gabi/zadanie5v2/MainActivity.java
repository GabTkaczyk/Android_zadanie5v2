package com.example.gabi.zadanie5v2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.support.v7.appcompat.R.styleable.View;
import static com.example.gabi.zadanie5v2.R.id.parent;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private String[] modele;
    private String[] opisy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
        initResources();
        initLanguagesListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),opisy[position], Toast.LENGTH_SHORT).show();
                if( position == 0 )
                {
                    Intent pierwsze = new Intent(MainActivity.this, Telefon1.class);
                    startActivity(pierwsze);
                }
                if( position == 1 )
                {
                    Intent drugie = new Intent(MainActivity.this, Telefon2.class);
                    startActivity(drugie);
                }
                if( position == 2 )
                {
                    Intent trzecie = new Intent(MainActivity.this, Telefon3.class);
                    startActivity(trzecie);
                }
            }
        });
    }


    private void initResources(){
        Resources res = getResources();
        modele = res.getStringArray(R.array.modele);
        opisy = res.getStringArray(R.array.hello_world);
    }

    private void initLanguagesListView(){
        lv.setAdapter(new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1,modele));


    }
}