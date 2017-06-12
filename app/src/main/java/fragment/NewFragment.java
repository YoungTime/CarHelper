package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.duzeming.carhelper.R;
import java.util.ArrayList;
import java.util.List;
import adapter.NewFragmentPagerAdapter;

/**
 * Created by DuZeming on 2017/4/27.
 */
public class NewFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new,container,false);

        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new CarOfNewFragment());
        fragmentList.add(new NearOfNewFragment());
        fragmentList.add(new FriendsOfNewFragment());

        titleList=new ArrayList<String>();
        titleList.add("淘车");
        titleList.add("附近");
        titleList.add("车友");
        tabLayout= (TabLayout) view.findViewById(R.id.tablayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        for(int i=0;i<titleList.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(i)));
        }

        viewPager= (ViewPager) view.findViewById(R.id.viewpager_new);
        NewFragmentPagerAdapter adapter=new NewFragmentPagerAdapter(getFragmentManager(),
                fragmentList,titleList,getActivity());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return  view;
    }
}
