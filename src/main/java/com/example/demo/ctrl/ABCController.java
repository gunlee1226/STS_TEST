package com.example.demo.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommonDto;
import com.example.demo.dto.UserDto;
import com.example.demo.svc.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ABCController {

	@Autowired
	UserService userService;

	@GetMapping("/abc/{userId}")
	public ResponseEntity<CommonDto> getHelloWorld(@RequestParam String userNm) {
		CommonDto commonDto = new CommonDto();
		commonDto.setBody(userService.getUserList());
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@GetMapping("/abc/{userSeq}")
	public ResponseEntity<CommonDto> getDetailHelloWorld(@RequestParam Integer userSeq) {
		CommonDto commonDto = new CommonDto();
		commonDto.setBody(userService.getUserDetail(userSeq));
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@PostMapping("/abc")
	public ResponseEntity<CommonDto> insertHelloWorld(@RequestBody UserDto user) {
		userService.createUser(user);
		CommonDto commonDto = new CommonDto();
		commonDto.setBody(user);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@PutMapping("/abc/{userSeqNo}")
	public ResponseEntity<CommonDto> updateHelloWorld(@PathVariable Integer userSeqNo, @RequestBody UserDto dto) {
		dto.setUserSeq(userSeqNo);

		userService.updateUser(dto);

		CommonDto commonDto = new CommonDto();
		commonDto.setBody(dto);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@DeleteMapping("/abc/{userSeq}")
	public ResponseEntity<CommonDto> deleteHelloWorld(@PathVariable Integer userSeq) {
		userService.deleteUser(userSeq);

		CommonDto commonDto = new CommonDto();

		commonDto.setBody(userSeq);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
}
