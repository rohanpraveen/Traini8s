package in.gov.traini8s.controller;

import in.gov.traini8s.entity.TrainingCenter;
import in.gov.traini8s.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training-centers")
public class TrainingCenterController {
    @Autowired
    private TrainingCenterService service;

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter center) {
        TrainingCenter savedCenter = service.createTrainingCenter(center);
        return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TrainingCenter> getAllTrainingCenters() {
        return service.getAllTrainingCenters();
    }

    @GetMapping("/training-centers")
    public List<TrainingCenter> searchCenters(@RequestParam(value = "searchTerm", required = false) String searchTerm) {
        return service.search(searchTerm);
    }
}