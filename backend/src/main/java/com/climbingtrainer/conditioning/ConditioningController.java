package com.climbingtrainer.conditioning;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/conditioning")
public class ConditioningController {

    private final ConditioningService conditioningService;

    public ConditioningController(ConditioningService conditioningService) {
        this.conditioningService = conditioningService;
    }

    @GetMapping
    public List<ConditioningDto> findAll() {
        return conditioningService.findAll().stream().map(ConditioningDto::from).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConditioningDto create(@RequestBody CreateConditioningRequest request) {
        return ConditioningDto.from(conditioningService.create(request.name(), request.conditioningType()));
    }

    @PostMapping("/{id}/entries")
    @ResponseStatus(HttpStatus.CREATED)
    public ConditioningDto.EntryDto addEntry(@PathVariable Long id, @RequestBody CreateConditioningEntryRequest request) {
        return ConditioningDto.EntryDto.from(
            conditioningService.addEntry(id, request.resistanceKg(), request.bodyWeightPct(),
                request.maxReps(), request.bodyWeightKg())
        );
    }
}
