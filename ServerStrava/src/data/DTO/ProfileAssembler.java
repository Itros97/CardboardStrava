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

    public ProfileDTO profileToDTO(Profile p1) {
        ProfileDTO dto = new ProfileDTO();

        dto.setEmail(p1.getEmail());
        dto.setNickname(p1.getNickname());

        return dto;
    }
}
