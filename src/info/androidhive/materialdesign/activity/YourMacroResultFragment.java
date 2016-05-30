package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import info.androidhive.materialdesign.R;


public class YourMacroResultFragment extends Fragment {

	Spinner spinner_goal;
	String selected_goal,bmr;
	double req_diet_goal,diet_goal;
	TextView macro_goal,pro_per,carb_per,fats_per,pro_cal,fat_cal,carb_cal;
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

		macro_goal=(TextView)rootView.findViewById(R.id.macro_goal_calories_calculated);

		//Macro Percent 

		pro_per=(TextView)rootView.findViewById(R.id.macro_protein_percentage_calculated);

		carb_per=(TextView)rootView.findViewById(R.id.macro_carb_percentage_calculated);

		fats_per=(TextView)rootView.findViewById(R.id.macro_fat_percentage_calculated);

		//Macro Cal

		pro_cal=(TextView)rootView.findViewById(R.id.macro_protein_percentage_manual);

		carb_cal=(TextView)rootView.findViewById(R.id.macro_carb_percentage_manual);

		fat_cal=(TextView)rootView.findViewById(R.id.macro_fat_percentage_manual);




		SharedPreferences pref = getActivity().getPreferences(1);
		bmr=pref.getString("cal_req_result", "0");
		req_diet_goal=Double.parseDouble(bmr);


		spinner_goal=(Spinner)rootView.findViewById(R.id.spinner_fitness_goal);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.fitness_goal,
				android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

		spinner_goal.setAdapter(adapter);

		spinner_goal.setGravity(Gravity.CENTER);

		spinner_goal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				selected_goal = parentView.getItemAtPosition(position).toString();

				
				if(selected_goal.equals("Loose Fat"))
				{
					diet_goal=req_diet_goal-10/100;

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
					diet_goal=req_diet_goal+10/100;

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
				if(selected_goal.equals("Maintain"))
				{
					diet_goal=req_diet_goal;

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
				if(selected_goal.endsWith("Extreme Loss(Consult Doctor)"))
				{
					diet_goal=req_diet_goal-10/100;

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
				
					Intent intent = new Intent(getActivity(), MainActivity.class);
					getActivity().startActivity(intent); 
				}	
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
