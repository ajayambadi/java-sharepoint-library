package org.korecky.sharepoint.search.request;

import java.io.StringWriter;
import java.text.ParseException;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;

import org.korecky.sharepoint.SpObject;
import org.korecky.sharepoint.Support;

//<Property name="author"></Property>


//ATTRIBUTES:
//---------
// name
// If no properties are specified, the default properties will be returned. The following properties are included in the list of default properties:
//-  WordId
//-  Rank
//-  Title
//-  Author
//-  Size
//-  Path
//-  Description
//-  Write
//-  SiteName
//-  CollapsingStatus
//-  HitHighlightedSummary
//-  HitHighlightedProperties
//-  ContentClass
//-  IsDocument
//-  PictureThumbnailURL


public class Property extends SpObject {	
	// name
	private String name = null;
	// value
	private String value = null;

	public Property() {
	}

	public Property(String xmlString) throws XMLStreamException,
			ParseException {
		OMElement xmlElement = null;
		xmlElement = Support.stringToOmElement(xmlString);

		if (xmlElement != null) {
			parse(xmlElement);
		}
	}

	public Property(OMElement xmlElement) throws ParseException {
		parse(xmlElement);
	}

	@Override
	public void parse(OMElement xmlElement) throws ParseException {
		String tempAttributeValue = null;
		
		tempAttributeValue = xmlElement.getAttributeValue(new QName(
				"name"));
		if ((tempAttributeValue != null) && (tempAttributeValue.length() > 0))
			this.setName(String.valueOf(tempAttributeValue));
		tempAttributeValue = null;
		
		this.setValue(xmlElement.getText());
	}

	@Override
	public String getAsXmlString() {
		StringWriter stringWriter = new StringWriter();
		if ((this.getName() != null) && (this.getName().length() > 0))
		{
			stringWriter.append("<Property ");
			stringWriter.append("name=\"" + this.getName() + "\"");		
			stringWriter.append(">");
			stringWriter.append(this.getValue());
			stringWriter.append("</Property>");
		}

		return stringWriter.toString();
	}

	/**
	 * Name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Value
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Value
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
