package njnu.det.newvision;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowComposition extends Activity {
	ActionBar actionBar;
	EditText showEditText;
	TextView dateTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_layout);
		MyApplication.getInstance().addActivity(this);
		actionBar = getActionBar();
		actionBar.show();
		
		save();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy年MM月dd日     HH：mm：ss");
		Date curdate = new Date(System.currentTimeMillis());
		String dateString = dFormat.format(curdate);
		
		dateTextView = (TextView)findViewById(R.id.showDate);
		dateTextView.setText(dateString);
	}
	
	private boolean save() {
		TextView tvTitle   =  (TextView) findViewById(R.id.showCompsitionTitle);
		TextView tvDate    =  (TextView) findViewById(R.id.showDate);
		EditText edContent = (EditText) findViewById(R.id.showCompositionContent);
		
		String sTitle   = getIntent().getStringExtra("sTitle");
		String sDate    = getIntent().getStringExtra("sDate");
		String sContent = getIntent().getStringExtra("sContent");
		 
		tvTitle.setText(sTitle);
		tvDate.setText(sDate);
		edContent.setText(sContent);
		
		
		
		return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		
		super.onCreateOptionsMenu(menu);
		final MenuItem modify = menu.add(0,1,1,"修改");
		modify.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		modify.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {				
				EditText edContent = (EditText) findViewById(R.id.showCompositionContent);
				String sContent = edContent.getText().toString();
				TextView tvTitle   =  (TextView) findViewById(R.id.showCompsitionTitle);
				String sTitle   = getIntent().getStringExtra("sTitle");
  	           
				// TODO Auto-generated method stub
				switch (item.getItemId()) {  
		         
		        case 1:  
		        	
					//Toast.makeText(getBaseContext(), "dd", Toast.LENGTH_SHORT).show();
		            {showEditText.setFocusableInTouchMode(true);
		            showEditText.setFocusable(true);
		            showEditText.requestFocus();
		            modify.setTitle("保存");
		            }
		            String keywords= "abc";
		        	User user = NV_Host.getLocalUser();
		        	String author = user.NikedName;
		        	String operation ="UPDATE";
		        	NV_Host.setOperation(operation);
		        	SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");     
		            String date = sDateFormat.format(new java.util.Date()); 
		        	try {
						UpdatetWriting(sTitle,keywords,author,date,sContent);
						//Toast.makeText(this, "You clicked on 保存", Toast.LENGTH_SHORT).show();	
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		        	//showEditText.setFocusable(true); 
		            }
				
	
				return true;
			}
		});
		 return true;
		
	}
	public void UpdatetWriting(String title,String keywords,String author,String date,String content) throws Exception{		
		if(NV_Host.isLocal){						
			PaperResource pr = new PaperResource();	
			String xml=pr.toXML(title,keywords,author,date,content);			
			pr.wirteXMLRemote(xml);
				
		}
		else{
			
		}

		
	}	    
	
}
