import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Reader} from "../model/reader.model";
import {NotificationService} from "../service/notification.service";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-sign-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {

  constructor(private userService: UserService,
              private router: Router,
              private notificationService: NotificationService) {
  }

  user: Reader = new Reader()


  ngOnInit(): void {
  }

  login() {
    this.userService.login(this.user.email, this.user.password).subscribe(value => {
      if (value == null) {
        this.notificationService.error("Wrong email or password!")
        return
      } else {
        this.notificationService.success("User " + value.name + " login successfully")
        this.router.navigate(['search-book'])
      }
    }, error => {
      this.notificationService.error("Something went wrong!")
    })
  }

  goToSignUp() {
    this.router.navigate(['signup'])
  }
}
