package njnu.det.newvision;


import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class CompositionFragmentTab extends ListFragment {

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
	        //����һ��Adapter,ʹ���Զ����Adapter
	        setListAdapter(new TextImageAdapter(getActivity()));
	}
	
	private class TextImageAdapter extends BaseAdapter{
        private Context mContext;
    	public TextImageAdapter(Context context) {
			this.mContext=context;
		}
        /**
         * Ԫ�صĸ���
         */
		public int getCount() {
			return texts.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}
		//����������ListView��չʾ��һ����Ԫ��View
		public View getView(int position, View convertView, ViewGroup parent) {
			//�Ż�ListView
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
			//�����ı���ͼƬ��Ȼ�󷵻����View������ListView��Item��չʾ
			//cache.mImageView.setImageResource(images[position]);
			cache.mTextView.setText(texts[position]);
			//cache.mImageView1.setImageResource(images[position]);
			cache.mTextView1.setText(texts1[position]);
			cache.mTextView2.setText(texts2[position]);
			
			return convertView;
		}
    }
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//super.onListItemClick(l, v, position, id);
		//Toast.makeText(getActivity(), "ѡ����", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent();
		intent.setClass(getActivity(), ShowActivity.class);
		startActivity(intent);
	}
	
    //Ԫ�صĻ�����,�����Ż�ListView
    private static class ItemViewCache{
		public TextView mTextView;
		//public ImageView mImageView;
		public TextView mTextView1;
		public TextView mTextView2;
		//public ImageView mImageView1;
	}
  //չʾ������
    private  String[] texts=new String[]{"���ⰻȻ","��������","�����ˬ","���ⰻȻ","��������","�����ˬ","���ⰻȻ","��������","�����ˬ","���ⰻȻ","��������","�����ˬ"};
    private  String[] texts1=new String[]{"����1","����2","����7","����1","����2","����7","����1","����2","����7","����1","����2","����7"};
    private  String[] texts2=new String[]{"2013-8-17","2013-7-28","2013-8-18","2013-8-17","2013-7-28","2013-8-18","2013-8-17","2013-7-28","2013-8-18","2013-8-17","2013-7-28","2013-8-18"};
    //չʾ��ͼƬ
   // private int[] images=new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3};
	
}






/*
 Դ��
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