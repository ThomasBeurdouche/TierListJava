import { Item } from './item.model';

export interface Tier {
  id?: bigint;
  tierTitle: string;
  items?: Item[];  // Assume that 'Item' is another model representing the items within a tier
}
