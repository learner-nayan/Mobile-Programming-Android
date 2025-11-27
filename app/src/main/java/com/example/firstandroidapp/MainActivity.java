package com.example.firstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity{

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


//        setContentView(R.layout.activity_relative);
//
//        Activity Linear
//        setContentView(R.layout.activity_linear);

//        ListView listView = findViewById(R.id.listViewExample);
//
//        ArrayAdapter<CharSequence> listAdapter = ArrayAdapter.createFromResource(
//                this,
//                R.array.student_list,
//                android.R.layout.simple_list_item_1
//        );
//
//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            String selected = parent.getItemAtPosition(position).toString();
//            Toast.makeText(this, "You selected: " + selected, Toast.LENGTH_SHORT).show();
//        });
//
//        listView.setAdapter(listAdapter);



//            Tast1
//        setContentView(R.layout.task1);
//        Button btn1 = findViewById(R.id.btn1);
//        Button btn2 = findViewById(R.id.btn2);
//        Button btn3 = findViewById(R.id.btn3);
//        Button newBtn1 = findViewById(R.id.newBtn1);
//        TextView textData = findViewById(R.id.textData);
//        EditText newText = findViewById(R.id.newText);
//
//        btn1.setOnClickListener((e) -> {
//            btn1.setBackgroundColor(Color.RED);
//        });
//
//        newBtn1.setOnClickListener((e) ->{
//            String data = newText.getText().toString();
//            textData.setText(data);
//        });



//        Task3 Count
        setContentView(R.layout.task3);

        // ADDING FRAGMENT
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFragment, new MessageFragment())
                .commit();

        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        TextView result = findViewById(R.id.count);

        plus.setOnClickListener((e) -> {
            update(++count);
        });

        minus.setOnClickListener(e -> {
            update(--count);
        });

        // for fragments
        Button showOpFragmentBtn = findViewById(R.id.showOpFragment);
        Button showLovelyFragmentBtn = findViewById(R.id.showLovelyFragment);

        showOpFragmentBtn.setOnClickListener((e) -> {
            loadFragment(new OpFragment());
        });

        showLovelyFragmentBtn.setOnClickListener((e) -> {
            loadFragment(new LovelyFragment());
        });

    }

    private void update(int count){
        TextView result = findViewById(R.id.count);
        result.setText(String.valueOf(count));

        if (count < 0) {
            result.setTextColor(Color.RED);
        }
        else if (count > 0) {
            result.setTextColor(Color.GREEN);
        } else {
            result.setTextColor(Color.BLACK);
        }
    }

    public void openSecondActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("username", "uncle");
        intent.putExtra("age", 15);

        startActivity(intent);
    }

    private void loadFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFragment, fragment)
                .commit();
    }

}







// copied class

//public class MainActivity extends AppCompatActivity {
//
//    private static final String TAG = "LifecycleDemo";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.task3);
//        Log.d(TAG, "onCreate: Activity created");
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d(TAG, "onStart: Activity visible");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d(TAG, "onResume: Activity in foreground");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d(TAG, "onPause: Activity partially obscured");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d(TAG, "onStop: Activity stopped");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d(TAG, "onRestart: Activity restarting");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d(TAG, "onDestroy: Activity destroyed");
//    }
//}