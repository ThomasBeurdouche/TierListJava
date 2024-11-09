package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Tier;
import com.takima.backskeleton.models.TierList;

public class TierDto {
    private Long id;
    private String tierTitle;
    private TierList tierList;

    public TierDto() {
    }

    public TierDto(Long id, String tierTitle, TierList tierList) {
        this.id = id;
        this.tierTitle = tierTitle;
        this.tierList = tierList;
    }

    public Long getId() {
        return id;
    }

    public String getTierTitle() {
        return tierTitle;
    }

    public TierList getTierList() {
        return tierList;
    }
}
