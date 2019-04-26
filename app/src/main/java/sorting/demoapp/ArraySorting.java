package sorting.demoapp;

import java.util.ArrayList;
import java.util.List;

import sorting.demoapp.BubbleSorter;
import sorting.demoapp.InsertionSorter;
import sorting.demoapp.MainActivity;
import sorting.demoapp.MergeSorter;
import sorting.demoapp.QuickSorter;
import sorting.demoapp.R;
import sorting.demoapp.SelectionSorter;
import sorting.demoapp.SortView;
import sorting.demoapp.Sorter;
import sorting.demoapp.SorterEvent;
import sorting.demoapp.SorterListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ArraySorting extends Activity {
    private final static int DATA_SET_SIZE = 30;
    private Button mButton;
    private Sorter<Integer> mSort;
    private SortView mList;
    private Spinner spinner;
    private boolean mNeedsInit = false;
    long tStart;
    /**
     * A list of available sorters, all of which get initialised to the same starting state.
     */
    private List<Sorter<Integer>> mAllSorters = new ArrayList<Sorter<Integer>>();  
    
    private Runnable mPlayEnabler = new Runnable() {
        @Override
        public void run() {
                // whether to re-enable the play button, which happens when both sorters complete.
                boolean e = mSort.isFinished();
                mButton.setEnabled(e);
                spinner.setEnabled(e);
                
                
              //Coding for counting Time
             	long tEnd = System.currentTimeMillis();
            	long tDelta = tEnd - tStart;
            	double elapsedSeconds = tDelta / 1000.0;
            	Dialog d=new Dialog(ArraySorting.this);
            	d.setTitle("Time Complexity && Space Complexity");
            	d.setContentView(R.layout.sorting_dialog);
            	TextView timeComplexity=(TextView)d.findViewById(R.id.timeComplexity);
            	TextView spaceComplexity=(TextView)d.findViewById(R.id.spaceComplexity); 
            	
            	if(mSort.getSorterName()==R.string.bubble_sort){
            	timeComplexity.setText(String.valueOf("Time Complexity - "+elapsedSeconds+" seconds"));
            	spaceComplexity.setText("Space Complexity - O("+Html.fromHtml("n<sup><small>2</small></sup>")+")");
            	timeComplexity.setTextSize(15);
            	//spaceComplexity.setTextSize(15);
            	}
            	else if(mSort.getSorterName()==R.string.insertion_sort){
                	timeComplexity.setText(String.valueOf("Time Complexity - "+elapsedSeconds+" seconds"));
                	spaceComplexity.setText("Space Complexity - O("+Html.fromHtml("n<sup><small>2</small></sup>")+")");
                	timeComplexity.setTextSize(15);
                	//spaceComplexity.setTextSize(15);
            	}
            	else if(mSort.getSorterName()==R.string.merge_sort){
                	timeComplexity.setText(String.valueOf("Time Complexity - "+elapsedSeconds+" seconds"));
                	spaceComplexity.setText("Space Complexity - O("+Html.fromHtml("n<sup><small>2</small></sup>")+")");
                	timeComplexity.setTextSize(15);
                	//spaceComplexity.setTextSize(15);
            	}
            	else if(mSort.getSorterName()==R.string.quick_sort){
                	timeComplexity.setText(String.valueOf("Time Complexity - "+elapsedSeconds+" seconds"));
                	spaceComplexity.setText("Space Complexity - O("+Html.fromHtml("n<sup><small>2</small></sup>")+")");
                	timeComplexity.setTextSize(15);
                	//spaceComplexity.setTextSize(15);
            	}
            	else if(mSort.getSorterName()==R.string.selection_sort){
                	timeComplexity.setText(String.valueOf("Time Complexity - "+elapsedSeconds+" seconds"));
                	spaceComplexity.setText("Space Complexity - O("+Html.fromHtml("n<sup><small>2</small></sup>")+")");
                	timeComplexity.setTextSize(15);
                	//spaceComplexity.setTextSize(15);
            	}
            	d.show();
                
        }
};
/**
 * Update to the left list.
 */
private Runnable mLeftUpdate = new Runnable() {
        @Override
        public void run() {
                refreshList(mList, mSort);
        }
};

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // set up the GUI from the resource layout file.
    setContentView(R.layout.activity_array_sorting);

// pull out the components we need to do updates/event-handling for.
mList = (SortView) findViewById(R.id.leftList);
mList.setFocusable(false);

// initialise sorters.
initStartingState();

// spinners (combo boxes in Swing) need adapters to populate their contents and listeners to deal with the events they generate.
spinner = (Spinner) findViewById(R.id.spinner);
spinner.setAdapter(new SorterSpinnerAdapter(this, R.layout.spinnertext, R.id.spinnerText, (Sorter<Integer>[]) mAllSorters.toArray(new Sorter[0])));
spinner.setSelection(0);
spinner.setOnItemSelectedListener(new SpinnerListener(true));


// redraw the lists.
refreshList(mList, mSort);


// event handling for the play button.
Button play = (Button) findViewById(R.id.startbutton);
mButton = play;
play.setOnClickListener(new OnClickListener() {
                
                @Override
                public void onClick(View v) {
                        // disable GUI controls.
                		tStart = System.currentTimeMillis();
                        mButton.setEnabled(false);
                        spinner.setEnabled(false);
                        spinner.setEnabled(false);
                        
                        // if we need to, generate a random starting state and redraw the lists.
                        if(mNeedsInit) {
                                initStartingState();

                                
                        refreshList(mList, mSort);
                        }
                        mNeedsInit = true;
                        // start the animations.
                        kickOffSorter(mSort);
                }
                
                /**
                 * Runs the sorter in a separate thread.
                 * @param s The sorter to run.
                 */
                private void kickOffSorter(Sorter<Integer> s) {
                        Thread t = new Thread(s);
                        // set to daemon so the JVM can close without waiting for the thread to finish.
                        t.setDaemon(true);
                        t.start();
                
                	}
                });
}


