package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.business.request.GetTopicListRequest;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.TopicVO;
import com.system.yyn.topicsystem.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName : CommonController
 * @Description : 公共方法
 */
@Controller
public class CommonController {

    @Resource
    private TopicService topicService;

    /**
     * 查看历届选题
     *
     * @param request
     * @return
     */
    @RequestMapping("/getHistoryTopics")
    public String getHistoryTopics(GetTopicListRequest getTopicListRequest , HttpServletRequest request) {

        List<TopicVO> topicList = topicService.getTopicList(getTopicListRequest);
        request.setAttribute("topics",topicList);
        return "topicHisList";
    }

    /**
     * 获取课题信息
     *
     * @param topic
     * @param request
     * @return
     */
    public String getTopicInfo(Topic topic, HttpServletRequest request) {
        Topic topicInfo = topicService.getTopicInfo(topic.getTopicId() + "");
        request.setAttribute("topic",topicInfo);
        return "topicHisList";
    }

}
