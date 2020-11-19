package com.physics.quesbank.util;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;

/**
 * @ClassName HtmlToPdfUtil
 * @Description TODO
 * @Author aron
 * @Date 2020/11/19 14:56
 **/
public class HtmlToPdfUtil {

    protected final static Logger logger = LoggerFactory.getLogger(HtmlToPdfUtil.class);

    public static void tomPdf(String html, String DEST) throws Exception {
        ConverterProperties props = new ConverterProperties();
        DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, false);
        defaultFontProvider.addFont("classpath:NotoSansCJKsc-Regular.otf");
        props.setFontProvider(defaultFontProvider);
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(new PageSize(595.0F, 842.0F));
        Document document = HtmlConverter.convertToDocument(new FileInputStream(html), pdf, props);
        document.close();
        pdf.close();

    }

}
