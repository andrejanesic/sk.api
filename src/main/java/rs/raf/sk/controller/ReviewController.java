package rs.raf.sk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.raf.sk.dto.ReviewDto;
import rs.raf.sk.service.ReviewService;

@RequestMapping("/review")
@RestController
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReviewDto reviewDto) {
        reviewService.save(reviewDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> findById(@PathVariable("id") int id) {
        ReviewDto review = reviewService.findById(id);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        reviewService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReviewDto>> pageQuery(ReviewDto reviewDto, @PageableDefault(/*sort = "createAt", direction = Sort.Direction.DESC*/) Pageable pageable) {
        Page<ReviewDto> reviewPage = reviewService.findByCondition(reviewDto, pageable);
        return ResponseEntity.ok(reviewPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReviewDto reviewDto, @PathVariable("id") int id) {
        reviewService.update(reviewDto, id);
        return ResponseEntity.ok().build();
    }
}