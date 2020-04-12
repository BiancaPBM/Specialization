package com.api.Specialization.controllers;

//DOAR INCEPUT...va fi implementat ulterior

import com.api.Specialization.models.Speciality;
import com.api.Specialization.service.SpecialityService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/specialities")
//@EnableMongoRepositories(basePackages ="com.api.Specialization.repository.speciality")
public class SpecialityController {

    private SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping
    public List<Speciality> getAllSpecialities() {
        Sort sortOrder = Sort.by("name");
        return specialityService.findAll(sortOrder);
    }

    @GetMapping("/{speciality}")
    public List<Speciality> getByName(@PathVariable("speciality") String name) {
        return specialityService.findByNameContaining(name);
    }

    @PostMapping
    public void insert(@RequestBody Speciality speciality) {
        this.specialityService.insert(speciality);
    }

    @PutMapping
    public void update(@RequestBody Speciality speciality) {
        this.specialityService.update(speciality);
    }

    @DeleteMapping("/{_id}")
    public void delete(@PathVariable("_id") String _id) {
        this.specialityService.deleteById(_id);
    }

}
