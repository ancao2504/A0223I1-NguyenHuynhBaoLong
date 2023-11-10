package org.example.repository.impl;

import org.example.bean.Email;
import org.example.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmailRepositoryImpl implements IEmailRepository {
    private final static Map<Integer,Email> map;
    static {
        map = new HashMap<>();
//            public Email(List<String> language, int size, Boolean spamsFilter, List<String> sigNature) {
        map.put(1,new Email(1,new String[]{"English,VN"}, new String[]{"5 10 15"},false,new String[]{"Thor,King"}));
        map.put(2,new Email(2,new String[]{"English,VN,Chinese,Japanese"}, new String[]{"5 10 15"},false,new String[]{"Thor,King"}));
        map.put(3,new Email(3,new String[]{"English,Japanese"}, new String[]{"5 10 15"},false,new String[]{"Thor,King"}));
        map.put(4,new Email(4,new String[]{"English,VN,Chinese"}, new String[]{"5 10 15"},false,new String[]{"Thor,King"}));
    }
    @Override
    public List<Email> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void update(Email email) {
        if (map.containsKey(email.getId())){
            map.remove(email.getId(),email);
            map.put(email.getId(),email);
        }
    }

    @Override
    public Email findById(int id) {
        return map.get(id);
    }
}
