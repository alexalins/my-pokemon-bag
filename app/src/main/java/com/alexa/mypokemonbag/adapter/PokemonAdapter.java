package com.alexa.mypokemonbag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.model.Pokemon;

import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

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
        TextView txtTitle = convertView.findViewById(R.id.pokemon_name);
        txtTitle.setText(pokemon.getName());
        return convertView;
    }
}
