import { Tier } from './tier.model';
import { User } from './user.model';

export interface TierList {
  id?: bigint;
  tierListTitle: string;
  publicTierList: boolean;
  votePour?: number;
  voteContre?: number;
  creationDate?: Date;
  tiers?: Tier[];
  owner: User;
}
