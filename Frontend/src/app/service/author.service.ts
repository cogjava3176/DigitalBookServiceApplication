import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Author} from "../model/author.model";
import {Book} from "../model/book.model";
import {ApiService} from "./api.service";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  baseUrl = `${environment.apiUrl}/author`;

  constructor(private apiService: ApiService) {
  }

  save(author: Author) : Observable<Author>{
    return this.apiService.post<Author>(this.baseUrl + `/signup`, author)
  }
}
