package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import info.androidhive.materialdesign.R;


public class YourResultFragment extends Fragment {
	
	TextView txtlable,txtdiet,txtcalresult,txtper,txtbf,txtbfresult,txtbmi,txtbmiresult,txthealth,txthealthresult,txthealthresult2;

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

        //Getting Calculated Result
        
        SharedPreferences pref = getActivity().getPreferences(0);
        String diet = pref.getString("cal_req_result", "0");
        String bmi_get=pref.getString("bmi_result", "0");
        String bf_health=pref.getString("bf_status", "Unknown");
        String bmi_health=pref.getString("bmi_status", "Unknown");
        String bf=pref.getString("bf_r", "0");
        
        
        
        //Setting Custom Fonts
        
        Typeface fontB = Typeface.createFromAsset(getActivity().getAssets(), "fonts/BEBAS.TTF");
		Typeface fontR = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto_Light.ttf");

		//View all Component
		
		txtlable=(TextView)rootView.findViewById(R.id.label);
		txtlable.setTypeface(fontB);
		
		txtdiet=(TextView)rootView.findViewById(R.id.textView);
		txtdiet.setTypeface(fontB);
		
		
		txtcalresult=(TextView)rootView.findViewById(R.id.txt_cal);
		txtcalresult.setTypeface(fontR);
		txtcalresult.setText(diet);
		
		txtper=(TextView)rootView.findViewById(R.id.textView2);
		txtper.setTypeface(fontB);
		
		txtbf=(TextView)rootView.findViewById(R.id.textView3);
		txtbf.setTypeface(fontB);
		
		txtbfresult=(TextView)rootView.findViewById(R.id.txt_body_fat);
		txtbfresult.setTypeface(fontR);
		txtbfresult.setText(bf);
		
		txtbmi=(TextView)rootView.findViewById(R.id.textView5);
		txtbmi.setTypeface(fontB);
		
		txtbmiresult=(TextView)rootView.findViewById(R.id.txt_bmi);
		txtbmiresult.setTypeface(fontR);
		txtbmiresult.setText(bmi_get);
		
		txthealth=(TextView)rootView.findViewById(R.id.textView6);
		txthealth.setTypeface(fontB);
		
		txthealthresult=(TextView)rootView.findViewById(R.id.txt_health_statusbf);
		txthealthresult.setTypeface(fontR);
		txthealthresult.setText(bf_health);
		
		txthealthresult2=(TextView)rootView.findViewById(R.id.txt_health_statusbmi);
		txthealthresult2.setTypeface(fontR);
		txthealthresult2.setText(bmi_health);
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
