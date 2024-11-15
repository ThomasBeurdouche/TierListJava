import { NgModule } from "@angular/core"
import { RouterModule, Routes } from "@angular/router"
import { HomeComponent } from "home/home.component"
import { TierListsResolver } from "tierLists/tierLists.resolver"
import { TierListsComponent } from "tierLists/tierLists.component"
import {UsersComponent} from "./users/users.component";
import {UsersResolver} from "./users/users.resolver";
import {TierListDetailsResolver} from "./tierLists/tierList-details/tierList-details.resolver";
import {TierListDetailsComponent} from "./tierLists/tierList-details/tierList-details.component";


const routes: Routes = [
  { path: "", component: HomeComponent },
  {
    path: "tierLists",
    component: TierListsComponent,
    resolve: {
      tierLists: TierListsResolver,
    },
  },
  {
    path: "users",
    component: UsersComponent,
    resolve: {
      users: UsersResolver,
    },
  },
  {
    path: "tierList-details/:id",
    component: TierListDetailsComponent,
    resolve: {
      tierList: TierListDetailsResolver,
    },
  },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
