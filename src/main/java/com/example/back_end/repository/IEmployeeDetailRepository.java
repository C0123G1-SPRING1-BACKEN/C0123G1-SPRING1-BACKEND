package com.example.back_end.repository;

import com.example.back_end.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IEmployeeDetailRepository extends JpaRepository<Employees, Long> {

    @Query(nativeQuery = true, value = "select * from employees where id = :id")
    Employees findWithIdEmployee(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET name = :name, birth_day = :birthDay, gender =:gender, email = :email," +
            " phone_number = :phoneNumber, address = :address, salary = :salary, citizen_code = :citizen_code, image = :image \n "+
            "WHERE id = :id", nativeQuery = true)
    void updateEmployee(@Param("id") Long id,
                        @Param("name") String name,
                        @Param("birthDay") String birthDay,
                        @Param("gender") Integer gender,
                        @Param("email") String email,
                        @Param("phoneNumber") String phoneNumber,
                        @Param("address") String address,
                        @Param("salary") String salary,
                        @Param("citizen_code") String citizenCode,
                        @Param("image") String image);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByCitizenCode(String citizenCode);
}
