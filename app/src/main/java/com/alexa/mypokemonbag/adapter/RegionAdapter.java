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
import com.alexa.mypokemonbag.model.Region;

import java.util.List;

public class RegionAdapter extends ArrayAdapter<Region> {

    private List<Region> list;


    public RegionAdapter(@NonNull Context context, @NonNull List<Region> objects) {
        super(context, 0, objects);
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Region region = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_region, parent, false);
        }
        //
        TextView txtTitle = convertView.findViewById(R.id.region_name);
        txtTitle.setText(region.getName());
        return convertView;
    }
}
