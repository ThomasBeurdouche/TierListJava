import { Injectable } from "@angular/core"
import { Resolve } from "@angular/router"
import { Observable } from "rxjs"
import { TierList } from "models/tierList.model"
import { TierListService } from "services/tierList.service"

@Injectable({
  providedIn: "root",
})
export class TierListsResolver implements Resolve<TierList[]> {
  constructor(private tierListService: TierListService) {
  }

  resolve(): Observable<TierList[]> {
    return this.tierListService.findAll()
  }
}
