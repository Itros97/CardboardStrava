package data.DTO;

import data.domain.*;

public class ChallengeAssembler {
    private static ChallengeAssembler instance;

    private ChallengeAssembler() { }

    public static ChallengeAssembler getInstance() {
        if (instance == null) {
            instance = new ChallengeAssembler();
        }

        return instance;
    }

    public ChallengeDTO profileToDTO(Challenge ch1) {
        ChallengeDTO dto = new ChallengeDTO();

        dto.setName(ch1.getName());
        dto.setDateOfStart(ch1.getDateOfStart());
        dto.setDateOfEnd(ch1.getDateOfEnd());
        dto.setSport(ch1.getSport());

        return dto;
    }
}