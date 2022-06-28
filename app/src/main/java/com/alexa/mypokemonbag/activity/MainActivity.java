package com.alexa.mypokemonbag.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.adapter.BagAdapter;
import com.alexa.mypokemonbag.databinding.ActivityMainBinding;
import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.presenter.HomePresenter;
import com.alexa.mypokemonbag.util.Utils;
import com.alexa.mypokemonbag.view.HomeContract;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeContract.View {

    private HomeContract.Presenter presenter;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private BagAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        presenter = new HomePresenter(this);
        presenter.start();

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindViews() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<Bag> list = (ArrayList<Bag>) presenter.getListsBag();
        adapter = new BagAdapter(this, list);
        binding.include.listview.setAdapter(adapter);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.nextPage();
            }
        });
    }

    @Override
    public void displayErrorMessage() {
        Utils.toast(this, "Erro ao listar seus dados");
    }

    @Override
    public void pageRegion() {
        Intent intent = new Intent(this, RegionActivity.class);
        startActivity(intent);
    }
}