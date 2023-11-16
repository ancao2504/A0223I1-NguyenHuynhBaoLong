package org.example.service.impl;

import org.example.bean.Music;
import org.example.repository.IMusicRepository;
import org.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }
}
