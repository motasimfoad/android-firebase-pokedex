package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Checkout activity xml file
        setContentView(R.layout.activity_checkout);

        //Just to load header image
        FragmentManager fManager = getSupportFragmentManager();
        Fragment frag = fManager.findFragmentById(R.id.checkoutFragHolder);

        if (frag == null){
            frag = new HeaderFragment();
            fManager.beginTransaction()
                    .add(R.id.checkoutFragHolder, frag)
                    .commit();
        }

        // Getting data from intent and storing them in variables
        Intent i = getIntent();
        String name = i.getStringExtra("name");

        TextView chkOut = findViewById(R.id.chkoutPokemon);
        chkOut.setText(name);

        Button chkOutBtn = findViewById(R.id.btnChkOut);

        chkOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), name+" is yours!", Toast.LENGTH_LONG).show();
            }
        });




    }
}