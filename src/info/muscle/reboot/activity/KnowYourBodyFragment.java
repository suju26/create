package info.muscle.reboot.activity;

import android.content.Context;
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
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import info.muscle.reboot.R;
import info.muscle.reboot.activity.Readme_1;


public class KnowYourBodyFragment extends Fragment {

	EditText edit_age,edit_ft,edit_inch,edit_weight;
	RadioButton rdm,rdf,radioSexButton;
	RadioGroup radiogender;
	Spinner spinner_level;
	/*	Typeface face;
	 */	double edit_txt_age,edit_txt_weight_in_kg,edit_txtheight_in_feet,edit_txt_height_in_inches;
	 double height_in_inches,weight_in_lbs, ideal_weight_male,ideal_weight_female;
	 String selected;
	 int selectedPosition;
	 SharedPreferences.Editor edt ;
	 SharedPreferences sharedPreferences;
	 Object obj;
	 int selectedindex ;

	 SharedPreferences pref;
	 int radio_saved;

	 //Fonts Declaration

	 /*	Typeface fontB,fontR,fontReg,fontThin,fontMed;
	  */
	 //Final Result
	 double bmi,
	 body_fat_percent_men,body_fat_percent_women,
	 lean_body_mass_men,lean_body_mass_women,
	 bmr_men,bmr_women,cal_req;

