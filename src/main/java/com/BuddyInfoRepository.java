package com;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by jeremydunsmore on 1/26/2017.
 */
@RepositoryRestResource
public interface BuddyInfoRepository  extends CrudRepository<BuddyInfo,String>{
    List<BuddyInfo> findByName(String name);
    List<BuddyInfo> findByPhone(String phone);
}
