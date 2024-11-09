import { NgModule } from "@angular/core"
import { RouterModule, Routes } from "@angular/router"
import { HomeComponent } from "home/home.component"
import { StudentsComponent } from "students/students.component"
import { StudentsResolver } from "students/students.resolver"
import { StudentDetailsComponent } from "students/student-details/student-details.component"
import { StudentDetailsResolver } from "students/student-details/student-details.resolver"
import { MajorsComponent } from "majors/majors.component"
import { MajorsResolver } from "majors/majors.resolver"
import { MajorStudentsResolver } from "majors/major-students/major-students.resolver"
import { MajorStudentsComponent } from "majors/major-students/major-students.component"
import { TierListsResolver } from "tierLists/tierLists.resolver"
import { TierListsComponent } from "tierLists/tierLists.component"
import {UsersComponent} from "./users/users.component";
import {UsersResolver} from "./users/users.resolver";
import {TierListDetailsResolver} from "./tierLists/tierList-details/tierList-details.resolver";
import {TierListDetailsComponent} from "./tierLists/tierList-details/tierList-details.component";


const routes: Routes = [
  { path: "", component: HomeComponent },
  {
    path: "students",
    component: StudentsComponent,
    resolve: {
      students: StudentsResolver,
    },
  },
  {
    path: "student-details/:id",
    component: StudentDetailsComponent,
    resolve: {
      student: StudentDetailsResolver,
    },
  },
  {
    path: "majors",
    component: MajorsComponent,
    resolve: {
      majors: MajorsResolver,
    },
  },
  {
    path: "major-students/:id",
    component: MajorStudentsComponent,
    resolve: {
      studentsFromMajor: MajorStudentsResolver,
    },
  },
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
