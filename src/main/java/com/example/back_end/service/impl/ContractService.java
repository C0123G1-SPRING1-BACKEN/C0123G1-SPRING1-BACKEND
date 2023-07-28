package com.example.back_end.service.impl;


import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.Customers;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.IContractProjection;
import com.example.back_end.projections.IMinAndMaxProjection;
import com.example.back_end.projections.ITransactionHistoryProjection;
import com.example.back_end.repository.IContractRepository;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
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
import java.util.*;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository icontractRepository;


    @Override
    public Contracts findContractById(Long id) {
        return icontractRepository.findContractById(id);
    }

    @Transactional
    @Override
    public void saveContract(ContractDto contractDto) {
        Contracts contract = icontractRepository.findContractById(contractDto.getId());
        contract.setContractCode(contractDto.getContractCode());
        contract.setProductName(contractDto.getProductName());
        contract.setLoans(contractDto.getLoans());
        contract.setProfit(contractDto.getProfit());
        contract.setImage(contractDto.getImage());
        contract.setStartDate(contractDto.getStartDate());
        contract.setEndDate(contractDto.getEndDate());
        contract.setDelete(contractDto.isDelete());
        contract.setProductType(contractDto.getProductType());
        contract.setCustomers(contractDto.getCustomers());
        contract.setContractStatus(contractDto.getContractStatus());
        contract.setEmployees(contractDto.getEmployees());
        contract.setContractType(contractDto.getContractType());

        icontractRepository.saveContract(
                contract.getContractCode(),
                contract.getProductName(),
                contract.getLoans(),
                contract.getProfit(),
                contract.getImage(),
                contract.getStartDate(),
                contract.getEndDate(),
                contract.isDelete(),
                contract.getProductType().getId(),
                contract.getCustomers().getId(),
                contract.getContractStatus().getId(),
                contract.getEmployees().getId(),
                contract.getContractType().getId(),
                contract.getId()
        );

    }


    @Override
    public Page<Contracts> showTop10NewContract(Pageable pageable) {

        return icontractRepository.showTop10NewContract(pageable);

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
            icontractRepository.deleteContractById(id);
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
    public Page<ITransactionHistoryProjection> showListAndSearchTransactionHistory(Integer page, Integer limit, ContractSearchDTO contractSearchDTO) {
        return icontractRepository.searchTransactionHistory(PageRequest.of(page, limit),
                contractSearchDTO.getCustomerName(), contractSearchDTO.getProductName(),
                contractSearchDTO.getStartDate(), contractSearchDTO.getEndDate(),
                contractSearchDTO.getContractType(), contractSearchDTO.getContractStatus());
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
        return icontractRepository.findContractsById(id);
    }

    @Override
    public List<Contracts> findAll() {
        return icontractRepository.findAll();
    }


    /**
     * Created by: DinhHD
     * Date created: 13/07/2023
     * Function: do about pawn interface, customer selection interface
     * <p>
     * // * @param Contracts
     *
     * @return createContract()
     */
    @Transactional
    @Override
    public void createContract(Contracts contracts) {
        Long loans = contracts.getLoans();
        NumberFormat numberFormat = NumberFormat.getInstance();
        String profit = (numberFormat.format(contracts.getProfit()));
        String loan = (numberFormat.format(loans));
//        tỷ lệ lãi suất là 2% trên tháng, thì lãi suất cần tính cho 1 ngày là 2%/30 = 0,067%.
        Double percent = 0.67 / 100; // Lãi suất hàng ngày (0.067%)

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(contracts.getStartDate());
        LocalDate endDate = LocalDate.parse(contracts.getEndDate());
        String start = startDate.format(dateTimeFormatter);
        String end = endDate.format(dateTimeFormatter);

        Long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

//        tính tổng tiền
        Long profits = (long) (loans * percent * daysBetween);
        String profitLoans = (numberFormat.format(profits));
        System.out.println("Tiền cho vay: " + loan);
        System.out.println("Ngày bắt đầu: " + start);
        System.out.println("Ngày kết thúc: " + end);
        System.out.println("Tổng số ngày: " + daysBetween);
        System.out.println("Lãi xuất % 1 ngày : " + percent);
        System.out.println("Liền lãi BE: " + profitLoans);
        System.out.println("Liền lãi FE: " + profit);

        if (contracts.getProfit().equals(profits)) {
            icontractRepository.createContract(
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
        } else {
            System.out.println("Mệnh giá tiền của FE - BE không trùng nhau");
        }

    }

    @Override
    public String randomContract() {
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            number.add(i);
        }
//        Sử dụng hàm Random để ngẫu nhiên hóa danh sách chữ số
        Random random = new Random();
        for (int i = number.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Collections.swap(number, i, j);
        }
        // Lấy 5 phần tử đầu tiên của danh sách xáo trộn để tạo thành chuỗi ngẫu nhiên
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            randomString.append(number.get(i));
        }
        return randomString.toString();
    }

    @Override
    public Optional<IMinAndMaxProjection> findMinDateAndMaxDate() {
        return icontractRepository.findByStartDate();
    }
}
