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
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import info.muscle.reboot.R;


public class DietPlanFragment extends Fragment {
	private PrefManager prefManager;

	SharedPreferences sharedPreferences;
	SharedPreferences.Editor edt ;
	String selected;
	Button btnfinish,btnreset;
	TextView paneer_txt_pro,paneer_txt_fats,paneer_txt_carbs;
	TextView pro_cmc,fats_cmc,carbs_cmc;
	TextView ghee_txt_pro,ghee_br_txt_fats,ghee_txt_carbs,ghee_br_txt_fats22;
	TextView ew_pro,ew_fats,ew_carbs;
	TextView ew1_pro,ew1_fats,ew1_carbs;
	TextView brc_pro,brc_fats,brc_carbs;
	TextView wr_pro,wr_fats,wr_carbs;
	TextView sc_pro,sc_fats,sc_carbs;
	TextView ghee_txt_pro2,ghee_br_txt_fats2,ghee_txt_carbs2;
	TextView chk_br_txt_pro,chk_br_txt_fats,chk_br_txt_carbs;
	TextView wr_pro2,wr_fats2,wr_carbs2;
	TextView sc_pro21,sc_fats21,sc_carbs21;
	TextView sc_proc,sc_fatsc,sc_carbsc;
	TextView chk_br_txt_pro2,chk_br_txt_fats2,chk_br_txt_carbs2;
	TextView wp_pro,wp_fats,wp_carbs;
	TextView wp_pro1,wp_fats1,wp_carbs1;
	TextView wp_pro11,wp_fats11,wp_carbs11;


	double  cp1,cf1,cc1, cp11,cf11,cc11,cp111,cf111,cc111;



	TextView pro_txt, fats_txt,carbs_txt;
	TextView pro_txtm, fats_txtm,carbs_txtm;

	EditText pro1,fats1,carbs1, pro11,fats11,carbs11, pro111,fats111,carbs111;

	double p1,p2;
	CheckBox chk1,chk2;



	double total_pro_con;



	Spinner spinner_paneer,spinner_cmc,spinner_ghee,spinner_ew,spinner_ew1,spinner_brc,spinner_wr,spinner_sc,spinner_ghee2,spinner_chk_br;
	Spinner spinner_wr2,spinner_sc2,spinner_c,spinner_ghee22,spinner_chk_br2,spinner_wp,spinner_wp1;

