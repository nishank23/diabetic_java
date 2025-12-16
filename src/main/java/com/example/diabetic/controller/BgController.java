package com.example.diabetic.controller;

import com.example.diabetic.model.BgReading;
import com.example.diabetic.service.BgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bg")
public class BgController {

    @Autowired
    BgService bgService;

    //For Adding/Updating Bg Reading
    @PostMapping()
    public ResponseEntity<BgReading> addBgReading(@RequestBody BgReading bgReading) {
        var saved = bgService.addBgReading(bgReading);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    //for bulk syncing apple/gfit data to our app.
    @PostMapping("/bulk")
    public ResponseEntity<List<BgReading>> addBgReadingBulk(@RequestBody List<BgReading> bgReadingList){
        var saved = bgService.addBgReadingList(bgReadingList);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }




    @DeleteMapping
    public ResponseEntity<Void> deleteBgReading(@PathVariable Long bgId){
        bgService.deleteBgReading(bgId);
        return ResponseEntity.noContent().build();  //204
    }

}

