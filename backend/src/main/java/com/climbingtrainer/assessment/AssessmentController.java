package com.climbingtrainer.assessment;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/grips/{gripId}/assessments")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @GetMapping
    public List<AssessmentDto> findByGripId(@PathVariable Long gripId) {
        return assessmentService.findByGripId(gripId).stream()
            .map(AssessmentDto::from).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssessmentDto create(@PathVariable Long gripId,
                                @Valid @RequestBody CreateAssessmentRequest request) {
        return AssessmentDto.from(assessmentService.create(gripId, request));
    }

    @PostMapping("/{id}/entries")
    @ResponseStatus(HttpStatus.CREATED)
    public AssessmentDto.EntryDto addEntry(@PathVariable Long gripId,
                                           @PathVariable Long id,
                                           @RequestBody CreateEntryRequest request) {
        return AssessmentDto.EntryDto.from(assessmentService.addEntry(id, request));
    }
}
