package com.physics.quesbank.entity.htmlToPdf;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HtmlToPdf
 * @Description TODO
 * @Author aron
 * @Date 2020/11/19 14:51
 **/
@Data
public class HtmlToPdf {

    private String htmlTemplate;
    private String htmlPath;
    private String pdfPath;
}
