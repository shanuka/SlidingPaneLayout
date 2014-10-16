package com.example.slidinglayer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slidinglayer.dummy.DummyContent;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

/**
 * A fragment representing a single Menu detail screen.
 */
public class MenuDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	private View mRootView;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public MenuDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.detail, menu);
	}
	
	 TestFragmentAdapter mAdapter;
	 PageIndicator mIndicator;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_menu_detail, container,
				false);
		
		mAdapter = new TestFragmentAdapter(getFragmentManager());

		ViewPager mPager = (ViewPager) mRootView.findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		mIndicator = (CirclePageIndicator) mRootView
				.findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);

		// Show the dummy content as text in a TextView.

		return mRootView;
	}

}
