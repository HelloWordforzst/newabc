package mobile.android.service.lifecycle;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{
	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}
	
	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		
		
		
		
		/*直接输出，阻塞界面
		 * for(int i=0; i<50;i++){
			try {
				Thread.sleep(1000);
				Log.i("abc", "Starting BeginService:" + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}*/
		
//		在多线程中输出Log()
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
							
				for(int i=0; i<50;i++){
					try {
						Thread.sleep(1000);
						Log.i("abc", "Starting BeginService:" + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			}
				
			}).start();
		
		
		
		
       
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i("myservice","serviceDestroy");
		super.onDestroy();
	}

}