private void refreshList(SortView list, Sorter<Integer> sorter) {
// link the GUI component to its data source.
list.setSorter(sorter);
// invalidate, which forces the component to redraw.
list.invalidate();
}

private void initStartingState() {
// start off with a sorted array of all integers in the range [1..DATA_SET_SIZE]
Integer[] startState = new Integer[DATA_SET_SIZE];
for(int i = 0; i < DATA_SET_SIZE; i++) {
        startState[i] = i+1;
} 
// make a random permutation.
randomlyPermute(startState);

// clear the list of available sorters and add one instance of each sub-class of Sorter.
// These are the available algorithms shown to users.
mAllSorters.clear();
mAllSorters.add(new BubbleSorter<Integer>(startState));
mAllSorters.add(new InsertionSorter<Integer>(cloneArray(startState)));
mAllSorters.add(new MergeSorter<Integer>(cloneArray(startState)));
mAllSorters.add(new QuickSorter<Integer>(cloneArray(startState)));
mAllSorters.add(new SelectionSorter<Integer>(cloneArray(startState)));
        
// figure out which sorters are displayed, using the selected items from the spinners.
mSort = mAllSorters.get(spinner == null ? 0 : spinner.getSelectedItemPosition());
        
        // remove existing listeners and add in a listener to handle events from each sorter.
        mSort.removeSorterListeners();
        mSort.addSorterListener(new EventListener(mLeftUpdate));
       
        mNeedsInit = false;
}

/**
* Copies the contents of the given array into a different one. Order remains the same.
* @param in The source array.
* @return A clone of the source array.
*/
private Integer[] cloneArray(Integer[] in) {
Integer[] out = new Integer[in.length];
System.arraycopy(in, 0, out, 0, in.length);
return out;
}

/**
* To get a random order, swap each member of the array with a randomly chosen index.
* @param state array to be permutated.
*/
private static void randomlyPermute(Integer[] state) {
for(int i = 0; i < state.length; i++) {
        int swapWith = (int)(Math.random()*DATA_SET_SIZE-0.5);
        swapWith = Math.max(0,Math.min(DATA_SET_SIZE-1,swapWith));
        if(swapWith != i) {
                int x = state[i];
                state[i] = state[swapWith];
                state[swapWith] = x;
        }
}
}

