package br.com.lucaswamser.moviesapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lucaswamser.moviesapi.app.MainApplication;
import br.com.lucaswamser.moviesapi.app.rest.MoviesController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
@AutoConfigureMockMvc

public class IntegrationTest {
	
	private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkIntervalApiOK() throws Exception { 
        
        mockMvc.perform(get("/movies/winnerinterval"))
                /*.andDo(print())*/
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath( "$.max").exists())
                .andExpect(jsonPath( "$.max[0].followingWin").exists())
                .andExpect(jsonPath( "$.max[0].producer").exists())
                .andExpect(jsonPath( "$.max[0].interval").exists())
                .andExpect(jsonPath( "$.max[0].interval",is(equalTo(13)) ))
                .andExpect(jsonPath( "$.max[0].previousWin").exists())
                .andExpect(jsonPath( "$.min").exists())
                .andExpect(jsonPath( "$.min[0].followingWin").exists())
                .andExpect(jsonPath( "$.min[0].producer").exists())
                .andExpect(jsonPath( "$.min[0].interval").exists())
                .andExpect(jsonPath( "$.min[0].interval",is(equalTo(1)) ))
                .andExpect(jsonPath( "$.min[0].previousWin").exists());
           

    }
    
    @Test
    public void checkListApiOk() throws Exception {

        mockMvc.perform(get("/movies/list"))
                /*.andDo(print())*/
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath( "$[0].year").exists())
                .andExpect(jsonPath( "$[0].title").exists())
                .andExpect(jsonPath( "$[0].studios").exists())
                .andExpect(jsonPath( "$[0].producers").exists())
                .andExpect(jsonPath( "$[0].winner").exists())
                ;
               
           

    }
}