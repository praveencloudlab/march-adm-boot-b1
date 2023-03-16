package com.cts.ecart.controller;

import com.cts.ecart.controller.BrandController;
import com.cts.ecart.dto.BrandDto;
import com.cts.ecart.mapper.BrandMapper;
import com.cts.ecart.mapper.EntityMapper;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional
public class BrandControllerTest {
    private static final String ENDPOINT_URL = "/api/brand";
    @InjectMocks
    private BrandController brandController;
    @Mock
    private BrandService brandService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(brandController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<BrandDto> page = new PageImpl<>(Collections.singletonList(BrandBuilder.getDto()));

        Mockito.when(brandService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(brandService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(brandService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(brandService.findById(ArgumentMatchers.anyInt())).thenReturn(BrandBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(brandService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(brandService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(brandService.save(ArgumentMatchers.any(BrandDto.class))).thenReturn(BrandBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(BrandBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(brandService, Mockito.times(1)).save(ArgumentMatchers.any(BrandDto.class));
        Mockito.verifyNoMoreInteractions(brandService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(brandService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInt())).thenReturn(BrandBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(BrandBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(brandService, Mockito.times(1)).update(ArgumentMatchers.any(BrandDto.class), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(brandService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(brandService).deleteById(ArgumentMatchers.anyInt());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(BrandBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(brandService, Mockito.times(1)).deleteById(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(brandService);
    }
}