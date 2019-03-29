package my.suveng.rss.controller.source;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import my.suveng.rss.common.response.Result;
import my.suveng.rss.common.response.ResultBuilder;
import my.suveng.rss.common.response.ResultEnums;
import my.suveng.rss.modules.source.dao.SourceRepository;
import my.suveng.rss.modules.source.entity.Source;
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
    @ApiOperation(value = "添加测试数据", httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200, message = "统一返回对象", response = Result.class)})
    public Result addTestData(String source){
        List<Source> sources = JSON.parseArray(source, Source.class);
        for (Source s : sources){
            sourceRepository.save(s);
        }
        return ResultBuilder.buildSimpleSuccessResult();
    }

    /**
     * 推荐源列表
     * @return result
     */
    @RequestMapping("/getList")
    @ApiOperation(value = "获取推荐源列表", httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200, message = "统一返回对象", response = Result.class)})
    public Result getList(){
        List<Source> all = sourceRepository.findAll();
        return ResultBuilder.build(ResultEnums.SIMPLE_SUCCESS,all);
    }
}
