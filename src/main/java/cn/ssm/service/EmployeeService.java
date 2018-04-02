package cn.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ssm.bean.Employee;
import cn.ssm.bean.EmployeeExample;
import cn.ssm.bean.EmployeeExample.Criteria;
import cn.ssm.dao.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper; 
	/**
	 * 查询所有员工（分页查询）
	 * @return
	 */
	public List<Employee> getAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}
	/**
	 * 保存员工
	 * @param employee
	 */
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}
	/**
	 * 校验用户名是否被占用
	 * @param empName
	 * @return
	 */
	public boolean checkuser(String empName) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		return employeeMapper.countByExample(example) == 0;
	}
	/**
	 * 修改员工信息的时候用于数据回显
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		 Employee employee = employeeMapper.selectByPrimaryKey(id);
		 return employee;
	}
	/**
	 * 修改员工信息的提交
	 * @param id
	 */
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	/**
	 * 删除员工信息
	 * @param id
	 */
	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除员工
	 * @param strIds
	 */
	public void deleteBatchEmp(List<Integer> ids) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(ids);
		//delete from xxx where emp_id in (1,2,3);
		employeeMapper.deleteByExample(example);
	}
}
