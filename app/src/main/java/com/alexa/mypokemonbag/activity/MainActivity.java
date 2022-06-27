package com.alexa.mypokemonbag.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.databinding.ActivityMainBinding;
import com.alexa.mypokemonbag.view.HomeContract;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements HomeContract.View {

    private HomeContract.Presenter presenter;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindViews() {

    }

    @Override
    public void displayErrorMessage() {

    }

    @Override
    public void displaySucessToast() {

    }

    @Override
    public void startHomeActivity() {

    }
}