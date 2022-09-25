import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from "./auth/auth.guard";
import {CreateBookComponent} from "./create-book/create-book.component";
import {IndexComponent} from "./index/index.component";
import {SearchBookComponent} from "./search-book/search-book.component";
import {LogInComponent} from "./login/log-in.component";
import {SignupComponent} from "./signup/signup.component";

const routes: Routes = [
  {
    path: '',
    component: IndexComponent
  },
  {
    path: 'create-book',
    pathMatch: 'full',
    component: CreateBookComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'search-book',
    pathMatch: 'full',
    component: SearchBookComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'signup',
    pathMatch: 'full',
    component: SignupComponent,
  },
  {
    path: 'login',
    pathMatch: 'full',
    component: LogInComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
