package njnu.det.newvision;
import java.text.SimpleDateFormat;
import java.io.StringWriter;
import java.sql.Date;

import org.restlet.resource.ClientResource;
import org.xmlpull.v1.XmlSerializer;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
public class NewComposition extends Activity{	
	private static final String ADDROW = null;
	ActionBar actionBar;
	private EditText titleEditText;
	private EditText keywordsEditText;
	private EditText contentEditText;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);	
	    setContentView(R.layout.writingdiary_layout); 
	    titleEditText = (EditText)findViewById(R.id.editText1);
	    keywordsEditText = (EditText)findViewById(R.id.EditText01);
	    contentEditText = (EditText)findViewById(R.id.editText2);    
	    actionBar = getActionBar();
	    actionBar.show();				
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuItem add = menu.add(0,0,0,"保存");
		add.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);		
		MenuItem del = menu.add(0,1,1,"放弃");
		del.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		 return true;	
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		return MenuChoice(item);
	}
	private boolean MenuChoice(MenuItem item)
	{		
		switch(item.getItemId()){		
		case 0:		
			String title = titleEditText.getText().toString();
            String keywords = keywordsEditText.getText().toString();
            String content = contentEditText.getText().toString();
            User user = NV_Host.getLocalUser();
        	String author = user.NikedName;
        	
        	//告知数据库如何操作
        	String operation ="ADDROW";
        	NV_Host.setOperation(operation);
        	
            SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");     
            String date = sDateFormat.format(new java.util.Date()); 
			try {
				InsertWriting(title,keywords,author,date,content);
				Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();	
				titleEditText.setText("");
				keywordsEditText.setText("");
				contentEditText.setText("");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true;
		case 1:
			titleEditText.setText("");
			keywordsEditText.setText("");
			contentEditText.setText("");
			Toast.makeText(this, "放弃保存", Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
	}

	public void InsertWriting(String title,String keywords,String author,String date,String content) throws Exception{		
		if(NV_Host.isLocal){						
			PaperResource pr = new PaperResource();	
			String xml=pr.toXML(title,keywords,author,date,content);			
			pr.wirteXMLRemote(xml);
				
		}
		else{
			
		}

		
	}	                  
}
