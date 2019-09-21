package com.example.alaa.views.ui.profile;

import android.os.Bundle;
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
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Objects;

public class ProfileFragment extends BottomSheetDialogFragment {

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
        init();
        setRecyclerViewProfileInfo();
        onClose();


        return view;
    }

    private void init() {
        recyclerViewProfileInfo = binding.recyclerProfileInfo;
    }

    private void setRecyclerViewProfileInfo() {
        ProfileInfoAdapter adapter = new ProfileInfoAdapter(getProfileInfoList());
        recyclerViewProfileInfo.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        recyclerViewProfileInfo.setAdapter(adapter);
    }

    private ArrayList<ProfileInfoCard> getProfileInfoList() {

        ArrayList<ProfileInfoCard> infoCardList = new ArrayList<>();
        infoCardList.add(getRegisterDate());
        infoCardList.add(getGender());
        infoCardList.add(getCity());
        infoCardList.add(getCity());
        infoCardList.add(getProvince());
        infoCardList.add(getProvince());
        infoCardList.add(getSchool());
        infoCardList.add(getSchool());
        infoCardList.add(getPostalCode());
        infoCardList.add(getPostalCode());

        return infoCardList;
    }

    private ProfileInfoCard getGender() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileGender));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_gender));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_genders_colored));
        return infoCard;
    }

    private ProfileInfoCard getRegisterDate() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileRegisterDate));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_registerDate));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_calendar));
        return infoCard;
    }

    private ProfileInfoCard getCity() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileCity));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_city));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_cityscape));
        return infoCard;
    }

    private ProfileInfoCard getProvince() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileProvince));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_province));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_cityscape));
        return infoCard;
    }

    private ProfileInfoCard getSchool() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.profileSchool));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_school));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_school));
        return infoCard;
    }

    private ProfileInfoCard getPostalCode() {
        ProfileInfoCard infoCard = new ProfileInfoCard();
        infoCard.setTitle(Objects.requireNonNull(getContext()).getString(R.string.proPostalCode));
        infoCard.setValue(Objects.requireNonNull(getContext()).getString(R.string.demo_postCode));
        infoCard.setIcon(getContext().getDrawable(R.drawable.ic_postalcode_colored));
        return infoCard;
    }

    private void onClose() {
        binding.closeProfile.setOnClickListener(view -> {
            onStop();
        });
    }


}
