/**
 * nasru
 * AddingImageToTable.java
 * Jan 17, 2020
 */
package com.mypractice.hrms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.io.font.FontConstants;
/**
 * @author nasru
 *
 */
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import com.mypractice.hrms.bean.ApplicationBean;

public class AddingImageToTable {
	public static void main(String args[]) throws Exception {
		List<ApplicationBean> al = new ArrayList<ApplicationBean>();
		al.add(new ApplicationBean("SSC", "Shri Krishna Pandey Inter College Basti", "UP Board", "MAY-06/JUNE-07",
				"63.33"));
		al.add(new ApplicationBean("HSC", "Kisan I C Moondaaiha Khurd Basti", "UP Board", "MAY-09/JUNE-10", "65.00"));
		al.add(new ApplicationBean("BA", "Choudhry Ram Charithra Parmeshwar Mahavidyalay Moodadiha khurd basti",
				"D.D.U. Gorakhpur Univercity", "MAY-10/JUNE-13", "50.30"));
		al.add(new ApplicationBean("MCM", "0046 Poona Inst. Of Mgnt. Pune", "Pune Univercity", "MAY-13/JUNE-15",
				"77.30"));

		// Creating a PdfWriter object
		String dest = "D:\\Application_Logs\\application.pdf";
		PdfWriter writer = new PdfWriter(dest);
		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);
		// Creating a Document object
		Document doc = new Document(pdfDoc, PageSize.A4);
		// Creating a table
		float[] pointhdtColumnWidths = { 190f, 275f, 135f };

		Table hdrTable = new Table(UnitValue.createPercentArray(pointhdtColumnWidths));
		hdrTable.setBorder(Border.NO_BORDER);
		Cell hdrcell = new Cell();
		hdrcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		hdrcell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		hdrcell.setTextAlignment(TextAlignment.CENTER);
		hdrcell.setBorder(Border.NO_BORDER);
		String hdrimageFile = "D:\\Application_Logs\\logo.png";
		ImageData hdrdata = ImageDataFactory.create(hdrimageFile);
		// Creating the image
		Image hdrimg = new Image(hdrdata);
		// Adding image to the cell10
		hdrcell.add(hdrimg.setAutoScale(false));
		hdrTable.addCell(hdrcell);

		Paragraph companyPrograph = new Paragraph();
		Text companyTextName = new Text("Jsoft India Technology\n");
		companyTextName.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		companyTextName.setFontSize(14);
		companyPrograph.setTextAlignment(TextAlignment.CENTER);

		Text text2 = new Text("A-101 First Floor above,\n");
		text2.setFontSize(9);
		text2.setTextAlignment(TextAlignment.CENTER);

		Text text3 = new Text("A-20 Sakinaka Industrial Market,\n");
		text3.setFontSize(9);
		text3.setTextAlignment(TextAlignment.CENTER);

		Text text4 = new Text("Beside Holiday Inn Hotel Ghatkopar,\n");
		text4.setFontSize(9);
		text4.setTextAlignment(TextAlignment.CENTER);

		Text text5 = new Text("Andheri Link Road Sakinaka Andheri(E),\n");
		text5.setFontSize(9);
		text5.setTextAlignment(TextAlignment.CENTER);

		Text text6 = new Text("Mumbai, Maharashtra,\n");
		text6.setFontSize(9);
		text6.setTextAlignment(TextAlignment.CENTER);

		Text text7 = new Text("India - 400072,\n");
		text7.setFontSize(9);
		text7.setTextAlignment(TextAlignment.CENTER);

		companyPrograph.add(companyTextName);
		companyPrograph.add(text2);
		companyPrograph.add(text3);
		companyPrograph.add(text4);
		companyPrograph.add(text5);
		companyPrograph.add(text6);
		companyPrograph.add(text7);
		Cell hdrcenterCell = new Cell();
		hdrcenterCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		hdrcenterCell.setBorder(Border.NO_BORDER);
		hdrcenterCell.add(companyPrograph);
		hdrcenterCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		hdrTable.addCell(hdrcenterCell);

