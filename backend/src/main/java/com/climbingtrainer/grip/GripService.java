package com.climbingtrainer.grip;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class GripService {

    private final GripRepository gripRepository;

    public GripService(GripRepository gripRepository) {
        this.gripRepository = gripRepository;
    }

    public List<Grip> findAll() {
        return gripRepository.findAll();
    }

    public Grip findById(Long id) {
        return gripRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Grip not found: " + id));
    }

    public Grip create(CreateGripRequest request) {
        Grip grip = new Grip(
            request.name(), request.category(), request.handMode(),
            request.fingers(), request.gripType(), request.edgeDepthMm(), request.edgeType()
        );
        return gripRepository.save(grip);
    }

    public Grip update(Long id, CreateGripRequest request) {
        Grip grip = findById(id);
        grip.setName(request.name());
        grip.setCategory(request.category());
        grip.setHandMode(request.handMode());
        grip.setFingers(request.fingers());
        grip.setGripType(request.gripType());
        grip.setEdgeDepthMm(request.edgeDepthMm());
        grip.setEdgeType(request.edgeType());
        return gripRepository.save(grip);
    }

    public void delete(Long id) {
        gripRepository.deleteById(id);
    }
}
