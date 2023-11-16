package org.example.service;

import org.example.bean.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void save(Music music);
    void update(int id);
    void delete(int id);
}
