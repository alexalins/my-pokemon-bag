package com.alexa.mypokemonbag.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.adapter.PokemonAdapter;
import com.alexa.mypokemonbag.databinding.ActivityPokemonBinding;
import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.mvp.contract.PokemonContract;
import com.alexa.mypokemonbag.mvp.presenter.PokemonPresenter;
import com.alexa.mypokemonbag.util.PokemonUtil;
import com.alexa.mypokemonbag.util.Utils;

import java.util.List;

public class PokemonActivity extends AppCompatActivity implements PokemonContract.View {

    private PokemonContract.Presenter presenter;
    private ActivityPokemonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        //
        presenter = new PokemonPresenter(this);
        presenter.start();
    }

    @Override
    public void setPresenter(PokemonContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindViews() {
        binding = ActivityPokemonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //
        Bundle extras = getIntent().getExtras();
        String url = extras.getString(Utils.getUrl());
        String id = url.substring(34);
        presenter.getListPokemon(id);
    }

    @Override
    public void displayErrorMessage() {
        Utils.toast(this, "Erro ao buscar os pokémon dessa região.");
    }

    @Override
    public void pageDetailPokemon(Pokemon pokemon) {
        Intent intent = new Intent(this, DetailPokemonActivity.class);
        String myJson = PokemonUtil.pokemonToJson(pokemon);
        intent.putExtra(Utils.getPokemon(), myJson);
        startActivity(intent);
    }

    @Override
    public void loadDataPokemon(List<Pokemon> list) {
        PokemonAdapter adapter = new PokemonAdapter(this, list);
        binding.gridPokemon.setAdapter(adapter);
        binding.gridPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.nextPage(list.get(position));
            }
        });
    }
}