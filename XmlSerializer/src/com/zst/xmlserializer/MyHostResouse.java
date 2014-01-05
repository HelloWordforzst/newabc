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
          // 设置输出流对象  
          xmlSerializer.setOutput(stringWriter);  
          /* 
           * startDocument(String encoding, Boolean standalone)encoding代表编码方式 
           * standalone  用来表示该文件是否呼叫其它外部的文件。 
           * 若值是 ”yes” 表示没有呼叫外部规则文件，若值是 ”no” 则表示有呼叫外部规则文件。默认值是 “yes”。 
           */  
          xmlSerializer.startDocument("utf-8", true);  
              /* 
               * startTag (String namespace, String name)这里的namespace用于唯一标识xml标签 
               *XML 命名空间属性被放置于某个元素的开始标签之中，并使用以下的语法： 
                  xmlns:namespace-prefix="namespaceURI" 
                  当一个命名空间被定义在某个元素的开始标签中时，所有带有相同前缀的子元素都会与同一个命名空间相关联。 
                  注释：用于标示命名空间的地址不会被解析器用于查找信息。其惟一的作用是赋予命名空间一个惟一的名称。不过，很多公司常常会作为指针来使用命名空间指向某个实存的网页，这个网页包含着有关命名空间的信息。 
               */  
//             xmlSerializer.startTag(null, "Hosts");
          
//          <?xml version="1.0" encoding="UTF-8"?>
//
//          <beauties>
//
//          	<beauty>
//
//          		<name>林志玲</name>
//
//          		<age>28</age>
//
//          	</beauty>
//
//          	<beauty>
//
//          		<name>杨幂</name>
//
//          		<age>23</age>
//
//          	</beauty>
//
//          </beauties>

          
          
          
              xmlSerializer.startTag(null, "beauties");  
                
              xmlSerializer.startTag(null, "beauty"); 
              xmlSerializer.startTag(null, "name"); 
              xmlSerializer.text("林志玲");  
              xmlSerializer.endTag(null, "name");  
                
              xmlSerializer.startTag(null, "age");  
              xmlSerializer.text("28");  
              xmlSerializer.endTag(null, "age"); 
              xmlSerializer.endTag(null, "beauty"); 
              
              
              xmlSerializer.startTag(null, "beauty"); 
              xmlSerializer.startTag(null, "name"); 
              xmlSerializer.text("小芳");  
              xmlSerializer.endTag(null, "name");  
                
              xmlSerializer.startTag(null, "age");  
              xmlSerializer.text("22");  
              xmlSerializer.endTag(null, "age"); 
              xmlSerializer.endTag(null, "beauty"); 
              
              xmlSerializer.endTag(null, "beauties");
              
//              xmlSerializer.startTag(null, "sign");  
//              xmlSerializer.text("不经历风雨，怎么见彩虹");  
//              xmlSerializer.endTag(null, "sign");
                
             
              
//              xmlSerializer.startTag(null, "Host");  
//              
//              xmlSerializer.startTag(null, "name");  
//              xmlSerializer.text("张鹏");  
//              xmlSerializer.endTag(null, "name");  
//                
//              xmlSerializer.startTag(null, "classes");  
//              xmlSerializer.text("一年级");  
//              xmlSerializer.endTag(null, "classes");  
//              
//              xmlSerializer.startTag(null, "sign");  
//              xmlSerializer.text("选择了远方，便只顾风雨兼程");  
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