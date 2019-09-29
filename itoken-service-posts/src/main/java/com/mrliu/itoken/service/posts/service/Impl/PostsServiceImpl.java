package com.mrliu.itoken.service.posts.service.Impl;

import com.mrliu.itoken.common.domain.BaseDomain;
import com.mrliu.itoken.common.domain.TbPostsPost;
import com.mrliu.itoken.common.mapper.TbPostsPostMapper;
import com.mrliu.itoken.common.mapper.service.Impl.BaseServiceImpl;
import com.mrliu.itoken.service.posts.service.PostsService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.MyMapper;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.posts.service.Impl
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/6/3 17:55
 * @UpdateRemark: 更新说明
 */
@Service
public class PostsServiceImpl extends BaseServiceImpl<TbPostsPost, TbPostsPostMapper> implements PostsService {
}
