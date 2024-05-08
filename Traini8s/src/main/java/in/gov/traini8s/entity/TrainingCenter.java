package in.gov.traini8s.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 40)
    @NotBlank
    private String centerName;

    @Pattern(regexp = "^[a-zA-Z0-9]{12}$")
    @NotBlank
    private String centerCode;

    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(updatable = false)
    private LocalDateTime createdOn;

    @Email
    private String contactEmail;

    @Pattern(regexp = "^[0-9]{10}$")
    @NotBlank
    private String contactPhone;

    @PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now();
    }
}