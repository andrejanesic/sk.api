package rs.raf.sk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.raf.sk.dto.RankDto;
import rs.raf.sk.mapper.RankMapper;
import rs.raf.sk.models.Rank;
import rs.raf.sk.repository.RankRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class RankService {
    private final RankRepository repository;
    private final RankMapper rankMapper;

    public RankService(RankRepository repository, RankMapper rankMapper) {
        this.repository = repository;
        this.rankMapper = rankMapper;
    }

    public RankDto save(RankDto rankDto) {
        Rank entity = rankMapper.toEntity(rankDto);
        if (!entity.getCriteria().equals("less") && !entity.getCriteria().equals("more"))
            return null;
        return rankMapper.toDto(repository.save(entity));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public RankDto findById(int id) {
        if (repository.findById(id).isPresent())
            return rankMapper.toDto(repository.findById(id).get());
        return null;
    }

    public Page<RankDto> findByCondition(RankDto rankDto, Pageable pageable) {
        Page<Rank> entityPage = repository.findAll(pageable);
        List<Rank> entities = entityPage.getContent();
        return new PageImpl<>(rankMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public RankDto update(RankDto rankDto, int id) {
        RankDto data = findById(id);
        if (data == null) return null;
        Rank entity = rankMapper.toEntity(rankDto);
        BeanUtils.copyProperties(data, entity);
        return save(rankMapper.toDto(entity));
    }
}