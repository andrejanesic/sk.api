package rs.raf.sk.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import rs.raf.sk.controller.CustomUtils;
import rs.raf.sk.controller.HotelController;
import rs.raf.sk.dto.HotelDto;
import rs.raf.sk.mapper.EntityMapper;
import rs.raf.sk.mapper.HotelMapper;
import rs.raf.sk.models.Hotel;
import rs.raf.sk.service.HotelService;

import java.util.Arrays;
import java.util.Collections;

@Transactional
public class HotelControllerTest {
    private static final String ENDPOINT_URL = "/api/hotel;@InjectMocks
    private HotelController hotelController;
    @Mock
    private HotelService hotelService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(hotelController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<HotelDto> page = new PageImpl<>(Collections.singletonList(HotelBuilder.getDto()));

        Mockito.when(hotelService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(hotelService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(hotelService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(hotelService.findById(ArgumentMatchers.anyInt())).thenReturn(HotelBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(hotelService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(hotelService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(hotelService.save(ArgumentMatchers.any(HotelDto.class))).thenReturn(HotelBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(HotelBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(hotelService, Mockito.times(1)).save(ArgumentMatchers.any(HotelDto.class));
        Mockito.verifyNoMoreInteractions(hotelService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(hotelService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInt())).thenReturn(HotelBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(HotelBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(hotelService, Mockito.times(1)).update(ArgumentMatchers.any(HotelDto.class), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(hotelService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(hotelService).deleteById(ArgumentMatchers.anyInt());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(HotelBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(hotelService, Mockito.times(1)).deleteById(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(hotelService);
    }
}