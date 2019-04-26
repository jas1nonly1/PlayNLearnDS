package sorting.demoapp;

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
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
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

public class TreeDemo extends Activity {
	View view;
	ViewGroup viewgroup;
	LinearLayout containView;
	
	int count;
	TextView time;
	Button b1,b2,b3,b4,b5,b6,b7,start,continueButton;
	LinearLayout layoutTop,layoutBottom,layout1,layout2,layout3,layout4,layout5,layout6,layout7;
	private static final String IMAGEVIEW_TAG = "The Android Logo";
	private static final String IMAGEVIEW_TAG1 = "The Android Logo1";
	private static final String IMAGEVIEW_TAG2 = "The Android Logo2";
	private static final String IMAGEVIEW_TAG3 = "The Android Logo3";
	private static final String IMAGEVIEW_TAG4 = "The Android Logo4";
	private static final String IMAGEVIEW_TAG5 = "The Android Logo5";
	private static final String IMAGEVIEW_TAG6 = "The Android Logo6";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tree_demo);
		b1=(Button)findViewById(R.id.b1);
		b2=(Button)findViewById(R.id.b2);
		b3=(Button)findViewById(R.id.b3);
		b4=(Button)findViewById(R.id.b4);
		b5=(Button)findViewById(R.id.b5);
		b6=(Button)findViewById(R.id.b6);
		b7=(Button)findViewById(R.id.b7);
		
		start=(Button)findViewById(R.id.start);
		continueButton=(Button)findViewById(R.id.continuePlay);
		time=(TextView)findViewById(R.id.time);
		
		b1.setTag(IMAGEVIEW_TAG);    
	    b2.setTag(IMAGEVIEW_TAG1);
	    b3.setTag(IMAGEVIEW_TAG2);
	    b4.setTag(IMAGEVIEW_TAG3);
	    b5.setTag(IMAGEVIEW_TAG4);
	    b6.setTag(IMAGEVIEW_TAG5);
		b7.setTag(IMAGEVIEW_TAG6);
		
		b1.setOnLongClickListener(new MyClickListener());
		b2.setOnLongClickListener(new MyClickListener());
		b3.setOnLongClickListener(new MyClickListener());
		b4.setOnLongClickListener(new MyClickListener());
		b5.setOnLongClickListener(new MyClickListener());
		b6.setOnLongClickListener(new MyClickListener());
		b7.setOnLongClickListener(new MyClickListener());

		
		findViewById(R.id.layoutTop).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout1).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout2).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout3).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout4).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout5).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout6).setOnDragListener(new MyDragListener());
		findViewById(R.id.layout7).setOnDragListener(new MyDragListener());
		
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		
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
		    	  
		    	    if(v == findViewById(R.id.layout1)) {
		    		  
		    		  view = (View) event.getLocalState();
		    		  if(view==b1){
		    		  viewgroup = (ViewGroup) view.getParent();
		    		  viewgroup.removeView(view);
		           
		    		  containView = (LinearLayout) v;
		    		  containView.addView(view,0);
		    		  
		    		 // added_views_list.add(view);
		    		  
		    		  view.setVisibility(View.VISIBLE);
		    		  count++;
		    		  }
		    		  else{
		    			  View view = (View) event.getLocalState();
			    		  view.setVisibility(View.VISIBLE);
			    		  Context context = getApplicationContext();
			    		  Toast.makeText(context, "You can't drop the image here", 
		                                             Toast.LENGTH_SHORT).show();
		    		  }
		    		 
		    	  }
		    	  if(v == findViewById(R.id.layout2)) {
		    		  
		    		  
		    		  view = (View) event.getLocalState();
		    		  if(view==b6){
			    		  viewgroup = (ViewGroup) view.getParent();
			    		  viewgroup.removeView(view);
			           
			    		  containView = (LinearLayout) v;
			    		  containView.addView(view,0);
			    		  
			    		 // added_views_list.add(view);
			    		  
			    		  view.setVisibility(View.VISIBLE);
			    		  count++;
			    		  }
			    		  else{
			    			  View view = (View) event.getLocalState();
				    		  view.setVisibility(View.VISIBLE);
				    		  Context context = getApplicationContext();
				    		  Toast.makeText(context, "You can't drop the image here", 
			                                             Toast.LENGTH_SHORT).show();
			    		  } 
		    	  } 
		    	  if(v == findViewById(R.id.layout3)) {
		    		  view = (View) event.getLocalState();
		    		  if(view==b7){
			    		  viewgroup = (ViewGroup) view.getParent();
			    		  viewgroup.removeView(view);
			           
			    		  containView = (LinearLayout) v;
			    		  containView.addView(view,0);
			    		  count++;
			    		  
			    		 // added_views_list.add(view);
			    		  
			    		  view.setVisibility(View.VISIBLE);
			    		  }
			    		  else{
			    			  View view = (View) event.getLocalState();
				    		  view.setVisibility(View.VISIBLE);
				    		  Context context = getApplicationContext();
				    		  Toast.makeText(context, "You can't drop the image here", 
			                                             Toast.LENGTH_SHORT).show();
			    		  }		    		 
		    	  } 
		    	  if(v == findViewById(R.id.layout4)) {
		    		  view = (View) event.getLocalState();
		    		  if(view==b2){
			    		  viewgroup = (ViewGroup) view.getParent();
			    		  viewgroup.removeView(view);
			           
			    		  containView = (LinearLayout) v;
			    		  containView.addView(view,0);
			    		  
			    		 // added_views_list.add(view);
			    		  
			    		  view.setVisibility(View.VISIBLE);
			    		  count++;
			    		  }
			    		  else{
			    			  View view = (View) event.getLocalState();
				    		  view.setVisibility(View.VISIBLE);
				    		  Context context = getApplicationContext();
				    		  Toast.makeText(context, "You can't drop the image here", 
			                                             Toast.LENGTH_SHORT).show();
			    		  }
		    	  } 
		    	  if(v == findViewById(R.id.layout5)) {
		    		  view = (View) event.getLocalState();
		    		  if(view==b5){
			    		  viewgroup = (ViewGroup) view.getParent();
			    		  viewgroup.removeView(view);
			           
			    		  containView = (LinearLayout) v;
			    		  containView.addView(view,0);
			    		  
			    		 // added_views_list.add(view);
			    		  
			    		  view.setVisibility(View.VISIBLE);
			    		  count++;
			    		  }
			    		  else{
			    			  View view = (View) event.getLocalState();
				    		  view.setVisibility(View.VISIBLE);
				    		  Context context = getApplicationContext();
				    		  Toast.makeText(context, "You can't drop the image here", 
			                                             Toast.LENGTH_SHORT).show();
			    		  }
		    	  } 
		    	  if(v == findViewById(R.id.layout6)) {
		    		  view = (View) event.getLocalState();
		    		  if(view==b3){
			    		  viewgroup = (ViewGroup) view.getParent();
			    		  viewgroup.removeView(view);
			           
			    		  containView = (LinearLayout) v;
			    		  containView.addView(view,0);
			    		  
			    		 // added_views_list.add(view);
			    		  
			    		  view.setVisibility(View.VISIBLE);
			    		  count++;
			    		  }
			    		  else{
			    			  View view = (View) event.getLocalState();
				    		  view.setVisibility(View.VISIBLE);
				    		  Context context = getApplicationContext();
				    		  Toast.makeText(context, "You can't drop the image here", 
			                                             Toast.LENGTH_SHORT).show();
			    		  }
		    		} 
		    	  if(v == findViewById(R.id.layout7)) {
		    		  view = (View) event.getLocalState();
		    		  if(view==b4){
			    		  viewgroup = (ViewGroup) view.getParent();
			    		  viewgroup.removeView(view);
			           
			    		  containView = (LinearLayout) v;
			    		  containView.addView(view,0);
			    		  
			    		 // added_views_list.add(view);
			    		  
			    		  view.setVisibility(View.VISIBLE);
			    		  count++;
			    		  }
			    		  else{
			    			  View view = (View) event.getLocalState();
				    		  view.setVisibility(View.VISIBLE);
				    		  Context context = getApplicationContext();
				    		  Toast.makeText(context, "You can't drop the image here", 
			                                             Toast.LENGTH_SHORT).show();
			    		  }
		    		} 