		Cell hdrpfofilecell = new Cell();
		hdrcell.setTextAlignment(TextAlignment.CENTER);
		hdrpfofilecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		hdrpfofilecell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		hdrpfofilecell.setBorder(Border.NO_BORDER);
		String hdrpfofileFile = "D:\\Application_Logs\\photo.jpg";
		ImageData hdrprofiledata = ImageDataFactory.create(hdrpfofileFile);
		// Creating the image
		Image hdrprolimg = new Image(hdrprofiledata);
		// Adding image to the cell10
		hdrpfofilecell.add(hdrprolimg.setAutoScale(false));
		hdrTable.addCell(hdrpfofilecell);

		doc.add(hdrTable);
		// doc.add(table);

		float[] personalDetials = { 600F };
		Table personalTable = new Table(personalDetials); // Closing the document
		Cell personalHerader = new Cell();
		personalHerader.add("Personal Details");
		personalHerader.setBackgroundColor(Color.LIGHT_GRAY);
		// c5.setBorder(Border.NO_BORDER);
		personalHerader.setTextAlignment(TextAlignment.CENTER);
		personalTable.addCell(personalHerader);
		doc.add(personalTable);

		float[] personalBodyDetials = { 110f, 190f, 110f, 190f };
		Table personalTableBody = new Table(personalBodyDetials);
		/*
		 * Cell hdrCell = new Cell(1,4); hdrCell.add("Personal Details");
		 * hdrcell.setBackgroundColor(Color.BLACK); personalTableBody.addCell(hdrCell);
		 */
		Cell nameLabel = new Cell();
		Paragraph nameLBLPragaf = new Paragraph();
		Text nameText = new Text("First Name :");
		nameText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		nameText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		nameLBLPragaf.add(nameText);
		nameLabel.setTextAlignment(TextAlignment.RIGHT);
		nameLabel.add(nameLBLPragaf);
		nameLabel.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(nameLabel);
		Cell nameValue = new Cell();
		Paragraph valueLBLPragaf = new Paragraph();
		Text valueText = new Text("Nasruddin Gayasuddin khan");
		valueText.setFontSize(9);
		valueLBLPragaf.add(valueText);
		nameValue.add(valueLBLPragaf);
		nameValue.setTextAlignment(TextAlignment.LEFT);
		nameValue.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(nameValue);
		Cell lsnamecell = new Cell();
		Paragraph lsnameLBLPragaf = new Paragraph();
		Text lsnameLBLText = new Text("Last Name :");
		lsnameLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		lsnameLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		lsnameLBLPragaf.add(lsnameLBLText);
		lsnamecell.setTextAlignment(TextAlignment.RIGHT);
		lsnamecell.add(lsnameLBLPragaf);
		lsnamecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(lsnamecell);
		Cell lsvaluecell = new Cell();
		Paragraph lsvaluecellPragaf = new Paragraph();
		Text lsnamevalueText = new Text("Khan");
		lsnamevalueText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		lsvaluecellPragaf.add(lsnamevalueText);
		lsvaluecell.setTextAlignment(TextAlignment.LEFT);
		lsvaluecell.add(lsvaluecellPragaf);
		lsvaluecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(lsvaluecell);
		Cell fanamecell = new Cell();
		Paragraph fanameLBLPragaf = new Paragraph();
		Text fanameLBLText = new Text("Father Name :");
		fanameLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		fanameLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		fanameLBLPragaf.add(fanameLBLText);
		fanamecell.setTextAlignment(TextAlignment.RIGHT);
		fanamecell.add(fanameLBLPragaf);
		fanamecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(fanamecell);
		Cell favaluecell = new Cell();
		Paragraph favaluecellPragaf = new Paragraph();
		Text fanamevalueText = new Text("Gayasuddin khan");
		fanamevalueText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		favaluecellPragaf.add(fanamevalueText);
		favaluecell.setTextAlignment(TextAlignment.LEFT);
		favaluecell.add(favaluecellPragaf);
		favaluecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(favaluecell);
		/*
		 * Cell mnamecell = new Cell(); Paragraph manameLBLPragaf = new Paragraph();
		 * Text mnameLBLText = new Text("Mother Name :");
		 * mnameLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
		 * ; mnameLBLText.setFontSize(9); //c5.setBorder(Border.NO_BORDER);
		 * manameLBLPragaf.add(mnameLBLText);
		 * mnamecell.setTextAlignment(TextAlignment.RIGHT);
		 * mnamecell.add(manameLBLPragaf);
		 * mnamecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		 * personalTableBody.addCell(mnamecell); Cell mvaluecell = new Cell(); Paragraph
		 * mvaluecellPragaf = new Paragraph(); Text mnamevalueText = new
		 * Text("Baharunnisa Gayasuddin khan"); mnamevalueText.setFontSize(9);
		 * //c5.setBorder(Border.NO_BORDER); mvaluecellPragaf.add(mnamevalueText);
		 * mvaluecell.setTextAlignment(TextAlignment.LEFT);
		 * mvaluecell.add(mvaluecellPragaf);
		 * mvaluecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		 * personalTableBody.addCell(mvaluecell);
		 */
		Cell emrgcontactlLBLcell = new Cell();
		Paragraph emrgcontactLBLPragaf = new Paragraph();
		Text emrgcontactLBLText = new Text("Emergency Contact :");
		emrgcontactLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		emrgcontactLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		emrgcontactLBLPragaf.add(emrgcontactLBLText);
		emrgcontactlLBLcell.setTextAlignment(TextAlignment.RIGHT);
		emrgcontactlLBLcell.add(emrgcontactLBLPragaf);
		emrgcontactlLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(emrgcontactlLBLcell);

