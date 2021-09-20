package com.apps.first_app.service.impl;

import com.apps.first_app.model.Employee;
import com.apps.first_app.model.Work;
import com.apps.first_app.repository.inter.WorkRepository;
import com.apps.first_app.service.inter.WorkService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    private final WorkRepository workRepository;

    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public void create(Work work) {
        workRepository.save(work);
    }

    @Override
    public List<Work> allWorks() {
        List<Work> works = new ArrayList<>();
        Iterable<Work> iterable = workRepository.findAll();

        iterable.forEach(work -> {
            works.add(work);
        });

        return works;
    }

    @Override
    public void add(Work work) {
        workRepository.save(work);
    }

    @Override
    public Work getById(Long id) {
        Work work = null;

        try {
            return work = workRepository.findById(id).get();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return work;
    }

    @Override
    public void update(Work work) {
        Work oldWork = workRepository.findById(work.getId()).get();

        oldWork.setId(work.getId());
        oldWork.setName(work.getName());

        workRepository.save(oldWork);
    }



    @Override
    public void delete(Long id) {
        workRepository.deleteById(id);
    }




}
