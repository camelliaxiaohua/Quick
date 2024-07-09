package camellia.controller;

import camellia.pojo.Dept;
import camellia.service.DeptService;
import camellia.utils.Result;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Datetime: 2024/7/5下午4:52
 * @author: Camellia.xioahua
 */
@Slf4j  //简化提供。
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门
     * @return
     */
    @GetMapping()
    public Result list() {
        log.info("查询所有部门数据");
        List<Dept> depts = deptService.list();
        if (depts != null && !depts.isEmpty()) {
            return Result.success(depts);
        } else {
            return Result.error("查询部门信息失败");
        }
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门：{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     */
    @PostMapping()
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：{}"+dept);
        int flag = deptService.insert(dept);
        if (flag>0){
            return Result.success(flag);
        }else{
            return Result.error("新增部门失败");
        }
    }


   @GetMapping("/{id}")
    public Result getId(@PathVariable Integer id) {
        Dept dept = deptService.SelectById(id);
        log.info("根据查询：{}",id);
        return Result.success(dept);
    }

    @PutMapping()
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        log.info("修改部门信息："+dept.toString());
        return Result.success();
    }



}
