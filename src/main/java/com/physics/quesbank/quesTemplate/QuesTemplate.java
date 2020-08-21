package com.physics.quesbank.quesTemplate;

import com.physics.quesbank.entity.demo.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ClassName QuesTemplate
 * @Description TODO
 * @Author aron
 * @Date 2020/8/21 13:44
 **/
public class QuesTemplate {

    protected final static Logger logger = LoggerFactory.getLogger(QuesTemplate.class);

    public static StringBuilder initQuesPage(List<Demo> demo){
        StringBuilder quesTemplate = new StringBuilder();
        quesTemplate.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
        quesTemplate.append("<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">");
        quesTemplate.append("<head>");
        quesTemplate.append("<meta charset=\"UTF-8\" />");
        quesTemplate.append("<title>Title</title>");
        quesTemplate.append("<link href=\"../css/bodyAndHtml.css\" rel=\"stylesheet\" />");
        quesTemplate.append("<link href=\"../css/flexPlugin.css\" rel=\"stylesheet\" />");
        quesTemplate.append("<link href=\"../css/quesBlock.css\" rel=\"stylesheet\" />");
        quesTemplate.append("</head>");
        quesTemplate.append("<body class=\"main\">");
        quesTemplate.append("<div class=\"container\">");
        quesTemplate.append("<div class=\"col-sm-2\"></div>");
        quesTemplate.append("<div class=\"col-sm-96 ques\">");
        quesTemplate.append("<div style=\"text-align: center;height: 7%\">XXXXXXXX题</div>");
        for (Demo sub: demo) {
            quesTemplate.append("<div class=\"recordContainer\">");
            quesTemplate.append("<div class=\"showBody\">");
            quesTemplate.append("<div class=\"content\">");
            quesTemplate.append("<div id=\"content\" contentEditable=\"false\" class=\"showDemo\">");
            quesTemplate.append(sub.getContent());
            quesTemplate.append("</div>");
            quesTemplate.append("</div>");
            quesTemplate.append("</div>");
            quesTemplate.append("</div>");
            quesTemplate.append("<div style=\"height: 3%\"></div>");
        }
        quesTemplate.append("</div>");
        quesTemplate.append("<div class=\"col-sm-2\"></div>");
        quesTemplate.append("</div>");
        quesTemplate.append("</body>");
        quesTemplate.append("<script type=\"text/javascript\" src=\"../formula/jmeditor/jquery-1.8.3.min.js\"></script>");
        quesTemplate.append("<script type=\"text/javascript\" src=\"../formula/jmeditor/JMEditor.js\"></script>");



        return quesTemplate;
    }
}
