package njnu.det.newvision;


import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class CompositionFragmentTab extends ListFragment {
	Table sResult;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.composition_layout,null);		
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 //setContentView(R.layout.listview);
	        //setContentView(R.layout.listview);
	        //设置一个Adapter,使用自定义的Adapter
	        setListAdapter(new TextImageAdapter(getActivity()));
	        try {
	         	getData();
			 } catch (Exception e) {
				// TODO Auto-generated catch block
			 	Log.i("NewVision","Error:" + e.getMessage());
			 }
	}
	
	private void getData() throws Exception{
		 sResult =null;
		if(NV_Host.isLocal){
			CompositionResource wr = new CompositionResource();
			sResult = wr.getXML();
		}
		//变量初始化
		/*sTitles = new String[sResult.getRowSize()];
		sComments = new String[sResult.getRowSize()];
		sDates = new String[sResult.getRowSize()];
		for(int i=0; i< sResult.getRowSize();i++){
			sTitles[i] =sResult.getRow(i).getString(1); 
			sDates[i] = sResult.getRow(i).getString(4);*/
		}
	
	private class TextImageAdapter extends BaseAdapter{
        private Context mContext;
    	public TextImageAdapter(Context context) {
			this.mContext=context;
		}
        /**
         * 元素的个数
         */
		public int getCount() {
			return sResult.getRowSize();
			
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}
		//用以生成在ListView中展示的一个个元素View
		public View getView(int position, View convertView, ViewGroup parent) {
			//优化ListView
			if(convertView==null){
				convertView=LayoutInflater.from(mContext).inflate(R.layout.composition_listiewitem, null);
				ItemViewCache viewCache=new ItemViewCache();
				//viewCache.mImageView=(ImageView)convertView.findViewById(R.id.cimage);
				viewCache.mTextView=(TextView)convertView.findViewById(R.id.ctext);
				//viewCache.mImageView1=(ImageView)convertView.findViewById(R.id.image1);
				viewCache.mTextView1=(TextView)convertView.findViewById(R.id.ctext1);
				viewCache.mTextView2=(TextView)convertView.findViewById(R.id.ctext2);
				
				convertView.setTag(viewCache);
			}
			ItemViewCache cache=(ItemViewCache)convertView.getTag();
			//设置文本和图片，然后返回这个View，用于ListView的Item的展示
			//cache.mImageView.setImageResource(images[position]);
			cache.mTextView.setText(sResult.Tbody.get(position).getTd(1).toString());
			Log.d("abc--", sResult.Tbody.get(position).getTd(1).toString());
//			cache.mImageView1.setImageResource(images[position]);
			cache.mTextView1.setText(texts1[position]);
			cache.mTextView2.setText(sResult.Tbody.get(position).getTd(4).toString());
			
			return convertView;
		}
    }
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent();
		intent.setClass(getActivity(), ShowActivity.class);
		intent.putExtra("sTitle", sResult.Tbody.get(position).getTd(1).toString());
		intent.putExtra("sDate", sResult.Tbody.get(position).getTd(4).toString());
		intent.putExtra("sContent", sResult.Tbody.get(position).getTd(5).toString());
		intent.putExtra("sId", sResult.Tbody.get(position).getTd(0).toString());
		intent.putExtra("sKeywords", sResult.Tbody.get(position).getTd(2).toString());		
		intent.putExtra("sAccessoryId", sResult.Tbody.get(position).getTd(7).toString());
        intent.putExtra("sSynctime", sResult.Tbody.get(position).getTd(8).toString());
				
		startActivity(intent);
	}
	
    //元素的缓冲类,用于优化ListView
    private static class ItemViewCache{
		public TextView mTextView;
		//public ImageView mImageView;
		public TextView mTextView1;
		public TextView mTextView2;
		//public ImageView mImageView1;
	}
  //展示的文字
//    private  String[] texts=new String[]{"春意盎然","夏日炎炎","秋高气爽","春意盎然","夏日炎炎","秋高气爽","春意盎然","夏日炎炎","秋高气爽","春意盎然","夏日炎炎","秋高气爽"};
    private  String[] texts1=new String[]{"评论1","评论2","评论7","评论1","评论2","评论7","评论1","评论2","评论7","评论1","评论2","评论7"};
//    private  String[] texts2=new String[]{"2013-8-17","2013-7-28","2013-8-18","2013-8-17","2013-7-28","2013-8-18","2013-8-17","2013-7-28","2013-8-18","2013-8-17","2013-7-28","2013-8-18"};
    //展示的图片
   // private int[] images=new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3};
	
}






/*
 源码
  import android.app.Fragment;
 
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class EssayFragment extends Fragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.essay_layout,null);		
		return view;
	}
}*/




/*package njnu.det.newvision;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CompositionFragmentTab extends Fragment {

	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.composition_layout,null);		
		return view;
	}
}
*/