package net.javaguides.clubservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.clubservice.dto.ClubDto;
import net.javaguides.clubservice.entity.Club;
import net.javaguides.clubservice.mapper.ClubMapper;
import net.javaguides.clubservice.repository.ClubRepository;
import net.javaguides.clubservice.service.ClubService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    @Override
    public ClubDto saveClub(ClubDto clubDto) {

        // convert OrganizationDto into Organization jpa entity
        Club club = ClubMapper.mapToClub(clubDto);

        Club savedClub = clubRepository.save(club);

        return ClubMapper.mapToClubDto(savedClub);
    }

    @Override
    public ClubDto getClubByCode(String clubCode) {
        Club club = clubRepository.findByClubCode(clubCode);
        return ClubMapper.mapToClubDto(club);
    }
}
