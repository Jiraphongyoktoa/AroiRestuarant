package janjira.jiraporn.yonlada.aroirestuarant.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import janjira.jiraporn.yonlada.aroirestuarant.R;
import janjira.jiraporn.yonlada.aroirestuarant.SerciveOrderActivity;

/**
 * Created by masterung on 22/12/2017 AD.
 */

public class ListOrderFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_order, container, false);
        return view;
    }
}
