package info.muscle.reboot.activity;

import android.app.Activity;
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
import android.widget.Spinner;
import android.widget.TextView;
import info.muscle.reboot.R;



/**
 * Created by Ravi on 29/07/15.
 */
public class DietFragment extends Fragment {
	String selected;
	TextView whole_egg_txt_pro,whole_egg_txt_fats,whole_egg_txt_carbs,whey_pro_txt_pro,whole_egg2_txt_pro,whole_egg2_txt_fats,whole_egg2_txt_carbs;
	TextView chk_br_txt_pro,chk_br_txt_fats,chk_br_txt_carbs;
	TextView ghee_txt_pro,ghee_br_txt_fats,ghee_txt_carbs;
	TextView paneer_txt_pro,paneer_txt_fats,paneer_txt_carbs;


	SharedPreferences sharedPreferences;
	SharedPreferences.Editor edt ;
	Spinner whole_egg_spinner,whey_protein_spinner,whole_egg2_spinner,spinner_chk_br,spinner_ghee,spinner_paneer;


	public DietFragment() {
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

		//Shared Preferrance

		sharedPreferences = getActivity().getPreferences(1);

		//Whole Egg Spinner
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

				//Whey Protein

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

						double fats=Double.parseDouble(selected)*0.81;
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

				
		//Button

		Button btnfinish=(Button)rootView.findViewById(R.id.finish);
		btnfinish.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				sharedPreferences = getActivity().getPreferences(1);
				edt = sharedPreferences.edit();

				//For Whole Egg

				edt.putInt("spinner_whole_egg", whole_egg_spinner.getSelectedItemPosition());
				
				//Whey Protein
				edt.putInt("spinner_whey_pro", whey_protein_spinner.getSelectedItemPosition());
				
				//Whole Egg Lunch
				
				edt.putInt("spinner_whole_egg2", whole_egg2_spinner.getSelectedItemPosition());
				
				//Chicken Breast
				edt.putInt("spinner_chk_br", spinner_chk_br.getSelectedItemPosition());
				
				//Paneer
				edt.putInt("spinner_paneer", spinner_paneer.getSelectedItemPosition());

				





				edt.apply();

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