		Cell emrgcontactVALcell = new Cell();
		Paragraph emrgcontactVALPragaf = new Paragraph();
		Text emrgcontactVALText = new Text("9594757518");
		emrgcontactVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		emrgcontactVALPragaf.add(emrgcontactVALText);
		emrgcontactVALcell.setTextAlignment(TextAlignment.RIGHT);
		emrgcontactVALcell.add(emrgcontactVALPragaf);
		emrgcontactVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(emrgcontactVALcell);

		Cell gendercell = new Cell();
		Paragraph genderLBLPragaf = new Paragraph();
		Text genderLBLText = new Text("Gender :");
		genderLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		genderLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		genderLBLPragaf.add(genderLBLText);
		gendercell.setTextAlignment(TextAlignment.RIGHT);
		gendercell.add(genderLBLPragaf);
		gendercell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(gendercell);
		Cell gnvaluecell = new Cell();
		Paragraph genvaluecellPragaf = new Paragraph();
		Text genvalueText = new Text("Male");
		genvalueText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		genvaluecellPragaf.add(genvalueText);
		gnvaluecell.setTextAlignment(TextAlignment.LEFT);
		gnvaluecell.add(genvaluecellPragaf);
		gnvaluecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(gnvaluecell);

		Cell maritialLBLcell = new Cell();
		Paragraph maritialLBLPragaf = new Paragraph();
		Text maritialLBLText = new Text("Maritial Status :");
		maritialLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		maritialLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		maritialLBLPragaf.add(maritialLBLText);
		maritialLBLcell.setTextAlignment(TextAlignment.RIGHT);
		maritialLBLcell.add(maritialLBLPragaf);
		maritialLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(maritialLBLcell);

		Cell maritialVALcell = new Cell();
		Paragraph maritialVALPragaf = new Paragraph();
		Text maritialVALText = new Text("Married");
		maritialVALText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		maritialVALPragaf.add(maritialVALText);
		maritialVALcell.setTextAlignment(TextAlignment.LEFT);
		maritialVALcell.add(maritialVALPragaf);
		maritialVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(maritialVALcell);

		Cell doblLBLcell = new Cell();
		Paragraph dobLBLPragaf = new Paragraph();
		Text dobLBLText = new Text("Date Of Birth :");
		dobLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		dobLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		dobLBLPragaf.add(dobLBLText);
		doblLBLcell.setTextAlignment(TextAlignment.RIGHT);
		doblLBLcell.add(dobLBLPragaf);
		doblLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(doblLBLcell);

