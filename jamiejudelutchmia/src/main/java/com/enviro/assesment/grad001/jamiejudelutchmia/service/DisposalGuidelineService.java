package com.enviro.assesment.grad001.jamiejudelutchmia.service;

import com.enviro.assesment.grad001.jamiejudelutchmia.exception.ResourceNotFoundException;
import com.enviro.assesment.grad001.jamiejudelutchmia.model.DisposalGuideline;
import com.enviro.assesment.grad001.jamiejudelutchmia.repository.DisposalGuidelineRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;

    public DisposalGuidelineService(DisposalGuidelineRepository disposalGuidelineRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
    }

    // Get all disposal guidelines
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    // Get one guideline by ID
    public Optional<DisposalGuideline> getDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id);
    }

    // Create new guideline
    public DisposalGuideline createDisposalGuideline(DisposalGuideline guideline) {
        return disposalGuidelineRepository.save(guideline);
    }

    // Update existing guideline
    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline updatedGuideline) {
        Optional<DisposalGuideline> existingGuideline = disposalGuidelineRepository.findById(id);
        if (existingGuideline.isPresent()) {
            DisposalGuideline guideline = existingGuideline.get();
            guideline.setWasteType(updatedGuideline.getWasteType());
            guideline.setDisposalInstructions(updatedGuideline.getDisposalInstructions());
            return disposalGuidelineRepository.save(guideline);
        } else {
            throw new ResourceNotFoundException("Disposal guideline not found.");
        }
    }

    // Delete a disposal guideline by ID
    public void deleteDisposalGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}