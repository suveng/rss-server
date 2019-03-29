package my.suveng.rss.modules.artitcle.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/29
 * description:
 **/
@Data
public class ArticleList {
    private String title;
    private String link;
    private Date pubDate;
    private String description;
}
