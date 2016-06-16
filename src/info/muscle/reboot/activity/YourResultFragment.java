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
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import info.muscle.reboot.R;


public class YourResultFragment extends Fragment {

	TextView txtlable,txtdiet,txtcalresult,txtper,txtbf,txtbfresult,txtbmi,txtbmiresult,txthealth,txthealthresult,txthealthresult2;
	SharedPreferences pref;
	Button btn2;
	String diet;
	public YourResultFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_your_result, container, false);

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

		//Getting Calculated Result

		pref = getActivity().getPreferences(1);
		String diet = pref.getString("cal_req_result", "0");
		String bmi_get=pref.getString("bmi_result", "0");
		String bf_health=pref.getString("bf_status", "Unknown");
		String bmi_health=pref.getString("bmi_status", "Unknown");
		String bf=pref.getString("bf_r", "0");



		//Setting Custom Fonts

		/*Typeface fontB = Typeface.createFromAsset(getActivity().getAssets(), "fonts/BEBAS.TTF");
		Typeface fontR = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto_Light.ttf");*/

		//View all Component

		txtlable=(TextView)rootView.findViewById(R.id.label);
		//txtlable.setTypeface(fontB);

		txtdiet=(TextView)rootView.findViewById(R.id.textView);
		/*		txtdiet.setTypeface(fontB);
		 */

		txtcalresult=(TextView)rootView.findViewById(R.id.txt_cal);
		/*		txtcalresult.setTypeface(fontR);
		 */		txtcalresult.setText(diet);

		 txtper=(TextView)rootView.findViewById(R.id.textView2);
		 /*		txtper.setTypeface(fontB);
		  */
		 txtbf=(TextView)rootView.findViewById(R.id.textView3);
		 /*		txtbf.setTypeface(fontB);
		  */
		 txtbfresult=(TextView)rootView.findViewById(R.id.txt_body_fat);
		 /*		txtbfresult.setTypeface(fontR);
		  */		txtbfresult.setText(bf);

		  txtbmi=(TextView)rootView.findViewById(R.id.textView5);
		  /*		txtbmi.setTypeface(fontB);
		   */
		  txtbmiresult=(TextView)rootView.findViewById(R.id.txt_bmi);
		  /*		txtbmiresult.setTypeface(fontR);
		   */		txtbmiresult.setText(bmi_get);

		   txthealth=(TextView)rootView.findViewById(R.id.textView6);
		   /*		txthealth.setTypeface(fontB);
		    */
		   txthealthresult=(TextView)rootView.findViewById(R.id.txt_health_statusbf);
		   /*		txthealthresult.setTypeface(fontR);
		    */		txthealthresult.setText(bf_health);

		    txthealthresult2=(TextView)rootView.findViewById(R.id.txt_health_statusbmi);
		    /*		txthealthresult2.setTypeface(fontR);
		     */		txthealthresult2.setText(bmi_health);







		     btn2=(Button)rootView.findViewById(R.id.btn2);
		     btn2.setOnClickListener(new OnClickListener() {

		    	 @Override
		    	 public void onClick(View v) {

		    		 
		    		 
		    		 Toast.makeText(getActivity(), "Cool , Now Its Time To Check Your Macro !!!", 
								Toast.LENGTH_LONG).show();

		    		/* Fragment newFragment = new YourMacroResultFragment();

		    		 FragmentTransaction transaction = getFragmentManager()
		    				 .beginTransaction();

		    		 transaction.replace(android.R.id.content, newFragment);

		    		 transaction.addToBackStack("tag");

		    		 transaction.commitAllowingStateLoss();*/

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
