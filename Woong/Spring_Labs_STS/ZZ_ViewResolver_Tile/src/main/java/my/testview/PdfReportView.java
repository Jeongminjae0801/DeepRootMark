package my.testview;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import my.dto.Report;

public class PdfReportView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(	Map<String, Object> model, 
											HttpServletRequest request,
											HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=myReport.pdf");
		Report report = (Report) model.get("report");

		// IText API
		PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
		PdfDocument pdf = new PdfDocument(pdfWriter);
		Document pdfDocument = new Document(pdf);

		// title
		Paragraph title = new Paragraph(report.getName());
		title.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		title.setFontSize(18f);
		title.setItalic();
		pdfDocument.add(title);

		// date
		Paragraph date = new Paragraph(report.getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		date.setFontSize(16f);
		pdfDocument.add(date);

		// content
		Paragraph content = new Paragraph(report.getContent());
		pdfDocument.add(content);

		pdfDocument.close();
	}

}
