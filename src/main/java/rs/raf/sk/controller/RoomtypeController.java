package rs.raf.sk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.raf.sk.dto.RoomtypeDto;
import rs.raf.sk.service.RoomtypeService;

@RequestMapping("/roomtype")
@RestController
@Slf4j
public class RoomtypeController {
    private final RoomtypeService roomtypeService;

    public RoomtypeController(RoomtypeService roomtypeService) {
        this.roomtypeService = roomtypeService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated RoomtypeDto roomtypeDto) {
        roomtypeService.save(roomtypeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomtypeDto> findById(@PathVariable("id") int id) {
        RoomtypeDto roomtype = roomtypeService.findById(id);
        return ResponseEntity.ok(roomtype);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        roomtypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<RoomtypeDto>> pageQuery(RoomtypeDto roomtypeDto, @PageableDefault(/*sort = "createAt", direction = Sort.Direction.DESC*/) Pageable pageable) {
        Page<RoomtypeDto> roomtypePage = roomtypeService.findByCondition(roomtypeDto, pageable);
        return ResponseEntity.ok(roomtypePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated RoomtypeDto roomtypeDto, @PathVariable("id") int id) {
        roomtypeService.update(roomtypeDto, id);
        return ResponseEntity.ok().build();
    }
}