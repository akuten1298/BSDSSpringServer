package com.example.bsdsspringserver;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aakash
 */

@RestController
public class TwinderServerController {

    @RequestMapping("/swipe/*")
    public ResponseEntity<String> twinderServer(@RequestBody SwipeRequest swipeRequest) {

      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.set("Content-Type", "text/plain");
      String responseBody = "";
      HttpStatus status;

      if(swipeRequest.getSwiper().equals("") || swipeRequest.getSwipee().equals("")) {
        responseBody = "Please provide non empty data";
        status = HttpStatus.BAD_REQUEST;
      } else if(swipeRequest.getComment().length() > 256) {
        responseBody = "Comments are too long! Please stay within 256 characters";
        status = HttpStatus.BAD_REQUEST;
      } else {
        responseBody = "We will keep this in mind and heart ;)";
        status = HttpStatus.OK;
      }

      System.out.println("In here");

      return new ResponseEntity<>(responseBody, responseHeaders, status);
    }
}
