package com.roderus.app.listviewdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends Activity {

    private ArrayList<String> namensliste = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.listview);

        initArrayList();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, namensliste );
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                                                final String clickedName = (String) parent.getItemAtPosition(position);
                                                Toast.makeText(getApplicationContext(), id+": "+clickedName, Toast.LENGTH_SHORT).show();
                                            }
                                        }
        );
        
    }


    private void initArrayList() {
        for (int i=0; i<=250; i++) {
            namensliste.add("Name"+i);
        }
    }
}
