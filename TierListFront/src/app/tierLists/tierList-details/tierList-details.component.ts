import { Component, OnDestroy, OnInit } from "@angular/core";
import { map, Observable } from "rxjs";
import { ActivatedRoute, Router } from "@angular/router";
import { TierList } from "models/tierList.model";
import { Tier } from "models/tier.model";
import { TierListService } from "services/tierList.service";
import { User } from "models/user.model";
import { TierService } from "../../services/tier.service";
import { Item } from "../../models/item.model";

@Component({
  selector: "epf-tierList-details",
  templateUrl: "./tierList-details.component.html",
  styleUrls: ["./tierList-details.component.scss"],
})
export class TierListDetailsComponent implements OnInit{
  tierList$: Observable<TierList> = this._route.data.pipe(map((data) => data["tierList"]));
  tierList: TierList | undefined;
  newTierName: string = "";
  newItemName: string = "";
  user: User = { username: "", mail: "", mdp: "" };

  constructor(
    private _route: ActivatedRoute,
    private tierListService: TierListService,
    private tierService: TierService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.tierList$.subscribe((tierList) => {
      this.tierList = tierList;
    });
  }

  onBeforeUnload = (event: BeforeUnloadEvent): void => {
    this.save();
  };

  // Add a new tier
  addTier(): void {
    if (this.tierList) {
      const newTier: Tier = {
        tierTitle: this.newTierName || "New Tier",
        items: [],
      };
      this.tierList.tiers?.push(newTier);
      this.newTierName = ""; // Reset new tier name
    }
  }

  // Remove a tier
  removeTier(index: number): void {
    if (this.tierList?.tiers) {
      this.tierList.tiers.splice(index, 1);
    }
  }

  // Add an item in a specific tier
  addItem(tierIndex: number): void {
    if (this.tierList?.tiers) {
      const newItem: Item = { itemTitle: this.newItemName || "New Item" };
      this.tierList.tiers[tierIndex].items!.push(newItem);
      this.newItemName = ""; // Reset new item name
    }
  }

  // Remove an item from a specific tier
  removeItem(tierIndex: number, itemIndex: number): void {
    if (this.tierList?.tiers && this.tierList.tiers[tierIndex].items) {
      this.tierList.tiers[tierIndex].items!.splice(itemIndex, 1);
    }
  }

  // Save the tier list
  save(): void {
    console.log("Saving tier list...");// Debug
    if (this.tierList) {
      if (this.tierList.owner.username === "" ||this.tierList.owner.username === "Default User") {
        const username = prompt("Please enter the owner's username:");
        const TierListTitle = prompt("Please enter the title of the TierList:");
        if (username) {
          this.user.username = username;
          this.tierList.owner = this.user;
          this.tierList.tierListTitle = TierListTitle || "New TierList";
        }
      }
      const id = this._route.snapshot.params["id"];
      console.log("TierList to save:", this.tierList); // Debug
      if (id === "new") {
        this.tierListService.create(this.tierList).subscribe(() => {
          this.router.navigate(["tierLists"]);
        });
      } else {
        this.tierListService.update(id, this.tierList).subscribe(() => {
          this.router.navigate(["tierLists"]);
        });
      }
    }
  }

}
