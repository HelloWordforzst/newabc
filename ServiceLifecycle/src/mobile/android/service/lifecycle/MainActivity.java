package mobile.android.service.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity 
{
	private Intent serviceIntent;

	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btnStartService = (Button) findViewById(R.id.btnStartService);
		Button btnStopService = (Button) findViewById(R.id.btnStopService);
		btnStartService.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				serviceIntent = new Intent(MainActivity.this,MyService.class);
				startService(serviceIntent);
			}					
		});
		
		btnStopService.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(serviceIntent!= null){
					Boolean returnResult = MainActivity.this.stopService(serviceIntent);
//					Main.this.stopService(serviceIntent);
					Log.i("MyService", "Service stop :"+ returnResult);
				}
				
			}
			
		});
	}
}