package com.zhengcj.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import com.zhengcj.dao.StudentDAO;
import com.zhengcj.domain.Student;

public class StudentDAOImpl extends NamedParameterJdbcDaoSupport implements StudentDAO {

	private LobHandler lobHandler;

	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}

	public List<Student> queryList() {
		List<Student> list = this.getJdbcTemplate().query("SELECT * FROM STUDENT", new StudentRowMapper());
		return list;
	}

	private class StudentRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			Student student = new Student();
			student.setAge(Integer.valueOf(rs.getString("AGE")));
			student.setId(rs.getString("ID"));
			student.setName(rs.getString("NAME"));
			return student;
		}

	}

	public void insert(final Student student) {
		this.getJdbcTemplate().execute("INSERT INTO STUDENT(ID,NAME,AGE,IMAGE) VALUES (?,?,?,?)",
				new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException,
							DataAccessException {
						ps.setString(1, student.getId());
						ps.setString(2, student.getName());
						ps.setInt(3, student.getAge());
						lobCreator.setBlobAsBytes(ps, 4, student.getImage());
					}

				});
	}

}
