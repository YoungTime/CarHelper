package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by DuZeming on 2017/1/5.
 */
public class NewFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment>fragmentList;
    private List<String>titleList;
    private FragmentManager fragmentManager;
    private Context mcontext;

    public NewFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList
            , Context context){
        super(fm);
        this.fragmentManager=fm;
        this.fragmentList=fragmentList;
        this.titleList=titleList;
        mcontext = context;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position % titleList.size());
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
