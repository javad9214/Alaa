package com.example.alaa.views.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.databinding.ProfileFragmentBinding;
import com.example.alaa.models.ProfileInfoCard;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Objects;

public class ProfileFragment extends BottomSheetDialogFragment {

    public static final String TAG = "Profile";

    private ProfileFragmentBinding binding;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return null;
    }

    private RecyclerView recyclerViewProfileInfo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false);

        View view = binding.getRoot();
        // BottomSheetBehavior behavior = BottomSheetBehavior.from(view);
        // bottomSheetBehavior(behavior);
        init();
        setRecyclerViewProfileInfo();
        onClose();


        return view;
    }

    private void bottomSheetBehavior(BottomSheetBehavior behavior) {
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.i(TAG, "onStateChanged: " + newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.i(TAG, "onSlide: " + slideOffset);
            }
        });
    }

    private void init() {
        recyclerViewProfileInfo = binding.recyclerProfileInfo;
    }

    private void setRecyclerViewProfileInfo() {
        ArrayList<ProfileInfoCard> profileInfoCardsList;
        profileInfoCardsList = getProfileInfoList();
        ProfileInfoAdapter adapter = new ProfileInfoAdapter(profileInfoCardsList);
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return profileInfoCardsList.get(position).getSpan();
            }
        });


        recyclerViewProfileInfo.setLayoutManager(glm);
        recyclerViewProfileInfo.setAdapter(adapter);
    }

    private ArrayList<ProfileInfoCard> getProfileInfoList() {

        ArrayList<ProfileInfoCard> infoCardList = new ArrayList<>();
        infoCardList.add(getMobileNumber());
        infoCardList.add(getMeliCode());
        infoCardList.add(getRegisterDate());
        infoCardList.add(getGender());
        infoCardList.add(getCity());
        infoCardList.add(getProvince());
        infoCardList.add(getSchool());
        infoCardList.add(getPostalCode());
        infoCardList.add(getMail());
        infoCardList.add(getAddress());

        return infoCardList;
    }

    private ProfileInfoCard getMobileNumber() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.mobilePhoneNumber));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_mobileNumber));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_mobile_color));
        infoCard.setSpan(1);
        return infoCard;
    }

    private ProfileInfoCard getMeliCode() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.personal_code));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_personalNumber));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_personal_code_colored));
        infoCard.setSpan(1);
        return infoCard;
    }

    private ProfileInfoCard getGender() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileGender));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_gender));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_genders_colored));
        infoCard.setSpan(1);
        return infoCard;
    }

    private ProfileInfoCard getRegisterDate() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileRegisterDate));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_registerDate));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_calendar));
        infoCard.setSpan(1);
        return infoCard;
    }

    private ProfileInfoCard getCity() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileCity));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_city));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_cityscape));
        infoCard.setSpan(1);
        return infoCard;
    }

    private ProfileInfoCard getProvince() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileProvince));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_province));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_cityscape));
        infoCard.setSpan(1);
        return infoCard;
    }

    private ProfileInfoCard getSchool() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileSchool));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_school));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_school));
        infoCard.setSpan(1);
        return infoCard;
    }

    private ProfileInfoCard getPostalCode() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.proPostalCode));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_postCode));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_postalcode_colored));
        infoCard.setSpan(1);
        return infoCard;
    }

    private ProfileInfoCard getMail() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.proMail));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_email));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_email_colored));
        infoCard.setSpan(2);
        return infoCard;
    }

    private ProfileInfoCard getAddress() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.ProAddress));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_address));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_home_location));
        infoCard.setSpan(2);
        return infoCard;
    }

    private void onClose() {
        binding.closeProfile.setOnClickListener(view -> {
            dismiss();
        });
    }


}
