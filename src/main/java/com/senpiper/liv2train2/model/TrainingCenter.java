package com.senpiper.liv2train2.model;

import lombok.Data;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Document(collection = "TrainingCenter")
public class TrainingCenter {

    @NotBlank(message = "center name cannot be empty")
    @Size(max=40, message = "Center Name can not be more than 40 characters")
    private String centerName;

    @Id
    @NotBlank(message = "center code cannot be empty")
    @Pattern(
            regexp = "^[a-zA-Z0-9]{12}$",
            message = "center code must be alphanumeric having exactly 12 characters")
    private String centerCode;

    @AddressValidatorConstraint
    private AddressDetails address;

    @Positive(message = "Capacity cannot be Negative")
    private Integer studentCapacity;

    private List<String> courses;
    private long createdOn;

    @Email(message = "Provide a valid contact Email")
    private String contactEmail;

    @NotBlank(message = "contact phone can not be empty")
    @Pattern(
            regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$",
            message = "contact phone is invalid" )
    private String contactPhone;

    public TrainingCenter(){}
}
