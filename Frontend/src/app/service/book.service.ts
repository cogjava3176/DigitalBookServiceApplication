import {HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Book} from "../model/book.model";
import {ApiService} from "./api.service";

@Injectable({
  providedIn: 'root'
})
export class BookService {
  baseUrl = `${environment.apiUrl}/books`;

  constructor(private apiService: ApiService) {
  }

  save(book: Book): Observable<Book> {
    return this.apiService.post<Book>(this.baseUrl, book)
  }

  search(category?: string, author?: string, publisher?: string, price?: number): Observable<Book[]> {
    let params = new HttpParams()

    if (category != null) {
      if (category.length != 0)
        params = params.append('category', category)
    }
    if (author != null) {
      if (author.length != 0)
        params = params.append('author', author)
    }
    if (publisher != null) {
      if (publisher.length != 0)
        params = params.append('publisher', publisher)
    }
    if (price != null) {
      if (price.toString().length != 0)
        params = params.append('price', price)
    }
    console.log(params)
    return this.apiService.get<Book[]>(this.baseUrl, 'search', params)
  }
}
