package my.suveng.rss.modules.artitcle.entity;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.Date;
import java.util.List;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/29
 * description:
 **/
@Data
public class Channel {
    private String title;
    private String description;
    private String copyright;
    private Date lastBuildDate;
    private List<ArticleList> item;
}
