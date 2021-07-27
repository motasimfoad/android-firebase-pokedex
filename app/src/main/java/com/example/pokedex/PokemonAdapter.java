package com.example.pokedex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonAdapter extends FirebaseRecyclerAdapter<Pokemon, PokemonAdapter.PokemonHolder> {

    public PokemonAdapter(FirebaseRecyclerOptions<Pokemon> options){
        super(options);
    }

    public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new PokemonHolder(layoutInflater, parent);
    }

    protected void onBindViewHolder(PokemonHolder holder, int position, Pokemon model) {
        StorageReference storRef = FirebaseStorage.getInstance().getReferenceFromUrl(model.getImg());

        holder.pokeName.setText(model.getName());
        holder.pokeType.setText(model.getType());

        Glide.with(holder.imgPokemon.getContext()).load(storRef).into(holder.imgPokemon);
    }

    class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView pokeName;
        TextView pokeType;
        ImageView imgPokemon;

        //Placing right document at the right place
        public PokemonHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.row_layout, parent, false));
            pokeName = itemView.findViewById(R.id.pokeName);
            pokeType = itemView.findViewById(R.id.pokeType);
            imgPokemon = itemView.findViewById(R.id.imgPokemon);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            //Passing value of the selected component to next activity
            Context c = view.getContext();
            Intent intent = new Intent(c, PokemonInfo.class);
            Pokemon p = getItem(getAdapterPosition());


            intent.putExtra("weakness", p.getWeakness());
            intent.putExtra("name", p.getName());
            intent.putExtra("img", p.getImg());
            intent.putExtra("details", p.getDetails());
            intent.putExtra("price", p.getPrice());
            intent.putExtra("type", p.getType());
            c.startActivity(intent);
        }
    }

}
