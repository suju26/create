package info.muscle.reboot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.Button;
import info.muscle.reboot.R;


/**
 * Created by Ravi on 29/07/15.
 */
public class Wrk_plan_gain extends Fragment {

	public Wrk_plan_gain() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.wrk_plan_layout_gain, container, false);
		rootView.setFocusableInTouchMode(true);
		rootView.requestFocus();

		rootView.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_BACK) 
					{
						return true;
					}
				}
				return false;
			}
		});

		Button chest_btn=(Button)rootView.findViewById(R.id.chest_tri_btn);
		chest_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Fragment newFragment = new Chest_tri_workout_mass();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();
				transaction.replace(android.R.id.content, newFragment);
				transaction.addToBackStack("tag");
				transaction.commitAllowingStateLoss();				
			}
		});

		Button leg_btn=(Button)rootView.findViewById(R.id.Legs_btn);
		leg_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Fragment newFragment = new Leg_workout_mass();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();
				transaction.replace(android.R.id.content, newFragment);
				transaction.addToBackStack(null);

				transaction.commitAllowingStateLoss();				
			}
		});

		Button delt_btn=(Button)rootView.findViewById(R.id.delts_btn);
		delt_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Fragment newFragment = new Shoulder_workout_mass2();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();
				transaction.replace(android.R.id.content, newFragment);
				transaction.addToBackStack("tag");
				transaction.commitAllowingStateLoss();				
			}
		});
		Button back_bi_btn=(Button)rootView.findViewById(R.id.back_biceps_btn);
		back_bi_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Fragment newFragment = new Back_biceps_workout_mass();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();
				transaction.replace(android.R.id.content, newFragment);
				transaction.addToBackStack("tag");
				transaction.commitAllowingStateLoss();	
			    getFragmentManager().beginTransaction().remove(newFragment).commit();

			}
		});
		// Inflate the layout for this fragment
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}
}
