package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Course;
import com.takima.backskeleton.models.Major;
import com.takima.backskeleton.models.Tier;
import com.takima.backskeleton.models.User;

import java.time.Instant;
import java.util.List;

public class TierListDto {
    private int votePour;
    private int voteContre;
    private Instant creationDate;
    private List<Tier> tiers;
    private User owner;
    private String tierListTitle;
    private boolean publicTierList;

        public static TierListDto builder() {
            return new TierListDto();
        }

        public static TierListDto builder(Integer votePour, Integer voteContre, Instant creationDate, List<Tier> tiers, User owner,String tierListTitle, Boolean publicTierList) {
            TierListDto tierListDto = new TierListDto();
            tierListDto.votePour = votePour;
            tierListDto.voteContre = voteContre;
            tierListDto.creationDate = creationDate;
            tierListDto.tiers = tiers;
            tierListDto.owner = owner;
            tierListDto.tierListTitle = tierListTitle;
            tierListDto.publicTierList = publicTierList;
            return tierListDto;

        }
        public TierListDto votePour(int votePour) {
            this.votePour = votePour;
            return this;
        }
        public TierListDto voteContre(int voteContre) {
            this.voteContre = voteContre;
            return this;
        }
        public TierListDto creationDate(Instant creationDate) {
            this.creationDate = creationDate;
            return this;
        }
        public TierListDto tiers(List<Tier> tiers) {
            this.tiers = tiers;
            return this;
        }
        public TierListDto owner(User owner) {
            this.owner = owner;
            return this;
        }

        public TierListDto tierListTitle(String tierListTitle) {
            this.tierListTitle = tierListTitle;
            return this;
        }
        public TierListDto publicTierList(boolean publicTierList) {
            this.publicTierList = publicTierList;
            return this;
        }
        public TierListDto build() {
            return this;
        }
        public TierListDto() {
        }
        public int getVotePour() {
            return votePour;
        }
        public int getVoteContre() {
            return voteContre;
        }
        public Instant getCreationDate() {
            return creationDate;
        }
        public List<Tier> getTiers() {
            return tiers;
        }
        public User getOwner() {
            return owner;
        }
        public String getTierListTitle() {
            return tierListTitle;
        }
        public boolean isPublicTierList() {
            return publicTierList;
        }


}
