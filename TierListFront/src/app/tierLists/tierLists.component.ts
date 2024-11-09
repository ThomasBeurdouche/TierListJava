import { Component } from "@angular/core"
import { map, Observable } from "rxjs"
import { TierList } from "models/tierList.model"
import { ActivatedRoute, Router } from "@angular/router"
import { TierListService } from "services/tierList.service"

@Component({
  selector: "epf-tierList",
  templateUrl: "./tierLists.component.html",
  styleUrls: ["./tierLists.component.scss"],
})
export class TierListsComponent {
  tierLists$: Observable<TierList[]> = this._route.data.pipe(map((data) => data["tierLists"]))

  constructor(private _route: ActivatedRoute, private tierListService: TierListService, private router: Router,) {
  }

  deleteTierList(event: any, tierList: TierList) {
    event.stopPropagation()
    this.tierListService.delete(tierList).subscribe(() => this.router.navigate(["tierLists"]))
  }

  /*searchByMajorAndCourse($event: Observable<TierList[]>) {
    this.tierLists$ = $event
  }*/
}
