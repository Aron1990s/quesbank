package com.physics.quesbank.controller.HighPhysicsGradeChapter;

import com.physics.quesbank.controller.base.BaseController;
import com.physics.quesbank.entity.HighPhysicsInfo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HighPhysicsGradeChapterController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/3 9:55
 **/
@RestController
@RequestMapping("highPhyGrChCtl")
public class HighPhysicsGradeChapterController extends BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsGradeChapterController.class);

    @Autowired
    private HighPhysicsInfo highPhysicsInfo;

    /**
     * 获取高中年级
     */
    @RequestMapping("getGradeInfo")
    public Object getGradeInfo(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<HighGradeInfo> grades = highPhysicsInfo.getGrades();
            map.put("code", "1");
            map.put("grades", grades);
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 获取章节信息
     * @param gradeId
     * @return
     */
    @RequestMapping("getChapterInfo")
    public Object getChapterInfo(String gradeId){
        Map<String, Object> map = new HashMap<>();
        try{
            Map<String, List<HighChapterInfo>> chapters = highPhysicsInfo.getChapters();
            map.put("chapters", chapters.get(gradeId));
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 获取章节子信息
     * @param chapterId
     * @return
     */
    @RequestMapping("getChapterSubInfo")
    public Object getChapterSubInfo(String chapterId){
        Map<String, Object> map = new HashMap<>();
        try{
            Map<String, List<HighChapterSubInfo>> chapterSubs = highPhysicsInfo.getChapterSubs();
            map.put("chapterSubs", chapterSubs.get(chapterId));
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 获取章节子项目项信息
     * @param chapterSubId
     * @return
     */
    @RequestMapping("getChapterSubItemInfo")
    public Object getChapterSubItemInfo(String chapterSubId){
        Map<String, Object> map = new HashMap<>();
        try{
            Map<String, List<HighChapterSubItemInfo>> chapterSubItems = highPhysicsInfo.getChapterSubItems();
            map.put("chapterSubItems", chapterSubItems.get(chapterSubId));
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

}
