package info.muscle.reboot.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import info.muscle.reboot.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

	public MainActivity() {
		// Required empty public constructor
	}

	private static String TAG = MainActivity.class.getSimpleName();

	private Toolbar mToolbar;
	private FragmentDrawer drawerFragment;
	SharedPreferences pref;
	String diet_saved;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		pref = this.getPreferences(1);
		diet_saved=pref.getString("diettype", "main");

		mToolbar = (Toolbar) findViewById(R.id.toolbar);

		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);

		drawerFragment = (FragmentDrawer)
				getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
		drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
		drawerFragment.setDrawerListener(this);

		// display the first navigation drawer view on app launch
		displayView(0);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		/*if (id == R.id.workout_menu) {

			startActivity(new Intent(MainActivity.this, MainActivity.class));
			finish();

			return true;
		}*/

		/*if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }
		 */
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onDrawerItemSelected(View view, int position) {
		displayView(position);
	}

	private void displayView(int position) {
		Fragment fragment = null;
		String title = getString(R.string.app_name);

		switch (position) {


		case 0:
			fragment = new HomeFragment();

			title = getString(R.string.title_home);
			break;
		case 1:
			fragment = new KnowYourBodyFragment();
			title = getString(R.string.title_friends);
			break;
		case 2:
			fragment = new YourResultFragment();
			title = getString(R.string.title_messages);
			break;
		case 3:
			fragment = new YourMacroResultFragment();
			title = getString(R.string.title_macro);
			break;
		case 4:
			fragment = new DietPlanFragment();
			title = getString(R.string.title_Diet);
			break;

		case 5:
			title = getString(R.string.title_Exit);
			finish();
			break;

		default:
		}


		if (fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.container_body, fragment);
			fragmentTransaction.commit();

			// set the toolbar title
			getSupportActionBar().setTitle(title);
		}
	}
}