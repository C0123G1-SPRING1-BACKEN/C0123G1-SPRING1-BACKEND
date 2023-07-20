package com.example.back_end.repository.customer;

import com.example.back_end.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ICustomerRepositoryCreateUpdate extends JpaRepository<Customers, Long> {
    @Query(nativeQuery = true, value = "select * from customers where id = :id")
    Customers findWithIdCustomer(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customers (name, birthday, gender, phone_number, email, address, citizen_code, image, front_citizen, back_citizen) " +
            "VALUES (:name, :birthday, :gender, :phoneNumber, :email, :address, :citizenCode, :image, :frontCitizen, :backCitizen)",
            nativeQuery = true)
    void addCustomer(@Param("name") String name,
                     @Param("birthday") String birthday,
                     @Param("gender") int gender,
                     @Param("phoneNumber") String phoneNumber,
                     @Param("email") String email,
                     @Param("address") String address,
                     @Param("citizenCode") String citizenCode,
                     @Param("image") String image,
                     @Param("frontCitizen") String frontCitizen,
                     @Param("backCitizen") String backCitizen);

    @Modifying
    @Transactional
    @Query(value = "UPDATE customers SET name = :name, birthday = :birthday, gender = :gender, " +
            "phone_number = :phoneNumber, email = :email, address = :address, citizen_code = :citizenCode, " +
            "image = :image, front_citizen = :frontCitizen, back_citizen = :backCitizen " +
            "WHERE id = :id", nativeQuery = true)
    void updateCustomer(@Param("id") Long id,
                        @Param("name") String name,
                        @Param("birthday") String birthday,
                        @Param("gender") int gender,
                        @Param("phoneNumber") String phoneNumber,
                        @Param("email") String email,
                        @Param("address") String address,
                        @Param("citizenCode") String citizenCode,
                        @Param("image") String image,
                        @Param("frontCitizen") String frontCitizen,
                        @Param("backCitizen") String backCitizen);

    /**
     * Create by: DatNT,
     * Date create : 18/07/2023
     * Method to check email exists or not
     * @param email
     * @return
     * If email exists, return true, else false
     */
    @Query(value = "SELECT IF(EXISTS(SELECT * FROM customers WHERE email = :email), 'true', 'false')", nativeQuery = true)
    Boolean existsByEmail(@Param("email") String email);

    /**
     * Create by: DatNT,
     * Date create : 18/07/2023
     * Method to check phoneNumber exists or not
     * @param phoneNumber
     * @return
     * If email exists, return true, else false
     */
    @Query(value = "SELECT IF(EXISTS(SELECT * FROM customers WHERE phone_number = :phoneNumber), 'true', 'false')", nativeQuery = true)
    Boolean existsByPhoneNumber(String phoneNumber);

    /**
     * Create by: DatNT,
     * Date create : 18/07/2023
     * Method to check citizenCode exists or not
     * @param citizenCode
     * @return
     * If email exists, return true, else false
     */
    @Query(value = "SELECT IF(EXISTS(SELECT * FROM customers WHERE citizen_code = :citizenCode), 'true', 'false')", nativeQuery = true)
    Boolean existsByCitizenCode(String citizenCode);
}