		Cell dobVALcell = new Cell();
		Paragraph dobVALPragaf = new Paragraph();
		Text dobVALText = new Text("05/July/1992");
		dobVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		dobVALPragaf.add(dobVALText);
		dobVALcell.setTextAlignment(TextAlignment.CENTER);
		dobVALcell.add(dobVALPragaf);
		dobVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(dobVALcell);

		Cell dojlLBLcell = new Cell();
		Paragraph dojLBLPragaf = new Paragraph();
		Text dojLBLText = new Text("Date Of Joining :");
		dojLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		dojLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		dojLBLPragaf.add(dojLBLText);
		dojlLBLcell.setTextAlignment(TextAlignment.RIGHT);
		dojlLBLcell.add(dojLBLPragaf);
		dojlLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(dojlLBLcell);

		Cell dojVALcell = new Cell();
		Paragraph dojVALPragaf = new Paragraph();
		Text dojVALText = new Text("05/Febuary/2018");
		dojVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		dojVALPragaf.add(dojVALText);
		dojVALcell.setTextAlignment(TextAlignment.CENTER);
		dojVALcell.add(dojVALPragaf);
		dojVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(dojVALcell);

		Cell emaillLBLcell = new Cell();
		Paragraph emailLBLPragaf = new Paragraph();
		Text emailLBLText = new Text("Email ID :");
		emailLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		emailLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		emailLBLPragaf.add(emailLBLText);
		emaillLBLcell.setTextAlignment(TextAlignment.RIGHT);
		emaillLBLcell.add(emailLBLPragaf);
		emaillLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(emaillLBLcell);

		Cell emailVALcell = new Cell();
		Paragraph emailVALPragaf = new Paragraph();
		Text emailVALText = new Text("nasruddinkhan44@gmail.com");
		emailVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		emailVALPragaf.add(emailVALText);
		emailVALcell.setTextAlignment(TextAlignment.LEFT);
		emailVALcell.add(emailVALPragaf);
		emailVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(emailVALcell);

		Cell contactlLBLcell = new Cell();
		Paragraph contactLBLPragaf = new Paragraph();
		Text contactLBLText = new Text("Contact Number :");
		contactLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		contactLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		contactLBLPragaf.add(contactLBLText);
		contactlLBLcell.setTextAlignment(TextAlignment.RIGHT);
		contactlLBLcell.add(contactLBLPragaf);
		contactlLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(contactlLBLcell);

		Cell contactVALcell = new Cell();
		Paragraph contactVALPragaf = new Paragraph();
		Text contactVALText = new Text("9987353738");
		contactVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		contactVALPragaf.add(contactVALText);
		contactVALcell.setTextAlignment(TextAlignment.RIGHT);
		contactVALcell.add(contactVALPragaf);
		contactVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(contactVALcell);

		Cell aadhaarlLBLcell = new Cell();
		Paragraph aadhaarLBLPragaf = new Paragraph();
		Text aadhaarLBLText = new Text("Aadhaar Number :");
		aadhaarLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		aadhaarLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		aadhaarLBLPragaf.add(aadhaarLBLText);
		aadhaarlLBLcell.setTextAlignment(TextAlignment.RIGHT);
		aadhaarlLBLcell.add(aadhaarLBLPragaf);
		aadhaarlLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(aadhaarlLBLcell);

		Cell aadhaarVALcell = new Cell();
		Paragraph aadhaarVALPragaf = new Paragraph();
		Text aadhaarVALText = new Text("1234 5678 9101");
		aadhaarVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		aadhaarVALPragaf.add(aadhaarVALText);
		aadhaarVALcell.setTextAlignment(TextAlignment.CENTER);
		aadhaarVALcell.add(aadhaarVALPragaf);
		aadhaarVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(aadhaarVALcell);

		Cell panlLBLcell = new Cell();
		Paragraph panLBLPragaf = new Paragraph();
		Text panLBLText = new Text("Pancard Number :");
		panLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		panLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		panLBLPragaf.add(panLBLText);
		panlLBLcell.setTextAlignment(TextAlignment.RIGHT);
		panlLBLcell.add(panLBLPragaf);
		panlLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(panlLBLcell);

