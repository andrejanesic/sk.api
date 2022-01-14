package rs.raf.sk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.raf.sk.dto.ListingDto;
import rs.raf.sk.service.ListingService;

@RequestMapping("/listing")
@RestController
@Slf4j
public class ListingController {
    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ListingDto listingDto) {
        listingService.save(listingDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingDto> findById(@PathVariable("id") int id) {
        ListingDto listing = listingService.findById(id);
        return ResponseEntity.ok(listing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        listingService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ListingDto>> pageQuery(ListingDto listingDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ListingDto> listingPage = listingService.findByCondition(listingDto, pageable);
        return ResponseEntity.ok(listingPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ListingDto listingDto, @PathVariable("id") int id) {
        listingService.update(listingDto, id);
        return ResponseEntity.ok().build();
    }
}