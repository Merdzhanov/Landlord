package com.landlord.utils.base;

import com.landlord.dto.base.DTOModelBase;
import com.landlord.models.base.ModelBase;
import java.util.List;

public interface DTOMapper<T extends ModelBase, VT extends DTOModelBase> {
    VT map(T model);

    T map(VT dtoModel);

    List<VT> mapMany(List<T> models);

    public List<T> mapManyToModel(List<VT> dtoModels);
}
