package janjira.jiraporn.yonlada.aroirestuarant.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Member;

import janjira.jiraporn.yonlada.aroirestuarant.MainActivity;
import janjira.jiraporn.yonlada.aroirestuarant.R;
import janjira.jiraporn.yonlada.aroirestuarant.utility.GetAllData;
import janjira.jiraporn.yonlada.aroirestuarant.utility.MyAdapter;
import janjira.jiraporn.yonlada.aroirestuarant.utility.MyConstanct;

/**
 * Created by ASUS on 10/16/2017.
 */

public class MainFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Create Toolber
        createToolber();

//        Create ListView
        createListView();

    }  // Main Method

    private void createListView() {
        ListView listView = getView().findViewById(R.id.livShowPromotion);
        MyConstanct myConstanct = new MyConstanct();
        String[] columnUserStrings = myConstanct.getColumnUSER();
        String tag = "15novV1";

        try {

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstanct.getUrlPromotionString());
            String resultJSON = getAllData.get();
            Log.d(tag, "JSON ==> " + resultJSON);

            JSONArray jsonArray = new JSONArray(resultJSON);
            String[] titleStrings = new String[jsonArray.length()];
            String[] detailStrings = new String[jsonArray.length()];
            String[] iconStrings = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i += 1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                titleStrings[i] = jsonObject.getString(columnUserStrings[1]);
                detailStrings[i] = jsonObject.getString(columnUserStrings[2]);
                iconStrings[i] = jsonObject.getString(columnUserStrings[3]);

            }

            MyAdapter myAdapter = new MyAdapter(getActivity(),
                    titleStrings, detailStrings, iconStrings);
            listView.setAdapter(myAdapter);

        } catch (Exception e) {
            Log.d(tag, "e ==> " + e.toString());
        }

    }


    private void createToolber() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarMain);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        getActivity().setTitle(getString(R.string.promotion));

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_add_member);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFragmentMain, new AuthenFragment())
                        .addToBackStack(null).commit();
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
} // Main Class
