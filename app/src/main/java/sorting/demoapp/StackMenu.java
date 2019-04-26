package sorting.demoapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StackMenu extends Activity {
TextView text1, text2, text3,text4,text5,text6,text7,text8,text9,text10;
EditText edit;
View v1,v2,v3,v4,v5,v6,v7,v8,v9;
Button push,pop,start;
//Timer
TextView timerValue;
long startTime=0L;
Handler customHandler=new Handler();
long timeInMilliseconds=0L;
long timeSwapBuff=0L;
long updatedTime=0L;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stack_menu);
		push=(Button)findViewById(R.id.push);
		pop=(Button)findViewById(R.id.pop);
		start=(Button)findViewById(R.id.start);
		timerValue=(TextView)findViewById(R.id.time);
		text1=(TextView)findViewById(R.id.txt1);
		text2=(TextView)findViewById(R.id.txt2);
		text3=(TextView)findViewById(R.id.txt3);
		text4=(TextView)findViewById(R.id.txt4);
		text5=(TextView)findViewById(R.id.txt5);
		text6=(TextView)findViewById(R.id.txt6);
		text7=(TextView)findViewById(R.id.txt7);
		text8=(TextView)findViewById(R.id.txt8);
		text9=(TextView)findViewById(R.id.txt9);
		text10=(TextView)findViewById(R.id.txt10);

		edit=(EditText)findViewById(R.id.edit);
		v1=findViewById(R.id.v1);
		v2=findViewById(R.id.v2);
		v3=findViewById(R.id.v3);
		v4=findViewById(R.id.v4);
		v5=findViewById(R.id.v5);
		v6=findViewById(R.id.v6);
		v7=findViewById(R.id.v7);
		v8=findViewById(R.id.v8);
		v9=findViewById(R.id.v9);

		push.setEnabled(false);
		pop.setEnabled(false);
		
	}
	public void startGame(View v){
		// Start Timer from Dialog
		
				AlertDialog.Builder dialog=new AlertDialog.Builder(this);
				dialog.setTitle("Start GAME");
				dialog.setIcon(R.drawable.ic_launcher);
				dialog.setMessage("Click OK to start playing with STACK");
				dialog.setPositiveButton("OK",new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						startTime=System.currentTimeMillis();

				        //5000 is the starting number (in milliseconds)
				        //1000 is the number to count down each time (in milliseconds)
				        MyCount counter = new MyCount(10000,1000);

				        counter.start();
						
						dialog.dismiss();
						timerValue.setVisibility(View.VISIBLE);
						push.setEnabled(true);
						pop.setEnabled(true);
						start.setEnabled(false);
					}
				});
				dialog.create();
				dialog.show();
	}
	
	 public class MyCount extends CountDownTimer{

	        public MyCount(long millisInFuture, long countDownInterval) {
	            super(millisInFuture, countDownInterval);
	        }
	        
	        @Override
	        public void onFinish() {
	        	timerValue.setText("Done !");
	        	if(text10.getVisibility()==View.VISIBLE){
	        		Dialog d=new Dialog(StackMenu.this);
	        		d.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        		d.setContentView(R.layout.dialog_layout_win);
	        		Button cont=(Button)d.findViewById(R.id.cont);
	        		d.setCanceledOnTouchOutside(false);
	        		//d.setCancelable(false);
	        		d.show();
	        		cont.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent i=new Intent(StackMenu.this,MainMenu.class);
							i.putExtra("Level - 1 Status", 2);
							startActivity(i);
						}
					});
	        		Button btn=(Button)findViewById(R.id.continuePlay);
	        		btn.setVisibility(View.VISIBLE);
	        	}
	        	else{
	        		Dialog d=new Dialog(StackMenu.this);
	        		d.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        		d.setContentView(R.layout.dialog_layout_lose);
	        		Button tryagain=(Button)d.findViewById(R.id.tryagain);
	        		//d.setCancelable(false);
	        		tryagain.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(StackMenu.this,StackMenu.class));
						}
					});
	        		d.setCanceledOnTouchOutside(false);
	        		d.show();
	        	}
	        }

	        @Override
	        public void onTick(long millisUntilFinished) {
	            timerValue.setText("Left: " + millisUntilFinished/1000);

	        }

	    }
	public void draw(View v){
		if(edit.getText().equals(""))
		{
			Toast.makeText(this, "No value entered!", Toast.LENGTH_LONG).show();
		}
		else
		{
		if(text1.getText().equals(""))
		{
			text1.setVisibility(View.VISIBLE);
			text1.setText(edit.getText().toString());
			v1.setVisibility(View.VISIBLE);
			Log.i("HaathiAction", "text1");
		}		
		else if(text2.getText().equals(""))
		{
			text2.setVisibility(View.VISIBLE);
			text2.setText(edit.getText().toString());
			Log.i("HaathiAction", "text2");
			v2.setVisibility(View.VISIBLE);
		}
		else if(text3.getText().equals(""))
		{
			text3.setVisibility(View.VISIBLE);
			text3.setText(edit.getText().toString());
			Log.i("HaathiAction", "text3");
			v3.setVisibility(View.VISIBLE);

		}
		else if(text4.getText().equals(""))
		{
			text4.setVisibility(View.VISIBLE);
			text4.setText(edit.getText().toString());
			v4.setVisibility(View.VISIBLE);

		}
		else if(text5.getText().equals(""))
		{
			text5.setVisibility(View.VISIBLE);
			text5.setText(edit.getText().toString());
			v5.setVisibility(View.VISIBLE);

		}
		else if(text6.getText().equals(""))
		{
			text6.setVisibility(View.VISIBLE);
			text6.setText(edit.getText().toString());
			v6.setVisibility(View.VISIBLE);

		}
		else if(text7.getText().equals(""))
		{
			text7.setVisibility(View.VISIBLE);
			text7.setText(edit.getText().toString());
			v7.setVisibility(View.VISIBLE);

		}
		else if(text8.getText().equals(""))
		{
			text8.setVisibility(View.VISIBLE);
			text8.setText(edit.getText().toString());
			v8.setVisibility(View.VISIBLE);

		}
		else if(text9.getText().equals(""))
		{
			text9.setVisibility(View.VISIBLE);
			text9.setText(edit.getText().toString());
			v9.setVisibility(View.VISIBLE);

		}
		else if(text10.getText().equals(""))
		{
			text10.setVisibility(View.VISIBLE);
			text10.setText(edit.getText().toString());

		}
		
		else{
			Toast.makeText(this,"Your Stack is Full !!", Toast.LENGTH_SHORT).show();
			long tEnd = System.currentTimeMillis();
        	long tDelta = tEnd - startTime;
        	double elapsedSeconds = tDelta / 1000.0;
        	
		}
		}
		
	}
	
	public void continuePlay(View v){
		Intent i=new Intent(StackMenu.this,MainMenu.class);
		i.putExtra("Level - 1 Status", 2);
		startActivity(i);	}
	
	public void delete(View v){
		if(!text10.getText().equals(""))
		{
			text10.setVisibility(View.INVISIBLE);
			text10.setText("");
			//v9.setVisibility(View.INVISIBLE);
			Log.i("HaathiAction", "text10");
		}		
		else if(!text9.getText().equals(""))
		{
			text9.setVisibility(View.INVISIBLE);
			text9.setText("");
			Log.i("HaathiAction", "text9");
			v9.setVisibility(View.INVISIBLE);
			//v8.setVisibility(View.INVISIBLE);
		}
		else if(!text8.getText().equals(""))
		{
			text8.setVisibility(View.INVISIBLE);
			text8.setText("");
			Log.i("HaathiAction", "text3");
			//v7.setVisibility(View.INVISIBLE);
			v8.setVisibility(View.INVISIBLE);

		}
		else if(!text7.getText().equals(""))
		{
			text7.setVisibility(View.INVISIBLE);
			text7.setText("");
			//v6.setVisibility(View.INVISIBLE);
			v7.setVisibility(View.INVISIBLE);

		}
		else if(!text6.getText().equals(""))
		{
			text6.setVisibility(View.INVISIBLE);
			text6.setText("");
			//v5.setVisibility(View.INVISIBLE);
			v6.setVisibility(View.INVISIBLE);

		}
		else if(!text5.getText().equals(""))
		{
			text5.setVisibility(View.INVISIBLE);
			text5.setText("");
			//v4.setVisibility(View.INVISIBLE);
			v5.setVisibility(View.INVISIBLE);

		}
		else if(!text4.getText().equals(""))
		{
			text4.setVisibility(View.INVISIBLE);
			text4.setText("");
			//v3.setVisibility(View.INVISIBLE);
			v4.setVisibility(View.INVISIBLE);

		}
		else if(!text3.getText().equals(""))
		{
			text3.setVisibility(View.INVISIBLE);
			text3.setText("");
			//v2.setVisibility(View.INVISIBLE);
			v3.setVisibility(View.INVISIBLE);

		}
		else if(!text2.getText().equals(""))
		{
			text2.setVisibility(View.INVISIBLE);
			text2.setText("");
			//v1.setVisibility(View.INVISIBLE);
			v2.setVisibility(View.INVISIBLE);
		}
		else if(!text1.getText().equals(""))
		{
			text1.setVisibility(View.INVISIBLE);
			text1.setText("");
			v1.setVisibility(View.INVISIBLE);
			Toast.makeText(this,"Your Stack is Empty !!", Toast.LENGTH_SHORT).show();

		}		
		else{
			Toast.makeText(this,"Your Stack is Empty !!", Toast.LENGTH_SHORT).show();
		}
	}
	
}
