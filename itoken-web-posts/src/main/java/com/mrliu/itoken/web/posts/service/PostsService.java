package com.mrliu.itoken.web.posts.service;

import com.mrliu.itoken.common.web.interceptor.service.BaseClientService;
import com.mrliu.itoken.web.posts.service.fallback.PostsServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.posts.service
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/6/17 9:59
 * @UpdateRemark: 更新说明
 */
@FeignClient(value = "itoken-service-posts", fallback = PostsServiceFallback.class)
public interface PostsService extends BaseClientService {

    @RequestMapping(value = "v1/posts/page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public String page(@PathVariable(required = true, value = "pageNum") int pageNum,
                       @PathVariable(required = true, value = "pageSize") int pageSize,
                       @RequestParam(required = false, value = "tbPostsPostJson") String tbPostsPostJson);


    @RequestMapping(value = "v1/posts/{postGuid}", method = RequestMethod.GET)
    public String get(@PathVariable(required = true, value = "postGuid") String postGuid);

    @RequestMapping(value = "v1/posts", method = RequestMethod.POST)
    public String save(@RequestParam(required = false, value = "tbPostsPostJson") String tbPostsPostJson,
                       @RequestParam(required = false, value = "optBy") String optBy);

    @RequestMapping(value = "v1/posts/delete", method = RequestMethod.POST)
    public String delete(@PathVariable(required = true, value = "postGuid") String tbPostsPostJson,
                         @PathVariable(required = true, value = "optBy")String optBy);
}
