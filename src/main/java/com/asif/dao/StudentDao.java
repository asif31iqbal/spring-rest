package com.asif.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.asif.model.Student;

@Component
public class StudentDao {
	//private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public boolean deleteStudent(String id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return jdbc.update("delete from student where id = :id", params) == 1;
	}
	
	public boolean addStudent(String id, String name) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		params.addValue("name", name);
		
		return jdbc.update("insert into student(id, name) values(:id, :name)", params) == 1;
	}
	
	public boolean addStudent(Student student) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);		
		return jdbc.update("insert into student(id, name) values(:id, :name)", params) == 1;
	}
	
	@Transactional
	public int[] addStudents(List<Student> students) {
		SqlParameterSource[] params =  SqlParameterSourceUtils.createBatch(students.toArray());
		return jdbc.batchUpdate("insert into student(id, name) values(:id, :name)", params);
	}
	
	public boolean updateStudent(Student student) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);		
		return jdbc.update("update student set name=:name where id=:id", params) == 1;
	}
	
	public int[] updateStudents(List<Student> students) {
		SqlParameterSource[] params =  SqlParameterSourceUtils.createBatch(students.toArray());
		return jdbc.batchUpdate("update student set name=:name where id=:id", params);
	}
	
	public List<Student> getStudents() {
		return jdbc.query("select * from student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Student(rs.getString("id"), rs.getString("name"));
			}
		});
	}
	
	public Student getStudent(String id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject("select * from student where id = :id", params, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Student(rs.getString("id"), rs.getString("name"));
			}
		});
	}
}
