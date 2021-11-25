package data.DTO;

import data.domain.Profile;

public class ProfileAssembler {
    private static ProfileAssembler instance;

    private ProfileAssembler() { }

    public static ProfileAssembler getInstance() {
        if (instance == null) {
            instance = new ProfileAssembler();
        }

        return instance;
    }

    public ProfileDTO profiletoDTO (Profile profile)
    {
        ProfileDTO dto = new ProfileDTO();

        dto.setNickname(profile.getNickname());
        dto.setEmail(profile.getEmail());

        return dto;
    }
}
