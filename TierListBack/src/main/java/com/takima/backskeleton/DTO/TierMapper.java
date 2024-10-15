package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Tier;

public class TierMapper {
    public static Tier fromDto(TierDto tierDto, Long id) {
        return new Tier(
                id,
                tierDto.getName(),
                tierDto.getTierList()
        );
    }
    public static TierDto toDto(Tier tier) {
        return new TierDto(
                tier.getId(),
                tier.getTierTitle(),
                tier.getTierList()
        );
    }
}
