package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.DepTopicVO;
import com.system.yyn.topicsystem.service.TopicService;
import org.apache.commons.lang3.StringUtils;
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
        String cellphone = request.getParameter("cellphone");
        if(StringUtils.isNotBlank(cellphone)){
            cellphone = cellphone.trim();
        }
        List<DepTopicVO> depTopics = topicService.getDepTopics(status,cellphone);
        request.setAttribute("topics", depTopics);
        return "dep/depTopicList";
    }

    @RequestMapping("/dep/toCheck")
    public String toCheckPage(HttpServletRequest request) {
        String topicId = request.getParameter("topicId");
        Topic topicInfo = topicService.getTopicInfo(topicId);
        request.setAttribute("topic", topicInfo);
        return "dep/depCheckTopic";
    }

    /**
     * 课题审核
     *
     * @param topic
     * @param request
     * @return
     */
    @RequestMapping("/dep/checkTopic")
    public String checkTopic(Topic topic,HttpServletRequest request) {
        int result = topicService.checkTopic(topic);
        if (result == 1) {
            request.setAttribute("success", "审核成功");
        } else {
            request.setAttribute("error", "审核失败");
        }
        return "redirect:/dep/queryTopics";
    }


}
