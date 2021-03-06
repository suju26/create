package info.muscle.reboot.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import info.muscle.reboot.R;

public class Leg_workout_loose extends Fragment {

	SharedPreferences.Editor edt ;
	SharedPreferences sharedPreferences;
	SharedPreferences pref;



	EditText i_c,f_p,p_d,i_f,c_g,l_t,t_p;
	
	EditText i_c1,f_p1,p_d1,i_f1,c_g1,l_t1,t_p1;
	
	String i_c1s,f_ps,p_ds,i_fs,c_gs,l_ts,t_ps;
	
	String i_c1s1,f_ps1,p_ds1,i_fs1,c_gs1,l_ts1,t_ps1;
	
	Button finish;




	public Leg_workout_loose() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.leg_layout_loose, container, false);
		rootView.setFocusableInTouchMode(true);
		rootView.requestFocus();

		rootView.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {Intent intent = new Intent(getActivity(), MainActivity.class);
					getActivity().startActivity(intent);getActivity().finish();}
				}
				return false;
			}
		});
		//Getting Store Value From shared

				sharedPreferences = getActivity().getPreferences(1);
				
				//For weight

				i_c1s=sharedPreferences.getString("exl1l", "");

				f_ps=sharedPreferences.getString("exl2l", "");

				p_ds=sharedPreferences.getString("exl3l", "");

				i_fs=sharedPreferences.getString("exl4l", "");

				c_gs=sharedPreferences.getString("exl5l", "");

				l_ts=sharedPreferences.getString("exl6l", "");

				t_ps=sharedPreferences.getString("exl7l", "");

				//For rep

				i_c1s1=sharedPreferences.getString("rl1l", "");

				f_ps1=sharedPreferences.getString("rl2l", "");

				p_ds1=sharedPreferences.getString("rl3l", "");

				i_fs1=sharedPreferences.getString("rl4l", "");

				c_gs1=sharedPreferences.getString("rl5l", "");

				l_ts1=sharedPreferences.getString("rl6l", "");

				t_ps1=sharedPreferences.getString("rl7l", "");



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

				edt.putString("exl1l", i_c.getText().toString());
				edt.putString("exl2l", f_p.getText().toString());
				edt.putString("exl3l", p_d.getText().toString());
				edt.putString("exl4l", i_f.getText().toString());
				edt.putString("exl5l", c_g.getText().toString());
				edt.putString("exl6l", l_t.getText().toString());
				edt.putString("exl7l", t_p.getText().toString());


				//Storing for rep

				edt.putString("rl1l", i_c1.getText().toString());
				edt.putString("rl2l", f_p1.getText().toString());
				edt.putString("rl3l", p_d1.getText().toString());
				edt.putString("rl4l", i_f1.getText().toString());
				edt.putString("rl5l", c_g1.getText().toString());
				edt.putString("rl6l", l_t1.getText().toString());
				edt.putString("rl7l", t_p1.getText().toString());

				edt.apply();

				Intent intent = new Intent(getActivity(), MainActivity.class);
				getActivity().startActivity(intent);

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
