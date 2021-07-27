package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class PokemonInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_info);

        // Getting data from intent and storing them in variables
        Intent i = getIntent();
        String weakness = i.getStringExtra("weakness");
        String name = i.getStringExtra("name");
        String img = i.getStringExtra("img");
        String details = i.getStringExtra("details");
        String type = i.getStringExtra("type");
        int price = i.getIntExtra("price", 0);

        //Displaying the right text and image to right component
        TextView txtName = findViewById(R.id.infoName);
        TextView txtPrice = findViewById(R.id.infoPrice);
        ImageView imgView = findViewById(R.id.infoImg);
        StorageReference storRef = FirebaseStorage.getInstance().getReferenceFromUrl(img);
        TextView txtWeakness = findViewById(R.id.infoWeakness);
        TextView txtDetails = findViewById(R.id.infoDetails);
        TextView txtType = findViewById(R.id.infoType);
        Button getBtn = findViewById(R.id.infoBtn);


        txtName.setText(name);
        txtPrice.setText(Integer.toString(price));
        Glide.with(imgView.getContext()).load(storRef).into(imgView);
        txtWeakness.setText(weakness);
        txtDetails.setText(details);
        txtType.setText(type);

        //Btnclick to go to checkout page
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PokemonInfo.this, Checkout.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //Just loading header image
        FragmentManager fManager = getSupportFragmentManager();
        Fragment frag = fManager.findFragmentById(R.id.infoFragmentHolder);

        if (frag == null){
            frag = new HeaderFragment();
            fManager.beginTransaction()
                    .add(R.id.infoFragmentHolder, frag)
                    .commit();
        }
    }
}