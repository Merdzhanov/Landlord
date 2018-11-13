package com.landlord.api;


import com.landlord.dto.*;
import com.landlord.models.Estate;
import com.landlord.services.base.EstateService;
import com.landlord.utils.EstateMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class EstatesApiController {
    private final EstateService mEstateService;
//    private final UserMapperImpl userMapper;
// private final EstateMapperImpl estateMapper;
//    private final ChatMessageMapperImpl chatMessageMapper;
//    private ChatMessageInputMapperImpl chatMessageInputMapper;


    @Autowired
    public EstatesApiController(
           EstateService estateService,
//            UserMapperImpl userMapper,
            EstateMapperImpl estateMapper

//            ChatMessageMapperImpl chatMessageMapper,
//            ChatMessageInputMapperImpl chatMessageInputMapper
    ) {
        mEstateService = estateService;
//        this.userMapper = userMapper;
//        this.estateMapper = estateMapper;
//        this.chatMessageMapper = chatMessageMapper;
//        this.chatMessageInputMapper=chatMessageInputMapper;
    }

//    @RequestMapping(
//            path = "Estates",
//            method = RequestMethod.GET
//    )
//    public List<EstateDTO> getAllEstates() {
//        List<Estate> models = this.landlordService.getAllEstates();
//        return this.estateMapper.mapMany(models);
//    }

    @RequestMapping(
            value = "Estates/User/{userName}",
            method = RequestMethod.GET
    )
    public List<EstateDTO> getEstatesByUser(@PathVariable("userName") String userName) {
        return mEstateService.getEstatesByUser(userName);
    }

    @RequestMapping(
            value = "Estates/ID/{id}",
            method = RequestMethod.GET
    )
    public EstateDTO getEstatesByID(@PathVariable("id") int id) {
        return mEstateService.getEstateByID(id);
    }

    @RequestMapping(
            value = "Estates/update",
            method = RequestMethod.PUT
    )
    public void updateEstate(@RequestBody Estate estateInput) {
        mEstateService.updateEstate(estateInput);
//        ResponseEntity<Estate>
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(estate);
    }
}
