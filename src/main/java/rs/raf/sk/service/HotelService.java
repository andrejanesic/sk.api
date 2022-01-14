package rs.raf.sk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.raf.sk.dto.HotelDto;
import rs.raf.sk.mapper.HotelMapper;
import rs.raf.sk.models.Hotel;
import rs.raf.sk.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class HotelService {
    private final HotelRepository repository;
    private final HotelMapper hotelMapper;

    public HotelService(HotelRepository repository, HotelMapper hotelMapper) {
        this.repository = repository;
        this.hotelMapper = hotelMapper;
    }

    public HotelDto save(HotelDto hotelDto) {
        Hotel entity = hotelMapper.toEntity(hotelDto);
        return hotelMapper.toDto(repository.save(entity));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public HotelDto findById(int id) {
        if (repository.findById(id).isPresent())
            return hotelMapper.toDto(repository.findById(id).get());
        return null;
    }

    public Page<HotelDto> findByCondition(HotelDto hotelDto, Pageable pageable) {
        Page<Hotel> entityPage = repository.findAll(pageable);
        List<Hotel> entities = entityPage.getContent();
        return new PageImpl<>(hotelMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public HotelDto update(HotelDto hotelDto, int id) {
        HotelDto data = findById(id);
        if (data == null) return null;
        Hotel entity = hotelMapper.toEntity(hotelDto);
        BeanUtils.copyProperties(data, entity);
        return save(hotelMapper.toDto(entity));
    }
}