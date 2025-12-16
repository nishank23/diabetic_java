package com.example.diabetic.service.impl;

import com.example.diabetic.exception.ResourceNotFoundException;
import com.example.diabetic.model.BgReading;
import com.example.diabetic.model.BgUnits;
import com.example.diabetic.repository.BgRepository;
import com.example.diabetic.service.BgService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Transactional
public class BgServiceImpl implements BgService {
    @Autowired
    BgRepository bgRepository;

    @Override
    public BgReading addBgReading(BgReading bgReading) {
        validateReading(bgReading);
        return bgRepository.save(bgReading);
    }

    @Override
    public List<BgReading> addBgReadingList(List<BgReading> bgReadingList){
        if(bgReadingList == null || bgReadingList.isEmpty()){
            throw new IllegalArgumentException("Bg Reading List is empty");
        }
        for(var bgreading :bgReadingList){
            validateReading(bgreading);
        }
        return bgRepository.saveAll(bgReadingList);
    }

    @Override
    public void deleteBgReading(Long bgId) {
        if (!bgRepository.existsById(bgId)) {
            throw new ResourceNotFoundException("BG reading not found");
        }
        bgRepository.deleteById(bgId);

    }

    private void validateReading(BgReading bg) {
        if(bg==null)
            throw new IllegalArgumentException("Bg values are empty");

        if (bg.getBg_unit() == null)
            throw new IllegalArgumentException("BG unit is required");

        if (bg.getBg_value() <= 0 || bg.getBg_value() > 1000)
            throw new IllegalArgumentException("Invalid BG value");

        if (bg.getBg_unit() == BgUnits.MMOL_PER_L && bg.getBg_value() > 40)
            throw new IllegalArgumentException("Invalid mmol/L value");
    }

}
