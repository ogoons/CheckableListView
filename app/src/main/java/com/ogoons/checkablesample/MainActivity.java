package com.ogoons.checkablesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<ListItem> items = new ArrayList<>();
        items.add(new ListItem("Item 1"));
        items.add(new ListItem("Item 2"));
        items.add(new ListItem("Item 3"));
        items.add(new ListItem("Item 4"));

        mAdapter = new CustomAdapter(this, R.layout.list_item_checkable, items);
        listView.setItemsCanFocus(false);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mAdapter.notifyDataSetInvalidated();
            }
        });
    }
}
