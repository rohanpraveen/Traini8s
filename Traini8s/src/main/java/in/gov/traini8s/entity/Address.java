package in.gov.traini8s.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Embeddable
@Data
public class Address {
    @NotBlank
    private String detailedAddress;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @Pattern(regexp = "^[0-9]{6}$")
    @NotBlank
    private String pinCode;
}