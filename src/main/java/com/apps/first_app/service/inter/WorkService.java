package com.apps.first_app.service.inter;

import com.apps.first_app.model.Work;
import javassist.NotFoundException;

import java.util.List;

public interface WorkService {

    void create(Work work);

    List<Work> allWorks();

    Work getById(Long id) throws NotFoundException;

    void add(Work work);

    void update(Work work);

    void delete(Long id);

}
