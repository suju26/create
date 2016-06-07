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
import info.muscle.reboot.activity.MainActivity;

public class Macro_readme extends Activity {

	String text_tdee="Nutrients are substances needed for growth, metabolism, and for other body functions."
			+ " Macronutrients are nutrients that provide calories or energy."
			+ "There are three broad classes of macro-nutrients: proteins, carbohydrates, and fats. ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_macro_readme);

		TextView tdee1=(TextView)findViewById(R.id.tdee);
		tdee1.setMovementMethod(new ScrollingMovementMethod());
		tdee1.setText(text_tdee);
		
		Button close_macro=(Button)findViewById(R.id.close_macro);
		close_macro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.macro_readme, menu);
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
