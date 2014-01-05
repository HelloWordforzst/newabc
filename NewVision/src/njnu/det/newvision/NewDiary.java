package njnu.det.newvision;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class NewDiary extends Activity{
	ActionBar actionBar;
	protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);	
		    setContentView(R.layout.writingdiary_layout); 
		    actionBar = getActionBar();
		    actionBar.show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuItem add = menu.add(0,1,1,"±£´æ");
		add.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		MenuItem del = menu.add(0,2,1,"·ÅÆú");
		del.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		 return true;
		
	}


}
