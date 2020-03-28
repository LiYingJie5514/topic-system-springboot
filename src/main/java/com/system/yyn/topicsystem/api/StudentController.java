package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.business.request.StudentGetTopicsRequest;
import com.system.yyn.topicsystem.business.response.BaseResponse;
import com.system.yyn.topicsystem.entity.vo.StudentTopicVO;
import com.system.yyn.topicsystem.service.StudentTopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName : StudentController
 * @Description : 学生 controller
 */
@Controller
public class StudentController {

    @Resource
    private StudentTopicService studentTopicService;

    //获取选选题列表
    @RequestMapping("/student/getTopics")
    public String getList(StudentGetTopicsRequest request, HttpServletRequest httpServletRequest) {
        request.setStudentId(httpServletRequest.getSession().getAttribute("cellphone").toString());
        List<StudentTopicVO> topics = studentTopicService.getTopics(request);
        httpServletRequest.setAttribute("topics", topics);
        return "student/stuTopicList";//选题页面
    }

    @RequestMapping("/student/toOperate")
    public String toOperate(HttpServletRequest request) {
        request.setAttribute("topicId", request.getParameter("topicId"));
        return "student/stuSelectTopic";
    }

    /**
     * 选课题
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/student/select")
    public String selectTopic(HttpServletRequest httpServletRequest) {
        String topicId = httpServletRequest.getParameter("topicId");
        String status = httpServletRequest.getParameter("status");
        String cellphone = (String) httpServletRequest.getSession().getAttribute("cellphone");
        String reason = httpServletRequest.getParameter("comment");
        BaseResponse baseResponse = studentTopicService.selectTopic(topicId, status, cellphone, reason);
        if (baseResponse.getStatus().equals("0")) {
            httpServletRequest.setAttribute("success", "成功");
        } else {
            httpServletRequest.setAttribute("error", "失败");
        }
        return "redirect:/student/getTopics";
    }

    /**
     * 退选
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/student/quit")
    public String quitTopic(HttpServletRequest httpServletRequest) {
        String topicId = httpServletRequest.getParameter("topicId");
        String cellphone = (String) httpServletRequest.getSession().getAttribute("cellphone");
        String reason = (String) httpServletRequest.getSession().getAttribute("reason");
        int result = studentTopicService.quitTopic(topicId, cellphone, reason);
        if (result == 1) {
            httpServletRequest.setAttribute("success", "审核成功");
        } else {
            httpServletRequest.setAttribute("error", "审核失败");
        }
        return "redirect:/student/getTopics";
    }

}
