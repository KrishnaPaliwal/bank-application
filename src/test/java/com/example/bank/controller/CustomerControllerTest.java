package com.example.bank.controller;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.bank.model.Customer;
import com.example.bank.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer testCustomer;

    @Before
    public void setUp() {
        testCustomer = new Customer();
        testCustomer.setId(1L);
        testCustomer.setFirstName("John");
        testCustomer.setLastName("Doe");
    }

    @Test
    public void testGetCustomerById() throws Exception {
        Long customerId = 1L;

        given(customerService.getCustomerById(customerId)).willReturn(testCustomer);

        mockMvc.perform(get("/customers/{id}", customerId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testCustomer.getId().intValue())))
                .andExpect(jsonPath("$.firstName", is(testCustomer.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(testCustomer.getLastName())));
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        // Implement this test if needed
    }

    @Test
    public void testCreateCustomer() throws Exception {
        // Implement this test if needed
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        // Implement this test if needed
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        // Implement this test if needed
    }
}