//		    	  else {
//		    		  View view = (View) event.getLocalState();
//		    		  view.setVisibility(View.VISIBLE);
//		    		  Context context = getApplicationContext();
//		    		  Toast.makeText(context, "You can't drop the image here", 
//	                                             Toast.LENGTH_SHORT).show();
//		    		  break;
//		    	   }
		    	  		    	 
		    	  break;
		    	  
		    //the drag and drop operation has concluded.
		    case DragEvent.ACTION_DRAG_ENDED:

	    		  view = (View) event.getLocalState();
		    		view.setVisibility(View.VISIBLE);
		       // v.setBackground(normalShape);	//go back to normal shape
		    
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
				dialog.setMessage("Click OK to start playing with TREE");
				dialog.setPositiveButton("OK",new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
				        //5000 is the starting number (in milliseconds)
				        //1000 is the number to count down each time (in milliseconds)
				        MyCount counter = new MyCount(25000,1000);

				        counter.start();
						
						dialog.dismiss();
						time.setVisibility(View.VISIBLE);
					}
				});
				dialog.create();
				dialog.show();
				b1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				b4.setEnabled(true);
				b5.setEnabled(true);
				b6.setEnabled(true);
				b7.setEnabled(true);
	}
	 public class MyCount extends CountDownTimer{
	        public MyCount(long millisInFuture, long countDownInterval) {
	            super(millisInFuture, countDownInterval);
	        }	        
	        @Override
	        public void onFinish() {
	        	time.setText("Done !");
	        	if(count==7){
	        		Dialog d=new Dialog(TreeDemo.this);
	        		d.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        		d.setContentView(R.layout.final_dialog);
	        		Button cont=(Button)d.findViewById(R.id.cont);
	        		d.setCanceledOnTouchOutside(false);
	        		//d.setCancelable(false);
	        		d.show();
	        		cont.setOnClickListener(new View.OnClickListener() {			
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent i=new Intent(TreeDemo.this,MainMenu.class);
							i.putExtra("Level - 1 Status", 4);
							startActivity(i);
						}
					});	        	
	        		Button btn=(Button)findViewById(R.id.continuePlay);
	        		btn.setVisibility(View.VISIBLE);
	        	}
	        	else{
	        		Dialog d=new Dialog(TreeDemo.this);
	        		d.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        		d.setContentView(R.layout.dialog_layout_lose);
	        		Button tryagain=(Button)d.findViewById(R.id.tryagain);
	        		d.setCancelable(false);
	        		d.setCanceledOnTouchOutside(false);
	        		tryagain.setOnClickListener(new View.OnClickListener() {						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(TreeDemo.this,TreeDemo.class));
						}
					});
	        		d.setCanceledOnTouchOutside(false);
	        		d.show();
	        	}
	        }
	        @Override
	        public void onTick(long millisUntilFinished) {
	            time.setText("Left: " + millisUntilFinished/1000);

	        }
	    }
	 public void continuePlay(View v){
		 Intent i=new Intent(TreeDemo.this,MainMenu.class);
			i.putExtra("Level - 1 Status", 4);
			startActivity(i);		
			}
}