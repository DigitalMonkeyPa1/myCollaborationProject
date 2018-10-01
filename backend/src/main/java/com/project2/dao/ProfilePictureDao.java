package com.project2.dao;

import com.project2.model.ProfilePicture;

public interface ProfilePictureDao {
void uploadProfilePicture(ProfilePicture profilePicture);
ProfilePicture getProfilePicture(String email);
}
