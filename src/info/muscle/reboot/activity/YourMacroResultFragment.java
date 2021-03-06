package info.muscle.reboot.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import info.muscle.reboot.activity.Macro_readme;
import info.muscle.reboot.R;


public class YourMacroResultFragment extends Fragment {

	Spinner spinner_goal;
	String selected_goal,bmr;
	double req_diet_goal,diet_goal;
	TextView macro_goal,pro_per,carb_per,fats_per,pro_cal,fat_cal,carb_cal;
	SharedPreferences.Editor edt ;
	int saved_spinner_goal;
	SharedPreferences pref;
	public YourMacroResultFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_macro, container, false);
		rootView.setFocusableInTouchMode(true);
		rootView.requestFocus();

		rootView.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {Intent intent = new Intent(getActivity(), MainActivity.class);
					getActivity().startActivity(intent);
					getActivity().finish();
					}
				}
				return false;
			}
		});
		macro_goal=(TextView)rootView.findViewById(R.id.macro_goal_calories_calculated);

		//Macro Percent 

		pro_per=(TextView)rootView.findViewById(R.id.macro_protein_percentage_calculated);

		carb_per=(TextView)rootView.findViewById(R.id.macro_carb_percentage_calculated);

		fats_per=(TextView)rootView.findViewById(R.id.macro_fat_percentage_calculated);

		//Macro Cal

		pro_cal=(TextView)rootView.findViewById(R.id.macro_protein_percentage_manual);

		carb_cal=(TextView)rootView.findViewById(R.id.macro_carb_percentage_manual);

		fat_cal=(TextView)rootView.findViewById(R.id.macro_fat_percentage_manual);




		pref = getActivity().getPreferences(1);
		bmr=pref.getString("cal_req_result", "0");
		req_diet_goal=Double.parseDouble(bmr);


		spinner_goal=(Spinner)rootView.findViewById(R.id.spinner_fitness_goal);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.fitness_goal,
				android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

		spinner_goal.setAdapter(adapter);

		spinner_goal.setGravity(Gravity.CENTER);

		spinner_goal.getSelectedItemPosition();

		int indexOfPreviousSelection = pref.getInt("spinner_goal_key", 0);

		spinner_goal.setSelection(indexOfPreviousSelection);

		spinner_goal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected_goal = parentView.getItemAtPosition(position).toString();


				if(selected_goal.equals("Loose Fat"))
				{
					diet_goal=Math.round(req_diet_goal*0.8);

					macro_goal.setText(""+diet_goal);

					pro_per.setText("45%");

					carb_per.setText("25%");

					fats_per.setText("30%");

					double pro_req=Math.round(diet_goal*0.45/4);
					pro_cal.setText(""+pro_req);

					double fat_req=Math.round(diet_goal*0.3/9);
					carb_cal.setText(""+fat_req);

					double carb_req=Math.round(diet_goal*0.25/4);
					fat_cal.setText(""+carb_req);

				}
				if(selected_goal.equals("Gain Muscle"))
				{
					diet_goal=Math.round(req_diet_goal*1.1);

					macro_goal.setText(""+diet_goal);

					pro_per.setText("40%");

					carb_per.setText("40%");

					fats_per.setText("30%");

					double pro_req=Math.round(diet_goal*0.3/4);
					pro_cal.setText(""+pro_req);

					double fat_req=Math.round(diet_goal*0.3/9);
					fat_cal.setText(""+fat_req);

					double carb_req=Math.round(diet_goal*0.4/4);
					carb_cal.setText(""+carb_req);


				}
				/*if(selected_goal.equals("Maintain"))
				{
					diet_goal=Math.round(req_diet_goal);

					macro_goal.setText(""+diet_goal);

					pro_per.setText("40%");

					carb_per.setText("40%");

					fats_per.setText("30%");

					double pro_req=Math.round(diet_goal*0.3/4);
					pro_cal.setText(""+pro_req);

					double fat_req=Math.round(diet_goal*0.3/9);
					fat_cal.setText(""+fat_req);

					double carb_req=Math.round(diet_goal*0.4/4);
					carb_cal.setText(""+carb_req);

				}*/
				if(selected_goal.endsWith("Extreme Loss(Consult Doctor)"))
				{
					diet_goal=Math.round(req_diet_goal*0.8);

					macro_goal.setText(""+diet_goal);

					pro_per.setText("35%");

					carb_per.setText("5%");

					fats_per.setText("60%");

					double pro_req=Math.round(diet_goal*0.35/4);
					pro_cal.setText(""+pro_req);

					double fat_req=Math.round(diet_goal*0.6/9);
					fat_cal.setText(""+fat_req);

					double carb_req=Math.round(diet_goal*0.05/4);
					carb_cal.setText(""+carb_req);
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {
				// your code here
			}
		});



		Button btndiet=(Button)rootView.findViewById(R.id.diet);
		btndiet.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(selected_goal.equals("Select Your Fitness Goal"))
				{
					Toast.makeText(getActivity(), "Select Your Fitness Goal You Want.", 
							Toast.LENGTH_SHORT).show();
				}
				else{
					pref = getActivity().getPreferences(1);
					edt = pref.edit();
					edt.putInt("spinner_goal_key", spinner_goal.getSelectedItemPosition());	
					edt.putString("macro_cal", macro_goal.getText().toString());
					edt.putString("protein_req", pro_cal.getText().toString());
					edt.putString("fats_req", fat_cal.getText().toString());
					edt.putString("carbs_req", carb_cal.getText().toString());

					edt.apply();
					
					
					Toast.makeText(getActivity(), "Awesome Almost , Set Your Desire Diet Plan !!!", 
							Toast.LENGTH_LONG).show();


					/*Fragment newFragment = new DietPlanFragment();
					FragmentTransaction transaction = getFragmentManager()
							.beginTransaction();

					// Replace whatever is in the fragment_container view with this
					// fragment,
					// and add the transaction to the back stack
					transaction.replace(android.R.id.content, newFragment);
					transaction.addToBackStack("tag");

					// Commit the transaction
					transaction.commitAllowingStateLoss();*/
				}
				/*Intent intent = new Intent(getActivity(), MainActivity.class);
					getActivity().startActivity(intent); */
			}	

		});

		Button rd1=(Button)rootView.findViewById(R.id.macro_read_me);
		rd1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getActivity(), Macro_readme.class);
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
