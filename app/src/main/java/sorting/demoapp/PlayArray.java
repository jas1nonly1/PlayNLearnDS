package sorting.demoapp;

import sorting.demoapp.ActivitySwitcher;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;

public class PlayArray extends Activity implements OnItemClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_array);
		ListView levels=(ListView)findViewById(R.id.list);
		levels.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(position==0){
			Intent i=new Intent(this,ArrayInsertion.class);
//			Intent i=new Intent(this,MainMenu.class);
//			i.putExtra("level1_status", 1);
			startActivity(i);
		}
		else if(position==1){
			Intent i=new Intent(this,ArraySorting.class);
			startActivity(i);
			
		}
		else if(position==2){
			Intent i=new Intent(this,ComparingArray.class);
			startActivity(i);
		}
		
	}

}
