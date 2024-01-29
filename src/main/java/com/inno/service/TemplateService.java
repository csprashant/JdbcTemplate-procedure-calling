package com.inno.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.inno.dto.Student;

@Service
public class TemplateService {
	@Autowired	private JdbcTemplate jdbcTemplate;

	public String getNameById(Integer id) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		SqlParameterSource in = new MapSqlParameterSource().addValue("eid", id);
		Map<String, Object> out = simpleJdbcCall.withProcedureName("getInfo").execute(in);
		System.out.println(out.isEmpty());
		System.out.println(out);
		String name = out.get("ENAME").toString(); 
		return name;
	}
	
	public Student getStudentDetailsById(Integer id) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		SqlParameterSource in = new MapSqlParameterSource().addValue("EID", id);
		Map<String, Object> out = simpleJdbcCall.withProcedureName("GET_DETAILS").execute(in);
		System.out.println(out.isEmpty());
		System.out.println(out);
		Student student = new Student();
		
		student.setName(out.get("SNAME").toString()); 
		student.setPercent(Double.parseDouble(out.get("SPER").toString()));
		
		return student;		
				
	}
	
	
	
}
