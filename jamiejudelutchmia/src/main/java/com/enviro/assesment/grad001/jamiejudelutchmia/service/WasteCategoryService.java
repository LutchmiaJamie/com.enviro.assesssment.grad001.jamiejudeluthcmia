package com.enviro.assesment.grad001.jamiejudelutchmia.service;

import com.enviro.assesment.grad001.jamiejudelutchmia.exception.ResourceNotFoundException;
import com.enviro.assesment.grad001.jamiejudelutchmia.model.WasteCategory;
import com.enviro.assesment.grad001.jamiejudelutchmia.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {


    private final WasteCategoryRepository wasteCategoryRepository;

    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    //Get all waste categories
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    //Get one waste category by ID
    public Optional<WasteCategory> getWasteCategoryById(Long id) {
        Optional<WasteCategory> existingTip = wasteCategoryRepository.findById(id);
        if (existingTip.isPresent()) {
            return wasteCategoryRepository.findById(id);
        } else  {
            throw new ResourceNotFoundException("Waste category not found with id " + id);
        }

    }

    //creat new waste category
    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    //Update existing category
    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedWasteCategory) {
        Optional<WasteCategory> existingWasteCategory = wasteCategoryRepository.findById(id);
        if (existingWasteCategory.isPresent()) {
            WasteCategory category = existingWasteCategory.get();
            category.setWasteType(updatedWasteCategory.getWasteType());
            category.setDescription(updatedWasteCategory.getDescription());
            return wasteCategoryRepository.save(category);
        } else {
            throw new ResourceNotFoundException("Waste Category not found with id." +id);
        }
    }

    //Delete category
    public void deleteWasteCategory(Long id) {
        Optional<WasteCategory> existingTip = wasteCategoryRepository.findById(id);
        if (existingTip.isPresent()) {
            wasteCategoryRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Waste category not found with id " + id);
        }
    }

}
