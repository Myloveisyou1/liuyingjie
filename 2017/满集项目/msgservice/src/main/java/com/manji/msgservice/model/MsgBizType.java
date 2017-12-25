package com.manji.msgservice.model;

import io.swagger.annotations.ApiModelProperty;

public class MsgBizType {
    /**
     * 业务类型ID
     *
     * @mbggenerated
     */
    private Long typeTypeId;

    /**
     * 业务类型名
     *
     * @mbggenerated
     */
    private String typeName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column msg_biz_type.type_type_id
     *
     * @return the value of msg_biz_type.type_type_id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务类型ID")
    public Long getTypeTypeId() {
        return typeTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column msg_biz_type.type_type_id
     *
     * @param typeTypeId the value for msg_biz_type.type_type_id
     *
     * @mbggenerated
     */
    public void setTypeTypeId(Long typeTypeId) {
        this.typeTypeId = typeTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column msg_biz_type.type_name
     *
     * @return the value of msg_biz_type.type_name
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务类型名")
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column msg_biz_type.type_name
     *
     * @param typeName the value for msg_biz_type.type_name
     *
     * @mbggenerated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}