package com.manji.desystem.service;

import com.alibaba.fastjson.JSONArray;
import com.manji.desystem.common.result.BaseObjectResult;
import com.manji.desystem.common.result.BaseResult;

public interface FeignSystemService {

    BaseResult insertRole(String roleName, int[] menuId) throws Exception;

    BaseObjectResult<Object> findRoles(int pageNum, int pageSize) throws Exception;

    BaseResult updateRoles(int roleId, String roleName, int[] menuId, int[] delMenuId) throws Exception;

    BaseObjectResult<Object> findMenuByRoleId(int roleId) throws Exception;

    BaseObjectResult<Object> findMenus() throws Exception;

}