package net.javaguides.clubservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.clubservice.dto.ClubDto;
import net.javaguides.clubservice.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clubs")
@AllArgsConstructor
public class ClubController {

    private ClubService clubService;

    // Build Save Club REST API
    @PostMapping
    public ResponseEntity<ClubDto> saveClub(@RequestBody ClubDto clubDto){
        ClubDto savedClub = clubService.saveClub(clubDto);
        return new ResponseEntity<>(savedClub, HttpStatus.CREATED);
    }

    // Build Get Club by Code REST API
    @GetMapping("{code}")
    public ResponseEntity<ClubDto> getClub(@PathVariable("code") String clubCode){
        ClubDto organizationDto = clubService.getClubByCode(clubCode);
        return ResponseEntity.ok(organizationDto);
    }

}
