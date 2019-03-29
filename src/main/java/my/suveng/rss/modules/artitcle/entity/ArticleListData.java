package my.suveng.rss.modules.artitcle.entity;

import lombok.Data;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/29
 * description:
 **/
@Data
public class ArticleListData {
        private Info info=new Info();
        private Channel channel;

}
