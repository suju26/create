package info.muscle.reboot.activity;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import info.muscle.reboot.R;


public class HomeFragment extends Fragment {


	//Fonts Declaration

	Typeface fontB,fontR,fontReg,fontThin,fontMed;
	Button btnhome;

	public HomeFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);





		//Fonts call

		fontB = Typeface.createFromAsset(getActivity().getAssets(), "fonts/BEBAS.TTF");
		fontR = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto_Light.ttf");
		fontReg = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
		fontThin = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");
		fontMed = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");

		SharedPreferences pref = getActivity().getPreferences(1);
		String cur_weight=pref.getString("weight", "0");
		String ideal_weight=pref.getString("ideal_weight", "0");
		String bf_result=pref.getString("bf_r", "0");
		String bf_status=pref.getString("bf_status", "Unknow");
		String bmi_result=pref.getString("bmi_result", "0");
		String bmi_status=pref.getString("bmi_status", "0");
		String macro_req=pref.getString("macro_cal", "0");

		TextView lbl_weigh=(TextView)rootView.findViewById(R.id.textView);
		lbl_weigh.setTypeface(fontB);

		TextView txt_tdde=(TextView)rootView.findViewById(R.id.txt_tdde);
		txt_tdde.setText(macro_req);
		txt_tdde.setTypeface(fontThin);

		TextView current_weight=(TextView)rootView.findViewById(R.id.txt_current_weight);
		current_weight.setText(cur_weight);
		current_weight.setTypeface(fontThin);



		TextView ideal_weight1=(TextView)rootView.findViewById(R.id.txt_ideal_weight);
		ideal_weight1.setText(ideal_weight);
		ideal_weight1.setTypeface(fontThin);

		TextView bf_result_txt=(TextView)rootView.findViewById(R.id.txt_body_fat);
		bf_result_txt.setText(bf_result);
		bf_result_txt.setTypeface(fontThin);

		TextView bf_result_txt_status=(TextView)rootView.findViewById(R.id.txt_body_fat_status);
		bf_result_txt_status.setText(bf_status);
		bf_result_txt_status.setTypeface(fontThin);



		TextView bmi_result_txt=(TextView)rootView.findViewById(R.id.txt_bmi);
		bmi_result_txt.setText(bmi_result);
		bmi_result_txt.setTypeface(fontThin);

		TextView bmi_result_txt_status=(TextView)rootView.findViewById(R.id.txt_bmi_status);
		bmi_result_txt_status.setText(bmi_status);
		bmi_result_txt_status.setTypeface(fontThin);



		//Calculating , weather to You Need To Loose or YOU NEED TO GAIN

		if(Double.parseDouble(cur_weight)< Double.parseDouble(ideal_weight))
		{
			TextView goal=(TextView)rootView.findViewById(R.id.txt_recommended_goal);
			goal.setText("YOU Need To GAIN");
			Double weight_goal=Double.parseDouble(ideal_weight)- Double.parseDouble(cur_weight);
			TextView txtGoalweight=(TextView)rootView.findViewById(R.id.txt_recommended_goal_weight);
			txtGoalweight.setText(""+Math.round(weight_goal));
			txtGoalweight.setTypeface(fontThin);

		}
		if(Double.parseDouble(cur_weight)>Double.parseDouble(ideal_weight))
		{
			TextView goal=(TextView)rootView.findViewById(R.id.txt_recommended_goal);
			goal.setText("You Need To LOSE");
			Double weight_goal=Double.parseDouble(cur_weight)- Double.parseDouble(ideal_weight);
			TextView txtGoalweight=(TextView)rootView.findViewById(R.id.txt_recommended_goal_weight);
			txtGoalweight.setText(""+Math.round(weight_goal));
			txtGoalweight.setTypeface(fontThin);

		}
		if(Double.parseDouble(cur_weight) == Double.parseDouble(ideal_weight))
		{
			TextView goal=(TextView)rootView.findViewById(R.id.txt_recommended_goal);
			goal.setText("Keep It");
			TextView txtGoalweight=(TextView)rootView.findViewById(R.id.txt_recommended_goal_weight);
			txtGoalweight.setText(cur_weight);
			txtGoalweight.setTypeface(fontThin);

		}

		//Calculating Difference now
		btnhome=(Button)rootView.findViewById(R.id.btnhome);
		btnhome.setOnClickListener(new View.OnClickListener() 
		{

			@Override
			public void onClick(View v) {
				
				Fragment newFragment = new KnowYourBodyFragment();
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