	public DietPlanFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_gain, container, false);
		rootView.setFocusableInTouchMode(true);
		rootView.requestFocus();

		rootView.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {
						
						
						
						Intent intent = new Intent(getActivity(), MainActivity.class);
						getActivity().startActivity(intent);
						getActivity().finish();}
				}
				return false;
			}
		});
		sharedPreferences = getActivity().getPreferences(1);

		String pro_re=sharedPreferences.getString("protein_req", "0");
		String fats_re=sharedPreferences.getString("fats_req", "0");
		String carbs_re=sharedPreferences.getString("carbs_req", "0");

		String pro_rec=sharedPreferences.getString("txt_prom", "0");
		String fats_rec=sharedPreferences.getString("txt_fatsm", "0");
		String carbs_rec=sharedPreferences.getString("txt_carbsm", "0");

		String cp1s=sharedPreferences.getString("cp1", "0");
		String cf1s=sharedPreferences.getString("cf1", "0");
		String ccs=sharedPreferences.getString("cc1", "0");

		String cp1s1=sharedPreferences.getString("cp11", "0");
		String cf1s1=sharedPreferences.getString("cf11", "0");
		String ccs1=sharedPreferences.getString("cc11", "0");

		String cp1s11=sharedPreferences.getString("cp111", "0");
		String cf1s11=sharedPreferences.getString("cf111", "0");
		String ccs11=sharedPreferences.getString("cc111", "0");




		//Adding to Macro View 

		pro_txt=(TextView)rootView.findViewById(R.id.macro_protein_percentage_manual);
		pro_txt.setText(pro_re);

		fats_txt=(TextView)rootView.findViewById(R.id.macro_fat_percentage_manual);
		fats_txt.setText(fats_re);

		carbs_txt=(TextView)rootView.findViewById(R.id.macro_carb_percentage_manual);
		carbs_txt.setText(carbs_re);



		pro_txtm=(TextView)rootView.findViewById(R.id.macro_protein_percentage_manualr);
		pro_txtm.setText(pro_rec);
		fats_txtm=(TextView)rootView.findViewById(R.id.macro_fat_percentage_manualr);
		fats_txtm.setText(fats_rec);
		carbs_txtm=(TextView)rootView.findViewById(R.id.macro_carb_percentage_manualr);
		carbs_txtm.setText(carbs_rec);

		//Custom Micro

		pro1=(EditText)rootView.findViewById(R.id.wp_proc);
		pro1.setText(cp1s);
		fats1=(EditText)rootView.findViewById(R.id.wp_fatsc);
		fats1.setText(cf1s);
		carbs1=(EditText)rootView.findViewById(R.id.wp_carbsc);
		carbs1.setText(ccs);

		pro11=(EditText)rootView.findViewById(R.id.wp_proc1);
		pro11.setText(cp1s1);
		fats11=(EditText)rootView.findViewById(R.id.wp_fatsc1);
		fats11.setText(cf1s1);
		carbs11=(EditText)rootView.findViewById(R.id.wp_carbsc1);
		carbs11.setText(ccs1);

		pro111=(EditText)rootView.findViewById(R.id.wp_proc11);
		pro111.setText(cp1s11);
		fats111=(EditText)rootView.findViewById(R.id.wp_fatsc11);
		fats111.setText(cf1s11);
		carbs111=(EditText)rootView.findViewById(R.id.wp_carbsc11);
		carbs111.setText(ccs11);


		//Chk br Spinner
		paneer_txt_pro=(TextView)rootView.findViewById(R.id.pro_paneer);
		paneer_txt_fats=(TextView)rootView.findViewById(R.id.fats_paneer);
		paneer_txt_carbs=(TextView)rootView.findViewById(R.id.carbs_paneer);
		spinner_paneer=(Spinner)rootView.findViewById(R.id.spinner_paneer);
		ArrayAdapter<CharSequence> adapter1111 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter1111.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_paneer.setAdapter(adapter1111);
		spinner_paneer.setGravity(Gravity.CENTER);
		spinner_paneer.getSelectedItemPosition();
		int indexOfPreviousSelection11111 = sharedPreferences.getInt("spinner_paneer", 1);
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

		//Spinner Cheese Cube
		pro_cmc=(TextView)rootView.findViewById(R.id.pro_cmc);
		fats_cmc=(TextView)rootView.findViewById(R.id.fats_cmc);
		carbs_cmc=(TextView)rootView.findViewById(R.id.carbs_cmc);
		spinner_cmc=(Spinner)rootView.findViewById(R.id.spinner_cmc);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_qty,
				android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_cmc.setAdapter(adapter1);
		spinner_cmc.setGravity(Gravity.CENTER);
		spinner_cmc.getSelectedItemPosition();
		int indexOfPreviousSelectioncmc = sharedPreferences.getInt("spinner_cmc", 1);
		spinner_cmc.setSelection(indexOfPreviousSelectioncmc);

		spinner_cmc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*5;
				pro_cmc.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*6.5;
				fats_cmc.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.5;
				carbs_cmc.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Ghee macro

		ghee_br_txt_fats=(TextView)rootView.findViewById(R.id.ghee_fats);
		spinner_ghee=(Spinner)rootView.findViewById(R.id.spinner_ghee);
		ArrayAdapter<CharSequence> adapter111 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter111.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_ghee.setAdapter(adapter111);
		spinner_ghee.setGravity(Gravity.CENTER);
		spinner_ghee.getSelectedItemPosition();
		int indexOfPreviousSelection1111 = sharedPreferences.getInt("spinner_ghee", 1);
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


		//Spinner Egg Whole
		ew_pro=(TextView)rootView.findViewById(R.id.ew_pro);
		ew_fats=(TextView)rootView.findViewById(R.id.ew_fats);
		ew_carbs=(TextView)rootView.findViewById(R.id.ew_carbs);
		spinner_ew=(Spinner)rootView.findViewById(R.id.spinner_ew);
		ArrayAdapter<CharSequence> adapterew = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_qty,
				android.R.layout.simple_spinner_item);
		adapterew.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_ew.setAdapter(adapterew);
		spinner_ew.setGravity(Gravity.CENTER);
		spinner_ew.getSelectedItemPosition();
		int indexOfPreviousSelectionew = sharedPreferences.getInt("spinner_ew", 2);
		spinner_ew.setSelection(indexOfPreviousSelectionew);

		spinner_ew.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*6.29;
				ew_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*4.97;
				ew_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.39;
				ew_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});


		//Spinner Egg White
		ew1_pro=(TextView)rootView.findViewById(R.id.ew1_pro);
		ew1_fats=(TextView)rootView.findViewById(R.id.ew1_fats);
		ew1_carbs=(TextView)rootView.findViewById(R.id.ew1_carbs);
		spinner_ew1=(Spinner)rootView.findViewById(R.id.spinner_ew1);
		ArrayAdapter<CharSequence> adapterew1 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_qty,
				android.R.layout.simple_spinner_item);
		adapterew1.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_ew1.setAdapter(adapterew1);
		spinner_ew1.setGravity(Gravity.CENTER);
		spinner_ew1.getSelectedItemPosition();
		int indexOfPreviousSelectionew1 = sharedPreferences.getInt("spinner_ew1", 2);
		spinner_ew1.setSelection(indexOfPreviousSelectionew1);

		spinner_ew1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*3.6;
				ew1_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0.06;
				ew1_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.24;
				ew1_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});
		//Spinner Whey
		wp_pro=(TextView)rootView.findViewById(R.id.wp_pro);
		wp_fats=(TextView)rootView.findViewById(R.id.wp_fats);
		wp_carbs=(TextView)rootView.findViewById(R.id.wp_carbs);
		spinner_wp=(Spinner)rootView.findViewById(R.id.spinner_wp);
		ArrayAdapter<CharSequence> adapterewp = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_qty,
				android.R.layout.simple_spinner_item);
		adapterewp.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_wp.setAdapter(adapterewp);
		spinner_wp.setGravity(Gravity.CENTER);
		spinner_ew1.getSelectedItemPosition();
		int indexOfPreviousSelectionewp = sharedPreferences.getInt("spinner_wp", 0);
		spinner_wp.setSelection(indexOfPreviousSelectionewp);

		spinner_wp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*25;
				wp_pro.setText(""+Math.round(pro));

			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});
		//Spinner Whey
		wp_pro1=(TextView)rootView.findViewById(R.id.wp_pro1);
		wp_fats1=(TextView)rootView.findViewById(R.id.wp_fats1);
		wp_carbs1=(TextView)rootView.findViewById(R.id.wp_carbs1);
		spinner_wp1=(Spinner)rootView.findViewById(R.id.spinner_wp1);
		ArrayAdapter<CharSequence> adapterewp1 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_qty,
				android.R.layout.simple_spinner_item);
		adapterewp1.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_wp1.setAdapter(adapterewp1);
		spinner_wp1.setGravity(Gravity.CENTER);
		spinner_wp1.getSelectedItemPosition();
		int indexOfPreviousSelectionewp1 = sharedPreferences.getInt("spinner_wp1", 0);
		spinner_wp1.setSelection(indexOfPreviousSelectionewp1);

		spinner_wp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*25;
				wp_pro1.setText(""+Math.round(pro));

			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Broccoli
		brc_pro=(TextView)rootView.findViewById(R.id.pro_brc);
		brc_fats=(TextView)rootView.findViewById(R.id.fats_brc);
		brc_carbs=(TextView)rootView.findViewById(R.id.carbs_brc);
		spinner_brc=(Spinner)rootView.findViewById(R.id.spinner_brc);
		ArrayAdapter<CharSequence> adapterbrc = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_gm,
				android.R.layout.simple_spinner_item);
		adapterbrc.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_brc.setAdapter(adapterbrc);
		spinner_brc.setGravity(Gravity.CENTER);
		spinner_brc.getSelectedItemPosition();
		int indexOfPreviousSelectionbrc = sharedPreferences.getInt("spinner_brc", 3);
		spinner_brc.setSelection(indexOfPreviousSelectionbrc);

		spinner_brc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.03;
				brc_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0;
				brc_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.07;
				brc_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});


		//White Rice
		wr_pro=(TextView)rootView.findViewById(R.id.wr_pro);
		wr_fats=(TextView)rootView.findViewById(R.id.wr_fats);
		wr_carbs=(TextView)rootView.findViewById(R.id.wr_carbs);
		spinner_wr=(Spinner)rootView.findViewById(R.id.spinner_wr);
		ArrayAdapter<CharSequence> adapterwr = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_gm,
				android.R.layout.simple_spinner_item);
		adapterwr.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_wr.setAdapter(adapterwr);
		spinner_wr.setGravity(Gravity.CENTER);
		spinner_wr.getSelectedItemPosition();
		int indexOfPreviousSelectionwr = sharedPreferences.getInt("spinner_wr", 2);
		spinner_wr.setSelection(indexOfPreviousSelectionwr);

		spinner_wr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.03;
				wr_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0;
				wr_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.28;
				wr_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});



		//Soy Chunck
		sc_pro=(TextView)rootView.findViewById(R.id.sc_pro);
		sc_fats=(TextView)rootView.findViewById(R.id.sc_fats);
		sc_carbs=(TextView)rootView.findViewById(R.id.sc_carbs);
		spinner_sc=(Spinner)rootView.findViewById(R.id.spinner_sc);
		ArrayAdapter<CharSequence> adaptersc = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_gm,
				android.R.layout.simple_spinner_item);
		adaptersc.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_sc.setAdapter(adaptersc);
		spinner_sc.setGravity(Gravity.CENTER);
		spinner_sc.getSelectedItemPosition();
		int indexOfPreviousSelectionsc = sharedPreferences.getInt("spinner_sc", 2);
		spinner_sc.setSelection(indexOfPreviousSelectionsc);

		spinner_sc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.17;
				sc_pro.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0.09;
				sc_fats.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.1;
				sc_carbs.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});


		//Ghee 2

		ghee_br_txt_fats2=(TextView)rootView.findViewById(R.id.ghee_fats2);
		spinner_ghee2=(Spinner)rootView.findViewById(R.id.spinner_ghee2);
		ArrayAdapter<CharSequence> adapter1112 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter1112.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_ghee2.setAdapter(adapter1112);
		spinner_ghee2.setGravity(Gravity.CENTER);
		spinner_ghee2.getSelectedItemPosition();
		int indexOfPreviousSelection11112 = sharedPreferences.getInt("spinner_ghee2", 2);
		spinner_ghee2.setSelection(indexOfPreviousSelection11112);

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
		int indexOfPreviousSelection111 = sharedPreferences.getInt("spinner_chk_br", 3);
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


		//White Rice 2
		wr_pro2=(TextView)rootView.findViewById(R.id.wr_pro2);
		wr_fats2=(TextView)rootView.findViewById(R.id.wr_fats2);
		wr_carbs2=(TextView)rootView.findViewById(R.id.wr_carbs2);
		spinner_wr2=(Spinner)rootView.findViewById(R.id.spinner_wr2);
		ArrayAdapter<CharSequence> adapterwr2 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_gm,
				android.R.layout.simple_spinner_item);
		adapterwr2.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_wr2.setAdapter(adapterwr2);
		spinner_wr2.setGravity(Gravity.CENTER);
		spinner_wr2.getSelectedItemPosition();
		int indexOfPreviousSelectionwr2 = sharedPreferences.getInt("spinner_wr2", 3);
		spinner_wr2.setSelection(indexOfPreviousSelectionwr2);

		spinner_wr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.03;
				wr_pro2.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0;
				wr_fats2.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.28;
				wr_carbs2.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Soy Chunck 2
		sc_pro21=(TextView)rootView.findViewById(R.id.sc_pro2);
		sc_fats21=(TextView)rootView.findViewById(R.id.sc_fats2);
		sc_carbs21=(TextView)rootView.findViewById(R.id.sc_carbs2);
		spinner_sc2=(Spinner)rootView.findViewById(R.id.spinner_sc2);
		ArrayAdapter<CharSequence> adaptersc2 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_gm,
				android.R.layout.simple_spinner_item);
		adaptersc2.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_sc2.setAdapter(adaptersc2);
		spinner_sc2.setGravity(Gravity.CENTER);
		spinner_sc2.getSelectedItemPosition();
		int indexOfPreviousSelectionsc2 = sharedPreferences.getInt("spinner_sc2", 2);
		spinner_sc2.setSelection(indexOfPreviousSelectionsc2);

		spinner_sc2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.17;
				sc_pro21.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0.09;
				sc_fats21.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.1;
				sc_carbs21.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});




		//Curd
		sc_proc=(TextView)rootView.findViewById(R.id.sc_proc);
		sc_fatsc=(TextView)rootView.findViewById(R.id.sc_fatsc);
		sc_carbsc=(TextView)rootView.findViewById(R.id.sc_carbsc);
		spinner_c=(Spinner)rootView.findViewById(R.id.spinner_c);
		ArrayAdapter<CharSequence> adaptersc2c = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_gm,
				android.R.layout.simple_spinner_item);
		adaptersc2c.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_c.setAdapter(adaptersc2c);
		spinner_c.setGravity(Gravity.CENTER);
		spinner_c.getSelectedItemPosition();
		int indexOfPreviousSelectionsc2c = sharedPreferences.getInt("spinner_sc2c", 5);
		spinner_c.setSelection(indexOfPreviousSelectionsc2c);

		spinner_c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.12;
				sc_proc.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*0.04;
				sc_fatsc.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0.03;
				sc_carbsc.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		//Ghee 2

		ghee_br_txt_fats22=(TextView)rootView.findViewById(R.id.ghee_fats22);
		spinner_ghee22=(Spinner)rootView.findViewById(R.id.spinner_ghee22);
		ArrayAdapter<CharSequence> adapter11122 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_ml,
				android.R.layout.simple_spinner_item);
		adapter11122.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_ghee22.setAdapter(adapter11122);
		spinner_ghee22.setGravity(Gravity.CENTER);
		spinner_ghee22.getSelectedItemPosition();
		int indexOfPreviousSelection111122 = sharedPreferences.getInt("spinner_ghee22", 1);
		spinner_ghee22.setSelection(indexOfPreviousSelection111122);

		spinner_ghee22.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double fats=Double.parseDouble(selected)*1;
				ghee_br_txt_fats22.setText(""+Math.round(fats));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {

			}
		});

		//Chk2 br Spinner
		chk_br_txt_pro2=(TextView)rootView.findViewById(R.id.chicken_breast_pro2);
		chk_br_txt_fats2=(TextView)rootView.findViewById(R.id.chicken_breast_fats2);
		chk_br_txt_carbs2=(TextView)rootView.findViewById(R.id.chicken_breast_carbs2);
		spinner_chk_br2=(Spinner)rootView.findViewById(R.id.spinner_chicken_b2);
		ArrayAdapter<CharSequence> adapter112 = ArrayAdapter.createFromResource(rootView.getContext(), R.array.diet_gm,
				android.R.layout.simple_spinner_item);
		adapter112.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spinner_chk_br2.setAdapter(adapter112);
		spinner_chk_br2.setGravity(Gravity.CENTER);
		spinner_chk_br2.getSelectedItemPosition();
		int indexOfPreviousSelection1112 = sharedPreferences.getInt("spinner_chk_br2", 5);
		spinner_chk_br.setSelection(indexOfPreviousSelection1112);

		spinner_chk_br2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				((TextView) parentView.getChildAt(0)).setTextColor(Color.BLACK);
				selected = parentView.getItemAtPosition(position).toString();

				double pro=Double.parseDouble(selected)*0.31;
				chk_br_txt_pro2.setText(""+Math.round(pro));
				double fats=Double.parseDouble(selected)*3.6/100;
				chk_br_txt_fats2.setText(""+Math.round(fats));
				double carbs=Double.parseDouble(selected)*0;
				chk_br_txt_carbs2.setText(""+Math.round(carbs));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {


			}
		});

		Button re_calbtn=(Button)rootView.findViewById(R.id.re_cal);
		re_calbtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				try {

					cp1=Double.parseDouble(pro1.getText().toString());
					cf1=Double.parseDouble(fats1.getText().toString());
					cc1=Double.parseDouble(carbs1.getText().toString());
					cp11=Double.parseDouble(pro11.getText().toString());
					cf11=Double.parseDouble(fats11.getText().toString());
					cc11=Double.parseDouble(carbs11.getText().toString());
					cp111=Double.parseDouble(pro111.getText().toString());
					cf111=Double.parseDouble(fats111.getText().toString());
					cc111=Double.parseDouble(carbs111.getText().toString());


				} catch (NumberFormatException e)
				{
					Toast.makeText(getActivity(), "Please Check Entered Custom Micro.", 
							Toast.LENGTH_LONG).show();		
				}

				double total_pro=Double.parseDouble(paneer_txt_pro.getText().toString())
						+Double.parseDouble(pro_cmc.getText().toString())
						+Double.parseDouble(ew_pro.getText().toString())
						+Double.parseDouble(ew1_pro.getText().toString())
						+Double.parseDouble(brc_pro.getText().toString())
						+Double.parseDouble(wr_pro.getText().toString())
						+Double.parseDouble(sc_pro.getText().toString())
						+Double.parseDouble(chk_br_txt_pro.getText().toString())
						+Double.parseDouble(wr_pro2.getText().toString())
						+Double.parseDouble(sc_pro21.getText().toString())
						+Double.parseDouble(sc_proc.getText().toString())
						+Double.parseDouble(chk_br_txt_pro2.getText().toString())
						+Double.parseDouble(chk_br_txt_pro2.getText().toString())
						+Double.parseDouble(wp_pro.getText().toString())
						+Double.parseDouble(wp_pro1.getText().toString())
						+cp1+cp11+cp111;
				pro_txtm.setText(""+total_pro);


				double total_fats=Double.parseDouble(paneer_txt_fats.getText().toString())
						+Double.parseDouble(fats_cmc.getText().toString())
						+Double.parseDouble(ghee_br_txt_fats.getText().toString())
						+Double.parseDouble(ew_fats.getText().toString())
						+Double.parseDouble(ew1_fats.getText().toString())
						+Double.parseDouble(brc_fats.getText().toString())
						+Double.parseDouble(wr_fats.getText().toString())
						+Double.parseDouble(sc_fats.getText().toString())
						+Double.parseDouble(ghee_br_txt_fats2.getText().toString())
						+Double.parseDouble(chk_br_txt_fats.getText().toString())
						+Double.parseDouble(wr_fats2.getText().toString())
						+Double.parseDouble(sc_fats21.getText().toString())
						+Double.parseDouble(sc_fatsc.getText().toString())
						+Double.parseDouble(ghee_br_txt_fats22.getText().toString())
						+Double.parseDouble(chk_br_txt_fats2.getText().toString())+cf1+cf11+cf111;
				fats_txtm.setText(""+total_fats);

				double total_carbs=Double.parseDouble(paneer_txt_carbs.getText().toString())
						+Double.parseDouble(carbs_cmc.getText().toString())
						+Double.parseDouble(ghee_br_txt_fats.getText().toString())
						+Double.parseDouble(ew_carbs.getText().toString())
						+Double.parseDouble(ew1_carbs.getText().toString())
						+Double.parseDouble(brc_carbs.getText().toString())
						+Double.parseDouble(wr_carbs.getText().toString())
						+Double.parseDouble(sc_carbs.getText().toString())
						+Double.parseDouble(chk_br_txt_carbs.getText().toString())
						+Double.parseDouble(wr_carbs2.getText().toString())
						+Double.parseDouble(sc_carbs21.getText().toString())
						+Double.parseDouble(sc_carbsc.getText().toString())
						+Double.parseDouble(chk_br_txt_carbs2.getText().toString())+cc1+cc11+cc111;
				carbs_txtm.setText(""+total_carbs);
				
				Toast.makeText(getActivity(), "Awesome , If Required Macro Match Click On Finish !!!", 
						Toast.LENGTH_LONG).show();

			}
		});

		//Button

		btnfinish=(Button)rootView.findViewById(R.id.finish_gain);
		btnfinish.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {


				Toast.makeText(getActivity(), "Awesome , Dont Forget To Calculate Your Health Profile Weekly.", 
						Toast.LENGTH_LONG).show();
				sharedPreferences = getActivity().getPreferences(1);
				edt = sharedPreferences.edit();
				//Paneer
				edt.putInt("spinner_paneer", spinner_paneer.getSelectedItemPosition());

				//Cheese Cube
				edt.putInt("spinner_cmc", spinner_cmc.getSelectedItemPosition());

				//Ghee
				edt.putInt("spinner_ghee", spinner_ghee.getSelectedItemPosition());

				//Whole Egg
				edt.putInt("spinner_ew", spinner_ew.getSelectedItemPosition());

				//Egg White
				edt.putInt("spinner_ew1", spinner_ew1.getSelectedItemPosition());

				//Brocolli
				edt.putInt("spinner_brc", spinner_brc.getSelectedItemPosition());

				//White Rice
				edt.putInt("spinner_wr", spinner_wr.getSelectedItemPosition());

				//Soy Chunck
				edt.putInt("spinner_sc", spinner_sc.getSelectedItemPosition());

				//Ghee 2
				edt.putInt("spinner_ghee2", spinner_ghee2.getSelectedItemPosition());

				//Chicken Breast
				edt.putInt("spinner_chk_br", spinner_chk_br.getSelectedItemPosition());

				//White Rice
				edt.putInt("spinner_wr2", spinner_wr2.getSelectedItemPosition());

				//Soy Chunck 2
				edt.putInt("spinner_sc2", spinner_sc2.getSelectedItemPosition());

				//Curd
				edt.putInt("spinner_c", spinner_c.getSelectedItemPosition());

				//Ghee 2
				edt.putInt("spinner_ghee22", spinner_ghee22.getSelectedItemPosition());

				//Chicken Breast
				edt.putInt("spinner_chk_br2", spinner_chk_br2.getSelectedItemPosition());


				//Whey Pro

				edt.putInt("spinner_wp", spinner_wp.getSelectedItemPosition());
				edt.putInt("spinner_wp1", spinner_wp1.getSelectedItemPosition());



				edt.putString("txt_prom", pro_txtm.getText().toString());
				edt.putString("txt_fatsm", fats_txtm.getText().toString());
				edt.putString("txt_carbsm", carbs_txtm.getText().toString());

				edt.putString("cp1", pro1.getText().toString());
				edt.putString("cf1", carbs1.getText().toString());
				edt.putString("cc1", fats1.getText().toString());

				edt.putString("cp11", pro11.getText().toString());
				edt.putString("cf11", carbs11.getText().toString());
				edt.putString("cc11", fats11.getText().toString());

				edt.putString("cp111", pro111.getText().toString());
				edt.putString("cf111", carbs111.getText().toString());
				edt.putString("cc111", fats111.getText().toString());


				edt.apply();

				Toast.makeText(getActivity(), "Congradualation !!! You Are Done , Keep Updating Every Week !!!", 
						Toast.LENGTH_LONG).show();	
/*
				Intent intent = new Intent(getActivity(), MainActivity.class);
				getActivity().startActivity(intent);*/




			}



		});

		/*btnreset=(Button)rootView.findViewById(R.id.reset);
		btnreset.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				sharedPreferences = getActivity().getPreferences(1);

				sharedPreferences.edit().remove("cp1").commit();

			}
		});*/


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
