import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  constructor(private router: Router,
              private userService: UserService) {
  }

  ngOnInit(): void {
    if (this.userService.isLoggedIn) {
      this.router.navigate(['/search-book']).then();
    } else {
      this.router.navigate(['/login']).then();
    }

  }
}