		Cell panVALcell = new Cell();
		Paragraph panVALPragaf = new Paragraph();
		Text panVALText = new Text("CDKPK2811E");
		panVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		panVALPragaf.add(panVALText);
		panVALcell.setTextAlignment(TextAlignment.LEFT);
		panVALcell.add(panVALPragaf);
		panVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(panVALcell);

		Cell addresscell = new Cell(1, 4);
		addresscell.add("Address Details");
		addresscell.setBackgroundColor(Color.LIGHT_GRAY);
		// c5.setBorder(Border.NO_BORDER);
		addresscell.setTextAlignment(TextAlignment.CENTER);
		personalTableBody.addCell(addresscell);

		Cell countrylLBLcell = new Cell();
		Paragraph countryLBLPragaf = new Paragraph();
		Text countryLBLText = new Text("Country :");
		countryLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		countryLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		countryLBLPragaf.add(countryLBLText);
		countrylLBLcell.setTextAlignment(TextAlignment.RIGHT);
		countrylLBLcell.add(countryLBLPragaf);
		countrylLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(countrylLBLcell);

		Cell countryVALcell = new Cell();
		Paragraph countryVALPragaf = new Paragraph();
		Text countryVALText = new Text("India");
		countryVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		countryVALPragaf.add(countryVALText);
		countryVALcell.setTextAlignment(TextAlignment.LEFT);
		countryVALcell.add(countryVALPragaf);
		countryVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(countryVALcell);

		Cell statelLBLcell = new Cell();
		Paragraph stateLBLPragaf = new Paragraph();
		Text stateLBLText = new Text("State :");
		stateLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		stateLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		stateLBLPragaf.add(stateLBLText);
		statelLBLcell.setTextAlignment(TextAlignment.RIGHT);
		statelLBLcell.add(stateLBLPragaf);
		statelLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(statelLBLcell);

		Cell stateVALcell = new Cell();
		Paragraph stateVALPragaf = new Paragraph();
		Text stateVALText = new Text("Maharashtra ");
		stateVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		stateVALPragaf.add(stateVALText);
		stateVALcell.setTextAlignment(TextAlignment.LEFT);
		stateVALcell.add(stateVALPragaf);
		stateVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(stateVALcell);

		Cell citylLBLcell = new Cell();
		Paragraph cityLBLPragaf = new Paragraph();
		Text cityLBLText = new Text("City :");
		cityLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		cityLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		cityLBLPragaf.add(cityLBLText);
		citylLBLcell.setTextAlignment(TextAlignment.RIGHT);
		citylLBLcell.add(cityLBLPragaf);
		citylLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(citylLBLcell);

		Cell cityVALcell = new Cell();
		Paragraph cityVALPragaf = new Paragraph();
		Text cityVALText = new Text("Mumbai ");
		cityVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		cityVALPragaf.add(cityVALText);
		cityVALcell.setTextAlignment(TextAlignment.LEFT);
		cityVALcell.add(cityVALPragaf);
		cityVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(cityVALcell);

		Cell pincodelLBLcell = new Cell();
		Paragraph pincodeLBLPragaf = new Paragraph();
		Text pincodeLBLText = new Text("Pincode :");
		pincodeLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		pincodeLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		pincodeLBLPragaf.add(pincodeLBLText);
		pincodelLBLcell.setTextAlignment(TextAlignment.RIGHT);
		pincodelLBLcell.add(pincodeLBLPragaf);
		pincodelLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(pincodelLBLcell);

		Cell pincodeVALcell = new Cell();
		Paragraph pincodeVALPragaf = new Paragraph();
		Text pincodeVALText = new Text("400083 ");
		pincodeVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		pincodeVALPragaf.add(pincodeVALText);
		pincodeVALcell.setTextAlignment(TextAlignment.RIGHT);
		pincodeVALcell.add(pincodeVALPragaf);
		pincodeVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(pincodeVALcell);

