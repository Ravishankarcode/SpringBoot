package com.ravishankarcode.excelfile.fileservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ravishankarcode.excelfile.model.Customer;
import com.ravishankarcode.excelfile.repository.CustomerRepository;
import com.ravishankarcode.excelfile.util.ExcelUtils;

@Service
public class FileServices{
	
	@Autowired
	CustomerRepository customerRepository;
	
	// Store File Data to Database
	public void store(MultipartFile file){
		try {
			List<Customer> lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
    		// Save Customers to DataBase
    		customerRepository.saveAll(lstCustomers);
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
	
	// Load Data to Excel File
    public ByteArrayInputStream loadFile() {
    	List<Customer> customers = (List<Customer>) customerRepository.findAll();
    	
    	try {
    		ByteArrayInputStream in = ExcelUtils.customersToExcel(customers);
    		return in;
		} catch (IOException e) {}
    	
        return null;
    }
}
