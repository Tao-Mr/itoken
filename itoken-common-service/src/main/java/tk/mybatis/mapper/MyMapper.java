package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ProjectName: itoken
 * @Package: tk.mybatis.mapper
 * @Description: 主要作用是让 DAO 层的接口继承该接口，以达到使用 tk.mybatis 的目的
 * @Date: 2019/4/19 16:16
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
