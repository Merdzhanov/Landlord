package com.landlord.android.views.Login;


import com.landlord.android.models.Estate;
import com.landlord.android.models.User;
import com.landlord.android.services.base.UsersService;

import java.util.List;

public interface LoginContracts {
    interface View {

    }

    interface Presenter {
        User getUserByName(String s);
    }

    interface Navigator {

    }
}
