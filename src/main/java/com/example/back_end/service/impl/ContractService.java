package com.example.back_end.service.impl;


import com.example.back_end.model.Contracts;
import com.example.back_end.model.Customers;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.IContractProjection;
import com.example.back_end.repository.IContractRepository;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/**
 * Created by: DinhHD
 * Date created: 13/07/2023
 * Function: do about pawn interface, customer selection interface
 * <p>
 * // * @param Contracts
 *
 * @return createContract()
 */

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: get page transaction history from Database
     * <p>
     *
     * @param page
     * @return Page<IContractProjection>
     */

    @Override
    public Page<IContractProjection> findAllTransactionHistory(Integer page, Integer limit) {
        return iContractRepository.findAllTransactionHistoryByDeleteIsFalse(PageRequest.of(page, limit, Sort.by("startDate").descending()));
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: delete transaction history
     * <p>
     *
     * @param id
     * @return boolean
     */

    @Override
    @Transactional
    public Boolean deleteTransactionHistoryById(Integer id) {
        try {
            iContractRepository.deleteContractById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: search transaction history from Database
     * <p>
     *
     * @param contractSearchDTO
     * @return ContractDTO
     */

    @Override
    public Page<IContractProjection> searchTransactionHistory(Integer page, Integer limit, ContractSearchDTO contractSearchDTO) {
        Page<IContractProjection> projectionPage = iContractRepository.searchTransactionHistory(PageRequest.of(page, limit, Sort.by("startDate").descending()),
                "%" + contractSearchDTO.getCustomerName() + "%", "%" + contractSearchDTO.getProductName() + "%",
                contractSearchDTO.getStartDate(), contractSearchDTO.getEndDate(), contractSearchDTO.getContractType(), contractSearchDTO.getContractStatus());
        return projectionPage;
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: find transaction history from Database
     * <p>
     *
     * @param id
     * @return ContractDTO
     */

    @Override
    public Optional<Contracts> findTransactionHistoryById(Integer id) {
        return iContractRepository.findContractsById(id);
    }

    @Override
    public List<Contracts> findAll() {
        return iContractRepository.findAll();
    }


    @Transactional
    @Override
    public void createContract(Contracts contracts) {
        Long loans = contracts.getLoans();
        NumberFormat numberFormat = NumberFormat.getInstance();
        String profit = (numberFormat.format(contracts.getProfit()));
        String loan = (numberFormat.format(loans));
//        tỷ lệ lãi suất là 2% trên tháng, thì lãi suất cần tính cho 1 ngày là 2%/30 = 0,067%.
        Double percent =  0.067; // Lãi suất hàng ngày (0.067%)

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate=LocalDate.parse(contracts.getStartDate());
        LocalDate endDate=LocalDate.parse(contracts.getEndDate());
        String start= startDate.format(dateTimeFormatter);
        String end= endDate.format(dateTimeFormatter);

        Long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

//        tính tổng tiền
        Long profits = (long) (loans * percent * daysBetween);
        String profitLoans = (numberFormat.format(profits));
        System.out.println("Tiền cho vay: "+loan);
        System.out.println("Ngày bắt đầu: "+start);
        System.out.println("Ngày kết thúc: "+end);
        System.out.println("Tổng số ngày: " + daysBetween);
        System.out.println("Liền lãi BE: " + profitLoans);
        System.out.println("Liền lãi FE: " + profit);

            if (contracts.getProfit().equals(profits)){
                iContractRepository.createContract(
                        contracts.getCustomers().getId(),
                        contracts.getContractCode(),
                        contracts.getProductName(),
                        contracts.getProductType().getId(),
                        contracts.getImage(),
                        contracts.getLoans(),
                        contracts.getStartDate(),
                        contracts.getEndDate(),
                        contracts.getProfit(),
                        contracts.getEmployees().getId());
            }else {
                System.out.println("Mệnh giá tiền của FE - BE không trùng nhau");
            }

    }
}
