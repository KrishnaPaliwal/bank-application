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

import com.example.bank.model.Card;
import com.example.bank.service.CardService;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CardController.class)
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cardService;

    private Card testCard;

    @Before
    public void setUp() {
        testCard = new Card();
        testCard.setId(1L);
        testCard.setCardNumber("1234567890123456");
        testCard.setExpirationDate("12/25");
    }

    @Test
    public void testGetCardById() throws Exception {
        Long cardId = 1L;

        given(cardService.getCardById(cardId)).willReturn(testCard);

        mockMvc.perform(get("/cards/{id}", cardId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testCard.getId().intValue())))
                .andExpect(jsonPath("$.cardNumber", is(testCard.getCardNumber())))
                .andExpect(jsonPath("$.expirationDate", is(testCard.getExpirationDate())));
    }

    @Test
    public void testGetAllCards() throws Exception {
        // Implement this test if needed
    }

    @Test
    public void testCreateCard() throws Exception {
        // Implement this test if needed
    }

    @Test
    public void testUpdateCard() throws Exception {
        // Implement this test if needed
    }

    @Test
    public void testDeleteCard() throws Exception {
        // Implement this test if needed
    }
}
