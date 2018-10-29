package com.landlord.utils;

import com.landlord.dto.EstateDTO;
import com.landlord.dto.UserDTO;
import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.User;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.base.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstateMapperImpl implements DTOMapper<Estate, EstateDTO> {
    private final UserMapperImpl userMapper;
    private final ChatMessageMapperImpl chatMessageMapper;

    @Autowired
    public EstateMapperImpl(
            UserMapperImpl userMapper,
            ChatMessageMapperImpl chatMessageMapper
    ) {
        this.userMapper = userMapper;
        this.chatMessageMapper = chatMessageMapper;
    }

    @Override
    public EstateDTO map(Estate model) {
        EstateDTO dtoModel = new EstateDTO();
        dtoModel.id=model.getId();
        dtoModel.imageUrl=model.getImageUrl();
        dtoModel.name=model.getName();
        dtoModel.description=model.getDescription();
        dtoModel.address=model.getAddress();
        dtoModel.monthlyRent=model.getMonthlyRent();
        dtoModel.owedAmount=model.getOwedAmount();
        dtoModel.dueDate=model.getDueDate();
        dtoModel.users= userMapper.mapMany(model.getUsers());
       // dtoModel.messageList=chatMessageMapper.mapMany(model.getMessageList());
        return dtoModel;
    }

    @Override
    public Estate map(EstateDTO dtoModel) {
        Estate model = new Estate();
        model.setId(dtoModel.id);
        model.setImageUrl(dtoModel.imageUrl);
        model.setName(dtoModel.name);
        model.setDescription(dtoModel.description);
        model.setAddress(dtoModel.address);
        model.setMonthlyRent(dtoModel.monthlyRent);
        model.setOwedAmount(dtoModel.owedAmount);
        model.setDueDate(dtoModel.dueDate);
        model.setUsers(userMapper.mapManyToModel(dtoModel.getUsers()));
        //model.setMessageList(chatMessageMapper.mapManyToModel(dtoModel.getMessageList()));
        return model;
    }

    @Override
    public List<EstateDTO> mapMany(List<Estate> models) {
        return models.stream()
            .map(this::map)
            .collect(Collectors.toList());
    }
    @Override
    public List<Estate> mapManyToModel(List<EstateDTO> dtoModels) {
        return dtoModels.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
