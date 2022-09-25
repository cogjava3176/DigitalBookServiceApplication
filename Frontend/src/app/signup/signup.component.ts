import {Component, OnInit} from '@angular/core';
import {Author} from "../model/author.model";
import {Reader} from "../model/reader.model";
import {AuthorService} from "../service/author.service";
import {NotificationService} from "../service/notification.service";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor(private userService: UserService,
              private notificationService: NotificationService) {
  }

  user: Reader = new Reader()
  rePassword?: string

  ngOnInit(): void {
  }

  signup() {
    if (this.user.name == null || this.user.name.trim().length == 0) {
      this.notificationService.error("Reader name can't empty!")
      return
    }
    if (this.user.email == null || this.user.email.trim().length == 0) {
      this.notificationService.error("Reader email can't empty!")
      return
    }
    if (this.user.password == null || this.user.password.trim().length == 0) {
      this.notificationService.error("Reader password can't empty!")
      return
    }
    if (this.rePassword == null) {
      this.notificationService.error("Reader password can't empty!")
      return
    }
    if (this.user.password != this.rePassword) {
      this.notificationService.error("Password not match!")
      return
    }

    this.userService.save(this.user).subscribe(value => {
        this.notificationService.success("New reader created: " + value.name)
      },
      error => {
        this.notificationService.success("Opps, Something went wrongs!")
      })

  }
}
