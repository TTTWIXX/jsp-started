package com.jsp.repository;


import com.jsp.entity.Dancer;

import java.util.ArrayList;
import java.util.List;

import static com.jsp.chap02.DancerRegProcessServlet.dancerMap;

// 댄서 정보 저장소
public class DancerRepository {

    // 댄서 저장 기능
    public void save(String name, String crewName,
                     String danceLevel, String[] genresArray) {
        // Dancer 객체로 포장
        com.jsp.entity.Dancer dancer = new com.jsp.entity.Dancer();
        dancer.setName(name);
        dancer.setCrewName(crewName);
        dancer.setDanceLevel(com.jsp.entity.Dancer.DanceLevel.valueOf(danceLevel));

        List<Dancer.Genre> genres = new ArrayList<>();
        if (genresArray != null) {
            for (String g : genresArray) {
                genres.add(Dancer.Genre.valueOf(g));
            }
        }
        dancer.setGenres(genres);

        System.out.println("dancer = " + dancer);


        // dancerList에 저장
        dancerMap.put(name, dancer);
    }
}
