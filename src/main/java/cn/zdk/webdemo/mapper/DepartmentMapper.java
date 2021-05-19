package cn.zdk.webdemo.mapper;

import cn.zdk.webdemo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdk
 * @date 2021/5/19 21:22
 */
@Repository
public class DepartmentMapper {
    private static Map<Integer, Department> departments=null;
    static {
        departments=new HashMap<>();
        departments.put(101,new Department(101,"教学部") );
        departments.put(102,new Department(102,"市场部") );
        departments.put(103,new Department(103,"后勤部") );
        departments.put(104,new Department(104,"教研部") );
        departments.put(105,new Department(105,"运营部") );
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartment(Integer id){
        return departments.get(id);
    }

}
