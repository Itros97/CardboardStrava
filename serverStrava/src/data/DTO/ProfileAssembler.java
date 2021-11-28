package data.DTO;

import data.domain.Profile;

import java.util.GregorianCalendar;

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
        dto.setBirthdate(p1.getBirthdate());
        dto.setWeightKg(p1.getWeightKg());
        dto.setHeightCm(p1.getHeightCm());
        dto.setMaximumHeartRate(p1.getMaximumHeartRate());
        dto.setReposeHeartRate(p1.getReposeHeartRate());
        dto.setRegisterType(p1.getRegisterType());

        return dto;
    }
}
