package com.enviro.assesment.grad001.jamiejudelutchmia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "disposal_guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Waste type is required")
    @Size(min = 2, max = 50, message = "Waste type must be between 2 and 50 characters")
    @Column(nullable = false)
    private String wasteType;

    @NotBlank(message = "Disposal instructions required")
    private String disposalInstructions;

    public DisposalGuideline() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getDisposalInstructions() {
        return disposalInstructions;
    }

    public void setDisposalInstructions(String disposalInstructions) {
        this.disposalInstructions = disposalInstructions;
    }
}