		Cell addressLBLcell = new Cell();
		Paragraph addressLBLPragaf = new Paragraph();
		Text addressLBLText = new Text("Address :");
		addressLBLText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		addressLBLText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		addressLBLPragaf.add(addressLBLText);
		addressLBLcell.setTextAlignment(TextAlignment.RIGHT);
		addressLBLcell.add(addressLBLPragaf);
		addressLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(addressLBLcell);

		Cell addressVALcell = new Cell(2, 4);
		Paragraph addressVALPragaf = new Paragraph();
		Text addressVALText = new Text("Uday Nagar Surya Nagar L.B.S Marg Vikhroli(w), Mumbai Maharashtra 400083  ");
		addressVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		addressVALPragaf.add(addressVALText);
		addressVALcell.setTextAlignment(TextAlignment.LEFT);
		addressVALcell.add(addressVALPragaf);
		addressVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		personalTableBody.addCell(addressVALcell);
		doc.add(personalTableBody);
		doc.add(new Paragraph("\n"));
		float[] educationDetials = { 40f, 80f, 200f, 200f, 120f, 60f };
		Table educationTableBody = new Table(educationDetials);
		Cell eduhdrcell = new Cell(1, 6);
		eduhdrcell.add("Education Details");
		eduhdrcell.setBackgroundColor(Color.LIGHT_GRAY);
		// c5.setBorder(Border.NO_BORDER);
		eduhdrcell.setTextAlignment(TextAlignment.CENTER);
		educationTableBody.addCell(eduhdrcell);

