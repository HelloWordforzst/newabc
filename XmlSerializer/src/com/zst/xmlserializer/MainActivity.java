package com.zst.xmlserializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;  
import java.security.Provider;
import java.util.ArrayList;  
  



import java.util.List;
import java.util.Map;

import org.apache.http.conn.scheme.HostNameResolver;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;  
import org.xmlpull.v1.XmlSerializer;  

import android.app.Activity;  
import android.content.res.XmlResourceParser;
import android.os.Bundle;  
import android.util.Log;
import android.util.Xml;
import android.widget.TextView;  
/** 
 *  
 *
 * @description 测试通过XmlSerilizer生成xml文件 
 *
 * 
 */  
public class MainActivity extends Activity {  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        MyHostResouse mh = new MyHostResouse();
        String resultxml = mh.toXml();  
        
       TextView tView2 = (TextView) findViewById(R.id.textView2);
	   tView2.setText(resultxml);//原始文本
	   Log.d("abc--resultxml", resultxml);

		 
		 
       
       //********返回解析好的ArrayList<Beauty>类型的beauties*******
       ArrayList<Beauty> beauties = null;
	try {
		beauties = praseXml(resultxml);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       String resultstr="";
       for(Beauty beauty2 : beauties){
			resultstr+="\n"+beauty2.toString();
		}
       resultstr = resultstr.replaceAll(" ","");//去掉所有空格，以便让现实的最终文字左对齐
	   resultstr = resultstr.replace("\\n", "n"); //有换行符
		//**************************
		
        TextView tView1 = (TextView)findViewById(R.id.textView1);        
			tView1.setText(resultstr);//解析之后
			Log.d("abc--resulter", resultstr);
          
    }  

  
public  ArrayList<Beauty> praseXml(String xmlstr) throws Exception{
          String result = "";
      	 ArrayList<Beauty> beauties = new ArrayList();
      	 //获取输入流
    	 InputStream InputStream =new ByteArrayInputStream(xmlstr.getBytes());
    			// 获取一个XmlPullParser
    			XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
    			XmlPullParser parser = xmlPullParserFactory.newPullParser();
    			// 设置输入流已经编码方式
    		
					parser.setInput(InputStream, "UTF-8");
				
    			// 获取当前的事件类型
    			int eventType = parser.getEventType();
    			Beauty beauty = null;
    			while(XmlPullParser.END_DOCUMENT!=eventType){
    				String nodeName = parser.getName();
    				
    				switch (eventType) {
    				case XmlPullParser.START_TAG:
    					if(nodeName.equals("beauty")){
    						beauty = new Beauty();
    					}
    					if(nodeName.equals("name")){
    						beauty.setName(parser.nextText());
    					}
    					if(nodeName.equals("age")){
    						beauty.setAge(parser.nextText());
    					}
    					break;
    				
    				case XmlPullParser.END_TAG:
    					if(nodeName.equals("beauty")&&beauty!=null){
    						beauties.add(beauty);
    					}
    					
    					break;
    				default:
    					break;
    				}
    				// 手动的触发下一个事件
    				eventType = parser.next();
    				Log.i("PullActivity", eventType+"");
    			}
    			return beauties;
}  
}

     
        /**
         *
         * 这里使用内部类是为了效率考虑，内部类要比单独顶一个bean类更加的高效以及节约空间
         *
         */
         class Beauty{
        	String name;
        	String age;
    		public String getName() {
    			return name;
    		}
    		public void setName(String name) {
    			this.name = name;
    		}
    		public String getAge() {
    			return age;
    		}
    		public void setAge(String age) {
    			this.age = age;
    		}
    		@Override
    		public String toString() {
    			String ss = "姓名=" + name + " \n  年龄=" + age+"\n\n";
    			String temp=ss.replace("\\n", "n");
    			return  temp ;
    		} 
        }