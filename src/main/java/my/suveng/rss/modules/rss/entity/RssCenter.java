package my.suveng.rss.modules.rss.entity;

import lombok.Data;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/22
 * description: rss订阅源
 **/
@Data
public class RssCenter {
    private String title;
    private String link;
    private String description;
    private String favicon;
    private String rssUrl;
 }
