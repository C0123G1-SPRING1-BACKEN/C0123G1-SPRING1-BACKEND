package com.example.back_end.service.customer;

import com.example.back_end.dto.CustomerSaveDto;
import com.example.back_end.model.Customers;
import com.example.back_end.repository.customer.ICustomerRepositoryCreateUpdate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceCreateUpdateImpl implements ICustomerServiceCreateUpdate{
    @Autowired
    private ICustomerRepositoryCreateUpdate customerRepositoryCreateUpdate;

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : connect database to create customer
     *
     * @param customerSaveDto
     */
    @Override
    public void createCustomer(CustomerSaveDto customerSaveDto) {
        Customers customers = new Customers();
        BeanUtils.copyProperties(customerSaveDto, customers);
        customerRepositoryCreateUpdate.addCustomer(
                customers.getName(),
                customers.getBirthday(),
                customers.getGender(),
                customers.getPhoneNumber(),
                customers.getEmail(),
                customers.getAddress(),
                customers.getCitizenCode(),
                customers.getImage(),
                customers.getFrontCitizen(),
                customers.getBackCitizen()
                );
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : connect database to update customer with corresponding id of customer
     *
     * @param id, customerSaveDto
     */
    @Override
    public void updateCustomer(Long id,CustomerSaveDto customerSaveDto) {
        Customers customers = new Customers();
        BeanUtils.copyProperties(customerSaveDto, customers);
        customerRepositoryCreateUpdate.updateCustomer(
                customers.getId(),
                customers.getName(),
                customers.getBirthday(),
                customers.getGender(),
                customers.getPhoneNumber(),
                customers.getEmail(),
                customers.getAddress(),
                customers.getCitizenCode(),
                customers.getImage(),
                customers.getFrontCitizen(),
                customers.getBackCitizen()
                );
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : connect database to customer find by id customer
     *
     * @param id
     * @return customerSaveDto
     */
    @Override
    public CustomerSaveDto findByIdCustomer(Long id) {
        Customers customers = customerRepositoryCreateUpdate.findWithIdCustomer(id);
        CustomerSaveDto customerSaveDto =new CustomerSaveDto();
        BeanUtils.copyProperties(customers, customerSaveDto);
        return customerSaveDto;
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : connect database to customer find by email check duplicate
     *
     * @param email
     * @return boolean
     */
    @Override
    public boolean existsByEmail(String email) {
        return customerRepositoryCreateUpdate.existsByEmail(email);
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : connect database to customer find by citizenCode check duplicate
     *
     * @param citizenCode
     * @return boolean
     */
    @Override
    public boolean existsByCitizenCode(String citizenCode) {
        return customerRepositoryCreateUpdate.existsByCitizenCode(citizenCode);
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : connect database to customer find by phoneNumber check duplicate
     *
     * @param phoneNumber
     * @return boolean
     */
    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return customerRepositoryCreateUpdate.existsByPhoneNumber(phoneNumber);
    }
}
