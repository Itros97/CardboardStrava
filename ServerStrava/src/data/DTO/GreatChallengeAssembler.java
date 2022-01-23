package data.DTO;

import data.domain.*;

import java.util.ArrayList;
import java.util.List;

public class GreatChallengeAssembler {
    private static GreatChallengeAssembler instance;

    private GreatChallengeAssembler() {
    }

    public static GreatChallengeAssembler getInstance() {
        if (instance == null) {
            instance = new GreatChallengeAssembler();
        }

        return instance;
    }

    public GreatChallengeDTO challengeToDTO(Challenge ch1) {
        GreatChallengeDTO dto = new GreatChallengeDTO();

        dto.setName(ch1.getName());
        dto.setDateOfStart(ch1.getDateOfStart());
        dto.setDateOfEnd(ch1.getDateOfEnd());
        dto.setSport(ch1.getSport());
        dto.setEmailAceptante(ch1.getEmailAceptante());
        dto.setObjectiveDistance(0);
        dto.setObjectiveTime(0);

        return dto;
    }

    public GreatChallengeDTO challengeWithDistanceToDTO(ChallengeWithDistance ch1) {
        GreatChallengeDTO dto = new GreatChallengeDTO();

        dto.setName(ch1.getName());
        dto.setDateOfStart(ch1.getDateOfStart());
        dto.setDateOfEnd(ch1.getDateOfEnd());
        dto.setSport(ch1.getSport());
        dto.setEmailAceptante(ch1.getEmailAceptante());
        dto.setObjectiveDistance(ch1.getObjectiveDistance());
        dto.setObjectiveTime(0);

        return dto;
    }

    public GreatChallengeDTO challengeWithTimeToDTO(ChallengeWithTime ch1) {
        GreatChallengeDTO dto = new GreatChallengeDTO();

        dto.setName(ch1.getName());
        dto.setDateOfStart(ch1.getDateOfStart());
        dto.setDateOfEnd(ch1.getDateOfEnd());
        dto.setSport(ch1.getSport());
        dto.setEmailAceptante(ch1.getEmailAceptante());
        dto.setObjectiveDistance(0);
        dto.setObjectiveTime(ch1.getObjectiveTime());

        return dto;
    }

    public List<GreatChallengeDTO> challengeToDTO(List<Challenge> chs, List<ChallengeWithDistance> chds, List<ChallengeWithTime> chts) {
        List<GreatChallengeDTO> dtos = new ArrayList<>();

        for (Challenge ch : chs) {
            dtos.add(this.challengeToDTO(ch));
        }

        for (ChallengeWithDistance chd : chds) {
            dtos.add(this.challengeWithDistanceToDTO(chd));
        }

        for (ChallengeWithTime cht : chts) {
            dtos.add(this.challengeWithTimeToDTO(cht));
        }

        return dtos;
    }
}