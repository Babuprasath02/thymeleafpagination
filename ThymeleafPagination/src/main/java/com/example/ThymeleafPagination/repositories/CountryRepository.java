package com.example.ThymeleafPagination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ThymeleafPagination.model.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>{

}
