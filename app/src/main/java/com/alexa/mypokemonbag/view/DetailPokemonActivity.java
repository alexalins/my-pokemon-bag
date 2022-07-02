package com.alexa.mypokemonbag.view;

import android.os.Bundle;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.databinding.ActivityDetailPokemonBinding;
import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.mvp.contract.DetailPokemonContract;
import com.alexa.mypokemonbag.mvp.presenter.DetailPokemonPresenter;
import com.alexa.mypokemonbag.util.PokemonUtil;
import com.alexa.mypokemonbag.util.Utils;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class DetailPokemonActivity extends AppCompatActivity implements DetailPokemonContract.View {

    private ActivityDetailPokemonBinding binding;
    private DetailPokemonContract.Presenter presenter;
    private Pokemon myPokemon;

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
        //
        Bundle extras = getIntent().getExtras();
        String json = extras.getString(Utils.getPokemon());
        boolean isEdit = extras.getBoolean(Utils.getEdit());
        myPokemon = PokemonUtil.jsonToPokemon(json);
        //
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(myPokemon.getName());
        FloatingActionButton fab = binding.fab;
        if(isEdit) {
            fab.setImageResource(R.drawable.ic_edit_white);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.savePokemon();
            }
        });

        Glide.with(this).load(Utils.getUrlImage(myPokemon.getUrl())).into(binding.imagePokemon);
    }

    @Override
    public void displayErrorMessage() {
        Utils.toast(this, "Erro em buscar os dados desse Pokémon.");
    }

    @Override
    public void displaySuccessSaveMessage() {
        Utils.toast(this, "Sucesso ao salvar Pokémon na bag");
    }

    @Override
    public void displayErrorSaveMessage() {
        Utils.toast(this, "Erro ao salvar Pokémon na bag.");

    }
}