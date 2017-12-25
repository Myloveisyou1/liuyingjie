package com.manji.desystem.feignInterface;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.manji.desystem.dao.account.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/10/13.
 */

@FeignClient(value = "uservice")
public interface LoginInterface {
    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @param code
     * @param sign
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    Account login(@RequestParam("username") String userName, @RequestParam("password") String password, @RequestParam("code") String code, @RequestParam("sign") String sign);

    /**
     * 校验用户有效性
     *
     * @param sessionId
     * @return
     */
    @RequestMapping(value = "/user/logins")
    Account checkUser(@RequestParam("sessionId") String sessionId);

    /**
     * 查询所有部门
     *
     * @return
     */
    @RequestMapping(value = "/dept/findAllDept")
    JSONArray findAllDept();

    /**
     * 根据姓名查询
     *
     * @param realName
     * @return
     */
    @RequestMapping(value = "/user/findUserByName")
    JSONArray findByName(@RequestParam("name") String realName);

    /**
     * 查询处理人
     *
     * @param userId
     * @param path
     * @return
     */
    @RequestMapping(value = "/user/findExamineUser")
    JSONArray findExaminePeople(@RequestParam("userId") String userId, @RequestParam("path") String path);

    /**
     * 通过部门查询全部用户信息
     *
     * @param deptId
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @RequestMapping(value = "/dept/findUserByDeptId", method = RequestMethod.GET)
    JSONObject findUserByDeptId(@RequestParam("dept_id") int deptId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("name") String name);

    /**
     * 根据用户id查询部门信息
     *
     * @param personId
     * @return
     */
    @RequestMapping(value = "/dept/findDeptNameByUserId")
    JSONArray findByUserId(@RequestParam("userId") int personId);

    /**
     * 添加角色
     *
     * @param dept_id
     * @param role_name
     * @param project
     * @return
     */
    @RequestMapping(value = "/role/insertRole", method = RequestMethod.GET)
    boolean insertRole(@RequestParam("dept_id") int dept_id, @RequestParam("role_name") String role_name, @RequestParam("pjt_code") String project);

    /**
     * 通过部门和角色名称查询角色
     *
     * @param dept_id
     * @param role_name
     * @return
     */
    @RequestMapping(value = "/role/findRoleBydeptandname", method = RequestMethod.GET)
    JSONObject findRoleBydeptandname(@RequestParam("dept_id") int dept_id, @RequestParam("role_name") String role_name);

    /**
     * 角色绑定权限
     *
     * @param roleId
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/menu/insertRoleMenu", method = RequestMethod.GET)
    boolean insertRoleMenu(@RequestParam("roleId") int roleId, @RequestParam("menuId") int[] menuId);

    /**
     * 校验此角色是否已经存在
     *
     * @param dept_id
     * @param role_name
     * @return
     */
    @RequestMapping(value = "/role/findRoleBydeptandnameCount", method = RequestMethod.GET)
    int findRoleBydeptandnameCount(@RequestParam("dept_id") int dept_id, @RequestParam("role_name") String role_name);

    /**
     * 查询全部角色信息
     *
     * @param dept_id
     * @return
     */
    @RequestMapping(value = "/role/findRoleByDept", method = RequestMethod.GET)
    JSONObject findRoleByDept(@RequestParam("dept_id") int dept_id, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 修改角色名称
     *
     * @param roleId
     * @param roleName
     * @return
     */
    @RequestMapping(value = "/role/updateRole")
    boolean updateRole(@RequestParam("roleId") int roleId, @RequestParam("roleName") String roleName);

    /**
     * 删除权限
     *
     * @param roleId
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/menu/deleteRoleMenu")
    boolean deleteMenuById(@RequestParam("roleId") int roleId, @RequestParam("menuId") int[] menuId);

    /**
     * 根据角色查询权限
     *
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/menu/findMenuByRoleId")
    JSONArray findMenuByRoleId(@RequestParam("roleId") int roleId);

    /**
     * 通过项目code查询项目下全部权限
     *
     * @param pjt_code
     * @return
     */
    @RequestMapping(value = "/menu/findMenus", method = RequestMethod.GET)
    JSONArray findMenus(@RequestParam("pjt_code") String pjt_code);


}
