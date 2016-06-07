package info.muscle.reboot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import info.muscle.reboot.R;
import info.muscle.reboot.activity.KnowYourBodyFragment;
import info.muscle.reboot.activity.MainActivity;

public class Readme_1 extends Activity {


	String text_tdee="TDEE is simply an acronym for Total Daily Energy Expenditure."
			+ " This is a measurement consisting of the total number of calories you burn in a day."
			+ " Your TDEE includes calories burned during exercise, "
			+ "during normal physical activity (showering, walking to/from your car, etc.),"
			+ " and your metabolic baseline (the calories you burn during the day to maintain body temperature, "
			+ "digest foods, breathe, and so on).";
	String text_tdee2="Fat loss sounds complicated when you consider the many facets of being healthy. "
			+ "There’s nutrition, exercise, and supplementation – but these all boil down to one basic concept:"
			+ " To lose weight, you must consume fewer calories each day than you expend."
			+ "One pound of fat is equal to 3,500 calories."
			+ " So, in order to lose one pound of fat in a week, you will need to take in 500 calories per day (3,500 / 7 = 500)"
			+ " less than your TDEE. To lose two pounds per week, you’ll need 1,000 calories per day less than your TDEE, "
			+ "and so on. You can increase your TDEE by more intensive exercise, or through metabolic"
			+ " hacks like using the ECA stack.";



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_readme_1);

		TextView tdee1=(TextView)findViewById(R.id.tdee);
		tdee1.setMovementMethod(new ScrollingMovementMethod());
		tdee1.setText(text_tdee);

		TextView tdee2=(TextView)findViewById(R.id.tdee1);
		tdee2.setMovementMethod(new ScrollingMovementMethod());
		tdee2.setText(text_tdee2);


		Button rd1_close=(Button)findViewById(R.id.close_rd1);
		rd1_close.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.readme_1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
