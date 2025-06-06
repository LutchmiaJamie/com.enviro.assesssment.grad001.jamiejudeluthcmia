package com.enviro.assesment.grad001.jamiejudelutchmia.controller;

import com.enviro.assesment.grad001.jamiejudelutchmia.model.WasteCategory;
import com.enviro.assesment.grad001.jamiejudelutchmia.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/waste-categories")
public class WasteCategoryController {
    private final WasteCategoryService wasteCategoryService;

    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }


    // Get all waste categories
    @GetMapping
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryService.getAllWasteCategories();
    }

    // Get a single waste category by ID
    @GetMapping("/{id}")
    public Optional<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        return wasteCategoryService.getWasteCategoryById(id);
    }

    // Create a new waste category
    @PostMapping
    public WasteCategory createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return wasteCategoryService.createWasteCategory(wasteCategory);
    }

    // Update an existing waste category
    @PutMapping("/{id}")
    public WasteCategory updateWasteCategory(@PathVariable Long id,@Valid @RequestBody WasteCategory updatedCategory) {
        return wasteCategoryService.updateWasteCategory(id, updatedCategory);
    }

    // Delete a waste category
    @DeleteMapping("/{id}")
    public void deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
    }
}

