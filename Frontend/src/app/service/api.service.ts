import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";

const API_URL="http://54.173.109.192:8091/books"

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(private httpClient: HttpClient) {
  }

  public get<T>(url: string, item?: string, param?: HttpParams): Observable<T> {
    if (item) {
      url += `/${item}`;
    }
    return this.httpClient.get<T>(url, {params: param});
  }

  public post<T>(url: string, item: any, httpOptions?: { headers: HttpHeaders }): Observable<T> {
    if (httpOptions != undefined) {
      return this.httpClient.post<T>(url, item, httpOptions);

    }
    return this.httpClient.post<T>(url, item);
  }

  public create<T>(url: string, item: T): Observable<T> {
    return this.httpClient.post<T>(url, item);
  }

  public update<T>(url: string, item: T): Observable<T> {
    return this.httpClient.put<T>(url, item);
  }

  public delete<T>(url: string, itemId: string): Observable<T> {
    url += `/${itemId}`;
    return this.httpClient.delete<T>(url);
  }

}
