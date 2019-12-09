package com.boot.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.entity.Actor;
import com.boot.model.MovieVO;

@Repository
public class ActorDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	public List<Actor> getActors(){
		 Session session = sessionFactory.openSession();
		 Query<Actor> query = session.createQuery("from Actor");
		 List<Actor> actors = query.list();
		 return actors;
	}
	
	public Actor getActorDetails(Long id){
		 Session session = sessionFactory.openSession();
		 Query<Actor> query = session.createQuery("from Actor where id=:id");
		 query.setParameter("id", id);
		 Actor actor = query.uniqueResult();
		 return actor;
	}
	
	public Actor addActor(Actor actor){
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(actor);
		return actor;
	}
	
	public Actor updateActor(Actor actor){
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(actor);
		return actor;
	}
	
	public boolean deleteActor(int movieId){
		Session session = sessionFactory.openSession();
		//session.de(movie);
		return true;
	}
	 
	public List<MovieVO> getMovieDetails(Long id){
		 Session session = sessionFactory.openSession();
		 Query<Object> query = session.createSQLQuery("select movie_id, movie_name,movie_path from actor_movie am join movie m  on am.movie_id = m.id and am.actor_id = :id");
		 query.setParameter("id", id);
		 List<MovieVO> movies = new ArrayList<MovieVO>();
		 Iterator movieList = query.list().iterator();
		 while ( movieList.hasNext() ) {
			 Object[] movieObj= (Object[]) movieList.next();
			    MovieVO movieVO = new MovieVO();
			    movieVO.setMovieid(Long.valueOf((Integer)movieObj[0]));
			    movieVO.setMoviename((String) movieObj[1]);
			    movieVO.setMoviepath((String) movieObj[2]);
			    movies.add(movieVO);
			}
		 return movies;
	}
}
