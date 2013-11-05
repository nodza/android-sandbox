package com.safirio.sandbox;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Nodza on 11/3/13.
 */
public class ActivityList extends ListActivity {

    String[] presidents = {
            "Grover Cleveland",
            "Benjamin Harrison",
            "Grover Cleveland",
            "William McKinley",
            "Theodore Roosevelt",
            "William H. Taft",
            "Woodrow Wilson",
            "Warren G. Harding",
            "Calvin Coolidge",
            "Herbert Hoover",
            "Franklin D. Roosevelt",
            "Harry S. Truman",
            "Dwight D. Eisenhower",
            "John F. Kennedy",
            "Lyndon B. Johnson",
            "Richard M. Nixon",
            "Gerald Ford",
            "Jimmy Carter",
            "Ronald Reagan",
            "George H. W. Bush",
            "Bill Clinton",
            "George W. Bush",
            "Barack H. Obama"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);

//        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, presidents));
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, presidents));
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
            Toast.makeText(this, "You have elected " + presidents[position], Toast.LENGTH_SHORT).show();
//        CheckedTextView item = (CheckedTextView) v;
//        Toast.makeText(this, presidents[position] + " elected : " + item.isChecked(), Toast.LENGTH_SHORT).show();


    }
}
