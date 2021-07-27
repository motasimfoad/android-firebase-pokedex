package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Main activity xml file
        setContentView(R.layout.activity_main);

        //Just to load header image
        FragmentManager fManager = getSupportFragmentManager();
        Fragment frag = fManager.findFragmentById(R.id.homeFragmentHolder);

        if (frag == null){
            frag = new HeaderFragment();
            fManager.beginTransaction()
                    .add(R.id.homeFragmentHolder, frag)
                    .commit();
        }

        //Btn click to next page
        btn_enter = (Button ) findViewById(R.id.btn_enter);
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PokemonList.class);
                startActivity(intent);
            }
        });
    }
}