package com.epam.prudential.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
@Document(collation = "products")
public class Products {

    @Id
    private String id;

    @Field(name = "products")
    @Indexed(unique = true)
    private String productName;


}
