package com.api.Specialization.controllers;

import com.api.Specialization.models.Doctor;
import com.api.Specialization.models.FilterEntry;
import com.api.Specialization.models.FilterResolver;
import com.api.Specialization.service.IDoctorService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/doctors")
public class DoctorController {
    private IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors(@RequestParam(value = "sortBy", required = false, defaultValue = "rating") String sortBy) {
        Sort sortOrder = Sort.by(sortBy);
        return doctorService.findAll(sortOrder);
    }
    @PostMapping
    public void insert(@RequestBody Doctor doctor) {
        this.doctorService.insert(doctor);
    }

    @PutMapping
    public void update(@RequestBody Doctor doctor) {
        this.doctorService.update(doctor);
    }

    @DeleteMapping("/{_id}")
    public void delete(@PathVariable("_id") String _id){
        this.doctorService.deleteById(_id);
    }
 /*
    @GetMapping("/firstname/{firstname}")
    public List<Doctor> getByFirstName(@PathVariable("firstname") String firstName) {
        return this.doctorRepository.findByFirstNameIgnoreCase(firstName);
    }

    @GetMapping("/lastname/{lastname}")
    public List<Doctor> getByLastName(@PathVariable("lastname") String lastName) {
        return this.doctorRepository.findByLastNameIgnoreCase(lastName);
    }

    @GetMapping("/city/{city}")
    public List<Doctor> getByCity(@PathVariable("city") String city) {
        return this.doctorRepository.findByCity(city);
    }

    @GetMapping("/speciality/{speciality}")
    public List<Doctor> getBySpeciality(@PathVariable("speciality") String speciality) {
        return this.doctorRepository.findBySpeciality(speciality);
    }
*/
    @GetMapping(value = "/filter")
    public List<Doctor> getByFilters(@RequestParam(value = "workplace.city", required = false) String city,
                                     @RequestParam(value = "speciality", required = false) String speciality,
                                     @RequestParam(value = "firstName", required = false) String firstName,
                                     @RequestParam(value = "lastName", required = false) String lastName,
                                     @RequestParam(value = "disponibility", required = false) String disponibleDay,
                                     @RequestParam(value = "sortBy", required = false) String sortBy,
                                     @RequestParam(value = "sortDirection", defaultValue = "DESC") String sortDirection) {
        List<FilterEntry> filterEntryList = new ArrayList<>();
        if (city != null) {
            filterEntryList.add(new FilterEntry("workplace.city", "=", city));
        }
        if (speciality != null) {
            filterEntryList.add(new FilterEntry("speciality", "=", speciality));
        }
        if (firstName != null) {
            filterEntryList.add(new FilterEntry("firstName", "=", firstName));
        }
        if (lastName != null) {
            filterEntryList.add(new FilterEntry("lastName", "=", lastName));
        }
        if(disponibleDay!=null){
            filterEntryList.add(new FilterEntry("disponibility", "=", disponibleDay));
        }
        Query query = new FilterResolver(filterEntryList).toQuery();
        if (sortBy != null) {
            if (sortDirection.equals("ASC")) {
                query.with(Sort.by(Sort.Direction.ASC, sortBy));
            } else {
                query.with(Sort.by(Sort.Direction.DESC, sortBy));
            }
        }
        return doctorService.solve(query);
    }
/*
    @GetMapping(value = "/name")
    public List<Doctor> getByName(@RequestParam(value = "firstname", required = false) String firstName,
                                  @RequestParam(value = "lastname", required = false) String lastName) {
        if (firstName == null) {
            if (lastName == null) {
                return null;
            }
            return this.doctorRepository.findByLastNameIgnoreCase(lastName);
        } else {
            if (lastName == null) {
                return this.doctorRepository.findByFirstNameIgnoreCase(firstName);
            } else {
                return this.doctorRepository.findByFirstNameAndLastNameIgnoreCase(firstName, lastName);
            }
        }
    }
 */
}
