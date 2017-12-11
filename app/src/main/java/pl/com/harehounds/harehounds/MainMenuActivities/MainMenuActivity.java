package pl.com.harehounds.harehounds.MainMenuActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import pl.com.harehounds.harehounds.Lobby;
import pl.com.harehounds.harehounds.R;
import pl.com.harehounds.harehounds.User.UserSingleton;

public class MainMenuActivity extends AppCompatActivity {
	private UserSingleton user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		user = UserSingleton.getInstance();
		if (user == null) {
			// TODO: 15.11.17 make back to login function
		}

//		newFriendNickName = (EditText) findViewById(R.id.newFriendNickName);

		TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
		tabLayout.addTab(tabLayout.newTab().setText("Nowa gra"));
		tabLayout.addTab(tabLayout.newTab().setText("Gry w pobliżu"));
		tabLayout.addTab(tabLayout.newTab().setText("Znajomi"));
//		tabLayout.addTab(tabLayout.newTab().setText("Settings"));
		tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

//		Button mAddFriend = (Button) findViewById(R.id.addFriendButton);
//		mAddFriend.bringToFront();
//		mAddFriend.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				addFriend();
//			}
//		});

		final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
		final PagerAdapter adapter = new PagerAdapter
				(getSupportFragmentManager(), tabLayout.getTabCount());
		viewPager.setAdapter(adapter);
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				viewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				Log.i("TAG", "onTabUnselected: " + tab.getPosition());
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {
				Log.i("TAG", "onTabReselected: " + tab.getPosition());
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main_menu, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		return id == R.id.action_settings || super.onOptionsItemSelected(item);
	}

	public void goToLobby(View view) {
		startActivity(new Intent(MainMenuActivity.this, Lobby.class));
	}
}
