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

import java.io.File;
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
        defaultFontProvider.addFont( currentPath()+"NotoSansCJKsc-Regular.otf");
        props.setFontProvider(defaultFontProvider);
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(new PageSize(700.0F, 1000.0F));
        Document document = HtmlConverter.convertToDocument(new FileInputStream(html), pdf, props);
        document.close();
        pdf.close();
        writer.close();
    }

    public static String currentPath() throws Exception{
        String path = null;
        String filePath = new File("").getCanonicalPath();
        if (judgeOperationSystemType().equals("linux")) {
            return filePath+"/";
        }
        path = filePath.substring(0, filePath.lastIndexOf("\\") + 1).replace("\\", "/");
        String temp = path.substring(0, path.lastIndexOf("/"));
        path = temp.substring(0, temp.lastIndexOf("/") + 1);
        return path;
    }

    /*
     * 判断项目部署所在的操作系统
     */
    public static String judgeOperationSystemType() {
        String osType = System.getProperty("os.name").toLowerCase();
        if (osType.startsWith("win")) {
            return "windows";
        } else if (osType.startsWith("lin")) {
            return "linux";
        } else {
            return "";
        }
    }

    public static void main (String[] args) throws Exception{
        tomPdf("D:/test.html", "D:/test.pdf");
    }

}
