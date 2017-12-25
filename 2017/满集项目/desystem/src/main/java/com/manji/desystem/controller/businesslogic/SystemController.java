package com.manji.desystem.controller.businesslogic;

import com.manji.desystem.common.result.BaseObjectResult;
import com.manji.desystem.common.result.BaseResult;
import com.manji.desystem.controller.interceptor.LoginAuth;
import com.manji.desystem.service.FeignSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/api-system", description = "系统设置")
@RequestMapping(value = "/system")
public class SystemController {

    @Autowired
    private FeignSystemService feignSystemService;

    @LoginAuth
    @ApiOperation(value = "新增角色")
    @GetMapping(value = "/addRoles")
    public BaseResult addRoles(@RequestParam(value = "roleName") String roleName, @RequestParam("menuId") int[] menuId, @RequestParam("sessionId") String sessionId) throws Exception {

        BaseResult baseResult = feignSystemService.insertRole(roleName, menuId);

        return baseResult;
    }

    @ApiOperation(value = "查询全部角色")
    @GetMapping(value = "/findRoles")
    public BaseObjectResult<Object> findRoles(@RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize) throws Exception {

        BaseObjectResult<Object> baseResult = feignSystemService.findRoles(pageNumber, pageSize);

        return baseResult;
    }

    @LoginAuth
    @ApiOperation(value = "修改角色权限")
    @PostMapping(value = "/updateRoles")
    public BaseResult updateRoles(@RequestParam("roleId") int roleId, @RequestParam("roleName") String roleName, @RequestParam("menuId") int[] menuId, @RequestParam(value = "delMenuId") int[] delMenuId, @RequestParam("sessionId") String sessionId) throws Exception {

        BaseResult baseResult = feignSystemService.updateRoles(roleId, roleName, menuId, delMenuId);

        return baseResult;

    }

    @LoginAuth
    @ApiOperation(value = "查询某个角色的权限")
    @GetMapping(value = "/findMenuByRoleId")
    public BaseObjectResult<Object> findMenuByRoleId(@RequestParam("roleId") int roleId, @RequestParam("sessionId") String sessionId) throws Exception {

        BaseObjectResult<Object> result = feignSystemService.findMenuByRoleId(roleId);
        return result;

    }

    @ApiOperation(value = "查询全部权限")
    @GetMapping(value = "/Menus")
    public BaseObjectResult<Object> findMenus() throws Exception {

        BaseObjectResult<Object> result = feignSystemService.findMenus();

        return result;

    }


}
