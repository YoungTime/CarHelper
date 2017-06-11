package fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.duzeming.carhelper.R;

/**
 * Created by DuZeming on 2017/4/27.
 */
public class NavigationFragment extends Fragment implements View.OnClickListener {

    private RadioButton toMap;
    private RadioButton toNew;
    private RadioButton toMy;
    private FragmentManager fragmentManager;
    private android.support.v4.app.FragmentTransaction transaction;
    MapFragment mapFragment;
    NewFragment newFragment;
    MyFragment myFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation,container,false);


        fragmentManager = getActivity().getSupportFragmentManager();
        mapFragment = new MapFragment();
        newFragment = new NewFragment();
        myFragment = new MyFragment();

        fragmentManager.beginTransaction().add(R.id.fra_up,mapFragment).add(R.id.fra_up,newFragment)
                .add(R.id.fra_up,myFragment).commit();
        fragmentManager.beginTransaction().hide(newFragment).hide(myFragment).commit();

        toMap = (RadioButton) view.findViewById(R.id.radio_toMap);
        toNew= (RadioButton) view.findViewById(R.id.radio_toNew);
        toMy= (RadioButton) view.findViewById(R.id.radio_toMy);
        toMap.setChecked(true);
        toMap.setOnClickListener(this);
        toNew.setOnClickListener(this);
        toMy.setOnClickListener(this);


        return  view;
    }

    @Override
    public void onClick(View v) {
        transaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.radio_toMap:
                transaction.hide(newFragment).hide(myFragment).show(mapFragment).commit();
                break;
            case R.id.radio_toNew:
                transaction.hide(mapFragment).hide(myFragment).show(newFragment).commit();
                break;
            case R.id.radio_toMy:
                transaction.hide(newFragment).hide(mapFragment).show(myFragment).commit();
                break;
        }
    }
}
