package com.camellia.controller;

import com.camellia.pojo.Address;
import com.camellia.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Datetime: 2024/6/30下午4:40
 * @author: Camellia.xioahua
 */

@RestController
public class ResponseController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World");
        return "Hello World";
    }

    @RequestMapping("/getAddr")
    public Address getAddr() {
        Address address = new Address();
        address.setProvince("浙江");
        address.setCity("杭州");
        return address;
    }

    @RequestMapping("/listAddr")
    public List<Address> listAddr() {
        List<Address> list = new ArrayList<Address>();
        Address address1 = new Address();
        address1.setProvince("江苏");
        address1.setCity("南京");
        Address address2 = new Address();
        address2.setProvince("浙江");
        address2.setCity("杭州");
        list.add(address1);
        list.add(address2);
        return list;
    }

    /**
     * 同一响应结果封装类
     */
    @RequestMapping("/helloResult")
    public Result helloResult() {
        System.out.println("Hello World");
        return Result.success("Hello World");
    }

    @RequestMapping("/getAddrResult")
    public Result getAddrResult() {
        Address address = new Address();
        address.setProvince("浙江");
        address.setCity("杭州");
        return Result.success(address);
    }

    @RequestMapping("/listAddrResult")
    public Result listAddrResult() {
        List<Address> list = new ArrayList<Address>();
        Address address1 = new Address();
        address1.setProvince("江苏");
        address1.setCity("南京");
        Address address2 = new Address();
        address2.setProvince("浙江");
        address2.setCity("杭州");
        list.add(address1);
        list.add(address2);
        return Result.success(list);
    }

}
