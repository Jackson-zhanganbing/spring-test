package com.zab.springboot.common.async.mapper;

import com.zab.springboot.common.async.entity.AsyncTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 异步任务表 Mapper 接口
 * </p>
 *
 * @author zab
 * @since 2022-12-11
 */
public interface AsyncTaskMapper extends BaseMapper<AsyncTask> {

    void updateByTaskNo(@Param("taskNo") String taskNo, @Param("status") Integer status);
}
