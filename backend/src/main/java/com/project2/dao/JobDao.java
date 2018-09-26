package com.project2.dao;

import java.util.List;

import com.project2.model.Job;

public interface JobDao
{
void addJob(Job job);
List<Job> getAllJobs();
Job getJob(int id);
}
