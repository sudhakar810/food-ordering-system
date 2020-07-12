package com.food.ordering.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.ordering.system.bean.DeliveryInfo.ItemInfo;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdfReport {

	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

	public static ByteArrayInputStream generateInvoice(List<OrderInfo> orderinfo) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			for (OrderInfo order : orderinfo) {

				PdfPTable table = new PdfPTable(4);
				table.setWidthPercentage(100);
				table.setWidths(new int[] { 3, 3, 3, 3 });

				Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

				PdfPCell hcell;
				hcell = new PdfPCell(new Phrase("Order Number", headFont));
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(hcell);

				hcell = new PdfPCell(new Phrase("Customer Name", headFont));
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(hcell);

				hcell = new PdfPCell(new Phrase("Total Fare", headFont));
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(hcell);

				hcell = new PdfPCell(new Phrase("Address", headFont));
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(hcell);

				Paragraph heading = new Paragraph("Food Items");
				Paragraph paragraph = new Paragraph();

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(order.getOrderId().toString()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(order.getCustomerName()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(order.getTotalFare())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(5);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(order.getAddress())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(5);
				table.addCell(cell);

				for (ItemInfo info : order.getItemInfo()) {

					paragraph.setAlignment(Element.ALIGN_LEFT);
					paragraph.add("Item Name : ");
					paragraph.setAlignment(Element.ALIGN_CENTER);
					paragraph.add(info.getItem_name());
					
					paragraph.add("\n\n");
					
					paragraph.setAlignment(Element.ALIGN_LEFT);
					paragraph.add("Quantity : ");
					paragraph.setAlignment(Element.ALIGN_CENTER);
					paragraph.add(info.getQuantity()+"");
					
					paragraph.add("\n\n");
					
					paragraph.setAlignment(Element.ALIGN_LEFT);
					paragraph.add("Price : ");
					paragraph.setAlignment(Element.ALIGN_CENTER);
					paragraph.add(info.getTotal_fare()+"");
					
					paragraph.add("\n\n");
					
				}

				PdfWriter.getInstance(document, out);
				document.open();
				document.add(table);
				document.add(heading);
				document.add(paragraph);

			}

			document.close();

		} catch (DocumentException ex) {

			logger.error("Error occurred: {0}", ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
}