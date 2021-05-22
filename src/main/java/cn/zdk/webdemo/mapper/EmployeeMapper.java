package cn.zdk.webdemo.mapper;

import cn.zdk.webdemo.pojo.Department;
import cn.zdk.webdemo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    private DepartmentMapper departmentMapper;
    static {
        employees=new HashMap<>();
        employees.put(1001,new Employee(1001,"AA","369365576@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","369365576@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","369365576@qq.com",0,new Department(103,"后勤部")));
        employees.put(1004,new Employee(1004,"DD","369365576@qq.com",1,new Department(104,"教研部")));
        employees.put(1005,new Employee(1005,"EE","369365576@qq.com",1,new Department(105,"运营部")));
    }

    public Collection<Employee> getDepartments(){
        return employees.values();
    }

    public Employee getDepartment(Integer id){
        return employees.get(id);
    }

    private static Integer initId=1006;

    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentMapper.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }
}
