package sorting.demoapp;

import java.util.ArrayList;

import sorting.demoapp.StackMenu.MyCount;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ArrayInsertion extends Activity {
Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,start;
int colorId,count, score;
ViewGroup viewgroup;
View view;
LinearLayout containView;
TextView timerValue;
private static final String IMAGEVIEW_TAG1 = "The Android Logo1";
private static final String IMAGEVIEW_TAG2 = "The Android Logo2";
private static final String IMAGEVIEW_TAG3 = "The Android Logo3";
private static final String IMAGEVIEW_TAG4 = "The Android Logo4";
private static final String IMAGEVIEW_TAG5 = "The Android Logo5";
private static final String IMAGEVIEW_TAG6 = "The Android Logo6";
private static final String IMAGEVIEW_TAG7 = "The Android Logo7";
private static final String IMAGEVIEW_TAG8 = "The Android Logo8";
private static final String IMAGEVIEW_TAG9 = "The Android Logo9";
private static final String IMAGEVIEW_TAG10 = "The Android Logo10";


int color_id_layout4;
int color_id_layout5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_array_insertion);
		timerValue=(TextView)findViewById(R.id.time);
		start=(Button)findViewById(R.id.start);
		btn1=(Button)findViewById(R.id.btn1);
		btn2=(Button)findViewById(R.id.btn2);
		btn3=(Button)findViewById(R.id.btn3);
		btn4=(Button)findViewById(R.id.btn4);
		btn5=(Button)findViewById(R.id.btn5);
		btn6=(Button)findViewById(R.id.btn6);
		btn7=(Button)findViewById(R.id.btn7);
		btn8=(Button)findViewById(R.id.btn8);
		btn9=(Button)findViewById(R.id.btn9);
		btn10=(Button)findViewById(R.id.btn10);
		
		
		btn1.setTag(IMAGEVIEW_TAG1);
	    btn2.setTag(IMAGEVIEW_TAG2);
	    btn3.setTag(IMAGEVIEW_TAG3);
	    btn4.setTag(IMAGEVIEW_TAG4);
	    btn5.setTag(IMAGEVIEW_TAG5);
	    btn6.setTag(IMAGEVIEW_TAG6);
	    btn7.setTag(IMAGEVIEW_TAG7);
	    btn8.setTag(IMAGEVIEW_TAG8);
	    btn9.setTag(IMAGEVIEW_TAG9);
	    btn10.setTag(IMAGEVIEW_TAG10);
	    
	    btn1.setOnLongClickListener(new MyClickListener());
		btn2.setOnLongClickListener(new MyClickListener());
		btn3.setOnLongClickListener(new MyClickListener());
		btn4.setOnLongClickListener(new MyClickListener());
		btn5.setOnLongClickListener(new MyClickListener());
		btn6.setOnLongClickListener(new MyClickListener());
		btn7.setOnLongClickListener(new MyClickListener());
		btn8.setOnLongClickListener(new MyClickListener());
		btn9.setOnLongClickListener(new MyClickListener());
		btn10.setOnLongClickListener(new MyClickListener());

	    findViewById(R.id.layout1).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout2).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout4).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout5).setOnDragListener(new MyDragListener());
		
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
		btn10.setEnabled(false);
		
	}


	private final class MyClickListener implements OnLongClickListener {

	    // called when the item is long-clicked
		@Override
		public boolean onLongClick(View view) {
		// TODO Auto-generated method stub
		
			// create it from the object's tag
			ClipData.Item item = new ClipData.Item((CharSequence)view.getTag());

	        String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
	        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
	        DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
	   
	        view.startDrag( data, //data to be dragged
	        				shadowBuilder, //drag shadow
	        				view, //local data about the drag and drop operation
	        				0   //no needed flags
	        			  );
	        
	        
	        view.setVisibility(View.INVISIBLE);
	        return true;
		}	
	}

	class MyDragListener implements OnDragListener {


		@Override
		public boolean onDrag(View v, DragEvent event) {
	  
			// Handles each of the expected events
		    switch (event.getAction()) {
		    
		    //signal for the start of a drag and drop operation.
		    case DragEvent.ACTION_DRAG_STARTED:
		        // do nothing
		    	//count++;
		        break;
		        
		    //the drag point has entered the bounding box of the View
		    case DragEvent.ACTION_DRAG_ENTERED:
		       // v.setBackground(targetShape);	//change the shape of the view
		        break;
		        
		    //the user has moved the drag shadow outside the bounding box of the View
		    case DragEvent.ACTION_DRAG_EXITED:
		       // v.setBackground(normalShape);	//change the shape of the view back to normal
		        break;
		        
		    //drag shadow has been released,the drag point is within the bounding box of the View
		    case DragEvent.ACTION_DROP:
		        // if the view is the bottomlinear, we accept the drag item
		    	
	    		  
		    	
		    	if(v == findViewById(R.id.layout4)) 
		    	  {
		    		  
	    		    view = (View) event.getLocalState();
		    		ColorDrawable buttonColor = (ColorDrawable) view.getBackground();
		    		colorId = buttonColor.getColor();

		    		  if(colorId != color_id_layout5)
		    			  if(color_id_layout4==0)
		    			  		color_id_layout4 = colorId;
		    		  
		    		  if(color_id_layout4 == colorId)
		    		  {
		    		  
			    		viewgroup = (ViewGroup) view.getParent();  
			    		  viewgroup.removeView(view);
			    		  containView = (LinearLayout) v;
			    		  containView.addView(view);
			    		  view.setVisibility(View.VISIBLE);
			    		  count++;
			    		  score++;
			    		  }
		    		  else 
		    		  {
			    		  view = (View) event.getLocalState();
			    		  view.setVisibility(View.VISIBLE);
			    		  Context context = getApplicationContext();
			    		  Toast.makeText(context, "You can't drop the image here", 
		                                             Toast.LENGTH_SHORT).show();
			    		  break;
			    	   }
		    	  }
		    	if(v == findViewById(R.id.layout5)) 
		    	  {		    		  
	    		    view = (View) event.getLocalState();
		    		ColorDrawable buttonColor = (ColorDrawable) view.getBackground();
		    		colorId = buttonColor.getColor();

		    		  if(colorId != color_id_layout4)
		    			  if(color_id_layout5==0)
		    			  		color_id_layout5 = colorId;
		    		  
		    		  if(color_id_layout5 == colorId)
		    		  {
		    		  
			    		viewgroup = (ViewGroup) view.getParent();  
			    		  viewgroup.removeView(view);
			    		  containView = (LinearLayout) v;
			    		  containView.addView(view);
			    		  view.setVisibility(View.VISIBLE);
			    		  //count++;
			    		  score++;

			    		  }
		    		  else 
		    		  {
			    		  view = (View) event.getLocalState();
			    		  view.setVisibility(View.VISIBLE);
			    		  Context context = getApplicationContext();
			    		  Toast.makeText(context, "You can't drop the image here", 
		                                             Toast.LENGTH_SHORT).show();
			    		  break;
			    	   }
		    	  		    	 
		    	  break;
		    	  }
		    	  
		    //the drag and drop operation has concluded.
		    case DragEvent.ACTION_DRAG_ENDED:
		       // v.setBackground(normalShape);	//go back to normal shape
		    //count--;
		    default:
		        break;
		    }
		    return true;
		}


	}
	public void startGame(View v){
		// Start Timer from Dialog
				start.setEnabled(false);
				AlertDialog.Builder dialog=new AlertDialog.Builder(this);
				dialog.setTitle("Start GAME");
				dialog.setIcon(R.drawable.ic_launcher);
				dialog.setMessage("Click OK to start playing with ARRAYS");
				dialog.setPositiveButton("OK",new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
				        //5000 is the starting number (in milliseconds)
				        //1000 is the number to count down each time (in milliseconds)
				        MyCount counter = new MyCount(22000,1000);

				        counter.start();
						
						dialog.dismiss();
						timerValue.setVisibility(View.VISIBLE);
					
					}
				});
				dialog.create();
				dialog.show();
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
				btn10.setEnabled(true);
	}
	 public class MyCount extends CountDownTimer{

	        public MyCount(long millisInFuture, long countDownInterval) {
	            super(millisInFuture, countDownInterval);
	        }
	        
	        @Override
	        public void onFinish() {
	        	timerValue.setText("Done !");
	        	if(score==10){
	        		Dialog d=new Dialog(ArrayInsertion.this);
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
							Intent i=new Intent(ArrayInsertion.this,MainMenu.class);
							i.putExtra("Level - 1 Status",1 );
							startActivity(i);
						}
					});
	        	
	        		Button btn=(Button)findViewById(R.id.continuePlay);
	        		btn.setVisibility(View.VISIBLE);
	        	}
	        	else{
	        		Dialog d=new Dialog(ArrayInsertion.this);
	        		d.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        		d.setContentView(R.layout.dialog_layout_lose);
	        		Button tryagain=(Button)d.findViewById(R.id.tryagain);
	        		d.setCancelable(false);
	        		tryagain.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(ArrayInsertion.this,ArrayInsertion.class));
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
	 public void continuePlay(View v){
		 Intent i=new Intent(ArrayInsertion.this,MainMenu.class);
			i.putExtra("Level - 1 Status",1 );
			startActivity(i);		}
}