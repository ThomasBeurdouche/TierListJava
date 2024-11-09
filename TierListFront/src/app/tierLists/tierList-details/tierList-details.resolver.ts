import { Injectable } from "@angular/core"
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router"
import {Observable, of} from "rxjs"
import { TierListService } from "services/tierList.service"
import { TierList } from "models/tierList.model"
import { Major } from "models/major.model"
import {User} from "../../models/user.model";

@Injectable({
  providedIn: "root",
})
export class TierListDetailsResolver implements Resolve<TierList> {
  constructor(private tierListService: TierListService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<TierList> {
    if (route.params["id"] === "new") {
      // Crée un nouvel objet TierList avec des valeurs par défaut
      const newTierList: TierList = {
        tierListTitle: "New Tier List",
        publicTierList: false,
        votePour: 0,
        voteContre: 0,
        creationDate: new Date(),
        tiers: [],
        owner: { username: "Default User" } as User, // Remplacer avec les valeurs appropriées si nécessaire
      };
      return of(newTierList);
    }
    // Récupère la TierList existante par son ID
    return this.tierListService.findById(parseInt(route.params["id"], 10));
  }
}
