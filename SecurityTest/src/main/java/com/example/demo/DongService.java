package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DongService {
    @Autowired
    private DongRepository repository;
    public Page<Dong> list(int pageNumber){
        Sort sort = Sort.by("username").ascending();
        Pageable pageable = PageRequest.of(pageNumber-1,5,sort);
        return repository.findAll(pageable);
    }
    public void save (Dong dong){
        repository.save(dong);
    }
    public Dong get(int id){
        return repository.findById(id).get();
    }
    public List<Dong> find(String keyword){
        return  repository.findByUsername(keyword);
    }
    public void delete (int id){
        repository.deleteById(id);
    }
}
