package com.alexa.mypokemonbag.util;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.alexa.mypokemonbag.R;
import com.alexa.mypokemonbag.adapter.BagAdapter;
import com.alexa.mypokemonbag.model.Bag;
import com.alexa.mypokemonbag.mvp.contract.ModalSavePokemonBagContract;
import com.alexa.mypokemonbag.mvp.presenter.ModalSavePokemonBagPresenter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class ModalSavePokemonBag extends BottomSheetDialogFragment implements ModalSavePokemonBagContract.View {

    private ModalSavePokemonBagContract.Presenter presenter;
    private BagAdapter adapter;
    private View view;
    private BottomSheetDialog dialog;
    private BottomSheetBehavior<View> bottomSheetBehavior;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.modal_save_pokemon_bag, container, false);
        presenter = new ModalSavePokemonBagPresenter(this);
        presenter.start();
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        return dialog;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        ConstraintLayout layout = dialog.findViewById(R.id.bottom_modal_layout);
        assert layout != null;
        layout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
    }

    @Override
    public void setPresenter(ModalSavePokemonBagContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindViews() {
        List<Bag> list = presenter.getListBag();
        adapter = new BagAdapter(view.getContext(), list);
        ListView listView = view.findViewById(R.id.list_bag);
        listView.setAdapter(adapter);
        Button button =  view.findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.savePokemon();
                dismiss();
            }
        });
    }

    @Override
    public void displayErrorMessage() {
        Utils.toast(view.getContext(), "Erro ao salvar o Pokémon!");
    }

    @Override
    public void displaySaveMessage() {
        Utils.toast(view.getContext(), "Pokémon Salvo com sucesso!");
    }
}
