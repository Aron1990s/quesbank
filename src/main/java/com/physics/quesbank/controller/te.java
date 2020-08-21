//package com.physics.quesbank.controller;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
//import com.itextpdf.tool.xml.XMLWorkerFontProvider;
//import com.itextpdf.tool.xml.XMLWorkerHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.Assert;
//import org.xhtmlrenderer.pdf.ITextFontResolver;
//import org.xhtmlrenderer.pdf.ITextRenderer;
//
//import java.io.*;
//
///**
// * @ClassName te
// * @Description TODO
// * @Author aron
// * @Date 2020/8/21 14:37
// **/
//public class te {
//
//    protected final static Logger logger = LoggerFactory.getLogger(te.class);
//
//
//    public static void createPDF(String filePath, String content, String waterMark) {
//        Assert.notNull(filePath, "FilePath can not be null");
//        Assert.notNull(content, "Content can not be null");
//        Assert.notNull(waterMark, "WaterMark can not be null");
//        Document document = new Document(PageSize.A4);
//        try {
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
//            writer.setPageEvent(new CustomEvent(waterMark));
//            document.addTitle("PDF标题");
//            document.open();
//
//            // 额外添加内容的方法 如果只是普通文本转pdf, 用下面注释的代码即可, 注释后面的代码为html to pdf
////            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
////                    BaseFont.EMBEDDED);
////            Font font = new Font(baseFont);
////            document.add(new Paragraph(content, font));
//
//            ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
//            ByteArrayInputStream is = new ByteArrayInputStream("".getBytes());
//            XMLWorkerHelper.getInstance().parseXHtml(writer, document, in,is,new PdfFont());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            document.close();
//        }
//    }
//
//    /**
//     * 中文字体支持
//     */
//    static class PdfFont extends XMLWorkerFontProvider {
//
//        @Override
//        public Font getFont(String fontname, String encoding, boolean embedded,
//                            float size, int style, BaseColor color) {
//            String font = fontname;
//            if (font == null) {
//                font = "宋体";
//            }
//            if (size <= 0) {//size<0 会使内容重叠在一体
//                size = 10.5f;
//            }
//            return super.getFont(font, encoding, embedded, size, style, color);
//        }
//
//    }
//
//    /**
//     * 事件处理类, 用于监听pdf页码增加时, 每页增加水印
//     */
//    static class CustomEvent extends PdfPageEventHelper {
//
//        private String waterMark;
//
//        public CustomEvent(String waterMark) {
//            this.waterMark = waterMark;
//        }
//
//        @Override
//        public void onStartPage(PdfWriter writer, Document document) {
//            try {
//                // 加入水印
//                PdfContentByte waterMar = writer.getDirectContentUnder();
//                // 开始设置水印
//                waterMar.beginText();
//                // 设置水印透明度
//                PdfGState gs = new PdfGState();
//                // 设置填充字体不透明度为0.2f
//                gs.setFillOpacity(0.1f);
//                // 设置水印字体参数及大小
//                BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
//                        BaseFont.EMBEDDED);
//                waterMar.setFontAndSize(baseFont,60);
//                // 设置透明度
//                waterMar.setGState(gs);
//                // 设置水印对齐方式 水印内容 X坐标 Y坐标 旋转角度
//                waterMar.showTextAligned(Element.ALIGN_CENTER, waterMark , 300, 500, 45);
//                //结束设置
//                waterMar.endText();
//                waterMar.stroke();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
