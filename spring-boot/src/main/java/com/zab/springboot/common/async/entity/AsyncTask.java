package com.zab.springboot.common.async.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 异步任务表
 * </p>
 *
 * @author zab
 * @since 2022-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_async_task")
public class AsyncTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务编号
     */
    private String taskNo;

    /**
     * 任务code
     */
    private String taskCode;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件地址
     */
    private String fileUrl;

    /**
     * 任务名称
     */
    private Integer fileSize;

    /**
     * 任务执行状态：0：new，1：running，2：done
     */
    private Integer status;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
