package in.gov.traini8s.service;

import in.gov.traini8s.entity.TrainingCenter;
import in.gov.traini8s.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TrainingCenterService {
    @Autowired
    private TrainingCenterRepository repository;

    public TrainingCenter createTrainingCenter(TrainingCenter center) {
        return repository.save(center);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }



    public List<TrainingCenter> search(String searchTerm) {
        return repository.findByQuery(searchTerm);
    }


}