package com.wen.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wen
 * @since 2021-10-03
 */
@Getter
@Setter
@TableName("t_joblevel")
@ApiModel(value = "Joblevel对象", description = "")
public class Joblevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("职称名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("职称等级")
    @TableField("titleLevel")
    private String titleLevel;

    @ApiModelProperty("创建时间")
    @TableField("createDate")
    private LocalDateTime createDate;

    @ApiModelProperty("是否启用")
    @TableField("enabled")
    private Boolean enabled;


}
