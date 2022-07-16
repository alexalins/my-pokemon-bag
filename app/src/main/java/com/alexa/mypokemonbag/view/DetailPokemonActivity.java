package com.alexa.mypokemonbag.view;

import android.os.Bundle;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.databinding.ActivityDetailPokemonBinding;
import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.model.Type;
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
        presenter.getPokemon(myPokemon);
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

    @Override
    public void loadDataPokemon(Pokemon pokemon) {
        binding.include.textType.setText(stringTypes(pokemon));
        binding.include.textHeight.setText("Altura: " +String.valueOf(pokemon.getHeight()));
        binding.include.textWeight.setText("Peso: " + String.valueOf(pokemon.getWeight()));
        binding.include.progressHp.setProgress(pokemon.getStats().get(0).getValue());
        binding.include.progressAttack.setProgress(pokemon.getStats().get(1).getValue());
        binding.include.progressDefense.setProgress(pokemon.getStats().get(2).getValue());
        binding.include.progressSpecialAttack.setProgress(pokemon.getStats().get(3).getValue());
        binding.include.progressSpecialDefense.setProgress(pokemon.getStats().get(4).getValue());
        binding.include.progressSpeed.setProgress(pokemon.getStats().get(5).getValue());
    }

    private String stringTypes(Pokemon pokemon) {
        String stringtypes = "Tipo: ";
        for(Type type : pokemon.getTypes()) {
            if(stringtypes == "Tipo: ") {
                stringtypes =  stringtypes + type.getName();
            } else {
                stringtypes = stringtypes + ", "+ type.getName();
            }
        }

        return stringtypes;
    }
}