package com.landlord.api;


import com.landlord.dto.*;
import com.landlord.models.RatingVote;
import com.landlord.services.base.EstateService;
import com.landlord.services.base.RatingVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class RatingVotesApiController {
    private final RatingVoteService mRatingVoteService;

    @Autowired
    public RatingVotesApiController(
            RatingVoteService ratingVoteService//,
    ) {
        mRatingVoteService = ratingVoteService;
    }

    @RequestMapping(
            value = "Rating/add",
            method = RequestMethod.POST
    )
    public void createOrUpdateRatingVote(@RequestBody RatingVoteDTO ratingVoteDTO) {
         mRatingVoteService.CreateORUpdateRatingVote(ratingVoteDTO);
//        ResponseEntity<RatingVote>
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(ratingVoteCreated);
    }
}
