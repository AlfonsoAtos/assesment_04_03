package com.Assessment.Users_WS.repositories;

import java.util.ArrayList;

import com.Assessment.Users_WS.models.Profile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
    public abstract ArrayList<Profile> findByProfile(String profile);
    public abstract ArrayList<Profile> findByIdProfile(Integer idProfile);
}
