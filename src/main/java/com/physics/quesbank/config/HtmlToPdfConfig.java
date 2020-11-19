package com.physics.quesbank.config;

import com.physics.quesbank.entity.htmlToPdf.HtmlToPdf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName HtmlToPdfConfig
 * @Description TODO
 * @Author aron
 * @Date 2020/11/19 14:52
 **/
@Configuration
public class HtmlToPdfConfig {

    @Value("${htmlToPdf.htmlTemplate}")
    private String htmlTemplate;

    @Value("${htmlToPdf.htmlPath}")
    private String htmlPath;

    @Value("${htmlToPdf.pdfPath}")
    private String pdfPath;

    @Bean
    public HtmlToPdf htmlToPdf(){
        HtmlToPdf htmlToPdf = new HtmlToPdf();
        try{
            htmlToPdf.setHtmlPath(htmlPath);
            htmlToPdf.setPdfPath(pdfPath);
            htmlToPdf.setHtmlTemplate(htmlTemplate);
        } catch (Exception e){
            e.printStackTrace();
        }
        return htmlToPdf;
    }


}
