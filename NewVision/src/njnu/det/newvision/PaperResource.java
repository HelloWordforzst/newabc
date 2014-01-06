package njnu.det.newvision;

import java.io.StringWriter;
import java.sql.Date;

import njnu.det.newvision.DAO.OperationType;

import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.xmlpull.v1.XmlSerializer;

import android.util.Log;
import android.util.Xml;

public class PaperResource {
	@Put
	public String toXML(String title, String keywords, String author,
			               String date, String content) {			
		StringWriter sw = new StringWriter();
		try {						
		    XmlSerializer xml = Xml.newSerializer();		
		    xml.setOutput(sw);
		    xml.startDocument("UTF-8",true);
		    //Begin Root node
			xml.startTag("","Table");
			xml.attribute("","name","writing");
			//Operation Section
			if(NV_Host.getOperation() != "UPDATE"){
				xml.startTag("","Operation");
				xml.text(DAO.OperationType.ADDROW.toString());
				xml.endTag("","Operation");	
				}
			
			else{
				xml.startTag("","Operation");
				xml.text(DAO.OperationType.UPDATE.toString());
				xml.endTag("","Operation");
				xml.startTag("","Condition");
				xml.text("Title='" + title + "'");
				xml.endTag("","Condition");
				}			
						
			//Table header section
			
			xml.startTag("","Theader");
					
	  		xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.TEXT.toString());
			xml.text("Title");
			xml.endTag("","Col");

			xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.TEXT.toString());
			xml.text("Keywords");
			xml.endTag("","Col");
			
			xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.TEXT.toString());
			xml.text("Author");
			xml.endTag("","Col");
			
			xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.DATE.toString());
			xml.text("Date");
			xml.endTag("","Col");
			
			xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.TEXT.toString());
			xml.text("Content");
			xml.endTag("","Col");
			
			xml.endTag("","Theader");
			//end table header
			
			//Table body Section is table body				
			xml.startTag("","Tbody");		
			xml.startTag("","Row");
					
			xml.startTag("","Td");
			xml.text(title);
			xml.endTag("","Td");

			xml.startTag("","Td");
			xml.text(keywords);
			xml.endTag("","Td");
			
			xml.startTag("","Td");
			xml.text(author);
			xml.endTag("","Td");
			
			xml.startTag("","Td");
			xml.text(date);
			xml.endTag("","Td");
							
			xml.startTag("","Td");
			xml.text(content);
			xml.endTag("","Td");
			
			xml.endTag("","Row");	
			xml.endTag("","Tbody");
			xml.endTag("","Table");
	        xml.flush();
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return sw.toString();
	}
	@Get
	public void wirteXMLLocal(String title,String keywords,String author,String date,String content){
		DAO dao;
		try {
			dao = new DAO(NV_Host.getDbPath(),NV_Host.getDbName());				
			String xml=toXML(title,keywords,author,date,content);
			dao.SetXML(xml);
			dao.Excute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}										
	}
	public void wirteXMLRemote(String xml){
		DAO dao;
		try {
			dao = new DAO(NV_Host.getDbPath(),NV_Host.getDbName());							
			dao.SetXML(xml);
			dao.Excute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}										
	}
	
		/*StringWriter sw = new StringWriter();
		try {					
			XmlSerializer xml = Xml.newSerializer();
			
			xml.setOutput(sw);
			xml.startDocument("UTF-8",true);
			//Begin Root node
			xml.startTag("","Table");
			xml.attribute("","name","writing");
			//Operation Section
			xml.startTag("","Operation");
			xml.text(DAO.OperationType.SELECT.toString());
			xml.endTag("","Operation");							
			//Table header section			
			xml.startTag("","Theader");
			//0:Writing_ID
			xml.startTag("", "col");
			xml.attribute("", "type",Table.DataType.NUMBER.toString());
			xml.text("Writing_ID");
			xml.endTag("", "col");
			//0:Title		
	  		xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.TEXT.toString());
			xml.text("Title");
			xml.endTag("","Col");
			//0:Keywords
			xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.TEXT.toString());
			xml.text("Keywords");
			xml.endTag("","Col");
			//0:Author
			xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.TEXT.toString());
			xml.text("Author");
			xml.endTag("","Col");
			//0:Date
			xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.DATE.toString());
			xml.text("Date");
			xml.endTag("","Col");
			//0:Content
			xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.TEXT.toString());
			xml.text("Content");
			xml.endTag("","Col");
			//0:Accessory_ID
			xml.startTag("", "col");
			xml.attribute("", "type",Table.DataType.NUMBER.toString());
			xml.text("Writing_ID");
			xml.endTag("", "col");
			//0:Synctime
			xml.startTag("","Col");
			xml.attribute("","type",Table.DataType.DATE.toString());
			xml.text("Synctime");
			xml.endTag("","Col");
			
			xml.endTag("","Theader");
			//end table header
			xml.endTag("", "Table");
			xml.flush();
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();						
	}*/

	
}
