package com.mrliu.itoken.service.posts.controller;

import com.github.pagehelper.PageInfo;
import com.mrliu.itoken.common.domain.TbPostsPost;
import com.mrliu.itoken.common.dto.BaseResult;
import com.mrliu.itoken.common.utils.MapperUtils;
import com.mrliu.itoken.service.posts.service.PostsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.posts.controller
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/6/3 18:03
 * @UpdateRemark: 更新说明
 */
@RestController
@RequestMapping(value = "v1/posts")
public class PostsController {
    @Autowired
    private PostsService postPostsService;

    /**
     * 保存文章信息（新增和更新）
     *
     * @param tbPostsPostJson
     * @param optBy
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResult save(String tbPostsPostJson, String optBy) {
        int result = 0;

        TbPostsPost tbPostsPost = null;
        try {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (tbPostsPost != null) {
            tbPostsPost.setUpdateBy(optBy);
            tbPostsPost.setUpdateDate(new Date());
            //判断新增还是更新
            if (StringUtils.isBlank(tbPostsPost.getPostGuid())) {
                tbPostsPost.setPostGuid(UUID.randomUUID().toString());
                result = postPostsService.insert(tbPostsPost, optBy);
            } else {
                result = postPostsService.update(tbPostsPost, optBy);
            }
            // 最少有一行数据受影响
            if (result > 0) {
                return BaseResult.ok("保存文章成功");
            }
        }
        return BaseResult.ok("保存文章失败");
    }

    /**
     * 彻底删除文章信息
     *
     * @param tbPostsPostJson
     * @param optBy
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public BaseResult deleteByGuuid(String tbPostsPostJson, String optBy) {
        int result = 0;
        TbPostsPost tbPostsPost = null;
        try {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (tbPostsPost != null) {
            result = postPostsService.delete(tbPostsPost);
            return BaseResult.ok("彻底删除文章成功");
        }
        List<BaseResult.Error> errorList = null;
        BaseResult.Error error = new BaseResult.Error("", "彻底删除文章失败，未能正确获取此文章信息！！");
        errorList.add(error);
        return BaseResult.notok(errorList);
    }

    /**
     * 根据Guuid查询单个文章信息
     *
     * @param postsGuuid
     * @return
     */
    @RequestMapping(value = "{postsGuuid}")
    public BaseResult get(@PathVariable(value = "postsGuuid") String postsGuuid) {
        TbPostsPost tbPostsPost = new TbPostsPost();
        tbPostsPost.setPostGuid(postsGuuid);
        TbPostsPost obj = postPostsService.selectOne(tbPostsPost);
        //判断一下查询结果，标题为空返回失败
        if (obj.equals(null)) {
            List<BaseResult.Error> errorList = null;
            BaseResult.Error error = new BaseResult.Error("", "无此文章信息！");
            errorList.add(error);
            return BaseResult.notok(errorList);
        } else {
            return BaseResult.ok(tbPostsPost);
        }
    }
    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param tbPostsPostJson
     * @return
     */
    @RequestMapping(value = "page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public BaseResult page(
            @PathVariable(required = true) int pageNum,
            @PathVariable(required = true) int pageSize,
            @RequestParam(required = false) String tbPostsPostJson
    ) throws Exception {

        TbPostsPost tbPostsPost = null;
        if (tbPostsPostJson != null) {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        }
        PageInfo pageInfo = postPostsService.page(pageNum, pageSize, tbPostsPost);

        // 分页后的结果集
        List<TbPostsPost> list = pageInfo.getList();

        // 封装 Cursor 对象
        BaseResult.Cursor cursor = new BaseResult.Cursor();
        cursor.setTotal(new Long(pageInfo.getTotal()).intValue());
        cursor.setOffset(pageInfo.getPageNum());
        cursor.setLimit(pageInfo.getPageSize());
        return BaseResult.ok(list, cursor);
    }

}
