package my.suveng.rss.controller.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import my.suveng.rss.common.response.Result;
import my.suveng.rss.common.response.ResultBuilder;
import my.suveng.rss.common.response.ResultEnums;
import my.suveng.rss.modules.rss.dao.SourceRepository;
import my.suveng.rss.modules.rss.entity.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/28
 * description: RssController
 **/
@Api(tags = {"订阅源模块"})
@RestController
@RequestMapping("/source")
@Slf4j
public class SourceController {
    @Autowired
    private SourceRepository sourceRepository;

    @RequestMapping("/addTestData")
    public Result addTestData(String source){
        List<Source> sources = JSON.parseArray(source, Source.class);
        for (Source s : sources){
            sourceRepository.save(s);
        }
        return ResultBuilder.buildSimpleSuccessResult();
    }

    @RequestMapping("/getList")
    public Result getList(){
        List<Source> all = sourceRepository.findAll();
        return ResultBuilder.build(ResultEnums.SIMPLE_SUCCESS,all);
    }
}
