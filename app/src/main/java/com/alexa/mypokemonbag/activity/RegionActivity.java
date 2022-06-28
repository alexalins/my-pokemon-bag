package com.alexa.mypokemonbag.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.adapter.RegionAdapter;
import com.alexa.mypokemonbag.databinding.ActivityRegionBinding;
import com.alexa.mypokemonbag.model.Region;
import com.alexa.mypokemonbag.mvp.presenter.RegionPresenter;
import com.alexa.mypokemonbag.util.Utils;
import com.alexa.mypokemonbag.mvp.contract.RegionContract;

import java.util.List;

public class RegionActivity extends AppCompatActivity implements RegionContract.View {

    private RegionContract.Presenter presenter;
    private ActivityRegionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        //
        presenter = new RegionPresenter(this);
        presenter.start();
    }

    @Override
    public void setPresenter(RegionContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindViews() {
        binding = ActivityRegionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        List<Region> list = presenter.getListPokemon();
        RegionAdapter adapter = new RegionAdapter(this, list);
        binding.gridRegion.setAdapter(adapter);
        binding.gridRegion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.nextPage();
            }
        });
    }

    @Override
    public void displayErrorMessage() {
        Utils.toast(this, "Erro ao listar as regiões.");
    }

    @Override
    public void pageListPokemon() {
        Intent intent = new Intent(this, PokemonActivity.class);
        startActivity(intent);
    }
}