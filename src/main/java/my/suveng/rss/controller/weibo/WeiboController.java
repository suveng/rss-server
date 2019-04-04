package my.suveng.rss.controller.weibo;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import my.suveng.rss.common.response.Result;
import my.suveng.rss.common.response.ResultBuilder;
import my.suveng.rss.common.response.ResultEnums;
import my.suveng.rss.modules.source.entity.Source;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/4/4
 * description: 微博订阅接口
 **/
@Api(tags = {"阅读模块"})
@RestController
@RequestMapping("/weibo")
@Slf4j
public class WeiboController {

    private final static String BASE_URL="http://cyjah.com:1200/weibo/user/" ;
    //http://ww1.sinaimg.cn/large/006jIRTegy1g1qzkifrm7j306404zjr7.jpg
    private final static String FAVICON="http://www.sina.com/favicon.ico";
    private static final String HTTPS_WEIBO_COM = "https://weibo.com";

    /**
     * 返回微博rss源
     * @param uid 微博用户id
     * @return result
     */
    @RequestMapping("/getWeiboSource")
    public Result getWeiboSource(String uid){
    //http://cyjah.com:1200/weibo/user/1195230310
        Source res = new Source();
        res.setTitle("微博:"+uid);
        res.setDescription("微博用户："+uid);
        res.setFavicon(FAVICON);
        res.setRssUrl(BASE_URL+uid);
        res.setLink(HTTPS_WEIBO_COM);
        return ResultBuilder.build(ResultEnums.SIMPLE_SUCCESS,res);
    }

}
