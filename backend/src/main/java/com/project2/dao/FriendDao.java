package com.project2.dao;

import java.util.List;

import com.project2.model.Friend;
import com.project2.model.User;

public interface FriendDao {

	List<User> listOfSuggestedUsers(String email);
	void addFriendRequest(Friend friend);
	List<Friend> getAllPendingRequests(String email);
	void updateFriendRequest(Friend friend);
	List<User> listOfFriends(String email);
}
