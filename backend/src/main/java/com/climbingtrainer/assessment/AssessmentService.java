package com.climbingtrainer.assessment;

import com.climbingtrainer.grip.Grip;
import com.climbingtrainer.grip.GripService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class AssessmentService {

    private final AssessmentRepository assessmentRepository;
    private final GripService gripService;

    public AssessmentService(AssessmentRepository assessmentRepository, GripService gripService) {
        this.assessmentRepository = assessmentRepository;
        this.gripService = gripService;
    }

    public List<Assessment> findByGripId(Long gripId) {
        return assessmentRepository.findByGripIdWithEntries(gripId);
    }

    public Assessment create(Long gripId, CreateAssessmentRequest request) {
        Grip grip = gripService.findById(gripId);
        Assessment assessment = new Assessment(grip, request.assessmentType(), request.customName());
        return assessmentRepository.save(assessment);
    }

    public AssessmentEntry addEntry(Long assessmentId, CreateEntryRequest request) {
        Assessment assessment = assessmentRepository.findById(assessmentId)
            .orElseThrow(() -> new RuntimeException("Assessment not found: " + assessmentId));

        AssessmentEntry entry = new AssessmentEntry();
        entry.setAssessment(assessment);
        entry.setResistanceKg(request.resistanceKg());
        entry.setBodyWeightPct(request.bodyWeightPct());
        entry.setResistanceLeftKg(request.resistanceLeftKg());
        entry.setResistanceRightKg(request.resistanceRightKg());
        entry.setBodyWeightPctLeft(request.bodyWeightPctLeft());
        entry.setBodyWeightPctRight(request.bodyWeightPctRight());
        entry.setNumberOfHangs(request.numberOfHangs());
        entry.setTimeUnderTensionSeconds(request.timeUnderTensionSeconds());
        entry.setBodyWeightKg(request.bodyWeightKg());
        entry.setRecordedAt(LocalDateTime.now());

        assessment.getEntries().add(entry);
        assessmentRepository.save(assessment);
        return entry;
    }
}
