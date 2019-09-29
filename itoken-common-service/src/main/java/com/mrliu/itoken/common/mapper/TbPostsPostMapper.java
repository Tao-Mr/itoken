package com.mrliu.itoken.common.mapper;

import com.mrliu.itoken.common.domain.TbPostsPost;
import com.mrliu.itoken.common.utils.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.mapper.MyMapper;

@CacheNamespace(implementation = RedisCache.class)
public interface TbPostsPostMapper extends MyMapper<TbPostsPost> {
}