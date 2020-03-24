package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.DepTopicVO;
import com.system.yyn.topicsystem.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName : DepartmentController
 * @Description :系主任
 */
@Controller
public class DepartmentController {

    @Resource
    private TopicService topicService;

    /**
     * 获取课题列表，审核
     *
     * @param request
     * @return
     */
    @RequestMapping("/dep/queryTopics")
    public String queryTopicList(HttpServletRequest request) {
        String status = request.getParameter("status");
        List<DepTopicVO> depTopics = topicService.getDepTopics(status);
        request.setAttribute("topics", depTopics);
        return "dep/depTopicList";
    }

    /**
     * 课题审核
     *
     * @param request
     * @return
     */
    @RequestMapping("/dep/checkTopic")
    public String checkTopic(HttpServletRequest request) {
        String topicId = request.getParameter("topicId");
        String type = request.getParameter("type");
        String comment = request.getParameter("comment");

        Topic topic = new Topic();
        topic.setTopicId(Long.parseLong(topicId));
        topic.setStatus(type);
        topic.setComment(comment);
        int result = topicService.checkTopic(topic);
        if (result == 1) {
            request.setAttribute("success", "审核成功");
        } else {
            request.setAttribute("error", "审核失败");
        }
        return "redirect:/dep/queryTopics";
    }


}
