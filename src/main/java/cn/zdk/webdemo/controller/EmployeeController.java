package cn.zdk.webdemo.controller;

import cn.zdk.webdemo.mapper.EmployeeMapper;
import cn.zdk.webdemo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author zdk
 * @date 2021/5/22 11:51
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;
    @RequestMapping("/employees")
    public String list(Model model){
        Collection<Employee> employees = employeeMapper.getAll();
        model.addAttribute("employees",employees);
        return "employee/list";
    }
}
