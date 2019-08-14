import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = "http://localhost:50421/api/apiposts";
const commentUrl="http://localhost:50421/api/apipostcomments";
const userurl ="http://localhost:50421/api/apiusers?id=";
const userurl2 ="http://localhost:50421/api/apiusers";
const PostTageUrl="http://localhost:50421/api/apiposttags";
const TagonPosts="http://localhost:50421/api/apitags";

const azurePosturl="https://svcswebapp.azurewebsites.net/api/apiposts";

const azurepostcomments="https://svcswebapp.azurewebsites.net/api/apipostcomments";

const AzureUserGet ="https://svcswebapp.azurewebsites.net/api/apiusers?id=";
const AzureUserPost="https://svcswebapp.azurewebsites.net/api/apiusers";

const AzurePostTags="https://svcswebapp.azurewebsites.net/api/apiposttags";
const AzureTagonPosts="https://svcswebapp.azurewebsites.net/api/apitags";

@Injectable({
  providedIn: 'root'
})
export class RestApiService {
  email = "zxc@zxc.com"
  constructor(private http: HttpClient) { }
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError('Something bad happened; please try again later.');
  }
  
  private extractData(res: Response) {
    let body = res;
    return body || { };
  }
  getPost(): Observable<any> {
    return this.http.get(azurePosturl, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }
    
  postSharing(data): Observable<any> {
    const url = `${azurePosturl}`;
    return this.http.post(url, data, httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }
  
  getPostById(id: string): Observable<any> {
    const url = `${azurePosturl}/${id}`;
    return this.http.get(url, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }
  getUserByEmail(email: string): Observable<any> {
    const url = `${AzureUserGet}${email}`;
    return this.http.get(url, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }
  getCommentsByPostId(id: string): Observable<any> {
    const url = `${azurepostcomments}/${id}`;
    return this.http.get(url, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }
  getTagsByPostID(id: string): Observable<any> {
    const url = `${AzurePostTags}/${id}`;
    return this.http.get(url, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }
  getPostsByTags(id: string): Observable<any> {
    const url = `${AzureTagonPosts}/${id}`;
    return this.http.get(url, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }

  PostComment(data): Observable<any> {
    const url = `${azurepostcomments}`;
    return this.http.post(url, data, httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }
  addUser(data): Observable<any> {
    const url = `${AzureUserPost}`;
    return this.http.post(url, data, httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }
  AddLikeByOne(data): Observable<any> {
    const url = `${azurePosturl}`;
    return this.http.put(url, data, httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }
  
  updatePost( data,id): Observable<any> {
    const url = `${azurePosturl}/${id}`;
    return this.http.put(url, data, httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }
  
  deleteContact(id: string): Observable<{}> {
    const url = `${azurePosturl}/${id}`;
    return this.http.delete(url, httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }
}
