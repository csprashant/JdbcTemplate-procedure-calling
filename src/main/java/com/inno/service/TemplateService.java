package com.inno.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

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
}