/**
* Event handling for changes to the spinner's selected values.
* @author dan
*
*/
private class SpinnerListener implements OnItemSelectedListener {
/**
 * Whether this spinner is on the left-hand side of the screen.
 */
private boolean mLeft;
public SpinnerListener(boolean left) {
        this.mLeft = left;
}
/**
 * Called when the user makes a selection within the spinner.
 */
        @Override
        public void onItemSelected(AdapterView parent, View v, int position, long id) {
//                Spinner thisOne = mLeft ? mLeftSpinner : mRightSpinner;
//                Spinner thatOne = mLeft ? mRightSpinner : mLeftSpinner;
//                
//                // ensure that the spinners never have the same selected sorting algorithm.
//                // TODO: Would be better to just not display the algorithm that is selected in the other spinner.
//                if(position == thatOne.getSelectedItemPosition()) {
//                        // setting a new position will call this method again as part of the component's event handling.
//                        if(position > 0) {
//                                thisOne.setSelection(position-1);
//                        } else {
//                                thisOne.setSelection(position+1);
//                        }
//                } else { 
                        // if the spinners have different values, get a starting state and update the display.
                        initStartingState();
                        refreshList(mList, mSort);
//                }                       
        }
        @Override
        public void onNothingSelected(AdapterView parent) {
                // do nothing. This isn't possible.
        }
}

/**
* Implementation of the listener interface defined for Sorter classes.
* @author dan
*
*/
private class EventListener implements SorterListener<Integer> {
/**
 * The runnable that will be called to update the view of this sorter.
 */
Runnable mListRefresh;
EventListener(Runnable listRefresh) {
        mListRefresh = listRefresh;
}
/**
 * Posts the update to the GUI thread so the view can be updated with changed data.
 */
        @Override
        public void sorterDataChange(SorterEvent<Integer> e) {
                runOnUiThread(mListRefresh);
        }
        /**
         * When the sorter finishes, check if we should enable the GUI controls again.
         * This happens when both sorters have finished. We don't need any synchronization
         * in the mPlayEnabler runnable, because we know the code will never be run
         * concurrently in different threads.
         */
        @Override
        public void sorterFinished(SorterEvent<Integer> e) {
       
                runOnUiThread(mPlayEnabler);
                
        }


}

/**
* Deals with converting the array of sorters into a list of strings for users
* to choose between in the spinner.
* @author dan
*
*/
private class SorterSpinnerAdapter extends ArrayAdapter<Sorter<Integer>> {
private int mResource;
private int mTextViewId;

public SorterSpinnerAdapter(Context context, int resource, int textViewResourceId, Sorter<Integer>[] data) {
        super(context, resource, textViewResourceId, data);
        this.mResource = resource;
        this.mTextViewId = textViewResourceId;
}

/**
 * Get the view shown on the main activity, displaying the chosen value.
 */
@Override
public View getView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, 5);
}

/**
 * The view used for each row of the list shown when the user choosing a value.
 */
@Override
public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, 10);
                
}

/**
 * We use the same logic for both kinds of view a spinner needs, but with different padding to reflect the different sizing
 * we want.
 * @param position The position in the list.
 * @param convertView The view to use, can be null - in which case build a view to use.
 * @param padding The padding to put around the text.
 * @return The view to use on screen.
 */
private View getView(int position, View convertView, int padding) {
        View retVal = null;
        // check that convertView is available and represents the right component.
                if(convertView != null && convertView.getId() == mResource) {
                        retVal = convertView;
                } else {
                        // if it's not right, build a view to use instead.
                        LayoutInflater inflater = ArraySorting.this.getLayoutInflater();
                        retVal = inflater.inflate(mResource, null);
                }
                // get the TextView label from within the main view and set its text and padding appropriately.
                TextView text = (TextView) retVal.findViewById(mTextViewId);
                text.setText(getItem(position).getSorterName());
                text.setPadding(padding/2,padding,padding/2,padding);
                return retVal;
}

}

}
