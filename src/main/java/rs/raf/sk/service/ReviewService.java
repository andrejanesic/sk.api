package rs.raf.sk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.raf.sk.dto.ReviewDto;
import rs.raf.sk.mapper.ReviewMapper;
import rs.raf.sk.models.Review;
import rs.raf.sk.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ReviewService {
    private final ReviewRepository repository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository repository, ReviewMapper reviewMapper) {
        this.repository = repository;
        this.reviewMapper = reviewMapper;
    }

    public ReviewDto save(ReviewDto reviewDto) {
        Review entity = reviewMapper.toEntity(reviewDto);
        return reviewMapper.toDto(repository.save(entity));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ReviewDto findById(int id) {
        if (repository.findById(id).isPresent())
            return reviewMapper.toDto(repository.findById(id).get());
        return null;
    }

    public Page<ReviewDto> findByCondition(ReviewDto reviewDto, Pageable pageable) {
        Page<Review> entityPage = repository.findAll(pageable);
        List<Review> entities = entityPage.getContent();
        return new PageImpl<>(reviewMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReviewDto update(ReviewDto reviewDto, int id) {
        ReviewDto data = findById(id);
        if (data == null) return null;
        Review entity = reviewMapper.toEntity(reviewDto);
        BeanUtils.copyProperties(data, entity);
        return save(reviewMapper.toDto(entity));
    }
}