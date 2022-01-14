package rs.raf.sk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.raf.sk.dto.RankDto;
import rs.raf.sk.service.RankService;

@RequestMapping("/rank")
@RestController
@Slf4j
public class RankController {
    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated RankDto rankDto) {
        rankService.save(rankDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RankDto> findById(@PathVariable("id") int id) {
        RankDto rank = rankService.findById(id);
        return ResponseEntity.ok(rank);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        rankService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<RankDto>> pageQuery(RankDto rankDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<RankDto> rankPage = rankService.findByCondition(rankDto, pageable);
        return ResponseEntity.ok(rankPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated RankDto rankDto, @PathVariable("id") int id) {
        rankService.update(rankDto, id);
        return ResponseEntity.ok().build();
    }
}