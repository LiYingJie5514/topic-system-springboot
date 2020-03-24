package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.business.request.GetTopicListRequest;
import com.system.yyn.topicsystem.entity.po.Bulletin;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.TopicVO;
import com.system.yyn.topicsystem.service.BulletinService;
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
    @Resource
    private BulletinService bulletinService;

    /**
     * 查看历届选题
     *
     * @param request
     * @return
     */
    @RequestMapping("/common/getHistoryTopics")
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
    @RequestMapping("/common/getTopicInfo")
    public String getTopicInfo(Topic topic, HttpServletRequest request) {
        Topic topicInfo = topicService.getTopicInfo(topic.getTopicId() + "");
        request.setAttribute("topic",topicInfo);
        return "topicHisList";
    }

    /**
     * 公告列表
     * @param request
     * @return
     */
    @RequestMapping("/common/queryBulletins")
    public String toBulletinList(HttpServletRequest request){
        List<Bulletin> list = bulletinService.getList();
        request.setAttribute("bulletins",list);
        return "";//公告列表页面
    }

    @RequestMapping("/common/bulletinInfo")
    public String bulletinInfo(Bulletin bulletin,HttpServletRequest request){
        Bulletin select = bulletinService.select(bulletin);
        request.setAttribute("bulletin",select);
        return "";//公告展示页面
    }
}
