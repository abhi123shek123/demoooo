package com.vocalink.demo.service;

import com.vocalink.demo.exception.EmployeeAlreadyPresentException;
import com.vocalink.demo.exception.NoEmployeePresentException;
import com.vocalink.demo.model.Employee;
import com.vocalink.demo.model.EmployeeDTO;
import com.vocalink.demo.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService/* , UserDetailsService */ {

    @Autowired
    private EmployeeDao employeeDao;

	/*
	 * @Autowired private PasswordEncoder bcryptEncoder;
	 */

    @Override
    public String saveEmployeeDetails(EmployeeDTO employee) throws EmployeeAlreadyPresentException {
        if(!employeeDao.existsById(employee.getEmpId())) {
            Employee newEmp = new Employee();
            //newEmp.setPassword(bcryptEncoder.encode(employee.getPassword()));
            newEmp.setPassword(employee.getPassword());
            newEmp.setEmail(employee.getEmail());
            newEmp.setEmpId(employee.getEmpId());
            newEmp.setEmpName(employee.getEmpName());
            newEmp.setSalary(employee.getSalary());
            employeeDao.save(newEmp);
            return "Employee details saved successfully!";
        } else
            throw new EmployeeAlreadyPresentException("Employee already exists!");
    }

    @Override
    public Optional<Employee> getEmployeeDetails(Integer empId) {
        return employeeDao.findById(empId);
    }
    
    @Override
    public List<Employee> getEmployeeDetailsList() {
        return employeeDao.findAll();
    }

	@Override
    public String updateEmployeeDetails(EmployeeDTO employee) throws NoEmployeePresentException {
        Employee existingEmployee = employeeDao.findById(employee.getEmpId()).orElse(null);
        if(null != existingEmployee) {
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setSalary(employee.getSalary());
            employeeDao.save(existingEmployee);
            return "Employee details updated successfully!";
        } else
            throw new NoEmployeePresentException("Employee not found");
    }

    @Override
    public String removeEmployeeDetails(Integer empId) {
        employeeDao.deleteById(empId);
        return "Employee details deleted successfully!";
    }
	
	/*
	 * @Override public UserDetails loadUserByUsername(String email) throws
	 * UsernameNotFoundException { Employee employee =
	 * employeeDao.findByEmail(email); if (employee == null) { throw new
	 * UsernameNotFoundException("User not found with username: " + email); } return
	 * new org.springframework.security.core.userdetails.User(employee.getEmail(),
	 * employee.getPassword(), new ArrayList<>()); }
	 */

}
