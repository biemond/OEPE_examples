package nl.amis.client;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

import nl.amis.model.hr.Department;

public class TestDepartment {

    public static void main(String[] asArgs) throws Throwable{
        NamedCache department = CacheFactory.getCache("Department");
        Department dept =  (Department) department.get(10);
        
        System.out.println("Name: "+dept.getDepartmentName());
    } 
}