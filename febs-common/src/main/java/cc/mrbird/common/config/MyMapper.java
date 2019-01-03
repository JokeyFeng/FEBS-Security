package cc.mrbird.common.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author yiheni
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
	
}