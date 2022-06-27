package com.alexa.mypokemonbag.mvp;

public interface BaseContract {
    interface BaseView<T> {
        void setPresenter(T presenter);
        void bindViews();
    }

    interface BasePresenter {
        void start();
    }
}
