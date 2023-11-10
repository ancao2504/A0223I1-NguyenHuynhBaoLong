package org.example.service.impl;

import org.example.bean.Music;
import org.example.service.IMusicService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MusicServiceImpl implements IMusicService {
    private final static List<Music> list = new ArrayList<>();

    @Override
    public List<Music> findAll() {
        return list;
    }

    @Override
    public void save(Music music) {
       list.add(music);
    }
}
