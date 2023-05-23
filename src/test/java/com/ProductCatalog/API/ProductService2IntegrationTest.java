package com.ProductCatalog.API;


import com.ProductCatalog.API.controller.ProductController;
import com.ProductCatalog.API.infrastructure.JwtRequestFilter;
import com.ProductCatalog.API.repositories.ProductRepository;
import com.ProductCatalog.API.security.JwtTokenUtil;
import com.ProductCatalog.API.services.IProductService;
import com.ProductCatalog.API.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@ContextConfiguration(classes = {ProductController.class, JwtRequestFilter.class})
public class ProductService2IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Mock
    private IProductService iproductService;
    @InjectMocks
    private ProductService productService;
    public ProductService2IntegrationTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @WithMockUser
    public void yourIntegrationTest() throws Exception {
        UserDetails userDetails = createMockUserDetails(); // Create your mock UserDetails

        String jwtToken = JwtTokenUtil.generateToken(userDetails);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products/search")
                        .content("{  \"name\":\"cat\"}")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //.andExpect(MockMvcResultMatchers.content().);
    }

    public static UserDetails createMockUserDetails() {
        String username = "testuser";
        String password = "testpassword";
        String role = "ROLE_USER";

        return User.withUsername(username)
                .password(password)
                .authorities(new SimpleGrantedAuthority(role))
                .build();
    }
}

