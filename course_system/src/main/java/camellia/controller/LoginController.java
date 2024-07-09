package camellia.controller;

import camellia.pojo.Emp;
import camellia.service.EmpService;
import camellia.utils.JwtUtils;
import camellia.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Datetime: 2024/7/9上午9:33
 * @author: Camellia.xioahua
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登入：{}", emp);
        Emp emped = empService.getUsernameAndPassword(emp);

        //登入成功
        if(emped != null) {
            Map<String , Object> claims = new HashMap<>();
            claims.put("id", emp.getId());
            claims.put("name", emp.getName());
            claims.put("username", emp.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("登入用户名或密码错误");
    }

}
