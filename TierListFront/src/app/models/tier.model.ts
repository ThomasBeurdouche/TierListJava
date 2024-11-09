import { Item } from './item.model';

export interface Tier {
  id?: bigint;
  tierTitle: string;
  items?: Item[];
}
