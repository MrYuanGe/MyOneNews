package com.example.administrator.myonenews.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myonenews.R;

/**
 * Created by Administrator on 2016/12/28.
 */

public class FunctionOne extends Fragment {
   private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.functionone,null);
        return view;
    }
}
