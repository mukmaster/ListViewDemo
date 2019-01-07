package com.roderus.app.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity {

    private List<String> namensliste = new ArrayList<>();

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
        namensliste = Arrays.asList(NameArrays.wvornamen);
    }
}
