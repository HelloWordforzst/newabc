package njnu.det.newvision;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class EssayFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.essay_layout, null);

		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 设置一个Adapter,使用自定义的Adapter

		setListAdapter(new TextImageAdapter(getActivity()));

	}

	private class TextImageAdapter extends BaseAdapter {
		private Context mContext;

		public TextImageAdapter(Context context) {
			this.mContext = context;
		}

		/**
		 * 元素的个数
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

		// 用以生成在ListView中展示的一个个元素View
		public View getView(int position, View convertView, ViewGroup parent) {
			// 优化ListView
			if (convertView == null) {
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.essay_listiewitem, null);
				ItemViewCache viewCache = new ItemViewCache();
				// viewCache.mImageView=(ImageView)convertView.findViewById(R.id.image);
				viewCache.mTextView = (TextView) convertView
						.findViewById(R.id.text);
				// viewCache.mImageView1=(ImageView)convertView.findViewById(R.id.image1);
				viewCache.mTextView1 = (TextView) convertView
						.findViewById(R.id.text1);
				viewCache.mTextView2 = (TextView) convertView
						.findViewById(R.id.text2);
				// viewCache.mListView=(ListView)convertView.findViewById(R.layout.essay_layout);
				convertView.setTag(viewCache);
			}
			ItemViewCache cache = (ItemViewCache) convertView.getTag();
			// 设置文本和图片，然后返回这个View，用于ListView的Item的展示
			// cache.mImageView.setImageResource(images[position]);
			cache.mTextView.setText(texts[position]);
			// cache.mImageView1.setImageResource(images[position]);
			cache.mTextView1.setText(texts1[position]);
			cache.mTextView2.setText(texts2[position]);

			return convertView;
		}

	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//super.onListItemClick(l, v, position, id);
		//Toast.makeText(getActivity(), "选中了", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent();
		intent.setClass(getActivity(), ShowActivity.class);
		startActivity(intent);
	}

	// 元素的缓冲类,用于优化ListView
	private static class ItemViewCache {
		public TextView mTextView;
		// public ImageView mImageView;
		public TextView mTextView1;
		public TextView mTextView2;

		// public ImageView mImageView1;
	}

	// 展示的文字
	private String[] texts = new String[] { "快乐的一天", "记一件小事", "美丽的雪——这是今年的第一场雪" };
	private String[] texts1 = new String[] { "评论3", "评论2", "评论4" };
	private String[] texts2 = new String[] { "2013-6-7", "2013-7-8", "2013-8-8" };
	// 展示的图片
	// private int[] images=new
	// int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3};

}

