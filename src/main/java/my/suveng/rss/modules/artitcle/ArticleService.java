package my.suveng.rss.modules.artitcle;

import com.alibaba.fastjson.JSON;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import my.suveng.rss.modules.artitcle.entity.ArticleList;
import my.suveng.rss.modules.artitcle.entity.ArticleListData;
import my.suveng.rss.modules.artitcle.entity.Channel;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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
@Service
public class ArticleService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 重新从rss中获取
     *
     * @param rssUrl rss订阅源
     *
     * @return ArticleListData
     */
    public ArticleListData getArticleListData(String rssUrl) {

        ArticleListData articleListData;
        articleListData = new ArticleListData();
        try (XmlReader reader = new XmlReader(new URL(rssUrl))) {
            SyndFeed feed = new SyndFeedInput().build(reader);
            List<SyndEntry> entries = feed.getEntries();

            Channel channel = new Channel();
            channel.setTitle(feed.getTitle());
            channel.setCopyright(feed.getCopyright());
            channel.setDescription(feed.getDescription());
            channel.setLastBuildDate(feed.getPublishedDate());

            List<ArticleList> item = new ArrayList<>();
            for (SyndEntry s :
                    entries) {
                ArticleList e = new ArticleList();
                e.setLink(s.getLink());
                e.setTitle(s.getTitle());
                e.setPubDate(s.getPublishedDate());
                e.setDescription(s.getDescription().getValue());
                item.add(e);
            }
            channel.setItem(item);
            articleListData.setChannel(channel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stringRedisTemplate.opsForValue().set(rssUrl, JSON.toJSONString(articleListData), TimeUnit.HOURS.toSeconds(12));
        return articleListData;
    }
}
