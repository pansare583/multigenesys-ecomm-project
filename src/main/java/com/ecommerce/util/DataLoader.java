package com.ecommerce.util;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.Role;
import com.ecommerce.entity.User;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            Product p1 = Product.builder()
                    .name("iPhone 15 Pro")
                    .description("Latest Apple iPhone with titanium design")
                    .price(new BigDecimal("999.99"))
                    .stock(50)
                    .imageUrl("https://images.unsplash.com/photo-1695048133142-1a2048 main6256c70")
                    .build();

            Product p2 = Product.builder()
                    .name("Samsung Galaxy S24 Ultra")
                    .description("Flagship Samsung phone with AI features")
                    .price(new BigDecimal("1199.99"))
                    .stock(30)
                    .imageUrl("https://images.unsplash.com/photo-1707204423853-43a088820f4c")
                    .build();

            Product p3 = Product.builder()
                    .name("Sony WH-1000XM5")
                    .description("Industry leading noise canceling headphones")
                    .price(new BigDecimal("399.99"))
                    .stock(100)
                    .imageUrl("https://images.unsplash.com/photo-1505740420928-5e560c06d30e")
                    .build();

            productRepository.saveAll(Arrays.asList(p1, p2, p3));
        }

        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role(Role.ROLE_ADMIN)
                    .build();

            User user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("user123"))
                    .role(Role.ROLE_USER)
                    .build();

            userRepository.saveAll(Arrays.asList(admin, user));
        }
    }
}
