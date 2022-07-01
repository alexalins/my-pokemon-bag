package com.alexa.mypokemonbag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.util.Utils;
import com.bumptech.glide.Glide;

import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    private final String BASE_IMAGE = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png";
    private List<Pokemon> list;

    public PokemonAdapter(@NonNull Context context, @NonNull List<Pokemon> objects) {
        super(context, 0, objects);
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pokemon pokemon = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pokemon, parent, false);
        }
        //
        ImageView imageView = convertView.findViewById(R.id.image_pokemon);
        String urlImage = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"+ Utils.validateNumber(pokemon.getId()) +".png";
        Glide.with(convertView).load(urlImage).into(imageView);
        TextView txtTitle = convertView.findViewById(R.id.pokemon_name);
        txtTitle.setText(pokemon.getName());
        return convertView;
    }
}
