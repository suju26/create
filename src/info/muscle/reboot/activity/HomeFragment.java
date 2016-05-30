package info.muscle.reboot.activity;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import info.muscle.reboot.R;


public class HomeFragment extends Fragment {

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

		SharedPreferences pref = getActivity().getPreferences(1);
		String cur_weight=pref.getString("weight", "0");
		String ideal_weight=pref.getString("ideal_weight", "0");
		String bf_result=pref.getString("bf_r", "0");
		String bf_status=pref.getString("bf_status", "Unknow");
		String bmi_result=pref.getString("bmi_result", "0");
		String bmi_status=pref.getString("bmi_status", "0");

		TextView current_weight=(TextView)rootView.findViewById(R.id.txt_current_weight);
		current_weight.setText(cur_weight);

		TextView ideal_weight1=(TextView)rootView.findViewById(R.id.txt_ideal_weight);
		ideal_weight1.setText(ideal_weight);

		TextView bf_result_txt=(TextView)rootView.findViewById(R.id.txt_body_fat);
		bf_result_txt.setText(bf_result);

		TextView bf_result_txt_status=(TextView)rootView.findViewById(R.id.txt_body_fat_status);
		bf_result_txt_status.setText(bf_status);

		TextView bmi_result_txt=(TextView)rootView.findViewById(R.id.txt_bmi);
		bmi_result_txt.setText(bmi_result);

		TextView bmi_result_txt_status=(TextView)rootView.findViewById(R.id.txt_bmi_status);
		bmi_result_txt_status.setText(bmi_status);



		//Calculating , weather to loose or gain

		if(Double.parseDouble(cur_weight)< Double.parseDouble(ideal_weight))
		{
			TextView goal=(TextView)rootView.findViewById(R.id.txt_recommended_goal);
			goal.setText("GAIN");
			Double weight_goal=Double.parseDouble(ideal_weight)- Double.parseDouble(cur_weight);
			TextView txtGoalweight=(TextView)rootView.findViewById(R.id.txt_recommended_goal_weight);
			txtGoalweight.setText(""+Math.round(weight_goal));

		}
		if(Double.parseDouble(cur_weight)>Double.parseDouble(ideal_weight))
		{
			TextView goal=(TextView)rootView.findViewById(R.id.txt_recommended_goal);
			goal.setText("Loose");
			Double weight_goal=Double.parseDouble(cur_weight)- Double.parseDouble(ideal_weight);
			TextView txtGoalweight=(TextView)rootView.findViewById(R.id.txt_recommended_goal_weight);
			txtGoalweight.setText(""+Math.round(weight_goal));
		}
		if(Double.parseDouble(cur_weight) == Double.parseDouble(ideal_weight))
		{
			TextView goal=(TextView)rootView.findViewById(R.id.txt_recommended_goal);
			goal.setText("Keep It");
			TextView txtGoalweight=(TextView)rootView.findViewById(R.id.txt_recommended_goal_weight);
			txtGoalweight.setText(cur_weight);
		}

		//Calculating Difference now





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
