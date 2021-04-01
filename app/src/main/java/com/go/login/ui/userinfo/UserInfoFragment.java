package com.go.login.ui.userinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.go.login.App;
import com.go.login.R;
import com.go.login.data.entity.UserEntity;
import com.go.login.usecases.GetCurrentUserUseCase;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

public class UserInfoFragment extends Fragment implements UserInfoContract.View {

    @Inject
    UserInfoContract.Presenter userInfoPresenter;

    TextView txt_userInfo;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState
    ) {

        View rootView = inflater.inflate(R.layout.fragment_user_info, container, false);
        App.applicationComponent.inject(this);

        txt_userInfo = rootView.findViewById(R.id.txt_user_info);
        userInfoPresenter.start(this);

        return rootView;
    }

    @Override
    public void showUserInfo(@NonNull UserEntity userEntity) {
        txt_userInfo.append(userEntity.getId() + "\n");
        txt_userInfo.append(userEntity.getCreatedAt() + "\n");
        txt_userInfo.append(userEntity.getEmail() + "\n");
        txt_userInfo.append(userEntity.getHasTrial() + "\n");
        txt_userInfo.append(userEntity.getNeedCard() + "\n");
        txt_userInfo.append(userEntity.getPlan() + "\n");
        txt_userInfo.append(userEntity.getTrialDays() + "\n");
    }
}