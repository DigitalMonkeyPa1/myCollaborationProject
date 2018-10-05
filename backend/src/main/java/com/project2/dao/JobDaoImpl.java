package com.project2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project2.model.Job;

@Repository
@Transactional
public class JobDaoImpl implements JobDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addJob(Job job) {
		Session session = sessionFactory.getCurrentSession();
		session.save(job);

	}

	public List<Job> getAllJobs() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Job");
		List<Job> jobs = query.list();

		return jobs;
	}

	public Job getJob(int id) {
		Session session = sessionFactory.getCurrentSession();
		Job job = (Job) session.get(Job.class, id);
		return job;

	}

}
