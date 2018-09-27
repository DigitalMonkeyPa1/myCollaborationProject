package com.project2.dao;

import java.util.List;

import com.project2.model.Notification;

public interface NotificationDao {
List<Notification> getAllNotification(String email);//login id
void updateViewedStatus(int notificationId);
Notification getNotification(int id);
}
