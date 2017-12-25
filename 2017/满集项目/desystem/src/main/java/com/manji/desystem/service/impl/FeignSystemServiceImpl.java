package com.manji.desystem.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.manji.desystem.common.config.Configure;
import com.manji.desystem.common.enums.ErrorCodeEnums;
import com.manji.desystem.common.exception.BusinessDealException;
import com.manji.desystem.common.result.BaseObjectResult;
import com.manji.desystem.common.result.BaseResult;
import com.manji.desystem.feignInterface.LoginInterface;
import com.manji.desystem.service.FeignSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignSystemServiceImpl implements FeignSystemService {

    @Autowired
    private LoginInterface loginInterface;

    private Integer deptId = Integer.parseInt(Configure.getDeptId());
    private String code = Configure.getCode();

    @Override
    public BaseResult insertRole(String roleName, int[] menuId) throws Exception {

        BaseResult baseResult = new BaseResult(ErrorCodeEnums.Success.getCode(), "新增成功");

        int roleCount = loginInterface.findRoleBydeptandnameCount(deptId, roleName);
        if (roleCount > 0) {
            throw new BusinessDealException("角色已存在!");
        }

        boolean isokrole = loginInterface.insertRole(deptId, roleName, code);//添加角色
        if (isokrole) {
            throw new BusinessDealException("添加角色失败!");
        }

        JSONObject deptNameObject = loginInterface.findRoleBydeptandname(deptId, roleName);//获取刚才添加的角色
        if (menuId.length != 0) {
            boolean isok = loginInterface.insertRoleMenu(deptNameObject.getInteger("id"), menuId);//角色绑定权限
            if (!isok) {
                throw new BusinessDealException("绑定权限失败!");
            }
        }

        return baseResult;
    }

    @Override
    public BaseObjectResult<Object> findRoles(int pageNum, int pageSize) throws Exception {

        BaseObjectResult<Object> baseResult = new BaseObjectResult<Object>(ErrorCodeEnums.Success.getCode(), "查询成功");

        JSONObject jsonArray = loginInterface.findRoleByDept(deptId, pageNum, pageSize);
        baseResult.setResult(jsonArray);

        return baseResult;
    }

    @Override
    public BaseResult updateRoles(int roleId, String roleName, int[] menuId, int[] delMenuId) throws Exception {

        BaseResult baseResult = new BaseResult(ErrorCodeEnums.Success.getCode(), "修改成功");

        boolean updFlag = loginInterface.updateRole(roleId, roleName);
        if (!updFlag) {
            throw new BusinessDealException("修改角色失败!");
        }

        //删除该权限
        boolean delFlag = loginInterface.deleteMenuById(roleId, delMenuId);

        boolean addFlag = loginInterface.insertRoleMenu(roleId, menuId);

        if (delFlag != true || addFlag != true) {
            throw new BusinessDealException("修改权限失败!");
        }

        return baseResult;
    }

    @Override
    public BaseObjectResult<Object> findMenuByRoleId(int roleId) throws Exception{

        BaseObjectResult<Object> baseResult = new BaseObjectResult<Object>(ErrorCodeEnums.Success.getCode(), "查询成功");

        JSONArray back = loginInterface.findMenuByRoleId(roleId);
        baseResult.setResult(back);


        return baseResult;
    }

    @Override
    public BaseObjectResult<Object> findMenus() throws Exception {

        BaseObjectResult<Object> baseResult = new BaseObjectResult<Object>(ErrorCodeEnums.Success.getCode(), "查询成功");

        JSONArray jsonArray=loginInterface.findMenus(code);
        baseResult.setResult(jsonArray);

        return baseResult;
    }

}