package com.enviro.assesment.grad001.jamiejudelutchmia.controller;

import com.enviro.assesment.grad001.jamiejudelutchmia.model.RecyclingTip;
import com.enviro.assesment.grad001.jamiejudelutchmia.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    //Get all recycle tips
    @GetMapping
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipService.getAllRecyclingTips();
    }

    // Get a single recycle tip
    @GetMapping("/{id}")
    public Optional<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        return recyclingTipService.getRecyclingTipById(id);
    }

    // create a recycle tip
    @PostMapping
    public RecyclingTip createRecyclingTip(@Valid @RequestBody RecyclingTip tip) {
        return recyclingTipService.createRecyclingTip(tip);
    }

    //update a recycle tip
    @PutMapping("/{id}")
    public RecyclingTip updateRecyclingTip(@PathVariable Long id,@Valid @RequestBody RecyclingTip updatedTip) {
        return recyclingTipService.updateRecyclingTip(id, updatedTip);
    }

    //delete a recycle tip
    @DeleteMapping("/{id}")
    public void deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
    }
}

