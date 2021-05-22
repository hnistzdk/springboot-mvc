package cn.zdk.webdemo.controller;

import cn.zdk.webdemo.mapper.DepartmentMapper;
import cn.zdk.webdemo.mapper.EmployeeMapper;
import cn.zdk.webdemo.pojo.Department;
import cn.zdk.webdemo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author zdk
 * @date 2021/5/22 11:51
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/employees")
    public String list(Model model){
        Collection<Employee> employees = employeeMapper.getAll();
        model.addAttribute("employees",employees);
        return "employee/list";
    }

    @GetMapping("/employee")
    public String toAdd(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("departments",departments);
        return "/employee/add";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        System.out.println("employee:"+employee);
        employeeMapper.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable Integer id,Model model){
        System.out.println("id：："+id);
        Employee employee = employeeMapper.getEmployeeById(id);
        System.out.println("employee"+employee);
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("employee",employee);
        model.addAttribute("departments",departments);
        return "employee/update";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        System.out.println("employee:"+employee);
        employeeMapper.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String delete(@PathVariable Integer id){
        employeeMapper.deleteEmployeeById(id);
        return "redirect:/employees";
    }

}
