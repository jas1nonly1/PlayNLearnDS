package sorting.demoapp;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.app.FragmentManager;

public class FlipArray extends Activity implements FragmentManager.OnBackStackChangedListener{
	
	public Handler mhandler=new Handler();
	public boolean mShowingBack=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flip_array);
//		if(savedInstanceState==null){
//			getFragmentManager().beginTransaction().add(R.id.c,new CardFrontFragment()).commit();
//		}
//		else{
//			mShowingBack=(getFragmentManager().getBackStackEntryCount()>0);
//		}
//		getFragmentManager().addOnBackStackChangedListener(this);
	}


	@Override
	public void onBackStackChanged() {
		// TODO Auto-generated method stub
		
	}
	public static class CardFrontFragment extends Fragment {
        public CardFrontFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_front, container, false);
        }
    }

    /**
     * A fragment representing the back of the card.
     */
    public static class CardBackFragment extends Fragment {
        public CardBackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_back, container, false);
        }
    }

}
