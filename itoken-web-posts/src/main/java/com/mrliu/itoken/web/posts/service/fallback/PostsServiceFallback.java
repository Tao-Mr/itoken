package com.mrliu.itoken.web.posts.service.fallback;

import com.mrliu.itoken.common.hystrix.FallBack;
import com.mrliu.itoken.web.posts.service.PostsService;
import javafx.geometry.Pos;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.posts.service.fallback
 * @Description: java类作用描述
 * @UpdateRemark: 更新说明
 */
@Component
public class PostsServiceFallback implements PostsService {
    @Override
    public String page(int pageNum, int pageSize, String tbPostsPostJson) {
        return FallBack.badGetway();
    }

    @Override
    public String get(String postGuid) {
        return null;
    }

    @Override
    public String save(String tbPostsPostJson, String optsBy) {
        return FallBack.badGetway();
    }

    @Override
    public String delete(String tbPostsPostJson, String optBy) {
        return null;
    }
}
