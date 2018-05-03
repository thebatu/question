package com.example.bats.testapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by bats on 5/3/18.
 */

public class ThirdFragment extends Fragment {


	public PagerNavigationInterface getPagerNavigationInterface() {
		return pagerNavigationInterface;
	}

	public void setPagerNavigationInterface(PagerNavigationInterface pagerNavigationInterface) {
		this.pagerNavigationInterface = pagerNavigationInterface;
	}

	private PagerNavigationInterface pagerNavigationInterface;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.third_frag, container, false);

		Button previous = (Button) v.findViewById(R.id.btn_previous);
		Button next = (Button) v.findViewById(R.id.btn_next);

		previous.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				pagerNavigationInterface.goPrevious();
			}
		});

		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				pagerNavigationInterface.goNext();
			}
		});
		return v;
	}

	public static ThirdFragment newInstance(String text) {

		ThirdFragment f = new ThirdFragment();
		Bundle b = new Bundle();
		b.putString("msg", text);

		f.setArguments(b);

		return f;
	}
}

