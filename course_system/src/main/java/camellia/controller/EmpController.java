package camellia.controller;

import camellia.pojo.Emp;
import camellia.pojo.PageBean;
import camellia.service.EmpService;
import camellia.utils.Result;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @Datetime: 2024/7/5下午4:52
 * @author: Camellia.xioahua
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        PageBean pageBean = empService.page(page, pageSize,name, gender, begin, end);
        log.info("分页查询参数 {} {} {} {} {} {}",page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }


    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids")List<Integer> ids){
        log.info("批量删除操作：{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping()
    public Result save(@RequestBody Emp emp){
        log.info("新增员工{}",emp);
        empService.add(emp);
        return Result.success();
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable("id") Integer id){
        Emp emp = empService.selectById(id);
        return Result.success(emp);
    }

    @PutMapping()
    public Result update(@RequestBody Emp emp){
        log.info("更新的员工信息:{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
