package com.climbingtrainer.grip;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/grips")
public class GripController {

    private final GripService gripService;

    public GripController(GripService gripService) {
        this.gripService = gripService;
    }

    @GetMapping
    public List<GripDto> findAll() {
        return gripService.findAll().stream().map(GripDto::from).toList();
    }

    @GetMapping("/{id}")
    public GripDto findById(@PathVariable Long id) {
        return GripDto.from(gripService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GripDto create(@Valid @RequestBody CreateGripRequest request) {
        return GripDto.from(gripService.create(request));
    }

    @PutMapping("/{id}")
    public GripDto update(@PathVariable Long id, @Valid @RequestBody CreateGripRequest request) {
        return GripDto.from(gripService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        gripService.delete(id);
    }
}
