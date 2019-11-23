package com.boot.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.model.Movie;

@Repository
public class MovieDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	public List<Movie> getMovies(){
		 Session session = sessionFactory.openSession();
		 Query<Movie> query = session.createQuery("from Movie");
		 List<Movie> movies = query.list();
		 return movies;
	}
	 
	 /* 
	 * 
	 * public UserInfo getUserInfo(String username){ String sql =
	 * "SELECT u.user_name name, u.user_pwd pass, r.user_role role FROM "+
	 * "user u INNER JOIN user_role r on u.user_name=r.user_name WHERE "+
	 * "u.user_name = ?"; UserInfo userInfo =
	 * (UserInfo)jdbcTemplate.queryForObject(sql, new Object[]{username}, new
	 * RowMapper<UserInfo>() { public UserInfo mapRow(ResultSet rs, int rowNum)
	 * throws SQLException { UserInfo user = new UserInfo();
	 * user.setUserName(rs.getString("name"));
	 * user.setPassword(rs.getString("pass")); user.setRole(rs.getString("role"));
	 * return user; } }); return userInfo; }
	 * 
	 * 
	 * public String saveUserInfo(String username){ String sql = "INSERT INTO ";
	 * UserInfo userInfo = (UserInfo)jdbcTemplate.queryForObject(sql, new
	 * Object[]{username}, new RowMapper<UserInfo>() { public UserInfo
	 * mapRow(ResultSet rs, int rowNum) throws SQLException { UserInfo user = new
	 * UserInfo(); user.setUserName(rs.getString("name"));
	 * user.setPassword(rs.getString("pass")); user.setRole(rs.getString("role"));
	 * return user; } }); return userInfo; }
	 * 
	 * public void registerUser(UserAuthRequest userRequest) { User user = new
	 * User(); user.setUsername(userRequest.getUsername()); user.setPassword(new
	 * BCryptPasswordEncoder().encode(userRequest.getPassword()));
	 * user.setEmail(userRequest.getEmail());
	 * user.setContact(userRequest.getContact()); Role role = new Role();
	 * role.setUsername(user.getUsername()); role.setRole("USER"); Set<Role> roles =
	 * new HashSet<Role>(); roles.add(role); user.setRoles(roles); Session session =
	 * sessionFactory.openSession(); session.save(user); }
	 */
}
