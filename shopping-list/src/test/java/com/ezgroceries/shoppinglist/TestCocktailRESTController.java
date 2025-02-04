package com.ezgroceries.shoppinglist;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(CocktailController.class)
//doesnt work when using more then 1 controller
//replace by
@SpringBootTest
@AutoConfigureMockMvc
public class TestCocktailRESTController {
/*
    @Autowired
    private MockMvc mvc;

    @Test
    public void getCocktailsAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .get("/cocktails?search=Russian")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getCreateShoppingListAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .post("/shopping-lists")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content("[{\"name\": \"Elise's birthday\"},{\"name\": \"Maarten's birthday\"}]"))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
*/
}