	 public KnowYourBodyFragment() {
		 // Required empty public constructor
	 }

	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);


	 }

	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
			 Bundle savedInstanceState) {
		 View rootView = inflater.inflate(R.layout.fragment_know_your_body, container, false);
		 rootView.setFocusableInTouchMode(true);
		 rootView.requestFocus();

		 rootView.setOnKeyListener(new OnKeyListener() {
			 @Override
			 public boolean onKey(View v, int keyCode, KeyEvent event) {
				 if (event.getAction() == KeyEvent.ACTION_DOWN) {
					 if (keyCode == KeyEvent.KEYCODE_BACK) {Intent intent = new Intent(getActivity(), MainActivity.class);
					 getActivity().startActivity(intent);
					 getActivity().finish();}
				 }
				 return false;
			 }
		 });
		 //Saved Value


		 sharedPreferences = getActivity().getPreferences(1);
		 String entered_age=sharedPreferences.getString("age", "");
		 String entered_feet=sharedPreferences.getString("feet", "");
		 String entered_inch=sharedPreferences.getString("inch", "");
		 String entered_weight=sharedPreferences.getString("weight", "");





		 //Fonts call

		 /* fontB = Typeface.createFromAsset(getActivity().getAssets(), "fonts/BEBAS.TTF");
		 fontR = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto_Light.ttf");
		 fontReg = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
		 fontThin = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");
		 fontMed = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");*/



		 //Getting Component reff

		 TextView lblage=(TextView)rootView.findViewById(R.id.label);
		 /*		 lblage.setTypeface(fontB);
		  */		 
		 EditText lblweight=(EditText)rootView.findViewById(R.id.edit_weight);
		 /*		 lblweight.setTypeface(fontB);
		  */		 
		 TextView lblact=(TextView)rootView.findViewById(R.id.label1);
		 /*		 lblact.setTypeface(fontB);
		  */		 


		 edit_age=(EditText)rootView.findViewById(R.id.edit_age);
		 /*		edit_age.setTypeface(fontThin);
		  */		edit_age.setText(entered_age);

		  edit_ft=(EditText)rootView.findViewById(R.id.edit_feet);
		  /*		edit_ft.setTypeface(fontThin);
		   */		edit_ft.setText(entered_feet);

		   edit_inch=(EditText)rootView.findViewById(R.id.edit_inch);
		   /*		edit_inch.setTypeface(fontThin);
		    */		edit_inch.setText(entered_inch);

		    edit_weight=(EditText)rootView.findViewById(R.id.edit_weight);
		    /*		edit_weight.setTypeface(fontThin);
		     */		edit_weight.setText(entered_weight);

		     radiogender=(RadioGroup)rootView.findViewById(R.id.radioGroup1);

		     rdm=(RadioButton)rootView.findViewById(R.id.radioButton1);
		     /*		rdm.setTypeface(fontReg);
		      */
		     rdf=(RadioButton)rootView.findViewById(R.id.radioButton2);
		     /*		rdf.setTypeface(fontReg);
		      */
		     radio_saved=sharedPreferences.getInt("radio_checked", 0);

		     if(radio_saved == R.id.radioButton1) {

		    	 rdm.setChecked(true);

		     } else if(radio_saved == R.id.radioButton2) {

		    	 rdf.setChecked(true);
		     } 

		     radiogender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

		    	 @Override
		    	 public void onCheckedChanged(RadioGroup group, int checkedId) {


		    		 // find which radio button is selected
		    		 /*if(radio_saved == R.id.radioButton1) {
					Toast.makeText(getActivity(), "You: Dude !!!", 
							Toast.LENGTH_SHORT).show();

				} else if(checkedId == R.id.radioButton2) {
					Toast.makeText(getActivity(), "You: Babe !!!", 
							Toast.LENGTH_SHORT).show();
				} */
		    	 }

		     });

		     spinner_level=(Spinner)rootView.findViewById(R.id.spinner_activity_level);
		     ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.activity_level,
		    		 android.R.layout.simple_spinner_item);
		     adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		     spinner_level.setAdapter(adapter);
		     spinner_level.setGravity(Gravity.CENTER);
		     spinner_level.getSelectedItemPosition();
		     int indexOfPreviousSelection = sharedPreferences.getInt("selectionText", 0);
		     spinner_level.setSelection(indexOfPreviousSelection);
		     spinner_level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		     {
		    	 @Override
		    	 public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
		    	 {
		    		 ((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
		    		 /*				((TextView) parentView.getChildAt(0)).setTypeface(fontThin);
		    		  */
		    		 selected = parentView.getItemAtPosition(position).toString();




		    	 }

		    	 @Override
		    	 public void onNothingSelected(AdapterView<?> parentView) {


		    	 }
		     });


		     //

		     Button button = (Button)rootView.findViewById(R.id.button2);
		     /*		button.setTypeface(fontMed);
		      */		button.setOnClickListener(new OnClickListener()
		      {
		    	  @Override
		    	  public void onClick(View v)
		    	  {


		    		  pref = getActivity().getPreferences(1);
		    		  edt = pref.edit();

		    		  //Storing Spinner Value 

		    		  edt.putInt("selectionText", spinner_level.getSelectedItemPosition());
		    		  edt.putInt("radio_checked", radiogender.getCheckedRadioButtonId());


		    		  //For Age
		    		  try {
		    			  String txtage=edit_age.getText().toString();
		    			  edt.putString("age", txtage);
		    			  edit_txt_age=Double.parseDouble(edit_age.getText().toString());
		    		  } catch (NumberFormatException e) {
		    			  Toast.makeText(getActivity(), "Please Enter Your Age In Years.", Toast.LENGTH_SHORT).show();
		    		  }
		    		  //Radio Gender
		    		  if (rdm.isChecked() || rdf.isChecked())
		    		  {}else
		    		  {	
		    			  Toast.makeText(getActivity(), "Tell Me Your Gender.", Toast.LENGTH_SHORT).show();
		    		  }
		    		  //Check for Weight
		    		  try {
		    			  String txtweight=edit_weight.getText().toString();
		    			  edt.putString("weight", txtweight);
		    			  edit_txt_weight_in_kg=Double.parseDouble(edit_weight.getText().toString());
		    		  } catch (NumberFormatException e) {
		    			  Toast.makeText(getActivity(), "Tell Me Your Current Weight.", Toast.LENGTH_SHORT).show();
		    		  }

		    		  //Check for Height 
		    		  try {
		    			  String txtfeet=edit_ft.getText().toString();
		    			  edt.putString("feet", txtfeet);
		    			  edit_txtheight_in_feet=Double.parseDouble(edit_ft.getText().toString());
		    		  } catch (NumberFormatException e) {
		    			  Toast.makeText(getActivity(), "Tell Me How Much Feet You Are Now .", Toast.LENGTH_SHORT).show();
		    		  }
		    		  try {
		    			  String txtinch=edit_inch.getText().toString();
		    			  edt.putString("inch", txtinch);
		    			  edit_txt_height_in_inches=Double.parseDouble(edit_inch.getText().toString());
		    		  } catch (NumberFormatException e) {
		    			  Toast.makeText(getActivity(), "Tell Me How Much Inches You Are Now .", Toast.LENGTH_SHORT).show();
		    		  }



		    		  if(selected.equals("Select Your Activity Level"))
		    		  {
		    			  Toast.makeText(getActivity(), "Please Tell Us Your Current Activity Level.", Toast.LENGTH_SHORT).show();
		    		  }

		    		  //Conversation
		    		  //For Height
		    		  height_in_inches=edit_txtheight_in_feet*12.000+edit_txt_height_in_inches;

		    		  //For WEIGHT
		    		  weight_in_lbs=edit_txt_weight_in_kg * 2.2046;

		    		  //Actual calculation
		    		  bmi = Math.round((weight_in_lbs * 703) / (height_in_inches * height_in_inches)*100.0)/100.0;
		    		  String bmi_to_text=""+bmi;
		    		  edt.putString("bmi_result", bmi_to_text);
		    		  if(bmi<18.5)
		    		  {
		    			  String bmi_to_str="Underweight: less than 18.5";
		    			  edt.putString("bmi_status", bmi_to_str);
		    		  }
		    		  if(bmi>=15.8 && bmi<=24.9)
		    		  {
		    			  String bmi_to_str="Normal:between 18.5 and 24.9";
		    			  edt.putString("bmi_status", bmi_to_str);
		    		  }
		    		  if(bmi>=25 && bmi<=29.9)
		    		  {
		    			  String bmi_to_str="Overweight:  between 25 and 29.9";
		    			  edt.putString("bmi_status", bmi_to_str);
		    		  }
		    		  if(bmi>30)
		    		  {
		    			  String bmi_to_str="Obese: 30 or greater";
		    			  edt.putString("bmi_status", bmi_to_str);
		    		  }

		    		  //Body Fats Percent Calculation

		    		  if(rdm.isChecked())
		    		  {
		    			  edt.putBoolean("radiostatus", true);
		    			  body_fat_percent_men=Math.round((1.20 * bmi) + (0.23 * edit_txt_age) - (10.8 * 1) - 5.4);
		    			  String bf_re=""+body_fat_percent_men;
		    			  edt.putString("bf_r", bf_re);

		    			  if(body_fat_percent_men>=2 && body_fat_percent_men<=5)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Essential";
		    				  edt.putString("bf_status", body_fats_status);
		    			  }
		    			  if(body_fat_percent_men>=6 && body_fat_percent_men<=13)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Athlete";
		    				  edt.putString("bf_status", body_fats_status);
		    			  }
		    			  if(body_fat_percent_men>=14 && body_fat_percent_men<=17)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Fitness";
		    				  edt.putString("bf_status", body_fats_status);
		    			  }

		    			  if(body_fat_percent_men>=18 && body_fat_percent_men<=24)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Average";
		    				  edt.putString("bf_status", body_fats_status);
		    			  }
		    			  if(body_fat_percent_men>24)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Obese";
		    				  edt.putString("bf_status", body_fats_status);
		    			  }

		    			  if(edit_txtheight_in_feet<=4){

		    				  ideal_weight_male=52+2.3;
		    				  edt.putString("ideal_weight", ""+ideal_weight_male);
		    			  }
		    			  else
		    			  {
		    				  ideal_weight_male=52+(2.3*edit_txt_height_in_inches);
		    				  edt.putString("ideal_weight", ""+ideal_weight_male);
		    			  }
		    		  }

		    		  if(rdf.isChecked())
		    		  {
		    			  edt.putBoolean("radiostatus", true);
		    			  body_fat_percent_women=Math.round((1.20 * bmi) + (0.23 * edit_txt_age) - (10.8 * 0) - 5.4);
		    			  String bf_re=""+body_fat_percent_women;
		    			  edt.putString("bf_r", bf_re);

		    			  if(body_fat_percent_women>=10 && body_fat_percent_women<=13)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Essential";
		    				  edt.putString("bf_status", body_fats_status);
		    				  System.out.println("Your Body Fat Level : Essential"+"\n");
		    			  }
		    			  if(body_fat_percent_women>=14 && body_fat_percent_women<=20)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Athlete";
		    				  edt.putString("bf_status", body_fats_status);
		    				  System.out.println("Your Body Fat Level : Athlete"+"\n");
		    			  }
		    			  if(body_fat_percent_women>=21 && body_fat_percent_women<=24)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Fitness";
		    				  edt.putString("bf_status", body_fats_status);
		    				  System.out.println("Your Body Fat Level : Fitness"+"\n");
		    			  }

		    			  if(body_fat_percent_women>=25 && body_fat_percent_women<=31)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Average";
		    				  edt.putString("bf_status", body_fats_status);
		    				  System.out.println("Your Body Fat Level : Average"+"\n");
		    			  }
		    			  if(body_fat_percent_women>31)
		    			  {
		    				  String body_fats_status="Your Body Fat Level : Obese";
		    				  edt.putString("bf_status", body_fats_status);
		    				  System.out.println("Your Body Fat Level : Obese"+"\n");
		    			  }


		    			  if(edit_txtheight_in_feet<=4){

		    				  ideal_weight_female=45+2.3;
		    				  edt.putString("ideal_weight", ""+ideal_weight_female);
		    			  }else
		    			  {
		    				  ideal_weight_female=45+(2.3*edit_txt_height_in_inches);
		    				  edt.putString("ideal_weight", ""+ideal_weight_female);
		    			  }

		    		  }


		    		  //Calculating Lean Body Mass
		    		  //Lean Body Mass = Body Weight(lbs) – (Body Weight x Body Fat %)
		    		  if(rdm.isChecked())
		    		  {
		    			  lean_body_mass_men=Math.round((weight_in_lbs-(weight_in_lbs*body_fat_percent_men/100))*0.45359237);
		    			  String lead_body_status=""+lean_body_mass_men;
		    			  edt.putString("lead_body_status", lead_body_status);
		    		  }
		    		  if(rdf.isChecked())
		    		  {
		    			  lean_body_mass_women=Math.round((weight_in_lbs-(weight_in_lbs*body_fat_percent_women/100))*0.45359237);
		    			  String lead_body_status=""+lean_body_mass_women;
		    			  edt.putString("lead_body_status", lead_body_status);
		    		  }

		    		  /*BMI Calculation 
				Women: BMR = 655 + ( 4.35 x weight in pounds ) + 
				( 4.7 x height in inches ) - ( 4.7 x age in years )
				Men: BMR = 66 + ( 6.23 x weight in pounds ) + 
				( 12.7 x height in inches ) - ( 6.8 x age in year )*/

		    		  /*To determine your total daily calorie needs, multiply your BMR by the appropriate activity factor, as follows:

				If you are sedentary (little or no exercise) : Calorie-Calculation = BMR x 1.2
				If you are lightly active (light exercise/sports 1-3 days/week) : Calorie-Calculation = BMR x 1.375
				If you are moderatetely active (moderate exercise/sports 3-5 days/week) : Calorie-Calculation = BMR x 1.55
				If you are very active (hard exercise/sports 6-7 days a week) : Calorie-Calculation = BMR x 1.725
				If you are extra active (very hard exercise/sports & physical job or 2x training) : Calorie-Calculation = BMR x 1.9*/

		    		  if(rdm.isChecked())
		    		  {
		    			  bmr_men=Math.round(66+(6.3*weight_in_lbs)+(12.7*height_in_inches)-(6.8*edit_txt_age));

		    			  if(selected.equals("Little Or No Excercise"))
		    			  {
		    				  cal_req=Math.round(bmr_men*1.2);	
		    			  }
		    			  if(selected.equals("Light Excercise 1 to 3 Days A Week"))
		    			  {
		    				  cal_req=Math.round(bmr_men*1.375);	
		    			  }
		    			  if(selected.equals("Moderate Excercise 3 to 5 Days A Week"))
		    			  {
		    				  cal_req=Math.round(bmr_men*1.55);	
		    			  }
		    			  if(selected.equals("Hard Excercise 6 to 7 Days A Week"))
		    			  {
		    				  cal_req=Math.round(bmr_men*1.725);	
		    			  }
		    			  if(selected.equals("Very Hard Ecercise Along Physical Job"))
		    			  {
		    				  cal_req=Math.round(bmr_men*1.9);	
		    			  }

		    			  String cal_rer_result_txt=""+cal_req;
		    			  edt.putString("cal_req_result", cal_rer_result_txt);
		    		  }
		    		  if(rdf.isChecked())
		    		  {
		    			  bmr_women=Math.round(655+(4.35*weight_in_lbs)+(4.7*height_in_inches)-(4.7*edit_txt_age));

		    			  if(selected.equals("Little Or No Excercise"))
		    			  {
		    				  cal_req=Math.round(bmr_women*1.2);	
		    			  }
		    			  if(selected.equals("Light Excercise 1 to 3 Days A Week"))
		    			  {
		    				  cal_req=Math.round(bmr_women*1.375);	
		    			  }
		    			  if(selected.equals("Moderate Excercise 3 to 5 Days A Week"))
		    			  {
		    				  cal_req=Math.round(bmr_women*1.55);	
		    			  }
		    			  if(selected.equals("Hard Excercise 6 to 7 Days A Week"))
		    			  {
		    				  cal_req=Math.round(bmr_women*1.725);	
		    			  }
		    			  if(selected.equals("Very Hard Ecercise Along Physical Job"))
		    			  {
		    				  cal_req=Math.round(bmr_women*1.9);	
		    			  }
		    			  String cal_rer_result_txt=""+cal_req;
		    			  edt.putString("cal_req_result", cal_rer_result_txt);
		    		  }

		    		  if (cal_req==0)
		    		  {}
		    		  else{
		    			 

		    			  edt.apply();

		    			  Toast.makeText(getActivity(), "Good , Check Your Body Status , Where Your Health Stand Now !!!", 
		    					  Toast.LENGTH_LONG).show();
		    		  }
		    	  }
		      }); 

		      Button rd1=(Button)rootView.findViewById(R.id.rd1);
		      rd1.setOnClickListener(new View.OnClickListener() {

		    	  @Override
		    	  public void onClick(View v) {

		    		  Intent intent = new Intent(getActivity(), Readme_1.class);
		    		  getActivity().startActivity(intent);

		    	  }
		      });




		      // Inflate the layout for this fragment
		      return rootView;
	 }



	 @Override
	 public void onAttach(Context context) {
		 super.onAttach(context);


	 }

	 @Override
	 public void onDetach() {
		 super.onDetach();


	 }


}
