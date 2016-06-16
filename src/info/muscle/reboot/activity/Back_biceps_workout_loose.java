package info.muscle.reboot.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import info.muscle.reboot.R;

public class Back_biceps_workout_loose extends Fragment {

	SharedPreferences.Editor edt ;
	SharedPreferences sharedPreferences;
	SharedPreferences pref;



	EditText i_c,f_p,p_d,i_f,c_g,l_t,t_p;

	EditText i_c1,f_p1,p_d1,i_f1,c_g1,l_t1,t_p1;

	String i_c1s,f_ps,p_ds,i_fs,c_gs,l_ts,t_ps;

	String i_c1s1,f_ps1,p_ds1,i_fs1,c_gs1,l_ts1,t_ps1;

	Button finish;




	public Back_biceps_workout_loose() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		android.app.ActionBar actionBar = getActivity().getActionBar();

		// Enabling Up / Back navigation
		actionBar.setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.back_biceps_layout_loose, container, false);
		rootView.setFocusableInTouchMode(true);
		rootView.requestFocus();
		rootView.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {/*
						getActivity().onBackPressed();
					*/}
				}
				return false;
			}
		});
		//Getting Store Value From shared

		sharedPreferences = getActivity().getPreferences(1);

		//For weight

		i_c1s=sharedPreferences.getString("exb1l", "");

		f_ps=sharedPreferences.getString("exb2l", "");

		p_ds=sharedPreferences.getString("exb3l", "");

		i_fs=sharedPreferences.getString("exb4l", "");

		c_gs=sharedPreferences.getString("exb5l", "");

		l_ts=sharedPreferences.getString("exb6l", "");

		t_ps=sharedPreferences.getString("exb7l", "");

		//For rep

		i_c1s1=sharedPreferences.getString("rb1l", "");

		f_ps1=sharedPreferences.getString("rb2l", "");

		p_ds1=sharedPreferences.getString("rb3l", "");

		i_fs1=sharedPreferences.getString("rb4l", "");

		c_gs1=sharedPreferences.getString("rb5l", "");

		l_ts1=sharedPreferences.getString("rb6l", "");

		t_ps1=sharedPreferences.getString("rb7l", "");



		//Weight
		i_c=(EditText)rootView.findViewById(R.id.ip_w1);
		i_c.setText(i_c1s);
		f_p=(EditText)rootView.findViewById(R.id.f_b_w1);
		f_p.setText(f_ps);
		p_d=(EditText)rootView.findViewById(R.id.p_d_w1);
		p_d.setText(p_ds);
		i_f=(EditText)rootView.findViewById(R.id.i_d_w1);
		i_f.setText(i_fs);
		c_g=(EditText)rootView.findViewById(R.id.c_g_w1);
		c_g.setText(c_gs);
		l_t=(EditText)rootView.findViewById(R.id.l_t_w1);
		l_t.setText(l_ts);
		t_p=(EditText)rootView.findViewById(R.id.t_p_w1);
		t_p.setText(t_ps);

		//Reps

		i_c1=(EditText)rootView.findViewById(R.id.ip_r);
		i_c1.setText(i_c1s1);

		f_p1=(EditText)rootView.findViewById(R.id.f_b_r);
		f_p1.setText(f_ps1);

		p_d1=(EditText)rootView.findViewById(R.id.p_d_r);
		p_d1.setText(p_ds1);

		i_f1=(EditText)rootView.findViewById(R.id.i_d_r);
		i_f1.setText(i_fs1);

		c_g1=(EditText)rootView.findViewById(R.id.c_g_r);
		c_g1.setText(c_gs1);

		l_t1=(EditText)rootView.findViewById(R.id.l_t_r);
		l_t1.setText(l_ts1);

		t_p1=(EditText)rootView.findViewById(R.id.t_p_r);
		t_p1.setText(t_ps1);




		//Button finish

		finish=(Button)rootView.findViewById(R.id.save_wrk);
		finish.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				pref = getActivity().getPreferences(1);
				edt = pref.edit();

				//Storing for weight

				edt.putString("exb1l", i_c.getText().toString());
				edt.putString("exb2l", f_p.getText().toString());
				edt.putString("exb3l", p_d.getText().toString());
				edt.putString("exb4l", i_f.getText().toString());
				edt.putString("exb5l", c_g.getText().toString());
				edt.putString("exb6l", l_t.getText().toString());
				edt.putString("exb7l", t_p.getText().toString());


				//Storing for rep

				edt.putString("rb1l", i_c1.getText().toString());
				edt.putString("rb2l", f_p1.getText().toString());
				edt.putString("rb3l", p_d1.getText().toString());
				edt.putString("rb4l", i_f1.getText().toString());
				edt.putString("rb5l", c_g1.getText().toString());
				edt.putString("rb6l", l_t1.getText().toString());
				edt.putString("rb7l", t_p1.getText().toString());

				edt.apply();

				getActivity().getFragmentManager().popBackStack();

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
