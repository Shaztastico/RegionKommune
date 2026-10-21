package org.example.jpaonetomany.controller;

import org.example.jpaonetomany.model.Region;
import org.example.jpaonetomany.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/regioner")
public class RegionRestController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping
    List<Region> getRegioner() {
        return regionRepository.findAll();
    }

    @DeleteMapping("/{kode}")
    List<Region> deleteRegion(@PathVariable String kode) {
        regionRepository.deleteById(kode);
        return regionRepository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Region postRegion(@RequestBody Region region) {
        System.out.println(region);
        return regionRepository.save(region);
    }


    /* Det her er et eksempel på en PostMapping som ikke bruger JSON
    * men istedet for bare bruger plain text/html. Det er ikke den løsning vi bruger
    * i forbindelse med JavaScript */
    @PostMapping("/region2")
    public ResponseEntity<String> postRegion2(@RequestParam String kode, @RequestParam String navn) {
        return ResponseEntity.ok("Received kode: " + kode + ", navn: " + navn);
    }



}