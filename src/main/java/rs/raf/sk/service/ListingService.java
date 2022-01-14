package rs.raf.sk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.raf.sk.dto.ListingDto;
import rs.raf.sk.mapper.ListingMapper;
import rs.raf.sk.models.Listing;
import rs.raf.sk.repository.ListingRepository;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ListingService {
    private final ListingRepository repository;
    private final ListingMapper listingMapper;

    public ListingService(ListingRepository repository, ListingMapper listingMapper) {
        this.repository = repository;
        this.listingMapper = listingMapper;
    }

    public ListingDto save(ListingDto listingDto) {
        Listing entity = listingMapper.toEntity(listingDto);
        return listingMapper.toDto(repository.save(entity));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ListingDto findById(int id) {
        if (repository.findById(id).isPresent())
            return listingMapper.toDto(repository.findById(id).get());
        return null;
    }

    public Page<ListingDto> findByCondition(ListingDto listingDto, Pageable pageable) {
        Page<Listing> entityPage = repository.findAll(pageable);
        List<Listing> entities = entityPage.getContent();
        return new PageImpl<>(listingMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ListingDto update(ListingDto listingDto, int id) {
        ListingDto data = findById(id);
        if (data == null) return null;
        Listing entity = listingMapper.toEntity(listingDto);
        BeanUtils.copyProperties(data, entity);
        return save(listingMapper.toDto(entity));
    }
}