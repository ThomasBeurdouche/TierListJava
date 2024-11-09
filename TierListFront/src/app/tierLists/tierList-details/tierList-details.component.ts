import {Component, OnDestroy, OnInit} from "@angular/core";
import { map, Observable } from "rxjs";
import { ActivatedRoute, Router } from "@angular/router";
import { TierList } from "models/tierList.model";
import { Tier } from "models/tier.model";
import { TierListService } from "services/tierList.service";
import { User } from "models/user.model";

@Component({
  selector: "epf-tierList-details",
  templateUrl: "./tierList-details.component.html",
  styleUrls: ["./tierList-details.component.scss"],
})
export class TierListDetailsComponent implements OnInit, OnDestroy {
  tierList$: Observable<TierList> = this._route.data.pipe(map((data) => data["tierList"]));
  tierList: TierList | undefined;
  newTierName: string = "";
  newItemName: string = "";

  constructor(
    private _route: ActivatedRoute,
    private tierListService: TierListService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.tierList$.subscribe((tierList) => {
      this.tierList = tierList;
    });
  }

  // Ajouter un nouveau tier
  addTier(): void {
    if (this.tierList) {
      const newTier: Tier = {
        tierTitle: this.newTierName || "New Tier",
        items: [],
      };
      this.tierList.tiers?.push(newTier);
      this.newTierName = ""; // Réinitialise le champ de nom de nouveau tier
    }
  }

  // Supprimer un tier
  removeTier(index: number): void {
    if (this.tierList?.tiers) {
      this.tierList.tiers.splice(index, 1);
    }
  }

  // Ajouter un item dans un tier spécifique
  addItem(tierIndex: number): void {
    if (this.tierList?.tiers) {
      const newItem = { itemTitle: this.newItemName || "New Item" };
      // @ts-ignore
      this.tierList.tiers[tierIndex].items.push(newItem);
      this.newItemName = ""; // Réinitialise le champ de nom de nouveau item
    }
  }

  // Supprimer un item dans un tier spécifique
  removeItem(tierIndex: number, itemIndex: number): void {
    if (this.tierList?.tiers && this.tierList.tiers[tierIndex].items) {
      // @ts-ignore
      this.tierList.tiers[tierIndex].items.splice(itemIndex, 1);
    }
  }

  // Sauvegarder la tier list
  save(): void {
    if (this.tierList) {
      const id = this._route.snapshot.params["id"];
      if (id === "new") {
        this.tierListService.create(this.tierList).subscribe(//() => {
          //this.router.navigate(["tierLists"]);
        //}
        );
      } else {
        this.tierListService.update(id, this.tierList).subscribe(//() => {
          //this.router.navigate(["tierLists"]);
        //}
        );
      }
    }
  }
  ngOnDestroy() {
    this.save(); // Sauvegarde automatique
  }
}
