package com.go.login.ui.userinfo;

import androidx.annotation.NonNull;
import com.go.login.data.entity.UserEntity;

public interface UserInfoContract {
    interface View{
        void showUserInfo(@NonNull UserEntity userEntity);
    }

    interface Presenter{
        void start(View view);
    }
}
