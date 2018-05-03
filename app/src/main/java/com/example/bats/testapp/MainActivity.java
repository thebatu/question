package com.example.bats.testapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity implements PagerNavigationInterface {

	private ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		pager = (ViewPager) findViewById(R.id.viewPager);
		pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
	}

	@Override
	public void goPrevious() {
		pager.setCurrentItem(pager.getCurrentItem() - 1);
	}

	@Override
	public void goNext() {
		pager.setCurrentItem(pager.getCurrentItem() + 1);
	}

	private class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int pos) {
			FirstFragment firstFragment = FirstFragment.newInstance("FirstFragment, Instance 1");
			firstFragment.setPagerNavigationInterface(MainActivity.this);

			SecondFragment secondFragment = SecondFragment.newInstance("FirstFragment, Instance 1");
			secondFragment.setPagerNavigationInterface(MainActivity.this);

			ThirdFragment thirdFragment = ThirdFragment.newInstance("FirstFragment, Instance 1");
			thirdFragment.setPagerNavigationInterface(MainActivity.this);

			switch (pos) {
				case 0:
					return firstFragment;
				case 1:
					return secondFragment;
				default:
					return thirdFragment;
			}
		}

		@Override
		public int getCount() {
			return 3;
		}
	}
}
