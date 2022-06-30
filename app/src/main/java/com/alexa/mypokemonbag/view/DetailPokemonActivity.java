package com.alexa.mypokemonbag.view;

import android.os.Bundle;

import com.alexa.mypokemonbag.databinding.ActivityDetailPokemonBinding;
import com.alexa.mypokemonbag.mvp.contract.DetailPokemonContract;
import com.alexa.mypokemonbag.mvp.presenter.DetailPokemonPresenter;
import com.alexa.mypokemonbag.util.Utils;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class DetailPokemonActivity extends AppCompatActivity implements DetailPokemonContract.View {

    private ActivityDetailPokemonBinding binding;
    private DetailPokemonContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new DetailPokemonPresenter(this);
        presenter.start();
    }

    @Override
    public void setPresenter(DetailPokemonContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindViews() {
        binding = ActivityDetailPokemonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Toolbar toolbar = binding.toolbar;
        //(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.savePokemon();
            }
        });
    }

    @Override
    public void displayErrorMessage() {
        Utils.toast(this, "Erro em buscar os dados desse Pokémon.");
    }

    @Override
    public void pageBags() {
        ModalSavePokemonBag modal = new ModalSavePokemonBag();
        modal.show(getSupportFragmentManager(), "modalSavePokemonBag");
    }
}