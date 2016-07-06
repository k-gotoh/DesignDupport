package html5api.jp.gls;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kgotoh on 2016/04/24.
 */
public class ListFragment2  extends AbstractListFragment {
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        type = 2;
    }
}