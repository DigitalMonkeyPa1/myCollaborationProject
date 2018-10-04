package com.project2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project2.model.Friend;
import com.project2.model.User;


@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
@Autowired
	private SessionFactory sessionFactory;
	public List<User> listOfSuggestedUsers(String email) {
	
	Session session=sessionFactory.getCurrentSession();
		SQLQuery sqlQuery=session.createSQLQuery("select * from users where email in (select email from users where email!=? minus (select fromId from friends where toId=? union select toId from friends where fromId=?))");
		sqlQuery.setString(0, email);
		sqlQuery.setString(1, email);
		sqlQuery.setString(2, email);
		sqlQuery.addEntity(User.class);
		List<User> suggestedUsers=sqlQuery.list();
		return suggestedUsers;
	}
	public void addFriendRequest(Friend friend) {
		
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
		}
	
	public List<Friend> getAllPendingRequests(String email) {
		
		Session session=sessionFactory.getCurrentSession();
		  Query query=session.createQuery("from Friend where toId=? and status=?");
		  query.setString(0, email);
		  query.setCharacter(1, 'P');
		  List<Friend> friendRequests=query.list();
		  return friendRequests;
		 
	}
	public void updateFriendRequest(Friend friend) {
		
			Session session=sessionFactory.getCurrentSession();
			if(friend.getStatus()=='A')
				session.update(friend);
			else
				session.delete(friend);
			
		}
	public List<User> listOfFriends(String email) {
		

		Session session=sessionFactory.getCurrentSession();
		SQLQuery query=
		session.createSQLQuery("select * from users where email in"
				+ "(select fromId from friends where toId=? and status='A' "
				+ " union "
				+ "select toId from friends where fromId=? and status='A')");
		query.setString(0, email);
		query.setString(1, email);
		query.addEntity(User.class);
		List<User> friends=query.list();
		return friends;
	}

		
	}	  


