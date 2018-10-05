package com.project2.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project2.dao.NotificationDao;
import com.project2.model.ErrorClazz;
import com.project2.model.Notification;

@Controller
public class NotificationController {
	@Autowired
private NotificationDao notificationDao;
	@RequestMapping(value="/getallnotification",method=RequestMethod.GET)
	public ResponseEntity<?> getNotification(HttpSession session){
		String email=(String)session.getAttribute("loginId");
		if(email==null){
			ErrorClazz error=new ErrorClazz(4,"Unauthrozied access.. Please login");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		List<Notification> notifications=notificationDao.getAllNotification(email);
		return new ResponseEntity<List<Notification>>(notifications,HttpStatus.OK);
	}

@RequestMapping(value="/updatenotification/{notificationId}",method=RequestMethod.PUT)
 public ResponseEntity<?> updateNotification(@PathVariable int notificationId,HttpSession session){
	 String email=(String)session.getAttribute("loginId");
		if(email==null){
			ErrorClazz error=new ErrorClazz(4,"Unauthrozied access.. Please login");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
		}
		notificationDao.updateViewedStatus(notificationId);
		return new ResponseEntity<Void>(HttpStatus.OK);
 }

@RequestMapping(value="/getnotification/{id}",method=RequestMethod.GET)
public ResponseEntity<?> getNotification(@PathVariable int id,HttpSession session){
	String email=(String)session.getAttribute("loginId");
	if(email==null){
		ErrorClazz error=new ErrorClazz(4,"Unauthrozied access.. Please login");
		return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
	}
	Notification notification=notificationDao.getNotification(id);
	return new ResponseEntity<Notification>(notification,HttpStatus.OK);
}
}

