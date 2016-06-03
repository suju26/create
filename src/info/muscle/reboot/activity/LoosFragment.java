package info.muscle.reboot.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import info.muscle.reboot.R;



/**
 * Created by Ravi on 29/07/15.
 */
public class LoosFragment extends Fragment {
	String selected;
	TextView whole_egg_txt_pro,whole_egg_txt_fats,whole_egg_txt_carbs,whey_pro_txt_pro,whole_egg2_txt_pro,whole_egg2_txt_fats,whole_egg2_txt_carbs;
	TextView chk_br_txt_pro,chk_br_txt_fats,chk_br_txt_carbs;
	TextView ghee_txt_pro,ghee_br_txt_fats,ghee_txt_carbs;
	TextView paneer_txt_pro,paneer_txt_fats,paneer_txt_carbs;
	TextView paneer_txt_pro2,paneer_txt_fats2,paneer_txt_carbs2;
	TextView chk_br2_txt_pro,chk_br2_txt_fats,chk_br2_txt_carbs;
	TextView che_txt_pro,che_txt_fats,che_txt_carbs;
	TextView ghee_txt_pro2,ghee_br_txt_fats2,ghee_txt_carbs2;
	TextView paneer2_txt_pro,paneer2_txt_fats,paneer2_txt_carbs;
	ScrollView loose;
	Button btnfinish;

	TextView pro_txt;
	TextView fats_txt,carbs_txt;

	//Adding macro based on user selection

	TextView your_macro_pro,your_macro_fats,your_macro_carbs;
	TextView your_macro_pro1,your_macro_fats1,your_macro_carbs1,your_macro_pro2,your_macro_fats2,your_macro_carbs2;



	SharedPreferences sharedPreferences;
	SharedPreferences.Editor edt ;
	Spinner whole_egg_spinner,whey_protein_spinner,whole_egg2_spinner,spinner_chk_br,spinner_ghee,spinner_paneer,spinner_paneer2,spinner_chk_br2,spinner_cheese,spinner_ghee2;
	Spinner spinner_paneer3;

