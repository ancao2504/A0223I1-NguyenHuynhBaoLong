package org.example.repository;

import org.example.bean.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();
    void save(Music music);
    void update(int id);
    void delete(int id);
}
