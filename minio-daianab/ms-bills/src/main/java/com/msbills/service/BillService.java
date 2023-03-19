package com.msbills.service;

import com.msbills.models.Bill;

import com.msbills.repositories.BillRepository;
import com.msbills.repositories.IFeignUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService {

  private final BillRepository repository;

  private final IFeignUserRepository feignUserRepository;

  public List<Bill> getAllBill() {
    return repository.findAll();
  }

  public Bill saveBill(Bill bill) {
    return repository.save(bill);
  }

  public Bill findByCustomer(String customer) {
    return repository.findByCustomerBill(customer).orElse(null);
  }

}
