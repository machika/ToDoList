package com.example.mmase.todolist;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity implements NewItemFragment.onNewItemAddedListener {

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        FragmentManager fm = getFragmentManager();
        ToDoListFragment todolistFragment = (ToDoListFragment)fm.findFragmentById(R.id.ToDoListFragment);

        todoItems = new ArrayList<String>();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, todoItems);
        todolistFragment.setListAdapter(arrayAdapter);
    }

    @Override
    public void onNewItemAdded(String newItem) {
        todoItems.add(newItem);
        arrayAdapter.notifyDataSetChanged();
    }
}
