package sorting.demoapp;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainMenu extends Activity {
	Button stackButton,queueButton,treeButton;
	public static final String STACK="sorting.demoapp.Stack";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		stackButton=(Button)findViewById(R.id.stackButton);
		queueButton=(Button)findViewById(R.id.queueButton);
		treeButton=(Button)findViewById(R.id.treeButton);

		
		int ii = getIntent().getIntExtra("Level - 1 Status", 0);
		if(ii == 1)
		{
			stackButton.setEnabled(true);
			stackButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
			stackButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.unlocked, 0);
		}
		
		if(ii == 2)
		{
			stackButton.setEnabled(true);
			stackButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
			stackButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.unlocked, 0);
		
			queueButton.setEnabled(true);
			queueButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
			queueButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.unlocked, 0);
			
		}
		if(ii == 3)
		{
			stackButton.setEnabled(true);
			stackButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
			stackButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.unlocked, 0);
		
			queueButton.setEnabled(true);
			queueButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
			queueButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.unlocked, 0);
			
			treeButton.setEnabled(true);
			treeButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
			treeButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.unlocked, 0);
			
		}
		if(ii == 4)
		{
			stackButton.setEnabled(true);
			stackButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
			stackButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.unlocked, 0);
		
			queueButton.setEnabled(true);
			queueButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
			queueButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.unlocked, 0);
			
			treeButton.setEnabled(true);
			treeButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
			treeButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.unlocked, 0);
			
		}
		
	}

	public void showArray(View v){
		Intent i=new Intent(this,ArrayMenu.class);
		
		startActivity(i);
	}
	public void showStack(View v){
		Intent i=new Intent(this,StackDef.class);
		i.putExtra("STACK", stackButton.getId());
		startActivity(i);
	}
	public void showQueue(View v){
		Intent i=new Intent(this,QueueDef.class);
		startActivity(i);
	}
	public void showTree(View v){
//		Intent i=new Intent(this,TreeDemo.class);
//		startActivity(i);
		Dialog d=new Dialog(MainMenu.this);
		d.setTitle("Instructions for Binary Search Tree Insertion");
//		d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		d.setContentView(R.layout.dialog_text);
		Button cont1=(Button)d.findViewById(R.id.cont1);
		d.setCancelable(false);
		d.setCanceledOnTouchOutside(false);
		cont1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainMenu.this,TreeDemo.class));
			}
		});
		d.setCanceledOnTouchOutside(false);
		d.show();
	}
		
	@Override
	public void onBackPressed(){
		new AlertDialog.Builder(this).setTitle("QUIT").setMessage("Do you want to Quit the Game?").setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					
						Intent intent = new Intent(Intent.ACTION_MAIN);
					    intent.addCategory(Intent.CATEGORY_HOME);
					    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					    startActivity(intent);
					}
				}).setNegativeButton("No",null).show();
	}

}
