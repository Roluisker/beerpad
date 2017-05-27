package homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.beerpad.R;

import adapters.BookingViewPagerAdapter;
import utils.AnimationGenericUtils;
import widget.BookingTabTitleWidget;

/**
 * Created by luisalfonsobejaranosanchez on 5/27/17.
 */

public class TripActionsFragment extends Fragment {

    private final String WIDGET_TAG = "TabTitleHomeViewPager";
    private static final String INFO_TAG = "ShowInfoTag";

    private ViewPager mViewPager;
    private BookingTabTitleWidget mBookingTrips;
    private BookingTabTitleWidget mManageTrips;
    private BookingViewPagerAdapter mAdapter;
    private RelativeLayout mPreferredContainer;

    private boolean showPreferredInfo;


    public static TripActionsFragment newInstance(boolean showPreferredInfo) {
        TripActionsFragment tripFragment = new TripActionsFragment();
        Bundle args = new Bundle();
        args.putBoolean(INFO_TAG, showPreferredInfo);
        tripFragment.setArguments(args);
        return tripFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            showPreferredInfo = bundle.getBoolean(INFO_TAG);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_trips_actions, container, false);

        //Initialize views
        mViewPager = (ViewPager) rootView.findViewById(R.id.homepageManagePager);
        mPreferredContainer = (RelativeLayout) rootView.findViewById(R.id.homepagePreferredContainer);

        mBookingTrips = (BookingTabTitleWidget) rootView.findViewById(R.id.book_trips);
        mManageTrips = (BookingTabTitleWidget) rootView.findViewById(R.id.manage_trips);

        //Create/set viewpager adapter

        mAdapter = new BookingViewPagerAdapter(getChildFragmentManager(),
                getActivity().getResources().getStringArray(R.array.homepage_booking_tabs), getActivity());

        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(onPageChangeListener);

        mBookingTrips.setTag(WIDGET_TAG + "0");
        mManageTrips.setTag(WIDGET_TAG + "1");

        mManageTrips.setOnClickListener(tabClickListener);
        mBookingTrips.setOnClickListener(tabClickListener);
        mBookingTrips.setSelected();

        if (showPreferredInfo) {
            showPreferredInfo();
        }

        return rootView;
    }

    public void showPreferredInfo() {
        AnimationGenericUtils.fadeInAnimation(mPreferredContainer, null, getContext());
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            if (mAdapter != null) {
                android.support.v4.app.Fragment f = mAdapter.getItem(position);
                if (f != null && f instanceof OnTabSelectedListener) {
                    ((OnTabSelectedListener) f).onTabSelected(position);
                }
            }
            selectedTab(position);
        }

        private void selectedTab(int tabIndex) {
            switch (tabIndex) {
                case 0:
                    mBookingTrips.setSelected();
                    mManageTrips.setDeselected();
                    mAdapter.animateAtIndex(0);
                    break;

                case 1:
                    mManageTrips.setSelected();
                    mBookingTrips.setDeselected();
                    mAdapter.animateAtIndex(1);
                    break;
            }

        }

    };

    private View.OnClickListener tabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                if (tag.toString().startsWith(WIDGET_TAG)) {
                    int index = Integer.parseInt(tag.toString().substring(WIDGET_TAG.length()));
                    mViewPager.setCurrentItem(index, true);
                }
            }
        }
    };


    public interface OnTabSelectedListener {
        void onTabSelected(int position);
    }


}
