package my.suveng.rss.controller.article;

import com.alibaba.fastjson.JSON;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.sun.javafx.scene.web.Debugger;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import my.suveng.rss.common.response.Result;
import my.suveng.rss.common.response.ResultBuilder;
import my.suveng.rss.common.response.ResultEnums;
import my.suveng.rss.modules.artitcle.ArticleService;
import my.suveng.rss.modules.artitcle.entity.ArticleList;
import my.suveng.rss.modules.artitcle.entity.ArticleListData;
import my.suveng.rss.modules.artitcle.entity.Channel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/29
 * description:
 **/
@Api(tags = {"阅读模块"})
@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getArticleList")
    public Result getArticleList(String rssUrl) {
        if (StringUtils.isBlank(rssUrl)) {
            return ResultBuilder.build(ResultEnums.ILLEGAL_ARGUMENT_ERROR, null);
        }
        // 清出末尾换行
        rssUrl = StringUtils.chomp(rssUrl);
        // 获取redis缓存，没有则重新从rss源获取
        String cs = stringRedisTemplate.opsForValue().get(rssUrl);
        ArticleListData articleListData = null;
        if (!StringUtils.isBlank(cs)) {
            articleListData = JSON.parseObject(cs, ArticleListData.class);
        } else {
            articleListData = articleService.getArticleListData(rssUrl);
        }
        //log.info("返回结果：【{}】", JSON.toJSONString(articleListData));
        return ResultBuilder.build(ResultEnums.SIMPLE_SUCCESS, articleListData);
    }


}
