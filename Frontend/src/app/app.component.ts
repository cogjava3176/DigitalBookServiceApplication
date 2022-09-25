import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "./service/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent implements OnInit {
  title = 'digital_book_fe';
  isLogin: boolean = false

  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private router: Router) {

  }

  ngOnInit(): void {
    this.userService.currentUserSubject.subscribe(value => {
      if (value) {
        this.isLogin = true
      } else {
        this.isLogin = false
      }
    })
  }

  logout() {
    this.userService.logout()
    this.router.navigate(['login'])
  }


}
