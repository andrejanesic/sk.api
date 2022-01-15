package rs.raf.sk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.raf.sk.dto.HotelDto;
import rs.raf.sk.service.HotelService;

@RequestMapping("/hotel")
@RestController
@Slf4j
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated HotelDto hotelDto) {
        hotelService.save(hotelDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> findById(@PathVariable("id") int id) {
        HotelDto hotel = hotelService.findById(id);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        hotelService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<HotelDto>> pageQuery(HotelDto hotelDto, @PageableDefault(/*sort = "createAt", direction = Sort.Direction.DESC*/) Pageable pageable) {
        Page<HotelDto> hotelPage = hotelService.findByCondition(hotelDto, pageable);
        return ResponseEntity.ok(hotelPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated HotelDto hotelDto, @PathVariable("id") int id) {
        hotelService.update(hotelDto, id);
        return ResponseEntity.ok().build();
    }
}