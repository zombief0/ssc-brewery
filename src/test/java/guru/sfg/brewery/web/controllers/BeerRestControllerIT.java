package guru.sfg.brewery.web.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
@SpringBootTest
public class BeerRestControllerIT extends BaseIT{

    @Test
    void deleteBadCred() throws Exception {

        mockMvc.perform(delete("/api/v1/beer/97df0c39-90c4-4ae0-b663-453e8e19c311")
                .header("Api-Key","spring").header("Api-Secret", "testxxx"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void deleteBeer() throws Exception {

        mockMvc.perform(delete("/api/v1/beer/97df0c39-90c4-4ae0-b663-453e8e19c311")
        .header("Api-Key","spring").header("Api-Secret", "test"))
                .andExpect(status().isOk());
    }

    @Test
    void findBeers() throws Exception{
        mockMvc.perform(get("/api/v1/beer/"))
                .andExpect(status().isOk());
    }

    @Test
    void findBeerById() throws Exception{
        mockMvc.perform(get("/api/v1/beer/97df0c39-90c4-4ae0-b663-453e8e19c311"))
                .andExpect(status().isOk());
    }
}
