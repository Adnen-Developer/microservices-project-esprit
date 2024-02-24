package net.javaguides.clubservice.service;

import net.javaguides.clubservice.dto.ClubDto;

public interface ClubService {



    ClubDto saveClub(ClubDto clubDto);

    ClubDto getClubByCode(String clubCode);
}
