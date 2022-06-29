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
import com.alexa.mypokemonbag.model.Bag;

import java.util.List;

public class BagAdapter extends ArrayAdapter<Bag> {

    private List<Bag> bag;

    public BagAdapter(@NonNull Context context, List<Bag> objects) {
        super(context, 0, objects);
        this.bag = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Bag bag = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bag, parent, false);
        }
        //
        TextView txtTitle = convertView.findViewById(R.id.item_title);
        TextView txtDescription = convertView.findViewById(R.id.item_description);
        txtTitle.setText(bag.getTitle());
        txtDescription.setText(bag.getDescription());
        return convertView;
    }
}
