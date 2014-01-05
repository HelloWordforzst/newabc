package njnu.det.newvision;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;

public class ShowActivity extends Activity {
	ActionBar actionBar;
	EditText showEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_layout);
		actionBar = getActionBar();
		actionBar.show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		showEditText=(EditText)findViewById(R.id.showEditText);
		super.onCreateOptionsMenu(menu);
		final MenuItem modify = menu.add(0,1,1,"ÐÞ¸Ä");
		modify.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		modify.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				switch (item.getItemId()) {  
		         
		        case 1:   
					//Toast.makeText(getBaseContext(), "dd", Toast.LENGTH_SHORT).show();
		            {showEditText.setFocusableInTouchMode(true);
		            showEditText.setFocusable(true);
		            showEditText.requestFocus();
		            modify.setTitle("±£´æ");
		            }
		        	//showEditText.setFocusable(true); 
		            }
				
	
				return true;
			}
		});
		 return true;
		
	}
	
}
