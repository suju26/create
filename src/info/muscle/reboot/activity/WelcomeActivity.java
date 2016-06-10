package info.muscle.reboot.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import info.muscle.reboot.R;

public class WelcomeActivity extends AppCompatActivity {


	private PrefManager prefManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Checking for first time launch - before calling setContentView()
		prefManager = new PrefManager(this);
		if (!prefManager.isFirstTimeLaunch()) {
			launchHomeScreen();
			finish();
		}



		// Making notification bar transparent
		if (Build.VERSION.SDK_INT >= 21) {
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		}

		setContentView(R.layout.welcome_slide1);

		Button btnwel=(Button)findViewById(R.id.wel_2);
		btnwel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Fragment newFragment = new KnowYourBodyFragment();
				FragmentTransaction transaction = getSupportFragmentManager()
						.beginTransaction();

				// Replace whatever is in the fragment_container view with this
				// fragment,
				// and add the transaction to the back stack
				transaction.replace(android.R.id.content, newFragment);
				transaction.addToBackStack("tag");

				// Commit the transaction
				transaction.commitAllowingStateLoss();				

			}
		});
	}
	private void launchHomeScreen() {
		prefManager.setFirstTimeLaunch(false);
		startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
		finish();
	}

	//	viewpager change listener

	/**
	 * Making notification bar transparent
	 */
	private void changeStatusBarColor() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(Color.TRANSPARENT);
		}
	}

	/**
	 * View pager adapter
	 */
}