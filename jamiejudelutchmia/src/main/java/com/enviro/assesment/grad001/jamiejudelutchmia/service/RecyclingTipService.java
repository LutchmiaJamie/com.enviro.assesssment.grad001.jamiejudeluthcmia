package com.enviro.assesment.grad001.jamiejudelutchmia.service;

import com.enviro.assesment.grad001.jamiejudelutchmia.exception.ResourceNotFoundException;
import com.enviro.assesment.grad001.jamiejudelutchmia.model.RecyclingTip;
import com.enviro.assesment.grad001.jamiejudelutchmia.repository.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepository recyclingTipRepository;
    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
    }

    // Retrieve all recycling tips
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    // Retrieve a single recycling tip by ID
    public Optional<RecyclingTip> getRecyclingTipById(Long id) {
        Optional<RecyclingTip> existingTip = recyclingTipRepository.findById(id);
        if (existingTip.isPresent()) {
            return recyclingTipRepository.findById(id);
        } else  {
            throw new ResourceNotFoundException("RecyclingTip not found with id " + id);
        }

    }

    // Create a new recycling tip
    public RecyclingTip createRecyclingTip(RecyclingTip tip) {
        return recyclingTipRepository.save(tip);
    }

    // Update an existing recycling tip by ID
    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip updatedTip) {
        Optional<RecyclingTip> existingTip = recyclingTipRepository.findById(id);
        if (existingTip.isPresent()) {
            RecyclingTip tip = existingTip.get();
            tip.setTip(updatedTip.getTip());
            return recyclingTipRepository.save(tip);
        } else {
            throw new ResourceNotFoundException("Recycling tip not found with id." +id);
        }
    }

    // Delete a recycling tip by ID
    public void deleteRecyclingTip(Long id) {
        Optional<RecyclingTip> existingTip = recyclingTipRepository.findById(id);
        if (existingTip.isPresent()) {
            recyclingTipRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Recycling Tip not found with id " + id);
        }
    }
}
