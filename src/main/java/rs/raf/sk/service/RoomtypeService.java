package rs.raf.sk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.raf.sk.dto.RoomtypeDto;
import rs.raf.sk.mapper.RoomtypeMapper;
import rs.raf.sk.models.Roomtype;
import rs.raf.sk.repository.RoomtypeRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class RoomtypeService {
    private final RoomtypeRepository repository;
    private final RoomtypeMapper roomtypeMapper;

    public RoomtypeService(RoomtypeRepository repository, RoomtypeMapper roomtypeMapper) {
        this.repository = repository;
        this.roomtypeMapper = roomtypeMapper;
    }

    public RoomtypeDto save(RoomtypeDto roomtypeDto) {
        Roomtype entity = roomtypeMapper.toEntity(roomtypeDto);
        return roomtypeMapper.toDto(repository.save(entity));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public RoomtypeDto findById(int id) {
        if (repository.findById(id).isPresent())
            return roomtypeMapper.toDto(repository.findById(id).get());
        return null;
    }

    public Page<RoomtypeDto> findByCondition(RoomtypeDto roomtypeDto, Pageable pageable) {
        Page<Roomtype> entityPage = repository.findAll(pageable);
        List<Roomtype> entities = entityPage.getContent();
        return new PageImpl<>(roomtypeMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public RoomtypeDto update(RoomtypeDto roomtypeDto, int id) {
        RoomtypeDto data = findById(id);
        if (data == null) return null;
        Roomtype entity = roomtypeMapper.toEntity(roomtypeDto);
        BeanUtils.copyProperties(data, entity);
        return save(roomtypeMapper.toDto(entity));
    }
}