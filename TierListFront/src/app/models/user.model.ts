import {TierList} from "./tierList.model";

export interface User {
  id?: bigint;
  username: string;
  mail: string;
  mdp: string;
  tierLists?: TierList[];
}
