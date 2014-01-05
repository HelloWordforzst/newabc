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
 * @description ����ͨ��XmlSerilizer����xml�ļ� 
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
	   tView2.setText(resultxml);//ԭʼ�ı�
	   Log.d("abc--resultxml", resultxml);

		 
		 
       
       //********���ؽ����õ�ArrayList<Beauty>���͵�beauties*******
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
       resultstr = resultstr.replaceAll(" ","");//ȥ�����пո��Ա�����ʵ���������������
	   resultstr = resultstr.replace("\\n", "n"); //�л��з�
		//**************************
		
        TextView tView1 = (TextView)findViewById(R.id.textView1);        
			tView1.setText(resultstr);//����֮��
			Log.d("abc--resulter", resultstr);
          
    }  

  
public  ArrayList<Beauty> praseXml(String xmlstr) throws Exception{
          String result = "";
      	 ArrayList<Beauty> beauties = new ArrayList();
      	 //��ȡ������
    	 InputStream InputStream =new ByteArrayInputStream(xmlstr.getBytes());
    			// ��ȡһ��XmlPullParser
    			XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
    			XmlPullParser parser = xmlPullParserFactory.newPullParser();
    			// �����������Ѿ����뷽ʽ
    		
					parser.setInput(InputStream, "UTF-8");
				
    			// ��ȡ��ǰ���¼�����
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
    				// �ֶ��Ĵ�����һ���¼�
    				eventType = parser.next();
    				Log.i("PullActivity", eventType+"");
    			}
    			return beauties;
}  
}

     
        /**
         *
         * ����ʹ���ڲ�����Ϊ��Ч�ʿ��ǣ��ڲ���Ҫ�ȵ�����һ��bean����ӵĸ�Ч�Լ���Լ�ռ�
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
    			String ss = "����=" + name + " \n  ����=" + age+"\n\n";
    			String temp=ss.replace("\\n", "n");
    			return  temp ;
    		} 
        }