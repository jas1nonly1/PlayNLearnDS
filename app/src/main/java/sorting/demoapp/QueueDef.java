package sorting.demoapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class QueueDef extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_queue_def);
	}

	public void playQueue(View v){
		animatedStartActivity();

	}
	
	public void back(View v){
		animatedStartActivity();
	}
	@Override
	protected void onResume() {
		// animateIn this activity
		ActivitySwitcher.animationIn(findViewById(R.id.container), getWindowManager());
		super.onResume();
	}
	
	private void animatedStartActivity() {
		// we only animateOut this activity here.
		// The new activity will animateIn from its onResume() - be sure to implement it.
		final Intent intent = new Intent(getApplicationContext(),WelcomeQueue.class);
		// disable default animation for new intent
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		ActivitySwitcher.animationOut(findViewById(R.id.container), getWindowManager(), new ActivitySwitcher.AnimationFinishedListener() {
			@Override
			public void onAnimationFinished() {
				startActivity(intent);
			}
		});
	}

}
