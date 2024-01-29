package com.inno.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.inno.dto.Student;

@Service
public class TemplateService {
	
	@Autowired private JdbcTemplate jdbcTemplate;

	Logger LOGGER = LoggerFactory.getLogger(TemplateService.class);
	
	public String getNameById(Integer id) {
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			SqlParameterSource in = new MapSqlParameterSource().addValue("eid", id);
			Map<String, Object> out = simpleJdbcCall.withProcedureName("getInfo").execute(in);
			if(!out.isEmpty()) {
				return out.get("ENAME").toString();
			}
			return null;
		}
		catch(Exception e) {
			LOGGER.error("Exception in calling procedure Exception : {} ",e.getMessage());
			return null;
		}
	}
	
	public Student getStudentDetailsById(Integer id) {
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			SqlParameterSource in = new MapSqlParameterSource().addValue("EID", id);
			Map<String, Object> out = simpleJdbcCall.withProcedureName("GET_DETAILS").execute(in);
			if(!out.isEmpty()) {
				Student student = new Student();
				student.setName(out.get("SNAME").toString()); 
				student.setPercent(Double.parseDouble(out.get("SPER").toString()));
				return student;		
			}
			return null;
		}
		catch(Exception e) {
			LOGGER.error("Exception in calling procedure Exception : {} ",e.getMessage());
			return null;
		}
	}
}
