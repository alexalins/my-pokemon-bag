package com.alexa.mypokemonbag.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.adapter.PokemonAdapter;
import com.alexa.mypokemonbag.adapter.RegionAdapter;
import com.alexa.mypokemonbag.databinding.ActivityDetailBagBinding;
import com.alexa.mypokemonbag.databinding.ActivityRegionBinding;
import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.model.Pokemon;
import com.alexa.mypokemonbag.model.Region;
import com.alexa.mypokemonbag.mvp.contract.DetailBagContract;
import com.alexa.mypokemonbag.mvp.presenter.DetailBagPresenter;
import com.alexa.mypokemonbag.util.BagUtil;
import com.alexa.mypokemonbag.util.PokemonUtil;
import com.alexa.mypokemonbag.util.Utils;
import com.google.gson.Gson;

import java.util.List;

public class DetailBagActivity extends AppCompatActivity implements DetailBagContract.View {

    private DetailBagContract.Presenter presenter;
    private ActivityDetailBagBinding binding;
    private List<Pokemon> listPokemon;
    private Bag myBag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bag);
        presenter = new DetailBagPresenter(this);
        presenter.start();
    }

    @Override
    public void setPresenter(DetailBagContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindViews() {
        binding = ActivityDetailBagBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //
        Bundle extras = getIntent().getExtras();
        String json = extras.getString(Utils.getBag());
        myBag = BagUtil.jsonToBag(json);
        //
        TextView title = binding.textTitle;
        TextView description = binding.textDescription;
        title.setText(myBag.getTitle());
        description.setText(myBag.getDescription());
        binding.buttonAddPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.savePokemon();
            }
        });
        //
        presenter.getBag(myBag);
    }

    @Override
    public void displayErrorMessage() {
        Utils.toast(this, "Erro ao buscar os dados dessa bolsa.");
    }

    @Override
    public void pageAddPokemon() {
        Intent intent = new Intent(this, RegionActivity.class);
        startActivity(intent);
    }

    @Override
    public void pageDetailPokemon(Pokemon pokemon) {
        Intent intent = new Intent(this, DetailPokemonActivity.class);
        String myJson = PokemonUtil.pokemonToJson(pokemon);
        intent.putExtra(Utils.getPokemon(), myJson);
        intent.putExtra(Utils.getEdit(), true);
        startActivity(intent);
    }

    @Override
    public void loadDataBag(Bag bag) {
        this.listPokemon = bag.getPokemons();
        PokemonAdapter adapter = new PokemonAdapter(this, this.listPokemon);
        if(listPokemon != null) {
            binding.gridPokemonBag.setAdapter(adapter);
            binding.gridPokemonBag.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    presenter.detailPokemon(listPokemon.get(position));
                }
            });
        }

    }

    @Override
    public void createDialogEdit() {

    }

    @Override
    public void createDialogDelete() {

    }
}