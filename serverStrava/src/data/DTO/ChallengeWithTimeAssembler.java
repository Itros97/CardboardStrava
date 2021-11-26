package data.DTO;

import data.domain.*;

public class ChallengeWithTimeAssembler {
    private static ChallengeWithTimeAssembler instance;

    private ChallengeWithTimeAssembler() { }

    public static ChallengeWithTimeAssembler getInstance() {
        if (instance == null) {
            instance = new ChallengeWithTimeAssembler();
        }

        return instance;
    }

    public ChallengeWithTimeDTO profileToDTO(ChallengeWithTime ch1) {
        ChallengeWithTimeDTO dto = new ChallengeWithTimeDTO();

        dto.setName(ch1.getName());
        dto.setDateOfStart(ch1.getDateOfStart());
        dto.setDateOfEnd(ch1.getDateOfEnd());
        dto.setSport(ch1.getSport());
        dto.setObjectiveTime(ch1.getObjectiveTime());

        return dto;
    }
}