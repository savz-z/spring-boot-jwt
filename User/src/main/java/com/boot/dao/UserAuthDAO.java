package com.boot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.model.Role;
import com.boot.model.User;
import com.boot.model.UserAuthRequest;
import com.boot.model.UserInfo;

@Repository
public class UserAuthDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public UserInfo getUserInfo(String username) {
		String sql = "SELECT u.user_name name, u.user_pwd pass, r.user_role role FROM "
				+ "user u INNER JOIN user_role r on u.user_name=r.user_name WHERE " + "u.user_name = ?";
		UserInfo userInfo = (UserInfo) jdbcTemplate.queryForObject(sql, new Object[] { username },
				new RowMapper<UserInfo>() {
					public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserInfo user = new UserInfo();
						user.setUserName(rs.getString("name"));
						user.setPassword(rs.getString("pass"));
						user.setRole(rs.getString("role"));
						return user;
					}
				});
		return userInfo;
	}
}
