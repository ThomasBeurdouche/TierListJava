import {TierList} from "../tierList.model";
import {User} from "../user.model";

export class UserTierListsDto {
  user: User
  tierLists: TierList[]

  constructor(user: User, tierLists: TierList[]) {
    this.user = user
    this.tierLists = tierLists
  }
}
