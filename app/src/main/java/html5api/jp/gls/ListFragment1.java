package html5api.jp.gls;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kgotoh on 2016/04/24.
 */
public class ListFragment1  extends AbstractListFragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        type = 1;
    }

}