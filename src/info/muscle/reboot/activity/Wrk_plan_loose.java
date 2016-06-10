package info.muscle.reboot.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import info.muscle.reboot.R;


/**
 * Created by Ravi on 29/07/15.
 */
public class Wrk_plan_loose extends Fragment {

	public Wrk_plan_loose() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.wrk_plan_layout_loose, container, false);

		Button chest_btn=(Button)rootView.findViewById(R.id.chest_tri_btn);
		chest_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Fragment newFragment = new Chest_tri_workout_loose();
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
				Fragment newFragment = new Leg_workout_loose();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();
				transaction.replace(android.R.id.content, newFragment);
				transaction.addToBackStack("tag");

				transaction.commitAllowingStateLoss();				
			}
		});

		Button delt_btn=(Button)rootView.findViewById(R.id.delts_btn);
		delt_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Fragment newFragment = new Shoulder_workout_loose();
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
				Fragment newFragment = new Back_biceps_workout_loose();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();
				transaction.replace(android.R.id.content, newFragment);
				transaction.addToBackStack("tag");
				transaction.commitAllowingStateLoss();				
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
