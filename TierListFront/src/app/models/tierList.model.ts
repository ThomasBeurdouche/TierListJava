import { Tier } from './tier.model';
import { User } from './user.model';

export interface TierList {
  id?: bigint;
  tierListTitle: string;
  publicTierList: boolean;
  votePour?: number;
  voteContre?: number;
  creationDate?: Date;
  tiers?: Tier[]; // Assume that 'Tier' is another model that represents individual tiers in the TierList
  owner: User;    // 'User' represents the owner of the TierList
}
