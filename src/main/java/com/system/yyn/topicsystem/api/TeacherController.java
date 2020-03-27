package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.business.request.TeacherAddTopicRequest;
import com.system.yyn.topicsystem.business.request.TeacherGetTopicsRequest;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.po.User;
import com.system.yyn.topicsystem.entity.vo.TeacherTopicVO;
import com.system.yyn.topicsystem.service.TeacherTopicService;
import com.system.yyn.topicsystem.service.TopicService;
import com.system.yyn.topicsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 教师
 */
@Controller
@RequestMapping("/adminUser")
public class TeacherController {

    @Resource
    private TeacherTopicService teacherTopicService;
    @Resource
    private TopicService topicService;

    /**
     * 添加课题
     * @param addTopicRequest
     * @param request
     * @return
     */
    @RequestMapping("/addTopic")
    public String addTopic(TeacherAddTopicRequest addTopicRequest, HttpServletRequest request) {

        String username = (String) request.getSession().getAttribute("cellphone");
        addTopicRequest.setTeacherId(username);
        int result = teacherTopicService.addTopic(addTopicRequest);
        if (result == 1) {
            return "redirect:/adminUser/queryTopics";
        }
        return "admin/adminAddTopic";
    }

    /**
     * 查询课题信息
     * @param request
     * @return
     */
    @RequestMapping("/queryTopics")
    public String queryTopics(HttpServletRequest request) {
        String cellphone = (String) request.getSession().getAttribute("cellphone");
        TeacherGetTopicsRequest teacherGetTopicsRequest = new TeacherGetTopicsRequest();
        teacherGetTopicsRequest.setTeacherId(cellphone);
        List<TeacherTopicVO> topicList = teacherTopicService.getTopicList(teacherGetTopicsRequest);
        request.setAttribute("topics",topicList);
        return "admin/adminTopicList";
    }

    /**
     * 跳转修改页
     * @param request
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdatePage(HttpServletRequest request){
        String id = request.getParameter("id");
        Topic topicInfo = topicService.getTopicInfo(id);
        request.setAttribute("topic",topicInfo);
        return "admin/adminUpdateTopic";
    }

    /**
     * 修改课题信息
     * @param topicInfo
     * @param request
     * @return
     */
    @RequestMapping("/updateTopic")
    public String updateTopic(Topic topicInfo,HttpServletRequest request){

        int result = topicService.updateTopicInfo(topicInfo);
        if(result == 1){
            request.setAttribute("success", "修改成功");
        } else {
            request.setAttribute("error", "修改失败");
        }
        return "redirect:/adminUser/queryTopics";
    }

    /**
     * 删除课题
     * @param request
     * @return
     */
    @RequestMapping("/delTopic")
    public String delTopic(HttpServletRequest request){
        String id = request.getParameter("id");
        String cellphone = (String)request.getSession().getAttribute("cellphone");
        int result = teacherTopicService.delTopic(cellphone, id);
        if(result == 1){
            request.setAttribute("success", "修改成功");
        } else {
            request.setAttribute("error", "修改失败");
        }
        return "redirect:/adminUser/queryTopics";
    }
}
