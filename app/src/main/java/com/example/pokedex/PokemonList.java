package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class PokemonList extends AppCompatActivity {

    private Query query;
    private PokemonAdapter adapter;
    private RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        //Loading header image
        FragmentManager fManager = getSupportFragmentManager();
        Fragment frag = fManager.findFragmentById(R.id.fragmentHolder);

        if (frag == null){
            frag = new HeaderFragment();
            fManager.beginTransaction()
                    .add(R.id.fragmentHolder, frag)
                    .commit();
        }

        //Firebase query to get info of "Pokemon"
        query = FirebaseDatabase.getInstance().getReference().child("Pokemon");
        FirebaseRecyclerOptions<Pokemon> options = new FirebaseRecyclerOptions.Builder<Pokemon>().setQuery(query, Pokemon.class).build();

        adapter = new PokemonAdapter(options);

        rView = findViewById(R.id.rView);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}