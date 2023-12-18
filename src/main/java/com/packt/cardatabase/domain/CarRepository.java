package com.packt.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "vehicles") -> 스프링 데이터 REST의 엔드포인트 바꿔줌
@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
    //브랜드와 모델로 자동차를 검색
    List<Car> findByBrandAndModel(String brand,String model);

    //브랜드나 색상으로 자동차를 검색
    List<Car> findByBrandOrColor(String brand,String color);

    //브랜드로 자동차를 검색하고 연도로 정렬
    List<Car> findByBrandOrderByYearAsc(String brand);

    //SQL 문을 이용해 브랜드로 자동차를 검색
//    @Query("select c from Car c where c.brand like %?1")
//    List<Car> findByBrand(String brand);

    //브랜드로 자동차를 검색
    List<Car> findByBrand(@Param("brand") String brand);

    //색상으로 자동차를 검색
    List<Car> findByColor(@Param("color") String color);
}
