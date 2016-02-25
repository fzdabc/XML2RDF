package xml2rdf.example;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import com.hp.hpl.jena.rdf.model.Model;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang.mutable.MutableObject;
import org.xml.sax.SAXException;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;

import xml2rdf.util.rdf.NameSpaceMapping;
import xml2rdf.util.rdf.TemplateRDF;
import xml2rdf.util.xml.CustomizedSAXYFilterHandler;
import xml2rdf.util.xml.SAXYFilterHandler;
import xml2rdf.util.xml.YFilter;

public class TestCustomized1 {
	
	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		MutableObject prefix1 = new MutableObject("aml");
		MutableObject url = new MutableObject("https://github.com/igg777/automationml/blob/master/aml.ttl/#");
		MutableObject prefix2 = new MutableObject("dc");
		MutableObject url2 = new MutableObject("http://purl.org/dc/elements/1.1/");
		MutableObject prefix3 = new MutableObject("schema");
		MutableObject url3 = new MutableObject("http://schema.org/");
		

		try {
			
			long SumTime = 0;			
			int runTimes = 1;
			for(int i = 0; i < runTimes; ++i) {
				long startTime = System.currentTimeMillis();
				SAXParser      saxParser = factory.newSAXParser();
			    CustomizedSAXYFilterHandler handler   = new CustomizedSAXYFilterHandler();
			    TemplateRDF template = new TemplateRDF();
			    // For STELL-I.rtml
			    template.setDefaultNameSpace("http://example.org/");
//			    template.setNameSpaceMapping(prefix1, url);			    
//			    template.setNameSpaceMapping(prefix2, url2);
//			    template.setNameSpaceMapping(prefix3, url3);
			    NameSpaceMapping aml = new NameSpaceMapping(prefix1.getValue().toString(),url.getValue().toString());
			    NameSpaceMapping dc = new NameSpaceMapping(prefix2.getValue().toString(),url2.getValue().toString());
			    NameSpaceMapping schema = new NameSpaceMapping(prefix3.getValue().toString(),url3.getValue().toString());

			    
//			    NameSpaceMapping prefix1 = new NameSpaceMapping("aml","https://github.com/igg777/automationml/blob/master/aml.ttl");

//			    template.addTriplePattern("RTMLData", null, "type", null, "/RTML/Telescope/Camera/FilterWheel/Filter/@type", null);
			    
//			    template.addTriplePattern(prefix1,"/RTML/Telescope/Camera/FilterWheel/Filter/@type", null, prefix2,"FocalLength", null, null,"/RTML/Telescope/FocalLength/text()",XSDDatatype.XSDdouble);
			    
//			    template.addTriplePattern("/RTML/Telescope/Camera/FilterWheel/Filter/@type", null, "FocalLength", null, "/RTML/Telescope/FocalLength/text()",XSDDatatype.XSDdouble);
//template.addTriplePattern(aml,"/RTML/Telescope/Camera/FilterWheel/Filter/@type", null, aml,"FocalLength", null,null, "/RTML/Telescope/FocalLength/text()",XSDDatatype.XSDdouble);
			   
//template.addTriplePattern(aml,"AdditionalInformation", null, aml,"hasWriterName", null, aml,"/CAEXFile/AdditionalInformation/WriterHeader/WriterName/text()",XSDDatatype.XSDstring);
			   
			   //CAEX file
			    template.addTriplePattern(":CAEXFile", null,"aml:hasFileName", null,"/CAEXFile/@FileName",XSDDatatype.XSDstring);
			    template.addTriplePattern(":CAEXFile", null,"aml:hasSchemaVersion", null,"/CAEXFile/@SchemaVersion",XSDDatatype.XSDstring);
			    template.addTriplePattern(":CAEXFile", null,"aml:hasAdditionalInformation", null,":CAEXFile/AdditionalInformation",null);
			    template.addTriplePattern(":CAEXFile", null,"aml:hasExternalReference", null,":CAEXFile/ExternalReference",null);
			    template.addTriplePattern(":CAEXFile", null,"aml:hasInstanceHierarchy", null,":CAEXFile/InstanceHierarchy",null);
			    template.addTriplePattern(":CAEXFile", null,"aml:hasInterfaceClassLib", null,":CAEXFile/InterfaceClassLib",null);
			    template.addTriplePattern(":CAEXFile", null,"aml:hasRoleClassLib", null,":CAEXFile/RoleClassLib",null);
			    template.addTriplePattern(":CAEXFile", null,"aml:hasSystemUnitClassLib", null,":CAEXFile/SystemUnitClassLib",null);
			   
			    
			    
			    //additional information
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:hasAutomationMLVersion", null,"/CAEXFile/AdditionalInformation/@AutomationMLVersion",XSDDatatype.XSDstring);
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:hasWriterName", null,"/CAEXFile/AdditionalInformation/WriterHeader/WriterName/text()",XSDDatatype.XSDstring);
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:hasWriterId", null,"/CAEXFile/AdditionalInformation/WriterHeader/WriterID/text()",XSDDatatype.XSDstring);
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:hasWriterVendor", null,"/CAEXFile/AdditionalInformation/WriterHeader/WriterVendor/text()",XSDDatatype.XSDstring);
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:hasWriterURL", null,"/CAEXFile/AdditionalInformation/WriterHeader/WriterVendorURL/text()",XSDDatatype.XSDstring);
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:hasWriterVersion", null,"/CAEXFile/AdditionalInformation/WriterHeader/WriterVersion/text()",XSDDatatype.XSDstring);
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:hasWriterRelease", null,"/CAEXFile/AdditionalInformation/WriterHeader/WriterRelease/text()",XSDDatatype.XSDstring);
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:lastWritingDate", null,"/CAEXFile/AdditionalInformation/WriterHeader/LastWritingDateTime/text()",XSDDatatype.XSDdateTime);
			   
// hasProject(blank node?)			   
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:hasProjectID", null,"/CAEXFile/AdditionalInformation/WriterHeader/WriterProjectID/text()",XSDDatatype.XSDstring);
			   template.addTriplePattern(":CAEXFile/AdditionalInformation", null,"aml:hasProjectTitle", null,"/CAEXFile/AdditionalInformation/WriterHeader/WriterProjectTitle/text()",XSDDatatype.XSDstring);
			   
			    //ExternalReference
			    template.addTriplePattern(":CAEXFile/ExternalReference", null,"aml:externalReferencePath", null,"/CAEXFile/ExternalReference/@Path",XSDDatatype.XSDstring);
			    template.addTriplePattern(":CAEXFile/ExternalReference", null,"aml:externalReferenceAlias", null,"/CAEXFile/ExternalReference/@Alias",XSDDatatype.XSDstring);

			    //InstanceHierarchy
// template.addTriplePattern("/CAEXFile/InstanceHierarchy/InternalElement/@Name", null,"schema:name", null,"/CAEXFile/InstanceHierarchy/InternalElement/@ID",null);// smart interpretation example

			    //InternalElement
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy", null,"aml:hasInternalElement", null,":CAEXFile/InstanceHierarchy/InternalElement_1",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy", null,"aml:hasInternalElement", null,":CAEXFile/InstanceHierarchy/InternalElement_2",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_2", null,"dc:identifier", null,"/CAEXFile/InstanceHierarchy/InternalElement[@Name='secondScrewdriver']/@ID",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1", null,"dc:identifier", null,"/CAEXFile/InstanceHierarchy/InternalElement[@Name='firstScrewdriver']/@ID",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_2", null,"schema:name", null,"/CAEXFile/InstanceHierarchy/InternalElement[@ID='{19dcf818-4716-4fc1-a85f-28e1938c4c3a}']/@Name",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1", null,"schema:name", null,"/CAEXFile/InstanceHierarchy/InternalElement[@ID='{788eb291-f103-4fdc-aba0-4893b599f556}']/@Name",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1", null,"aml:RefBaseSystemUnitPath", null,"/CAEXFile/InstanceHierarchy/InternalElement[@ID='{788eb291-f103-4fdc-aba0-4893b599f556}']/@RefBaseSystemUnitPath",null);
				template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_2", null,"aml:RefBaseSystemUnitPath", null,"/CAEXFile/InstanceHierarchy/InternalElement[@ID='{19dcf818-4716-4fc1-a85f-28e1938c4c3a}']/@RefBaseSystemUnitPath",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1/ExternalInterface1", null,"schema:name", null,"/CAEXFile/InstanceHierarchy/InternalElement/ExternalInterface[@ID='{5f535d4c-dd46-4c1c-898c-4e58419048b6}']/@Name",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_2/ExternalInterface2", null,"schema:name", null,"/CAEXFile/InstanceHierarchy/InternalElement/ExternalInterface[@ID='50e10905-ac18-413c-afab-ad8ed1569fff']/@Name",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1/ExternalInterface1", null,"dc:identifier", null,"/CAEXFile/InstanceHierarchy/InternalElement/ExternalInterface[@ID='{5f535d4c-dd46-4c1c-898c-4e58419048b6}']/@ID",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_2/ExternalInterface2", null,"dc:identifier", null,"/CAEXFile/InstanceHierarchy/InternalElement/ExternalInterface[@ID='50e10905-ac18-413c-afab-ad8ed1569fff']/@ID",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1/ExternalInterface1", null,"aml:refBaseClassPath", null,"/CAEXFile/InstanceHierarchy/InternalElement/ExternalInterface[@ID='{5f535d4c-dd46-4c1c-898c-4e58419048b6}']/@RefBaseClassPath",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_2/ExternalInterface2", null,"aml:refBaseClassPath", null,"/CAEXFile/InstanceHierarchy/InternalElement/ExternalInterface[@ID='50e10905-ac18-413c-afab-ad8ed1569fff']/@RefBaseClassPath",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1/ExternalInterface1", null,"aml:supportedRoleClass", null,":CAEXFile/InstanceHierarchy/InternalElement/ExternalInterface/SupportedRoleClass1",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_2/ExternalInterface2", null,"aml:supportedRoleClass", null,":CAEXFile/InstanceHierarchy/InternalElement/ExternalInterface/SupportedRoleClass1",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement/ExternalInterface/SupportedRoleClass1", null,"aml:refRoleClassPath", null,"/CAEXFile/InstanceHierarchy/InternalElement/SupportedRoleClass/@RefRoleClassPath",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1", null,"aml:hasRoleRequeriment", null,":CAEXFile/InstanceHierarchy/InternalElement/RoleRequirements_1",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_2", null,"aml:hasRoleRequeriment", null,":CAEXFile/InstanceHierarchy/InternalElement/RoleRequirements_1",null);
			    template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1", null,"aml:refBaseRoleClassPath", null,"/CAEXFile/InstanceHierarchy/InternalElement/RoleRequirements/@RefBaseRoleClassPath",null);

			    //InterfaceClassLib
			    template.addTriplePattern(":CAEXFile", null,"aml:hasInterfaceClassLib", null,":CAEXFile/InterfaceClassLib",null);
			    template.addTriplePattern(":CAEXFile/InterfaceClassLib", null,"schema:name", null,"/CAEXFile/InterfaceClassLib/@Name",null); 
			    template.addTriplePattern(":CAEXFile/InterfaceClassLib", null,"aml:hasInterfaceClass", null,":CAEXFile/InterfaceClassLib/InterfaceClass",null); 
			    template.addTriplePattern(":CAEXFile/InterfaceClassLib", null,"aml:hasVersion", null,"/CAEXFile/InterfaceClassLib/Version/text()",XSDDatatype.XSDstring); 
			    template.addTriplePattern(":CAEXFile/InterfaceClassLib/InterfaceClass", null,"aml:refBaseClassPath", null,"/CAEXFile/InterfaceClassLib/InterfaceClass/@RefBaseClassPath",XSDDatatype.XSDstring); 
			    template.addTriplePattern(":CAEXFile/InterfaceClassLib/InterfaceClass", null,"schema:name", null,"/CAEXFile/InterfaceClassLib/InterfaceClass/@Name",XSDDatatype.XSDstring); 
			    template.addTriplePattern(":CAEXFile", null,"aml:hasRoleClassLib", null,":CAEXFile/RoleClassLib_1",null); 
			    template.addTriplePattern(":CAEXFile/RoleClassLib_1", null,"schema:name", null,"/CAEXFile/RoleClassLib/@Name",null); 
			    template.addTriplePattern(":CAEXFile/RoleClassLib_1", null,"aml:hasVersion", null,"/CAEXFile/RoleClassLib/Version/text()",XSDDatatype.XSDstring); 
			    template.addTriplePattern(":CAEXFile/RoleClassLib_1", null,"aml:hasRoleclass_1", null,":CAEXFile/RoleClassLib/RoleClass_1",null); 
			    template.addTriplePattern(":CAEXFile/RoleClassLib_1/RoleClass_1", null,"schema:name", null,"/CAEXFile/RoleClassLib/RoleClass/@Name",null); 
			    template.addTriplePattern(":CAEXFile/RoleClassLib_1/RoleClass_1", null,"aml:refBaseClassPath", null,"/CAEXFile/RoleClassLib/RoleClass/@RefBaseClassPath",null); 
			    template.addTriplePattern(":CAEXFile", null,"aml:hasSystemUnitClassLib", null,":CAEXFile/SystemUnitClassLib_1",null); 
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib_1", null,"schema:name", null,"/CAEXFile/SystemUnitClassLib/@Name",null); 
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib_1", null,"aml:hasVersion", null,"/CAEXFile/SystemUnitClassLib/Version/text()",null); 
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib_1", null,"aml:hasSystemUnitClass", null,":CAEXFile/SystemUnitClassLib/SystemUnitClass_1",null);
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib/SystemUnitClass_1", null,"schema:name", null,"/CAEXFile/SystemUnitClassLib/SystemUnitClass/@Name",null);
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib/SystemUnitClass_1", null,"aml:hasExternalInterface", null,":CAEXFile/SystemUnitClassLib/SystemUnitClass/ExternalInterface_2",null);
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib/SystemUnitClass_1/ExternalInterface_2", null,"schema:name", null,"/CAEXFile/SystemUnitClassLib/SystemUnitClass/ExternalInterface/@Name",null);
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib/SystemUnitClass_1/ExternalInterface_2", null,"dc:identifier", null,"/CAEXFile/SystemUnitClassLib/SystemUnitClass/ExternalInterface/@ID",null);
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib/SystemUnitClass_1/ExternalInterface_2", null,"aml:refBaseClassPath", null,"/CAEXFile/SystemUnitClassLib/SystemUnitClass/ExternalInterface/@RefBaseClassPath",null);
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib/SystemUnitClass_1", null,"aml:supportedRoleClass", null,":CAEXFile/SystemUnitClassLib/SystemUnitClass/SupportedRoleClass1",null);
			    template.addTriplePattern(":CAEXFile/SystemUnitClassLib/SystemUnitClass_1/SupportedRoleClass1", null,"aml:refRoleClassPath", null,"/CAEXFile/SystemUnitClassLib/SystemUnitClass/SupportedRoleClass/@RefRoleClassPath",null);


			    
		   		    
//blank node(attribute)			    
//template.addTriplePattern(":CAEXFile/InstanceHierarchy/InternalElement_1", null,"aml:hasAttribute ", null,"_:Attribute_1",null);
//template.addTriplePattern("_:Attribute_1", null,"schema:name ", null,"/CAEXFile/InstanceHierarchy/InternalElement/Attribute/@Name",null);

			   
			    
			    
			    
			    
			    
			   //			    template.addTriplePattern("/RTML/Telescope/Camera/FilterWheel/Filter/@type", null, "units", null, "meters",XSDDatatype.XSDstring);
//			    template.addTriplePattern("Author", null, "a", null, "person",XSDDatatype.XSDstring);
			    
			   
			    //template.addTriplePattern("/RTML/Telescope/Camera/FilterWheel/Filter/@name", null,"type", null,"CameraType",XSDDatatype.XSDstring);	
			    
			    //template.addTriplePattern("FocalLength", null,"hasvalue", null,"/RTML/Telescope/FocalLength/test()",XSDDatatype.XSDdouble);		   

//			    template.addTriplePattern("/RTML/Telescope/Camera/FilterWheel/Filter/@name", null,"modelType", null,"/RTML/Telescope/Camera/FilterWheel/Filter/@type",XSDDatatype.XSDstring);
			    // For publicatios.xml. It's subject is realted to :OpenAIREDataModel.
//			    template.addTriplePattern("/response/results/result/header/dri:objIdentifier/text()", null, "a", null, "bibo:Publication", null);
//			    template.addTriplePattern("/response/results/result/header/dri:objIdentifier/text()", null, "swpo:hasTitle", null, "/response/results/result/metadata/oaf:entity/oaf:result/title/text()", XSDDatatype.XSDstring);			    
//			    template.addTriplePattern("/response/results/result/header/dri:objIdentifier/text()", null, ":objectIdentifier", null, "/response/results/result/header/dri:objIdentifier/text()",null);
//			    template.addTriplePattern("/response/results/result/header/dri:objIdentifier/text()", null, ":dateofacceptance", null, "/response/results/result/metadata/oaf:entity/oaf:result/dateofacceptance/text()",XSDDatatype.XSDdate);
//			    template.addTriplePattern("/response/results/result/header/dri:objIdentifier/text()", null, ":language", null, "/response/results/result/metadata/oaf:entity/oaf:result/language/@classname",XSDDatatype.XSDstring);
//			    template.addTriplePattern("/response/results/result/header/dri:objIdentifier/text()", null, ":hasPublisher", null, "/response/results/result/metadata/oaf:entity/oaf:result/publisher/text()",XSDDatatype.XSDstring);
//			    template.addTriplePattern("/response/results/result/header/dri:objIdentifier/text()", null, ":description", null, "/response/results/result/metadata/oaf:entity/oaf:result/description/text()",XSDDatatype.XSDstring);
//			    template.addTriplePattern("/response/results/result/header/dri:objIdentifier/text()", null, ":license", null, "/response/results/result/metadata/oaf:entity/oaf:result/bestlicense/@classid",XSDDatatype.XSDstring);
//			    template.addTriplePattern("/response/results/result/header/dri:objIdentifier/text()", null, ":licenseType", null, "/response/results/result/metadata/oaf:entity/oaf:result/bestlicense/@classname",XSDDatatype.XSDstring);
			    
			    // Not support
			    // template.addTriplePattern(":OpenAIREDataModel", null, ":hasAuthor", null, "/response/results/result/metadata/oaf:entity/oaf:result/rels/rel/to[class="hasAuthor"]/text()",XSDDatatype.XSDstring);			    			    
			    // handler.setTemplateRDF(template);
			    
			    // End of publications.xml

			    // End of publications.xml. It's subject is related to :OpenAIREDataModel.
			    handler.setTemplateRDF(template);

			    //InputStream    xmlInput  = new FileInputStream("publications_template.xml");
//InputStream    xmlInput  = new FileInputStream("STELL-I_3.rtml");
			    InputStream    xmlInput  = new FileInputStream("ExampleTopology.xml");
			    //InputStream    xmlInput  = new FileInputStream("publications.xml");
				//InputStream xmlInput = new FileInputStream("dblp_small.xml");			    
			    //myFilter.AppendXPath("/RTML/Telescope/Camera//*");
			    //myFilter.AppendXPath("/RTML/Telescope/Camera/");
			    // myFilter.AppendXPath("/response/header/page");
			    
			    // For STELL-I_3.rtml.
			    // myFilter.AppendXPath("//Camera/FilterWheel");
			    // myFilter.AppendXPath("//Filter");
			    // For publicaitons.xml	
			    /*
			    myFilter.AppendXPath("//metadata");
			    myFilter.AppendXPath("//publisher");
			    myFilter.AppendXPath("//journal");
			    myFilter.AppendXPath("//title");
			    myFilter.AppendXPath("//originalId");
			    myFilter.AppendXPath("//dateofacceptance");
			    
			    */
			    // For dblp_small.xml 
			    /*
			    myFilter.AppendXPath("//author");			    
			    myFilter.AppendXPath("//title");
			    myFilter.AppendXPath("//journal");
			    myFilter.AppendXPath("//booktitle");
			    myFilter.AppendXPath("//volume");
			    myFilter.AppendXPath("//year");
			    myFilter.AppendXPath("//month");
			    myFilter.AppendXPath("//pages");
			    */
			    
			    
			    //handler.setFilter(myFilter);
			    //long startTime = System.currentTimeMillis();
			    saxParser.parse(xmlInput, handler);
			    long stopTime = System.currentTimeMillis();
				long elapsedTime = stopTime - startTime;
				SumTime += elapsedTime;
			    //handler.model.write(new FileWriter("dblp_small_customized.rdf"), "RDF/XML-ABBREV");
				System.out.println("@prefix       :  " + template.getDefaultNameSpace());
				System.out.println("@prefix    aml:  " + url.toString());
				System.out.println("@prefix     dc:  " + url2.toString());
				System.out.println("@prefix schema:  " + url3.toString() + "\n\n\n");
				
				
				handler.model.write(System.out, "TTL");
				//RDFDataMgr.write(System.out, handler.model, Lang.TURTLE);
				//RDFDataMgr.write(System.out,model, "TURTLE");
			
				

			//	System.out.println("prefix:  " + template.prefixSet.iterator());
				//
				//System.out.println("prefix num: "+ template.prefixSet.size());
			    // System.out.println(SAXYFilterHandler.outputStream);
				//TimeUnit.MILLISECONDS.sleep(2000);
				
			}
			System.out.println("Time elapsed: " + SumTime/runTimes);
		} catch (SAXException e) {		
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    e.printStackTrace ();
		}
	}
}
