import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ArticleDTO } from '../dtos/articleDTO';
import { RouteService } from './route.service';

@Injectable({
  providedIn: 'root'
})
export class ArticleApiService {

  constructor(private http: HttpClient,
              private routeService: RouteService) { }

  getArticles(): Observable<any> {
    return this.http.get(this.routeService.articleApiUrl);
  }

  saveArticle(article: ArticleDTO): Observable<any> {
    return this.http.post(this.routeService.saveArticleUrl, article);
  }
}
