package helloworld.example.com.calculator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//         Set dividers around boxes
//        getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.holo_blue_dark));
//        getListView().setDividerHeight(1);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
