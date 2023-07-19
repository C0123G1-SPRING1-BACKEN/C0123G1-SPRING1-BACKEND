package com.example.back_end.repository;

import com.example.back_end.model.RegisterPawn;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface IRegisterPawnRepository extends JpaRepository<RegisterPawn, Long> {

   @Transactional
   @Modifying
   @Query(value = "INSERT INTO register_pawn (name,phone,email,address,content_note,product_type_id,status) value (:name,:phone,:email,:address,:content_note,:product_type_id,false) ",nativeQuery = true)
    void createRegisterPawn(@Param("name")String name,@Param("phone")String phone,@Param("email")String email , @Param("address") String address,
                            @Param("content_note") String contentNote,@Param("product_type_id") Long productTypeId);

    @Query(value = "select * from register_pawn", nativeQuery = true)
    Page<RegisterPawn> findByNameRegisterPawn(Pageable pageable);


   @Transactional
   @Modifying
   @Query(value = "UPDATE register_pawn r SET r.status = true WHERE r.id = :id",nativeQuery = true)
    void confirmRegisterPawn(@Param("id") Long id);
}
