package net.javaguides.clubservice.mapper;

import net.javaguides.clubservice.dto.ClubDto;
import net.javaguides.clubservice.entity.Club;

public class ClubMapper {

    public static ClubDto mapToClubDto(Club club){
        ClubDto clubDto = new ClubDto(
                club.getId(),
                club.getClubName(),
                club.getClubDescription(),
                club.getClubCode(),
                club.getCreatedDate()
        );
        return clubDto;
    }

    public static Club mapToClub(ClubDto clubDto){
        Club club = new Club(
                clubDto.getId(),
                clubDto.getClubName(),
                clubDto.getClubDescription(),
                clubDto.getClubCode(),
                clubDto.getCreatedDate()
        );
        return club;
    }
}
