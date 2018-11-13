package com.landlord.api;

import com.landlord.dto.*;
import com.landlord.services.base.RatingVoteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    }
}
