package com.enviro.assesment.grad001.jamiejudelutchmia.controller;

import com.enviro.assesment.grad001.jamiejudelutchmia.model.DisposalGuideline;
import com.enviro.assesment.grad001.jamiejudelutchmia.service.DisposalGuidelineService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disposal-guidelines")
public class DisposalGuidelineController {
    private final DisposalGuidelineService disposalGuidelineService;

    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }


    // Get all guidelines
    @GetMapping
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineService.getAllDisposalGuidelines();
    }

    //Get a single guideline with ID
    @GetMapping("/{id}")
    public Optional<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
        return disposalGuidelineService.getDisposalGuidelineById(id);
    }

    // create new guideline
    @PostMapping
    public DisposalGuideline createDisposalGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        return disposalGuidelineService.createDisposalGuideline(guideline);
    }

    // Update an existing guideline
    @PutMapping("/{id}")
    public DisposalGuideline updateDisposalGuideline(@PathVariable Long id,@Valid @RequestBody DisposalGuideline updatedGuideline) {
        return disposalGuidelineService.updateDisposalGuideline(id, updatedGuideline);
    }

    // Delete a guideline
    @DeleteMapping("/{id}")
    public void deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
    }
}
