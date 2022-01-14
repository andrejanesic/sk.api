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
import rs.raf.sk.controller.ReviewController;
import rs.raf.sk.dto.ReviewDto;
import rs.raf.sk.mapper.EntityMapper;
import rs.raf.sk.mapper.ReviewMapper;
import rs.raf.sk.models.Review;
import rs.raf.sk.service.ReviewService;

import java.util.Arrays;
import java.util.Collections;

@Transactional
public class ReviewControllerTest {
    private static final String ENDPOINT_URL = "/api/review;@InjectMocks
    private ReviewController reviewController;
    @Mock
    private ReviewService reviewService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(reviewController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<ReviewDto> page = new PageImpl<>(Collections.singletonList(ReviewBuilder.getDto()));

        Mockito.when(reviewService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(reviewService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(reviewService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(reviewService.findById(ArgumentMatchers.anyInt())).thenReturn(ReviewBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(reviewService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(reviewService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(reviewService.save(ArgumentMatchers.any(ReviewDto.class))).thenReturn(ReviewBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(ReviewBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(reviewService, Mockito.times(1)).save(ArgumentMatchers.any(ReviewDto.class));
        Mockito.verifyNoMoreInteractions(reviewService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(reviewService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInt())).thenReturn(ReviewBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(ReviewBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(reviewService, Mockito.times(1)).update(ArgumentMatchers.any(ReviewDto.class), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(reviewService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(reviewService).deleteById(ArgumentMatchers.anyInt());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(ReviewBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(reviewService, Mockito.times(1)).deleteById(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(reviewService);
    }
}