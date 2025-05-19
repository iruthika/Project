package com.example.lbfds.controller;



import com.example.lbfds.dto.HistoryDTO;
import com.example.lbfds.model.Volunteer;
import com.example.lbfds.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/volunteer")

public class VolunteerController {

 @Autowired
 private VolunteerService volunteerService;

 @PostMapping("/add")
 public ResponseEntity<Volunteer> addVolunteer(@RequestBody Volunteer volunteer) {
     Volunteer savedVolunteer = volunteerService.addVolunteerData(volunteer);
     return ResponseEntity.ok(savedVolunteer);
 }

 @GetMapping("/history/{myId}")
 public ResponseEntity<List<Volunteer>> getVolunteerHistory(@PathVariable Long myId) {
     List<Volunteer> history = volunteerService.getVolunteerHistory(myId);
     return ResponseEntity.ok(history);
 }
 @GetMapping("volunteerhistory/{myid}")
 public List<HistoryDTO> volunteerhistory(@PathVariable Long myid){
	 return volunteerService.volunteerhistory(myid);
 }
}
