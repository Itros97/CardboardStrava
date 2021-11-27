package data.DTO;

import data.domain.*;

public class PasswordProfileAssembler {

    private static PasswordProfileAssembler instance;

    private PasswordProfileAssembler() { }

    public static PasswordProfileAssembler getInstance() {
        if (instance == null) {
            instance = new PasswordProfileAssembler();
        }

        return instance;
    }

    public PasswordProfileDTO passwordProfileToDTO(PasswordProfile p1) {
        PasswordProfileDTO dto = new PasswordProfileDTO();

        dto.setEmail(p1.getEmail());
        dto.setNickname(p1.getNickname());
        dto.setBirthdate(p1.getBirthdate());
        dto.setWeightKg(p1.getWeightKg());
        dto.setHeightCm(p1.getHeightCm());
        dto.setMaximumHeartRate(p1.getMaximumHeartRate());
        dto.setReposeHeartRate(p1.getReposeHeartRate());
        dto.setRegisterType(p1.getRegisterType());
        dto.setPassword(p1.getPassword());

        return dto;
    }
}
