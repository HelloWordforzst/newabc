package com.zst.xmlserializer;
import java.io.StringWriter;
import java.util.ArrayList;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import android.util.Xml;

public class MyHostResouse extends ServerResource{
	@Get
	public String toXml(){  
        
      StringWriter stringWriter = new StringWriter();  
     try {  
          XmlSerializer xmlSerializer = Xml.newSerializer();  
          // �������������  
          xmlSerializer.setOutput(stringWriter);  
          /* 
           * startDocument(String encoding, Boolean standalone)encoding������뷽ʽ 
           * standalone  ������ʾ���ļ��Ƿ���������ⲿ���ļ��� 
           * ��ֵ�� ��yes�� ��ʾû�к����ⲿ�����ļ�����ֵ�� ��no�� ���ʾ�к����ⲿ�����ļ���Ĭ��ֵ�� ��yes���� 
           */  
          xmlSerializer.startDocument("utf-8", true);  
              /* 
               * startTag (String namespace, String name)�����namespace����Ψһ��ʶxml��ǩ 
               *XML �����ռ����Ա�������ĳ��Ԫ�صĿ�ʼ��ǩ֮�У���ʹ�����µ��﷨�� 
                  xmlns:namespace-prefix="namespaceURI" 
                  ��һ�������ռ䱻������ĳ��Ԫ�صĿ�ʼ��ǩ��ʱ�����д�����ͬǰ׺����Ԫ�ض�����ͬһ�������ռ�������� 
                  ע�ͣ����ڱ�ʾ�����ռ�ĵ�ַ���ᱻ���������ڲ�����Ϣ����Ωһ�������Ǹ��������ռ�һ��Ωһ�����ơ��������ܶ๫˾��������Ϊָ����ʹ�������ռ�ָ��ĳ��ʵ�����ҳ�������ҳ�������й������ռ����Ϣ�� 
               */  
//             xmlSerializer.startTag(null, "Hosts");
          
//          <?xml version="1.0" encoding="UTF-8"?>
//
//          <beauties>
//
//          	<beauty>
//
//          		<name>��־��</name>
//
//          		<age>28</age>
//
//          	</beauty>
//
//          	<beauty>
//
//          		<name>����</name>
//
//          		<age>23</age>
//
//          	</beauty>
//
//          </beauties>

          
          
          
              xmlSerializer.startTag(null, "beauties");  
                
              xmlSerializer.startTag(null, "beauty"); 
              xmlSerializer.startTag(null, "name"); 
              xmlSerializer.text("��־��");  
              xmlSerializer.endTag(null, "name");  
                
              xmlSerializer.startTag(null, "age");  
              xmlSerializer.text("28");  
              xmlSerializer.endTag(null, "age"); 
              xmlSerializer.endTag(null, "beauty"); 
              
              
              xmlSerializer.startTag(null, "beauty"); 
              xmlSerializer.startTag(null, "name"); 
              xmlSerializer.text("С��");  
              xmlSerializer.endTag(null, "name");  
                
              xmlSerializer.startTag(null, "age");  
              xmlSerializer.text("22");  
              xmlSerializer.endTag(null, "age"); 
              xmlSerializer.endTag(null, "beauty"); 
              
              xmlSerializer.endTag(null, "beauties");
              
//              xmlSerializer.startTag(null, "sign");  
//              xmlSerializer.text("���������꣬��ô���ʺ�");  
//              xmlSerializer.endTag(null, "sign");
                
             
              
//              xmlSerializer.startTag(null, "Host");  
//              
//              xmlSerializer.startTag(null, "name");  
//              xmlSerializer.text("����");  
//              xmlSerializer.endTag(null, "name");  
//                
//              xmlSerializer.startTag(null, "classes");  
//              xmlSerializer.text("һ�꼶");  
//              xmlSerializer.endTag(null, "classes");  
//              
//              xmlSerializer.startTag(null, "sign");  
//              xmlSerializer.text("ѡ����Զ������ֻ�˷�����");  
//              xmlSerializer.endTag(null, "sign");
//                
//              xmlSerializer.endTag(null, "Host");  
//             xmlSerializer.endTag(null, "Hosts");
          xmlSerializer.endDocument();  
        } catch (Exception e) {  
          e.printStackTrace();  
  }
     return stringWriter.toString();
  }
}