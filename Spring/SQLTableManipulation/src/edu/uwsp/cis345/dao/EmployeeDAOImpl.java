package edu.uwsp.cis345.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import edu.uwsp.cis345.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	final String QUERY = "SELECT * FROM [CIS345_01_DAVIS_G].[dbo].[Employee] WHERE empId = ?";
	final String INSERT_QUERY = "insert into [CIS345_01_DAVIS_G].[dbo].[Employee] (empId, firstname, lastname, yearOfJoining) values (:empId, :firstname, :lastname, :yearOfJoining)";
	final String UPDATE_QUERY = "UPDATE [CIS345_01_DAVIS_G].[dbo].[Employee] SET lastname=:lastname WHERE empId=:empId";
	final String DELETE_QUERY= "delete from [CIS345_01_DAVIS_G].[dbo].[Employee] WHERE empId = ?";
	final String LIST_QUERY= "SELECT * FROM [CIS345_01_DAVIS_G].[dbo].[Employee]";
	
	private final RowMapper<Employee> employeeRowMapper = (resultSet, rowNum) ->{
		Employee employee = new Employee();
		employee.setEmpID(resultSet.getInt("empId"));
		employee.setFirstName(resultSet.getString("firstname"));
		employee.setLastName(resultSet.getString("lastname"));
		employee.setYearOfJoining(resultSet.getInt("yearOfJoining"));
		return employee;
	};
	
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
    
    @Autowired
    public EmployeeDAOImpl(NamedParameterJdbcTemplate namedJdbcTemplate) {
    	this.namedJdbcTemplate = namedJdbcTemplate;
    }

	@Override
	public Employee getEmployee(int empId) {
		Employee employee = null;
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(QUERY, new Object[] { empId });
		
		while (rowset.next()) {
			employee = new Employee();
			employee.setEmpID(rowset.getInt("empId"));
			employee.setFirstName(rowset.getString("firstname"));
			employee.setLastName(rowset.getString("lastname"));
			employee.setYearOfJoining(rowset.getInt("yearOfJoining"));
		}
		return employee;
	}

	@Override
	public boolean createEmployee(Employee newEmp) {
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("empId", newEmp.getEmpID());
		paramMap.put("firstname", newEmp.getFirstName());
		paramMap.put("lastname", newEmp.getLastName());
		paramMap.put("yearOfJoining", newEmp.getYearOfJoining());
		
		int result = namedJdbcTemplate.update(INSERT_QUERY, paramMap);
		boolean status = false;
		
		if(result != 0 ) {	
			status = true;
		}
		return status;
	}

	@Override
	public boolean updateEmployee(Employee newEmp) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("lastname", newEmp.getLastName()).addValue("empId", newEmp.getEmpID());
		
		int result = namedJdbcTemplate.update(UPDATE_QUERY, namedParameters);
		boolean status = false;
				
		if(result != 0 ) {
			status = true;
		}
		return status;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		int result = this.jdbcTemplate.update(DELETE_QUERY, empId);
		boolean status = false;
		if( result != 0) {
			status = true;
		}
		return status;
	}

	@Override
	public List<Employee> getEmployees() {		
		return this.jdbcTemplate.query(LIST_QUERY, employeeRowMapper);
	}

}