		Cell edusrcell = new Cell();
		Paragraph srPragraf = new Paragraph();
		Text asrText = new Text("SR ");
		asrText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		// asrText.setFontColor(Color.WHITE);
		asrText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);

		srPragraf.add(asrText);
		edusrcell.add(srPragraf);
		edusrcell.setBackgroundColor(Color.LIGHT_GRAY);
		edusrcell.setTextAlignment(TextAlignment.CENTER);

		edusrcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(edusrcell);

		Cell eduscoursecell = new Cell();
		Paragraph coursePragraf = new Paragraph();
		Text courseText = new Text("Course ");
		courseText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		// courseText.setFontColor(Color.WHITE);
		courseText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		coursePragraf.add(courseText);
		eduscoursecell.add(coursePragraf);
		eduscoursecell.setBackgroundColor(Color.LIGHT_GRAY);
		eduscoursecell.setTextAlignment(TextAlignment.CENTER);
		eduscoursecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(eduscoursecell);

		Cell eduscollegecell = new Cell();
		Paragraph eduscollegePragraf = new Paragraph();
		Text eduscollegeText = new Text("College Name");
		eduscollegeText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		// courseText.setFontColor(Color.WHITE);
		eduscollegeText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		eduscollegePragraf.add(eduscollegeText);
		eduscollegecell.add(eduscollegePragraf);
		eduscollegecell.setBackgroundColor(Color.LIGHT_GRAY);
		eduscollegecell.setTextAlignment(TextAlignment.CENTER);
		eduscollegecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(eduscollegecell);

		Cell edusunivercitycell = new Cell();
		Paragraph edusunivercityPragraf = new Paragraph();
		Text edusunivercityText = new Text("Univercity Name");
		edusunivercityText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		// courseText.setFontColor(Color.WHITE);
		edusunivercityText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		edusunivercityPragraf.add(edusunivercityText);
		edusunivercitycell.add(edusunivercityPragraf);
		edusunivercitycell.setBackgroundColor(Color.LIGHT_GRAY);
		edusunivercitycell.setTextAlignment(TextAlignment.CENTER);
		edusunivercitycell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(edusunivercitycell);

		Cell edusdurationcell = new Cell();
		Paragraph edusdurationPragraf = new Paragraph();
		Text edusdurationText = new Text("Duration");
		edusdurationText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		// courseText.setFontColor(Color.WHITE);
		edusdurationText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		edusdurationPragraf.add(edusdurationText);
		edusdurationcell.add(edusdurationPragraf);
		edusdurationcell.setBackgroundColor(Color.LIGHT_GRAY);
		edusdurationcell.setTextAlignment(TextAlignment.CENTER);
		edusdurationcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(edusdurationcell);

		Cell eduspercentagecell = new Cell();
		Paragraph eduspercentagePragraf = new Paragraph();
		Text eduspercentageText = new Text("%");
		eduspercentageText.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		// courseText.setFontColor(Color.WHITE);
		eduspercentageText.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		eduspercentagePragraf.add(eduspercentageText);
		eduspercentagecell.add(eduspercentagePragraf);
		eduspercentagecell.setBackgroundColor(Color.LIGHT_GRAY);
		eduspercentagecell.setTextAlignment(TextAlignment.CENTER);
		eduspercentagecell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(eduspercentagecell);

		for (int i = 0; i < al.size(); i++) {
		// SR
		Cell edusrVALcell = new Cell();
		Paragraph edusrVALPragaf = new Paragraph();
		Text edusrVALText = new Text(String.valueOf(i+1));
		edusrVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		edusrVALPragaf.add(edusrVALText);
		edusrVALcell.setTextAlignment(TextAlignment.CENTER);
		edusrVALcell.add(edusrVALPragaf);
		edusrVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(edusrVALcell);

		// Course
		Cell educourseVALcell = new Cell();
		Paragraph educourseVALPragaf = new Paragraph();
		Text educourseVALText = new Text(al.get(i).getCourse());
		educourseVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		educourseVALPragaf.add(educourseVALText);
		educourseVALcell.setTextAlignment(TextAlignment.CENTER);
		educourseVALcell.add(educourseVALPragaf);
		educourseVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(educourseVALcell);

		// Clg
		Cell educlgVALcell = new Cell();
		Paragraph educlgVALPragaf = new Paragraph();
		Text educlgVALText = new Text(al.get(i).getCollegeName());
		educlgVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		educlgVALPragaf.add(educlgVALText);
		educlgVALcell.setTextAlignment(TextAlignment.CENTER);
		educlgVALcell.add(educlgVALPragaf);
		educlgVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(educlgVALcell);

		// Univercity
		Cell eduunivecityVALcell = new Cell();
		Paragraph eduunivecityVALPragaf = new Paragraph();
		Text eduunivecityVALText = new Text(al.get(i).getUnivercityName());
		eduunivecityVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		eduunivecityVALPragaf.add(eduunivecityVALText);
		eduunivecityVALcell.setTextAlignment(TextAlignment.CENTER);
		eduunivecityVALcell.add(eduunivecityVALPragaf);
		eduunivecityVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(eduunivecityVALcell);

		// Univercity
		Cell edudurationVALcell = new Cell();
		Paragraph edudurationVALPragaf = new Paragraph();
		Text edudurationVALText = new Text(al.get(i).getDuration());
		edudurationVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		edudurationVALPragaf.add(edudurationVALText);
		edudurationVALcell.setTextAlignment(TextAlignment.CENTER);
		edudurationVALcell.add(edudurationVALPragaf);
		edudurationVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(edudurationVALcell);

		// Percentage
		Cell eduperVALcell = new Cell();
		Paragraph eduperVALPragaf = new Paragraph();
		Text eduperVALText = new Text(al.get(i).getPercentage());
		eduperVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		eduperVALPragaf.add(eduperVALText);
		eduperVALcell.setTextAlignment(TextAlignment.CENTER);
		eduperVALcell.add(eduperVALPragaf);
		eduperVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		educationTableBody.addCell(eduperVALcell);
		}
		
		doc.add(educationTableBody);
		doc.add(new Paragraph("\n"));
		float[] refrenceDetials = { 50f, 120f, 100f, 100f, 50f,180f };
		Table refrenceTable = new Table(refrenceDetials);
		Cell refercell = new Cell(1, 6);
		refercell.add("Reference Details");
		refercell.setBackgroundColor(Color.LIGHT_GRAY);
		// c5.setBorder(Border.NO_BORDER);
		refercell.setTextAlignment(TextAlignment.CENTER);
		refrenceTable.addCell(refercell);

		Cell refLBLcell = new Cell();
		Paragraph refLBLPragaf = new Paragraph();
		Text refLBLText = new Text("Name :");
		refLBLPragaf.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		refLBLPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		refLBLPragaf.add(refLBLText);
		refLBLcell.setTextAlignment(TextAlignment.RIGHT);
		refLBLcell.add(refLBLPragaf);
		refLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		refrenceTable.addCell(refLBLcell);

		
		Cell refVALcell = new Cell();
		Paragraph refVALPragaf = new Paragraph();
		Text refVALText = new Text("Anwar Malik");
		refVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		refVALPragaf.add(refVALText);
		refVALcell.setTextAlignment(TextAlignment.CENTER);
		refVALcell.add(refVALPragaf);
		refVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		refrenceTable.addCell(refVALcell);
		
		
		Cell refConLBLcell = new Cell();
		Paragraph refConLBLPragaf = new Paragraph();
		Text refConLBLText = new Text("Contact Number :");
		refConLBLPragaf.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		refConLBLPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		refConLBLPragaf.add(refConLBLText);
		refConLBLcell.setTextAlignment(TextAlignment.RIGHT);
		refConLBLcell.add(refConLBLPragaf);
		refConLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		refrenceTable.addCell(refConLBLcell);
		
		Cell refConVALcell = new Cell();
		Paragraph refConVALPragaf = new Paragraph();
		Text refConVALText = new Text("9702639889");
		refConVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		refConVALPragaf.add(refConVALText);
		refConVALcell.setTextAlignment(TextAlignment.RIGHT);
		refConVALcell.add(refConVALPragaf);
		refConVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		refrenceTable.addCell(refConVALcell);

		Cell refEmailLBLcell = new Cell();
		Paragraph refEmailLBLPragaf = new Paragraph();
		Text refEmailLBLText = new Text("Email :");
		refEmailLBLPragaf.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
		refEmailLBLPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		refEmailLBLPragaf.add(refEmailLBLText);
		refEmailLBLcell.setTextAlignment(TextAlignment.RIGHT);
		refEmailLBLcell.add(refEmailLBLPragaf);
		refEmailLBLcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		refrenceTable.addCell(refEmailLBLcell);
		
		Cell refEmailVALcell = new Cell();
		Paragraph refEmailVALPragaf = new Paragraph();
		Text refEmailVALText = new Text("anwarmalikbkl@gmail.com");
		refEmailVALPragaf.setFontSize(9);
		// c5.setBorder(Border.NO_BORDER);
		refEmailVALPragaf.add(refEmailVALText);
		refEmailVALcell.setTextAlignment(TextAlignment.CENTER);
		refEmailVALcell.add(refEmailVALPragaf);
		refEmailVALcell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		refrenceTable.addCell(refEmailVALcell);
		doc.add(refrenceTable);
		doc.add(new Paragraph("\n"));
		doc.add(new Paragraph("\n"));
		float[] sigColumnWidths = { 300f, 300f };

		Table sigTable = new Table(UnitValue.createPercentArray(sigColumnWidths));
		sigTable.setBorder(Border.NO_BORDER);
		Cell sigcell = new Cell();
		sigcell.setHorizontalAlignment(HorizontalAlignment.LEFT);
		sigcell.setVerticalAlignment(VerticalAlignment.BOTTOM);
		sigcell.setBorder(Border.NO_BORDER);
		String sigimageFile = "D:\\Application_Logs\\signature.jfif";
		ImageData hdrsigdata = ImageDataFactory.create(sigimageFile);
		// Creating the image
		Image sigimg = new Image(hdrsigdata);
		// Adding image to the cell10
		sigcell.add(sigimg.setAutoScale(false));
		sigTable.addCell(sigcell);
		
		
		Cell usrsigcell = new Cell();
		usrsigcell.add("Student Signature");
		usrsigcell.setTextAlignment(TextAlignment.RIGHT);
		usrsigcell.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		usrsigcell.setVerticalAlignment(VerticalAlignment.BOTTOM);
		usrsigcell.setBorder(Border.NO_BORDER);

		sigTable.addCell(usrsigcell);
		
		doc.add(sigTable);
		doc.close();

		System.out.println("Image added to table successfully..");
	}
}