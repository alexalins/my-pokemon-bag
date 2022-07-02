package com.alexa.mypokemonbag.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.adapter.BagAdapter;
import com.alexa.mypokemonbag.databinding.ActivityMainBinding;
import com.alexa.mypokemonbag.databinding.ModalAddBagBinding;
import com.alexa.mypokemonbag.databinding.ModalSavePokemonBagBinding;
import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.mvp.presenter.HomePresenter;
import com.alexa.mypokemonbag.util.BagUtil;
import com.alexa.mypokemonbag.util.Utils;
import com.alexa.mypokemonbag.mvp.contract.HomeContract;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.View {

    private HomeContract.Presenter presenter;
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
        List<Bag> list = presenter.getListBag();
        adapter = new BagAdapter(this, list);
        binding.include.listview.setAdapter(adapter);
        binding.include.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.nextPage(list.get(position));
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.dialiogSave();
            }
        });
    }

    @Override
    public void displayErrorMessage() {
        Utils.toast(this, "Erro ao listar seus dados.");
    }

    @Override
    public void pageDetailBag(Bag bag) {
        Intent intent = new Intent(this, DetailBagActivity.class);
        String json = BagUtil.bagToJson(bag);
        intent.putExtra(Utils.getBag(), json);
        startActivity(intent);
    }

    @Override
    public void createDialog() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.modal_add_bag);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //
        EditText editTextName = dialog.findViewById(R.id.editTextName);
        EditText editTextDescription = dialog.findViewById(R.id.editTextDescription);
        Button btn_save = dialog.findViewById(R.id.button);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Utils.toast(getBaseContext(), "Salva com sucesso!");
            }
        });
        //
        dialog.show();
    }

}