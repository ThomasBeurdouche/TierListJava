import { Component } from "@angular/core"
import { map, Observable } from "rxjs"
import { ActivatedRoute, Router } from "@angular/router"
import {User} from "../models/user.model";
import {UserService} from "../services/user.service";

@Component({
  selector: "epf-user",
  templateUrl: "./users.component.html",
  styleUrls: ["./users.component.scss"],
})
export class UsersComponent {
  users$: Observable<User[]> = this._route.data.pipe(
    map((data) => {
      console.log('Users component received from route data:', data["users"]); // Affiche les utilisateurs reçus
      return data["users"];
    })
  );
  constructor(private _route: ActivatedRoute, private userService: UserService, private router: Router,) {
  }

  //deleteTierList(event: any, user: User {
    //event.stopPropagation()
    //this.tierListService.delete(<bigint>tierList.id).subscribe(() => this.router.navigate(["tierLists"]))
  //}

  /*searchByMajorAndCourse($event: Observable<TierList[]>) {
    this.tierLists$ = $event
  }*/
}
