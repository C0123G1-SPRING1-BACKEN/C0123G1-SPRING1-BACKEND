package com.example.back_end.repository;

import com.example.back_end.model.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employees, Integer> {
    @Query(value = "select * from employees where name like concat('%', :search, '%') ", nativeQuery = true)
    Page<Employees> findAllByNameContaining(Pageable pageable, @Param("search") String search);

    @Modifying
    @Transactional
    @Query(value = "insert into employees (name, birth_day, gender, email, phone_number, address, salary, citizen_code, image) " +
            "value(:name, :birth_day, :gender, :email, :phone_number, :address, :salary, :citizen_code, :image)", nativeQuery = true)
    void createEmployee(@Param("name") String name,
                        @Param("birth_day") String birthDay,
                        @Param("gender") Integer gender,
                        @Param("email") String email,
                        @Param("phone_number") String phoneNumber,
                        @Param("address") String address,
                        @Param("salary") String salary,
                        @Param("citizen_code") String citizenCode,
                        @Param("image") String image);

    @Transactional
    @Query(value = "select * from employees where id = :id", nativeQuery = true)
    Employees findById(@Param("id") int id);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByCitizenCode(String citizenCode);

}
