package cn.zdk.webdemo.mapper;

import cn.zdk.webdemo.pojo.Department;
import cn.zdk.webdemo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdk
 * @date 2021/5/19 21:22
 */
@Repository
public class EmployeeMapper {
    private static Map<Integer, Employee> employees=null;
    @Autowired
    private static DepartmentMapper departmentMapper;
    static {
        employees=new HashMap<>();
        employees.put(101,new Employee(1001,"AA","369365576@qq.com",1,departmentMapper.getDepartment(101)));
        employees.put(102,new Employee(1001,"AA","369365576@qq.com",1,departmentMapper.getDepartment(102)));
        employees.put(103,new Employee(1001,"AA","369365576@qq.com",1,departmentMapper.getDepartment(103)));
        employees.put(104,new Employee(1001,"AA","369365576@qq.com",1,departmentMapper.getDepartment(104)));
        employees.put(105,new Employee(1001,"AA","369365576@qq.com",1,departmentMapper.getDepartment(105)));
    }

    public Collection<Employee> getDepartments(){
        return employees.values();
    }

    public Employee getDepartment(Integer id){
        return employees.get(id);
    }
}
