package com.epam.prudential;

import com.epam.prudential.model.User;
import com.epam.prudential.repository.ProductsRepository;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@MappedTypes(User.class)
@MapperScan("com.epam.prudential.mapper")
@SpringBootApplication(scanBasePackages = "com.epam")
@EnableMongoRepositories(basePackageClasses = ProductsRepository.class)
public class PrudentialProjectApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PrudentialProjectApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PrudentialProjectApplication.class);
    }
}
