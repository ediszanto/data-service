package com.microservices.bootcamp.rds.service;

import com.microservices.bootcamp.rds.entity.ServiceEntity;
import com.microservices.bootcamp.rds.exception.CsvFileReadException;
import com.microservices.bootcamp.rds.model.Service;
import com.microservices.bootcamp.rds.repository.ServiceRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.microservices.bootcamp.rds.entity.ServiceMapper.SERVICE_MAPPER;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class ServicesService {
    private final ServiceRepository serviceRepository;

    public long servicesFileUploadPost(MultipartFile file) throws CsvFileReadException {
        List<ServiceEntity> services = fetchServicesFromCsvFile(file);
        return serviceRepository.saveAll(services).size();
    }

    private List<ServiceEntity> fetchServicesFromCsvFile(MultipartFile file) throws CsvFileReadException {
        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            return new CsvToBeanBuilder<ServiceCsvLine>(reader)
                    .withType(ServiceCsvLine.class)
                    .build()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(SERVICE_MAPPER::fromCsvModel)
                    .toList();
        } catch (IOException e) {
            throw new CsvFileReadException("Unable to read services csv file", e);
        }
    }

    @Transactional
    public Service servicesServiceCodeGet(Long serviceId) {
        return SERVICE_MAPPER.toDto(serviceRepository.findByServiceId(serviceId));
    }

    @Transactional
    public Set<Service> servicesServicesCodesGet(Set<String> codes) {
        return serviceRepository.findByCodeIn(codes)
                .stream()
                .map(SERVICE_MAPPER::toDto)
                .collect(Collectors.toSet());
    }

    @Transactional
    public List<Service> servicesGet(int page, int size, String sort, String by) {
        PageRequest pageable = PageRequest.of(page, size).withSort(Sort.Direction.fromString(sort), isNull(by) ? "serviceId" : by);
        Page<ServiceEntity> entities = serviceRepository.findAll(pageable);
        return entities.stream().sequential().map(SERVICE_MAPPER::toDto).collect(toList());
    }
}
