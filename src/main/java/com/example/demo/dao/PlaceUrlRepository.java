
package com.example.demo.dao;

import com.example.demo.model.PlaceUrl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceUrlRepository extends CrudRepository<PlaceUrl, Long> {
    PlaceUrl findByUrl(String url);
}