	public LoosFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);





	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.diet_loose, container, false);
		/*
		loose=(ScrollView)rootView.findViewById(R.id.LooseScrollView);
		loose.setVisibility(View.INVISIBLE);*/


		//Shared Preferrance

		sharedPreferences = getActivity().getPreferences(1);
		String pro_re=sharedPreferences.getString("protein_req", "0");
		String fats_re=sharedPreferences.getString("fats_req", "0");
		String carbs_re=sharedPreferences.getString("carbs_req", "0");

		//Adding to Macro View 

		pro_txt=(TextView)rootView.findViewById(R.id.macro_protein_percentage_manual);
		pro_txt.setText(pro_re);

		fats_txt=(TextView)rootView.findViewById(R.id.macro_fat_percentage_manual);
		fats_txt.setText(fats_re);

		carbs_txt=(TextView)rootView.findViewById(R.id.macro_carb_percentage_manual);
		carbs_txt.setText(carbs_re);


		your_macro_pro=(TextView)rootView.findViewById(R.id.macro_protein_percentage_manualr);
		your_macro_fats=(TextView)rootView.findViewById(R.id.macro_fat_percentage_manualr);
		your_macro_carbs=(TextView)rootView.findViewById(R.id.macro_carb_percentage_manualr);


		whole_egg_txt_pro=(TextView)rootView.findViewById(R.id.whole_egg_pro);
		whole_egg_txt_fats=(TextView)rootView.findViewById(R.id.whole_egg_fats);
		whole_egg_txt_carbs=(TextView)rootView.findViewById(R.id.whole_egg_carbs);
		whole_egg_spinner=(Spinner)rootView.findViewById(R.id.spinner_whole_egg);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_qty,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		whole_egg_spinner.setAdapter(adapter);
		whole_egg_spinner.setGravity(Gravity.CENTER);
		whole_egg_spinner.getSelectedItemPosition();
		int indexOfPreviousSelection = sharedPreferences.getInt("spinner_whole_egg", 0);
		whole_egg_spinner.setSelection(indexOfPreviousSelection);

		whole_egg_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*6.3;
				whole_egg_txt_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*4.8;
				whole_egg_txt_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.4;
				whole_egg_txt_carbs.setText(""+Math.round(carbs));

				//Calculating





			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Whey Protein

		whey_pro_txt_pro=(TextView)rootView.findViewById(R.id.whole_whey_pro);
		whey_protein_spinner=(Spinner)rootView.findViewById(R.id.spinner_whey_pro);
		whey_protein_spinner.setAdapter(adapter);
		whey_protein_spinner.setGravity(Gravity.CENTER);
		whey_protein_spinner.getSelectedItemPosition();
		int indexOfPreviousSelection1 = sharedPreferences.getInt("spinner_whey_pro", 0);
		whey_protein_spinner.setSelection(indexOfPreviousSelection1);

		whey_protein_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*25;
				whey_pro_txt_pro.setText(""+Math.round(pro));

			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {

			}
		});


		//Whole Egg2 Spinner
		whole_egg2_txt_pro=(TextView)rootView.findViewById(R.id.whole_wholeegg2_pro);
		whole_egg2_txt_fats=(TextView)rootView.findViewById(R.id.whole_wholeegg2_fats);
		whole_egg2_txt_carbs=(TextView)rootView.findViewById(R.id.whole_wholeegg2_carbs);
		whole_egg2_spinner=(Spinner)rootView.findViewById(R.id.spinner_whole_egg2);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_qty,
				android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
		whole_egg2_spinner.setAdapter(adapter1);
		whole_egg2_spinner.setGravity(Gravity.CENTER);
		whole_egg2_spinner.getSelectedItemPosition();
		int indexOfPreviousSelection11 = sharedPreferences.getInt("spinner_whole_egg2", 0);
		whole_egg2_spinner.setSelection(indexOfPreviousSelection11);

		whole_egg2_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*6.3;
				whole_egg2_txt_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*4.8;
				whole_egg2_txt_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.4;
				whole_egg2_txt_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});


		//Chk br Spinner
		chk_br_txt_pro=(TextView)rootView.findViewById(R.id.chicken_breast_pro);
		chk_br_txt_fats=(TextView)rootView.findViewById(R.id.chicken_breast_fats);
		chk_br_txt_carbs=(TextView)rootView.findViewById(R.id.chicken_breast_carbs);
		spinner_chk_br=(Spinner)rootView.findViewById(R.id.spinner_chicken_b);
		ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_gm,
				android.R.layout.simple_spinner_item);
		adapter11.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_chk_br.setAdapter(adapter11);
		spinner_chk_br.setGravity(Gravity.CENTER);
		spinner_chk_br.getSelectedItemPosition();
		int indexOfPreviousSelection111 = sharedPreferences.getInt("spinner_chk_br", 0);
		spinner_chk_br.setSelection(indexOfPreviousSelection111);

		spinner_chk_br.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.31;
				chk_br_txt_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*3.6/100;
				chk_br_txt_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0;
				chk_br_txt_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Ghee

		ghee_br_txt_fats=(TextView)rootView.findViewById(R.id.ghee_fats);
		spinner_ghee=(Spinner)rootView.findViewById(R.id.spinner_ghee);
		ArrayAdapter<CharSequence> adapter111 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter111.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_ghee.setAdapter(adapter111);
		spinner_ghee.setGravity(Gravity.CENTER);
		spinner_ghee.getSelectedItemPosition();
		int indexOfPreviousSelection1111 = sharedPreferences.getInt("spinner_whey_pro", 0);
		spinner_ghee.setSelection(indexOfPreviousSelection1111);

		spinner_ghee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double fats=Double.parseDouble(selected)*1;
				ghee_br_txt_fats.setText(""+Math.round(fats));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {

			}
		});


		//Chk br Spinner
		paneer_txt_pro=(TextView)rootView.findViewById(R.id.paneer_pro);
		paneer_txt_fats=(TextView)rootView.findViewById(R.id.paneer_fats);
		paneer_txt_carbs=(TextView)rootView.findViewById(R.id.paneer_carbs);
		spinner_paneer=(Spinner)rootView.findViewById(R.id.spinner_paneer);
		ArrayAdapter<CharSequence> adapter1111 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter1111.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_paneer.setAdapter(adapter1111);
		spinner_paneer.setGravity(Gravity.CENTER);
		spinner_paneer.getSelectedItemPosition();
		int indexOfPreviousSelection11111 = sharedPreferences.getInt("spinner_paneer", 0);
		spinner_paneer.setSelection(indexOfPreviousSelection11111);

		spinner_paneer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.20;
				paneer_txt_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0.23;
				paneer_txt_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.03;
				paneer_txt_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Paneer 2 Lunch 


		paneer_txt_pro2=(TextView)rootView.findViewById(R.id.paneer_pro2);
		paneer_txt_fats2=(TextView)rootView.findViewById(R.id.paneer_fats2);
		paneer_txt_carbs2=(TextView)rootView.findViewById(R.id.paneer_carbs2);
		spinner_paneer2=(Spinner)rootView.findViewById(R.id.spinner_paneer2);
		ArrayAdapter<CharSequence> adapter11112 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter1111.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_paneer2.setAdapter(adapter11112);
		spinner_paneer2.setGravity(Gravity.CENTER);
		spinner_paneer2.getSelectedItemPosition();
		int indexOfPreviousSelection111112 = sharedPreferences.getInt("spinner_paneer2", 0);
		spinner_paneer2.setSelection(indexOfPreviousSelection111112);

		spinner_paneer2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.20;
				paneer_txt_pro2.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0.23;
				paneer_txt_fats2.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.03;
				paneer_txt_carbs2.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Chk 2

		//Chk br Spinner
		chk_br2_txt_pro=(TextView)rootView.findViewById(R.id.cb2_pro);
		chk_br2_txt_fats=(TextView)rootView.findViewById(R.id.cb2_fats);
		chk_br2_txt_carbs=(TextView)rootView.findViewById(R.id.cb2_carbs);
		spinner_chk_br2=(Spinner)rootView.findViewById(R.id.spinner_cb2);
		ArrayAdapter<CharSequence> adapter113 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_gm,
				android.R.layout.simple_spinner_item);
		adapter113.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_chk_br2.setAdapter(adapter113);
		spinner_chk_br2.setGravity(Gravity.CENTER);
		spinner_chk_br2.getSelectedItemPosition();
		int indexOfPreviousSelection1113 = sharedPreferences.getInt("spinner_chk_br2", 0);
		spinner_chk_br2.setSelection(indexOfPreviousSelection1113);

		spinner_chk_br2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.31;
				chk_br2_txt_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*3.6/100;
				chk_br2_txt_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0;
				chk_br2_txt_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Che Spineer
		che_txt_pro=(TextView)rootView.findViewById(R.id.cheese_pro);
		che_txt_fats=(TextView)rootView.findViewById(R.id.cheese_fats);
		che_txt_carbs=(TextView)rootView.findViewById(R.id.cheese_carbs);
		spinner_cheese=(Spinner)rootView.findViewById(R.id.spinner_cheese);
		ArrayAdapter<CharSequence> adapter1134 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter1134.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_cheese.setAdapter(adapter1134);
		spinner_cheese.setGravity(Gravity.CENTER);
		spinner_cheese.getSelectedItemPosition();
		int indexOfPreviousSelection11134 = sharedPreferences.getInt("spinner_cheeee", 0);
		spinner_cheese.setSelection(indexOfPreviousSelection11134);

		spinner_cheese.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.22;
				che_txt_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0.27;
				che_txt_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.05;
				che_txt_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});


		//Ghee 2

		//Ghee

		ghee_br_txt_fats2=(TextView)rootView.findViewById(R.id.co_fats);
		spinner_ghee2=(Spinner)rootView.findViewById(R.id.spinner_co);
		ArrayAdapter<CharSequence> adapter1115 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter1115.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_ghee2.setAdapter(adapter1115);
		spinner_ghee2.setGravity(Gravity.CENTER);
		spinner_ghee2.getSelectedItemPosition();
		int indexOfPreviousSelection11115 = sharedPreferences.getInt("spinner_ghee2", 0);
		spinner_ghee2.setSelection(indexOfPreviousSelection11115);

		spinner_ghee2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double fats=Double.parseDouble(selected)*1;
				ghee_br_txt_fats2.setText(""+Math.round(fats));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {

			}
		});


		paneer2_txt_pro=(TextView)rootView.findViewById(R.id.paneer2_pro);
		paneer2_txt_fats=(TextView)rootView.findViewById(R.id.paneer2_fats);
		paneer2_txt_carbs=(TextView)rootView.findViewById(R.id.paneer2_carbs);
		spinner_paneer3=(Spinner)rootView.findViewById(R.id.spinner_panner);
		ArrayAdapter<CharSequence> adapter111126 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter111126.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_paneer3.setAdapter(adapter111126);
		spinner_paneer3.setGravity(Gravity.CENTER);
		spinner_paneer3.getSelectedItemPosition();
		int indexOfPreviousSelection1111126 = sharedPreferences.getInt("spinner_paneer21", 0);
		spinner_paneer3.setSelection(indexOfPreviousSelection1111126);

		spinner_paneer3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.2;
				paneer2_txt_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0.23;
				paneer2_txt_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.03;
				paneer2_txt_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Getting all Pro text and adding to macro pro


		//
		//Button





		btnfinish=(Button)rootView.findViewById(R.id.finish);
		btnfinish.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {



				if(btnfinish.getText().equals("NEXT"))
				{

					double addpro=(Double.parseDouble(whole_egg_txt_pro.getText().toString()))
							+(Double.parseDouble(whey_pro_txt_pro.getText().toString()))
							+(Double.parseDouble(paneer_txt_pro.getText().toString()))
							+(Double.parseDouble(whole_egg2_txt_pro.getText().toString()))
							+(Double.parseDouble(chk_br_txt_pro.getText().toString()))
							+(Double.parseDouble(paneer_txt_pro.getText().toString()))
							+(Double.parseDouble(paneer_txt_pro2.getText().toString()))
							+(Double.parseDouble(chk_br2_txt_pro.getText().toString()))
							+(Double.parseDouble(che_txt_pro.getText().toString()))
							+(Double.parseDouble(paneer2_txt_pro.getText().toString()));
					your_macro_pro.setText(""+addpro);	

					double addfats=(Double.parseDouble(whole_egg_txt_fats.getText().toString()))
							+(Double.parseDouble(whole_egg2_txt_fats.getText().toString()))
							+(Double.parseDouble(chk_br_txt_fats.getText().toString()))
							+(Double.parseDouble(ghee_br_txt_fats.getText().toString()))
							+(Double.parseDouble(paneer_txt_fats.getText().toString()))
							+(Double.parseDouble(paneer_txt_fats2.getText().toString()))
							+(Double.parseDouble(chk_br2_txt_fats.getText().toString()))
							+(Double.parseDouble(che_txt_fats.getText().toString()))
							+(Double.parseDouble(ghee_br_txt_fats2.getText().toString()))
							+(Double.parseDouble(paneer2_txt_fats.getText().toString()));
					your_macro_fats.setText(""+addfats);


					double addcarbs=(Double.parseDouble(whole_egg_txt_carbs.getText().toString()))
							+(Double.parseDouble(whole_egg2_txt_carbs.getText().toString()))
							+(Double.parseDouble(chk_br_txt_carbs.getText().toString()))
							+(Double.parseDouble(paneer_txt_carbs.getText().toString()))
							+(Double.parseDouble(paneer_txt_carbs2.getText().toString()))
							+(Double.parseDouble(chk_br2_txt_carbs.getText().toString()))
							+(Double.parseDouble(che_txt_carbs.getText().toString()))
							+(Double.parseDouble(paneer2_txt_carbs.getText().toString()));
					your_macro_carbs.setText(""+addcarbs);

					if(Double.parseDouble(your_macro_pro.getText().toString())<Double.parseDouble(pro_txt.getText().toString()))
					{
						Toast.makeText(getActivity(), "You Are Less With Protein Intake ,.", 
								Toast.LENGTH_SHORT).show();
					}

					if(Double.parseDouble(your_macro_fats.getText().toString())<Double.parseDouble(fats_txt.getText().toString()))
					{

						Toast.makeText(getActivity(), "You Are Less With Fats Intake ,.", 
								Toast.LENGTH_SHORT).show();
				}

				if(Double.parseDouble(your_macro_carbs.getText().toString())<Double.parseDouble(carbs_txt.getText().toString()))
				{
					Toast.makeText(getActivity(), "You Are Less With Carbs Intake ,.", 
							Toast.LENGTH_SHORT).show();
				}

				}
				else
				{	
					btnfinish.setText("DONE");
				}



				if(btnfinish.getText().equals("DONE")){

					sharedPreferences = getActivity().getPreferences(1);
					edt = sharedPreferences.edit();







					//Saving all details to shared 
					//For Whole Eggwhole_egg2_txt_pro

					edt.putInt("spinner_whole_egg", whole_egg_spinner.getSelectedItemPosition());

					//Whey Protein
					edt.putInt("spinner_whey_pro", whey_protein_spinner.getSelectedItemPosition());

					//Whole Egg Lunch

					edt.putInt("spinner_whole_egg2", whole_egg2_spinner.getSelectedItemPosition());

					//Chicken Breast
					edt.putInt("spinner_chk_br", spinner_chk_br.getSelectedItemPosition());

					//Paneer
					edt.putInt("spinner_paneer", spinner_paneer.getSelectedItemPosition());

					//Paneer2
					edt.putInt("spinner_paneer2", spinner_paneer2.getSelectedItemPosition());

					//cb 2
					edt.putInt("spinner_chk_br2", spinner_chk_br2.getSelectedItemPosition());

					//che
					edt.putInt("spinner_cheeee", spinner_cheese.getSelectedItemPosition());

					//Ghee 2
					edt.putInt("spinner_ghee2", spinner_ghee2.getSelectedItemPosition());

					//Paneer3
					edt.putInt("spinner_paneer21", spinner_paneer3.getSelectedItemPosition());

					//Saving 

					edt.putString("diettype", "loss");

					edt.apply();
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
