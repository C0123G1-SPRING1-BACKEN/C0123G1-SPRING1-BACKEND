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
     * Param customerSaveDto)
     */
    @Override
    public void create(CustomerSaveDto customerSaveDto) {
        Customers customers = new Customers();
        BeanUtils.copyProperties(customerSaveDto, customers);
        customerRepositoryCreateUpdate.addCustomer(customers.getName(),
                customers.getBirthday(),
                customers.getGender(),
                customers.getPhoneNumber(),
                customers.getEmail(),
                customers.getAddress(),
                customers.getCitizenCode(),
                customers.getImage(),
                customers.getFrondCitizen(),
                customers.getBackCitizen(),
                customers.isDelete()
                );
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : connect database to update customer with corresponding id of customer
     *
     * Param id, customerSaveDto)
     */
    @Override
    public void update(Long id,CustomerSaveDto customerSaveDto) {
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
                customers.getFrondCitizen(),
                customers.getBackCitizen(),
                customers.isDelete()
                );
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : connect database to customer find by id customer
     *
     * @Param id
     * @Return customerSaveDto
     */
    @Override
    public CustomerSaveDto findById(Long id) {
        Customers customers = customerRepositoryCreateUpdate.findWithId(id);
        CustomerSaveDto customerSaveDto =new CustomerSaveDto();
        BeanUtils.copyProperties(customers, customerSaveDto);
        return customerSaveDto;
    }
}
