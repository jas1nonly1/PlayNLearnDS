package sorting.demoapp;


import java.util.ArrayList;

import sorting.demoapp.ArrayInsertion.MyCount;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlayQueue extends Activity{
public TextView t1,t2,t3,t4,t5,t6;
Button b1,b2,b3,b4,b5,b6,insert,delete,start;
ColorDrawable btncolor1,btncolor2,btncolor3,btncolor4,btncolor5,btncolor6;
int id1,id2,id3,id4,id5,id6,count,count1;
Thread t;
LinearLayout containView;
View view;
ViewGroup viewgroup;
TextView timerValue;
ArrayList<View> added_views_list;

private static final String IMAGEVIEW_TAG = "The Android Logo";
private static final String IMAGEVIEW_TAG1 = "The Android Logo1";
private static final String IMAGEVIEW_TAG2 = "The Android Logo2";
private static final String IMAGEVIEW_TAG3 = "The Android Logo3";
private static final String IMAGEVIEW_TAG4 = "The Android Logo4";
private static final String IMAGEVIEW_TAG5 = "The Android Logo5";



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_queue);
		insert=(Button)findViewById(R.id.insert);
		delete=(Button)findViewById(R.id.delete);
		
		timerValue=(TextView)findViewById(R.id.time);
		start=(Button)findViewById(R.id.start);
		
		b1=(Button)findViewById(R.id.btn);
		b2=(Button)findViewById(R.id.button1);
		b3=(Button)findViewById(R.id.button2);
		b4=(Button)findViewById(R.id.button3);
		b5=(Button)findViewById(R.id.button4);
		b6=(Button)findViewById(R.id.btn1);
		
	    b1.setTag(IMAGEVIEW_TAG);
	    
	    
	    b2.setTag(IMAGEVIEW_TAG1);
	    b3.setTag(IMAGEVIEW_TAG2);
	    b4.setTag(IMAGEVIEW_TAG3);
	    b5.setTag(IMAGEVIEW_TAG4);
	    b6.setTag(IMAGEVIEW_TAG5);
		   
	    findViewById(R.id.layout1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.layout2).setOnDragListener(new MyDragListener());
		
	    b1.setOnLongClickListener(new MyClickListener());
		b2.setOnLongClickListener(new MyClickListener());
		b3.setOnLongClickListener(new MyClickListener());
		b4.setOnLongClickListener(new MyClickListener());
		b5.setOnLongClickListener(new MyClickListener());
		b6.setOnLongClickListener(new MyClickListener());
		
		btncolor1=(ColorDrawable)b1.getBackground();
	    btncolor2=(ColorDrawable)b2.getBackground();
		btncolor3=(ColorDrawable)b3.getBackground();
		btncolor4=(ColorDrawable)b4.getBackground();
		btncolor5=(ColorDrawable)b5.getBackground();
		btncolor6=(ColorDrawable)b6.getBackground();
		id1=btncolor1.getColor();
		id2=btncolor2.getColor();
		id3=btncolor3.getColor();
		id4=btncolor4.getColor();
		id5=btncolor5.getColor();
		id6=btncolor6.getColor();
		
		delete.setEnabled(false);

		added_views_list = new ArrayList<View>();
		
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
	}
	
	
	
	public void insert(View v){
		Dialog diag=new Dialog(this);
		diag.setTitle("INSERTION");
//		ImageView img=new ImageView(this);
//		img.setBackgroundResource(R.drawable.queue_dialog);
		TextView txt=new TextView(this);
		txt.setText("Drag & Drop the Coloured Squares in the Queue below");
		txt.setMinWidth(100);
		//diag.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		diag.setContentView(txt);
		diag.show();
		
	}
	
	public void delete(View v){

		/*
		 view = added_views_list.get(added_views_list.size()-1);
		 added_views_list.remove(added_views_list.size()-1);
		*/
		 
			view = added_views_list.get(0);
			added_views_list.remove(0);
		 
		  containView.removeView(view);
		  
		
		//viewgroup = (ViewGroup) view.getParent();
		  viewgroup.addView(view);
      
		  
		  view.setVisibility(View.VISIBLE);
		  //count1++;
		  count--;
		  if(count==0){
  	    	Toast.makeText(PlayQueue.this,"Queue is Empty !", Toast.LENGTH_SHORT).show();
  	    	 delete.setEnabled(false);
		  }

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
	    	  if(v == findViewById(R.id.layout2)) {
	    		  
	    		  
	    		  view = (View) event.getLocalState();
	    		  viewgroup = (ViewGroup) view.getParent();
	    		  viewgroup.removeView(view);
	           
	    		  containView = (LinearLayout) v;
	    		  containView.addView(view,0);
	    		  
	    		  added_views_list.add(view);
	    		  
	    		  view.setVisibility(View.VISIBLE);
	    		  count++;	 	    	 

	    		  if(count>0)
	    		  {
	    			  delete.setEnabled(true);
	    		  }
	    		 
	    	  } 
	    	
	    	  else {
	    		  View view = (View) event.getLocalState();
	    		  view.setVisibility(View.VISIBLE);
	    		  Context context = getApplicationContext();
	    		  Toast.makeText(context, "You can't drop the image here", 
                                             Toast.LENGTH_SHORT).show();
	    		  break;
	    	   }
	    	
	    	  if(count==6){
	    	    	Toast.makeText(PlayQueue.this,"Queue is full !", Toast.LENGTH_SHORT).show();
	    	    	 delete.setEnabled(true);
	    	}
	    	  
	    	 
	    	  break;
	    	  
	    //the drag and drop operation has concluded.
	    case DragEvent.ACTION_DRAG_ENDED:
	    	

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
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);
			b5.setEnabled(true);
			b6.setEnabled(true);
			AlertDialog.Builder dialog=new AlertDialog.Builder(this);
			dialog.setTitle("Start GAME");
			dialog.setIcon(R.drawable.ic_launcher);
			dialog.setMessage("Click OK to start playing with QUEUE");
			dialog.setPositiveButton("OK",new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
			        //5000 is the starting number (in milliseconds)
			        //1000 is the number to count down each time (in milliseconds)
			        MyCount counter = new MyCount(15000,1000);

			        counter.start();
					
					dialog.dismiss();
					timerValue.setVisibility(View.VISIBLE);
				
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
        	if(count==6){
        		Dialog d=new Dialog(PlayQueue.this);
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
						Intent i=new Intent(PlayQueue.this,MainMenu.class);
						i.putExtra("Level - 1 Status",3 );
						startActivity(i);
					}
				});
        	
        		Button btn=(Button)findViewById(R.id.continuePlay);
        		btn.setVisibility(View.VISIBLE);
        	}
        	else{
        		Dialog d=new Dialog(PlayQueue.this);
        		d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        		d.setContentView(R.layout.dialog_layout_lose);
        		Button tryagain=(Button)d.findViewById(R.id.tryagain);
        		d.setCancelable(false);
        		tryagain.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(PlayQueue.this,PlayQueue.class));
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
	 Intent i=new Intent(PlayQueue.this,MainMenu.class);
		i.putExtra("Level - 1 Status",3 );
		startActivity(i);		
		}
}