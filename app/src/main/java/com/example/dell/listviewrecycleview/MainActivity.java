package com.example.dell.listviewrecycleview;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.listviewrecycleview.model.DataModel;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    ArrayList<DataModel> filteredList = new ArrayList<>();
    ArrayList<DataModel> dataModels;
    ListView listView;
    RecyclerView recyclerView;
    private static CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.lvCards);
        recyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);




//        listView=(ListView)findViewById(R.id.list);

        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1","September 23, 2008"));
        dataModels.add(new DataModel("Banana Bread", "Android 1.1", "2","February 9, 2009"));
        dataModels.add(new DataModel("Cupcake", "Android 1.5", "3","April 27, 2009"));
        dataModels.add(new DataModel("Donut","Android 1.6","4","September 15, 2009"));
        dataModels.add(new DataModel("Eclair", "Android 2.0", "5","October 26, 2009"));
        dataModels.add(new DataModel("Froyo", "Android 2.2", "8","May 20, 2010"));
        dataModels.add(new DataModel("Gingerbread", "Android 2.3", "9","December 6, 2010"));
        dataModels.add(new DataModel("Honeycomb","Android 3.0","11","February 22, 2011"));
        dataModels.add(new DataModel("Ice Cream Sandwich", "Android 4.0", "14","October 18, 2011"));
        dataModels.add(new DataModel("Jelly Bean", "Android 4.2", "16","July 9, 2012"));
        dataModels.add(new DataModel("Kitkat", "Android 4.4", "19","October 31, 2013"));
        dataModels.add(new DataModel("Lollipop","Android 5.0","21","November 12, 2014"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));


            adapter = new CustomAdapter(dataModels, getApplicationContext());

        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        Toast.makeText(MainActivity.this, "position of clicked item"+position, Toast.LENGTH_SHORT).show();
                    }
                })
        );


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                DataModel dataModel= dataModels.get(position);
//
//                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getType()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//            }
//        });
    }



    @Override

    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem seachItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(seachItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

                    @Override
                    public boolean onQueryTextSubmit(String query)
                    {
                        //                        query = query.toString().toLowerCase();

                        Log.d("Query", "onQueryTextChange: " + query);


                        for (int i = 0; i < dataModels.size(); i++) {

                            final String text = dataModels.get(i).getName();

                            if (text.contains(query)) {
                                filteredList.add(dataModels.get(i));
                                Log.d("text Contain", "onQueryTextSubmit: ");
                            }
                            adapter = new CustomAdapter(filteredList, getApplicationContext());
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                        return false;

                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        Log.d("myApp", "onQueryTextChange ");
//                        query = query.toString().toLowerCase();

                        Log.d("Query", "onQueryTextChange: " + newText);


//                        for (int i = 0; i < dataModels.size(); i++) {
//
//                            final String text = dataModels.get(i).getName();
//
//                            if (text.contains(newText)) {
//                                filteredList.add(dataModels.get(i));
//                                Log.d("text Contain", "onQueryTextSubmit: ");
//                            }
//                            adapter = new CustomAdapter(filteredList, getApplicationContext());
//                            recyclerView.setAdapter(adapter);
//                            adapter.notifyDataSetChanged();
//                        }
                        return false;
                    }
                });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
        case  R.id.action_settings :

            break;

//        case  R.id.search :




        }

        return super.onOptionsItemSelected(item);
    }


    public void Search()
    {

    }
}