import {HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {BehaviorSubject, Observable, ReplaySubject} from "rxjs";
import {environment} from "../../environments/environment";
import {Author} from "../model/author.model";
import {Book} from "../model/book.model";
import {Reader} from "../model/reader.model";
import {ApiService} from "./api.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = `${environment.apiUrl}/readers`;

  private readonly USER_KEY = 'user';
  currentUser: Reader | undefined;
  currentUserSubject: ReplaySubject<any> = new ReplaySubject<any>()

  constructor(private apiService: ApiService) {

    var data = localStorage.getItem(this.USER_KEY);
    if (data) {
      this.currentUser = JSON.parse(data);
      this.currentUserSubject.next(this.currentUser)
    }

  }

  public setCurrentUser(user: any) {
    this.currentUser = user;
    this.currentUserSubject.next(user)
    if (user) {
      localStorage.setItem(this.USER_KEY, JSON.stringify(user));
    } else {
      localStorage.removeItem(this.USER_KEY);
    }
  }

  public getCurrentUser() {
    return this.currentUser
  }

  get isLoggedIn(): boolean {
    return !!this.getCurrentUser();
  }

  save(reader: Reader): Observable<Reader> {
    return this.apiService.post<Reader>(this.baseUrl + `/signup`, reader)
  }

  login(email?: string, password?: string): Observable<Reader> {
    let params = new HttpParams()
    if (email) {
      params = params.append('email', email)
    }
    if (password) {
      params = params.append('password', password)
    }
    return new Observable<Reader>(
      subscriber => {
        this.apiService.get<Reader>(this.baseUrl, 'login', params).subscribe(value => {
            if (value != null) {
              this.setCurrentUser(value)
            }
            this.currentUserSubject.next(value)
            console.log('logged: ')
            console.log(this.getCurrentUser())
            subscriber.next(value)
          }, error => subscriber.error(error),
          () => subscriber.complete())
      }
    )
  }

  logout() {
    this.setCurrentUser(null);
    console.log(this.getCurrentUser())
    this.currentUserSubject.next(null)
  }
}
