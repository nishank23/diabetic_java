package com.example.diabetic.service;

import com.example.diabetic.model.BgReading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BgService {

   BgReading addBgReading(BgReading bgReading);

   List<BgReading> addBgReadingList(List<BgReading> bgReadingList);

   void deleteBgReading(Long bgId);
}
